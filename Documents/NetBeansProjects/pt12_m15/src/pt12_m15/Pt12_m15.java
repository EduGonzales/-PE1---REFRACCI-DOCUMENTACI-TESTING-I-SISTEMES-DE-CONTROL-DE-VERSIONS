/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15;

import pt12_m15.model.Usuario;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;
import pt12_m15.model.DNA_or_RNA_Strand;





/**
 *
 * @author J1E2S
 */
public class Pt12_m15 {
private Usuario UserList;
private DNA_or_RNA_Strand conver;
    /**
     * @param args the command line arguments
     */
        //String [] for display the menu with the role USER
        private String[] MainMenuUser ={
            "Turn a DNA strand." ,"Find the most repeated nitrogenous bases.",
            "Find the least repeated nitrogenous bases.","Count bases and show it.","Convert DNA to RNA",
            "Convert an RNA to DNA","Logout","Exit"
        };
        //String [] for display the menu with the role USER
        private String[] MainMenuADMIN ={
            "ADD NEW USER","Turn a DNA strand." ,"Find the most repeated nitrogenous bases.",
            "Find the least repeated nitrogenous bases.","Count bases and show it.","Convert DNA to RNA",
            "Convert an RNA to DNA","Logout","Exit"
        };
    public static void main(String[] args) throws IOException {

        Pt12_m15 myApp=new Pt12_m15();
        //MAIN APP
        myApp.run(); 
    
        /*List<Usuario> usuarios = new ArrayList<Usuario>();      
        usuarios.add(new Usuario("jesus", "1234","USER"));
        usuarios.add(new Usuario("profe", "12345","ADMIN"));*/
        //usuarios.add(new Usuario("profe", "12345");
        //ExportarCSV(usuarios);
        //ImportarCSV();
        
    }
    
     public static void ImportarCSV() {
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>(); // Lista donde guardaremos los datos del archivo
            
            CsvReader leerUsuarios = new CsvReader("Usuarios.csv");
            leerUsuarios.readHeaders();
            
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String nickname = leerUsuarios.get(0);
                String password=leerUsuarios.get(1);
                        
                
                usuarios.add(new Usuario(nickname, password)); // Añade la informacion a la lista
            }
            
            leerUsuarios.close(); // Cierra el archivo
            
            // Recorremos la lista y la mostramos en la pantalla
            for(Usuario user : usuarios) {
                System.out.println(user.getNickname() + " , "
                    + user.getPassword());
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
     public static void ExportarCSV(List<Usuario> usuarios) {
        String salidaArchivo = "users.csv"; // Nombre del archivo
        // Si existe un archivo llamado asi lo borra
        /*if(existe) {
            File archivoUsuarios = new File(salidaArchivo);
            archivoUsuarios.delete();
        }*/
        
        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
            
            // Datos para identificar las columnas
            salidaCSV.write("nickname");
            salidaCSV.write("password");
            salidaCSV.write("role");
            
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            
            // Recorremos la lista y lo insertamos en el archivo
            for(Usuario user : usuarios) {
                salidaCSV.write(user.getNickname());
                byte[] encodepassword = Base64.encodeBase64(user.getPassword().getBytes());
                String password_cripted=new String(encodepassword);
                salidaCSV.write(password_cripted);
                salidaCSV.write(user.getRole());
                
                salidaCSV.endRecord(); // Deja de escribir en el archivo
            }
            
            salidaCSV.close(); // Cierra el archivo
            
        } catch(IOException e) {
            e.printStackTrace();
        }    
    }

