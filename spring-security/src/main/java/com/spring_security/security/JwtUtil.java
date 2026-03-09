package com.spring_security.security;

import com.spring_security.entity.Role;
import com.spring_security.entity.User;
import com.spring_security.repository.UserRepository;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    //secret key

    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);





    //expiration time

    private final int jwtExpirationMs = 86400000;

    private UserRepository userRepository;

    public JwtUtil(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Generate Token
    public String generateToken(String username){
        Optional<User> user = userRepository.findByUsername(username);

        Set<Role> roles = user.get().getRoles();

        //Add roles to the Token

        return Jwts.builder().setSubject(username).claim("roles", roles.stream()
                .map(role -> role.getName()).collect(Collectors.joining(",")))
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(secretKey).compact();


    }

    //Extract UserName
    public String extractUsername(String token){
       return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
    }

    //Extract roles
    public Set<String> extractRoles(String token){

        String roleString = Jwts.parserBuilder().setSigningKey(secretKey)
                .build().parseClaimsJws(token).getBody().get("roles", String.class);

        return Set.of(roleString);
    }

    //Token validation

    public boolean isTokenValid(String token){
        try {

            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;


        }catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }
}
