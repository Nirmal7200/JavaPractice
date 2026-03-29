package function.consumer.MovieInfo;

public class Movie {

    String name;
    String hero;
    String heroine;

    public Movie(String name, String hero, String heroine){
        this.name=name;
        this.hero=hero;
        this.heroine=heroine;
    }

    public String getName(){
        return name;
    }

    public String getHero(){
        return hero;
    }
    public String getHeroine(){
        return heroine;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setHero(String hero){
        this.hero=hero;
    }

    public void setHeroine(String heroine){
        this.heroine=heroine;
    }

    @Override
    public String toString(){
        return name +
                hero + heroine ;
    }
}
