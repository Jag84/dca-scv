
import java.io.*;
import java.util.ArrayList;


public class SCV{

    public static String usuario;


    public static void about() {
        System.out.println("-----------------------INFO---------------------");
        System.out.println("Programa desarrollado por: Javier Añón Gutiérrez");
        System.out.println("Lenguaje utilizado: Java");
        System.out.println("Versión; 1.2.0");
        System.out.println("------------------------------------------------");

    }
    

    public static boolean registro (){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pass = "";

        FileWriter fichero = null;
        PrintWriter pw = null;
        boolean registro = false;
    

        try
        {
            System.out.print("Introduce tu usuario: ");
            usuario = br.readLine();

            System.out.print("Introduce tu contraseña: ");
            pass = br.readLine();

            fichero = new FileWriter( usuario  + ".txt");
            
            pw = new PrintWriter(fichero);
            pw.println(pass + "\n");

            registro = true;
            return registro;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
            if (null != fichero)
                fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
           return registro;
        }


    }

    public static boolean acceso (){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pass = "";
        String truepass = "";

        File fichero = null;
        FileReader fr = null;
        boolean login = false;

    

        try
        {
            System.out.print("Introduce tu usuario: ");
            usuario = br.readLine();

            System.out.print("Introduce tu contraseña: ");
            pass = br.readLine();

            fichero = new File (usuario  + ".txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            truepass = br.readLine();

            if (truepass.equals(pass)){
                System.out.println("Contraseña Correcta. Accediendo...");
                login = true;
            }
            else{
                System.out.println("Contraseña Incorrecta.");

            }

        }
        catch (FileNotFoundException e){
            System.out.println("ERROR: Usuario no registrado");

        }
         catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
            if (null != fichero)
                fr.close();
           } catch (Exception e2) {
           }
           return login;
        }


    }


    public static boolean menu_inicial (){
        int opcion = 0;

        System.out.println("---------LBT CUSTOM---------");
        System.out.println("1.Registrarse");
        System.out.println("2.Acceder");
        System.out.println("-----------------------------");
        
        System.out.print("Selecciona una opción: ");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            opcion = Integer.parseInt(br.readLine());

            switch (opcion){
                case 1: return registro();
                case 2: return acceso();
            }
            
        }
        catch (Exception ex){
            System.out.println("ERROR: opción incorrecta");
        }
        return false;
    }

    public static void almacenar_bug(Bug fallo){

        FileWriter fichero = null;
        PrintWriter pw = null;

        try
        {
            
            fichero = new FileWriter( usuario  + ".txt", true);
            
            pw = new PrintWriter(fichero);
            pw.println(fallo.getTitle());
            pw.println(fallo.getIssue());
            pw.println(fallo.getType() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
            if (null != fichero)
                fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }



    }

    public static void crear_bug(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Bug fallo = null;
        String t, i, ty = "";

        try{
            System.out.print("Introduce el título del fallo: ");
            t = br.readLine();

            System.out.print("Describe el fallo: ");
            i = br.readLine();

            System.out.print("¿Qué tipo de fallo es?: ");
            ty = br.readLine();

            fallo = new Bug(usuario, t, i, ty);

            almacenar_bug(fallo);

            System.out.println(fallo.toString());


        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public static ArrayList<Bug> cargar_bugs(String u){
        
        ArrayList<Bug> lista = new ArrayList<Bug>();
        BufferedReader br = null;
        File fichero = null;
        FileReader fr = null;
        String t, i, ty = "";

        Bug fallo = null;

        try
        {
            fichero = new File (u  + ".txt");
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            
            br.readLine();
            br.readLine();
            
            do{

                t = br.readLine();
                i = br.readLine();
                ty = br.readLine();

                fallo = new Bug(u,t,i,ty);

                lista.add(fallo);

            }while (br.readLine() != null);

        }
        catch (FileNotFoundException e){
            System.out.println("ERROR: Usuario no registrado");

        }
         catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
            if (null != fichero)
                fr.close();
           } catch (Exception e2) {
           }
           return lista;
        }

    }

    public static void detalle_bug(Bug fallo){

        int opcion = 0;

        System.out.println("------------------------------------");
        System.out.println(fallo.toString());
        System.out.println("--------¿Qué quieres hacer?---------");
        System.out.println("1.Crear aviso de fallo");
        System.out.println("2.Ver tus avisos de fallos");
        System.out.println("3.Créditos");
        System.out.println("------------------------------------");
        
        System.out.print("Selecciona una opción: ");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            opcion = Integer.parseInt(br.readLine());

            switch (opcion){
                case 1: crear_bug();
                break;
                case 2: listar_bugs();
                break;
                case 3: about();
            }
            
        }
        catch (Exception ex){
            System.out.println("ERROR: opción incorrecta");
        }


    }

    public static void listar_bugs(){

        Bug fallo = null;
        ArrayList<Bug> lista = cargar_bugs(usuario);

        for (int i =1; i < lista.size(); i++) { 
            
            fallo = lista.get(i-1);
            System.out.println(i + ". Autor: " + fallo.getUsername() + "|| Fallo: " + fallo.getTitle()); 		
       }

       System.out.print("Introduce el número del fallo a revisar (0 para salir): ");
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int num;
       try{
        num = Integer.parseInt(br.readLine()) - 1;
        if (num != -1){
            fallo = lista.get(num);
            System.out.println(fallo.toString());
        }
       }
       catch (Exception e){
           e.printStackTrace();
       }  

    }



    public static boolean menu_principal (){
        int opcion = 0;

        System.out.println("\n---------LBT---------");
        System.out.println("--- MENÚ PRINCIPAL---");
        System.out.println("1.Crear aviso de fallo");
        System.out.println("2.Ver tus avisos de fallos");
        System.out.println("3.Créditos");
        System.out.println("---------------------");
        
        System.out.print("Selecciona una opción: ");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            opcion = Integer.parseInt(br.readLine());

            switch (opcion){
                case 1: crear_bug();
                break;
                case 2: listar_bugs();
                break;
                case 3: about();
            }
            
        }
        catch (Exception ex){
            System.out.println("ERROR: opción incorrecta");
        }
        return false;
    }

    public static void main(String[] args) {

        boolean acceso = menu_inicial();

        if (acceso){

            menu_principal();

        }
    }

}



