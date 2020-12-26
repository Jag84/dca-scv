

import java.util.ArrayList;


public class Bug {

    private String username;
    private String title;
    private String issue;
    private String type;
    ArrayList<Comentario> comments;

    public String getUsername(){
        return username;
    }

    public void setUsername(String u){
        username = u;
    }


    public String getType(){
        return type;
    }

    public void setType(String t){
        type = t;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String t){
        title = t;
    }

    public String getIssue(){
        return issue;
    }

    public void setIssue(String i){
        issue = i;
    }

    public Bug (String u, String t, String i, String ty){
        username = u;
        title = t;
        issue = i;
        type = ty;
        comments = new ArrayList<Comentario>();   
    }

    public void save (){

    }

    @Override
    public String toString() { 
        
        String s = "";
        
        s =  "Autor:          " + username + "\n";
        s += "Título:         " + title + "\n";
        s += "Descripción:    " + issue + "\n";
        s += "Tipo de fallo:  "  + type + "\n";

        return s;
    }   

};