    private void run() {
        UserList=new Usuario();
        conver=new DNA_or_RNA_Strand();
        LoginUser();
    }
    /**
     * This function will be display the Login and save the correct login of the user
     */
    private void LoginUser() {
        //array for save the username and role of the user
        String[] session_user = new String[3];
        session_user[0]="";
        session_user[1]="";
        session_user[2]="";
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce your username: ");
        String username=sc.nextLine();
        
        System.out.println("Introduce your password");
        String password=sc.nextLine();
        //to validate the user 
            //another function will be validate this
        session_user =UserList.loginUser(username,password);
        
        //Here different actions will be performed depending on what it returns from the function 
        if(session_user[0]=="true") {
            
            System.out.println("Login correct. Welcome ADMIN " + session_user[1]);
            
            DisplayMenu();
        }else if (session_user[0]=="false"){   
            System.out.println("Login correct. Welcome USER " + session_user[1]);
            DisplayMenuUser(session_user[1]);
        } else {
            System.out.println("You are not in database. Bye!");
        } 

        
    }
    /**
     * This function will be display the menu of the role ADMIN and the user will 
     * the user will have to choose an option
     */
    private void DisplayMenu() {
    //variable to exit the menu loop
    boolean exit=false;
    //variable for the logout
    int comp=0;
        do{
            	System.out.println("");
		System.out.println("MAIN MENU ADMIN");
		System.out.println("");
		for (int i = 0; i < MainMenuADMIN.length; i++) {
			System.out.format("[%d]. %s\n", i, MainMenuADMIN[i]);
		}
                	System.out.println("Select an option");
			Scanner sc = new Scanner(System.in);
			int selectedOption;
                        selectedOption = sc.nextInt();
                        // process option selected
			switch (selectedOption) {
                                    case 0:
                                            add_new_user();
                                            break;
                                    case 1:
                                            Turn_around_strand();
                                            break;
                                    case 2: //nitrogenous base more repited
                                            baseMasRepetida();
                                            break;
                                    case 3: //nitrogenous base less repited
                                            baseMenosRepetida();
                                            break;
                                    case 4: //nitrogenous base count
                                            nitrogenous_bases_count();
                                            break;
                                    case 5: //List your Information
                                            ConversADNtoARN();
                                            break;
                                    case 6:
                                            ConversARNtoADN();
                                            break;
                                    case 7: //Logout
                                            comp=1;
                                            exit=true;         
                                            break;
                                    case 8: //Exit
                                            exit = true;
                                            break;                                        
                                    default:
                                            System.out.println("Invalid option");
                                            break;
			}
        }while(!exit);
        if(comp==1){
            LoginUser();
        }else{
           System.out.println("See you later or Again !"); 
        }    
    }
    /**
     * This function will be display the menu of the role USER and the user will 
     * the user will have to choose an option
     */
    private void DisplayMenuUser(String username) {
        //variable to exit the menu loop
        boolean exit=false;
        //variable for the logout
        int comp=0;
            do{
                    System.out.println("");
                    System.out.println("MAIN MENU");
                    System.out.println("");
                    for (int i = 0; i < MainMenuUser.length; i++) {
                            System.out.format("[%d]. %s\n", i, MainMenuUser[i]);
                    }
                            System.out.println("Select an option");
                            Scanner sc = new Scanner(System.in);
                            int selectedOption;
                            selectedOption = sc.nextInt();
                            // process option selected
                            switch (selectedOption) {
                                    case 0:
                                            Turn_around_strand();
                                            break;
                                    case 1: //nitrogenous base more repited
                                            baseMasRepetida();
                                            break;
                                    case 2: //nitrogenous base less repited
                                            baseMenosRepetida();
                                            break;
                                    case 3: //nitrogenous base count
                                            nitrogenous_bases_count();
                                            break;
                                    case 4: //List your Information
                                            ConversADNtoARN();
                                            break;
                                    case 5:
                                            ConversARNtoADN();
                                            break;
                                    case 6: //Logout
                                            comp=1;
                                            exit=true;
                                            break;
                                    case 7: //Exit
                                            exit = true;
                                            break;
                                    default:
                                            System.out.println("Invalid option");
                                            break;
                            }
            }while(!exit);
            if(comp==1){
                LoginUser();
            }else{
               System.out.println("See you later or Again !"); 
            }        
    }

    private void ConversADNtoARN() {
        
        String DNAInput=AskUserADNString();
        String newArnConvert=conver.ConvertDNA_to_RNA(DNAInput);
        System.out.println("ARN NEW : " + newArnConvert);
        
    }

    private void baseMasRepetida() {
        String strand=AskUserADNString();
        conver.ContarBaseRepetida(strand);
    }

    private String AskUserADNString() {
       String comp= conver.Validate_strand();
       return comp;
    }

    private void baseMenosRepetida() {
        String DNAInput=AskUserADNString();
        conver.ContarBaseMenosRepitada(DNAInput);
    }

    private void Turn_around_strand() {
       String DNAInput=AskUserADNString();
       conver.ReverseString(DNAInput);
    }

    private void nitrogenous_bases_count() {
        String DNAInput=AskUserADNString();
        String comp=conver.bases_count(DNAInput);

    }

    private void ConversARNtoADN() {
        String DNAInput=AskUserADNString();
        String newArnConvert=conver.ConvertRNA_to_DNA(DNAInput);
         System.out.println("ADN NEW : " + newArnConvert);
    }

    private void add_new_user() {
       Usuario user=UserList.FormUser(); 
       UserList.AddNewUser(user);
    }
    


}
