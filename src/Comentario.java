

public class Comentario {

    private String username;
    private String comment;
    

    public String getUsername(){
        return username;
    }

    public void setUsername(String u){
        username = u;
    }


    public String getComment(){
        return comment;
    }

    public void setComment(String c){
        comment = c;
    }

    public Comentario (String u, String c){
        username = u;
        comment = c;
    }


};
