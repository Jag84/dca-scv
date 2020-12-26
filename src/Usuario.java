

public class Usuario {

    private String username;
    private String password;



    public String getUsername(){
        return username;
    }

    public void setUsername(String u){
        username = u;
    }

    public void setPassword(String p){
        password = p;
    }

    public Usuario (String u, String p){
        username = u;
        password = p;
    }


};
