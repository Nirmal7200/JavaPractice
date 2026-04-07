package function.consumer.consumerChaining;

public class Movie {

    String name;
    String result;

    public Movie(String name, String result){
        this.name = name;
        this.result = result;
    }

    public String getName(){
        return name;
    }

    public String getResult(){
        return result;
    }

    public void setName(String name){
        this.name = name;
    }

    public void  setResult(){
        this.result = result;
    }

    @Override
    public String toString(){
        return name + result ;
    }
}
