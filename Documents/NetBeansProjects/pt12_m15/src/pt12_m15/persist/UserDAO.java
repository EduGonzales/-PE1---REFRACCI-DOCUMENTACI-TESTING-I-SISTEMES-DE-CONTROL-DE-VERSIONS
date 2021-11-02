/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.persist;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pt12_m15.model.Usuario;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author J1E2S
 */
public class UserDAO implements UserInterface {
    /**
     * this function will be find in the csv the username , password and role to login
     * @param username {String} username
     * @param password {String} password
     * @return {String[]} string of arrays to validate the role
     */
    public String[] findUserLogin(String username, String password) {
        //array for save the username and role of the user        
        String[] session_user = new String[3];
        session_user[0]="";
        //variable for validate the user exits
        boolean exists = false;   
        
        try{
            List<Usuario> usuarios = new ArrayList<Usuario>(); // list for save all the users
            
            CsvReader leerUsuarios = new CsvReader("users.csv");
            leerUsuarios.readHeaders();
            // Mientras haya lineas obtenemos los datos del archivo
            while(leerUsuarios.readRecord()) {
                String nickname = leerUsuarios.get(0);
                String pass=leerUsuarios.get(1);
                String role=leerUsuarios.get(2);
                usuarios.add(new Usuario(nickname, pass,role)); // Añade la informacion a la lista
            }
            leerUsuarios.close(); // close the file
            
            // Recorremos la lista y la mostramos en la pantalla
            for(int i=0;i<usuarios.size() && !exists; i++) {
                Usuario p=usuarios.get(i);
                 byte[] decodedpassword = Base64.decodeBase64(p.getPassword());
                 String password_decripted=new String(decodedpassword);
                if(p.getNickname().toLowerCase().equals(username) && password_decripted.equals(password)){
                    System.out.println("Usuario : " + p.getNickname());
                    System.out.println("Contraseña SIN DESENCRIPTAR: " + p.getPassword());
                    System.out.println("Contraseña desincriptada : " + password_decripted );
                    System.out.println("ROL : " + p.getRole());
                    exists =true;
                    String role=p.getRole();
                //if the user exits then validate the role to display the menu 
                if(role.equals("ADMIN")){
                    session_user[0]="true";
                    session_user[1]=username;
                    session_user[2]=p.getRole();
                    return session_user ;
                }else{
                    session_user[0]="false";
                    session_user[1]=username;
                    session_user[2]=p.getRole();
                    return session_user;
                }
                
            }else{
                exists=false;
                session_user[0]="error";
            }
            }
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return session_user;
    }



    public void add_new_user(Usuario user) {
            //to do
         
    }
    
   
}
