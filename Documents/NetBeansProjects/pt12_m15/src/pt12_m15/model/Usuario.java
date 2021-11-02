/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.model;

import java.util.InputMismatchException;
import java.util.Scanner;
import pt12_m15.persist.UserDAO;

/**
 *
 * @author J1E2S
 */
public class Usuario {
    
    private UserDAO userdao;
    
    
    private String nickname;
    private String password;
    private String role;

    public Usuario(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public Usuario(String nickname, String password, String role) {
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }

    public Usuario() {
        
    }
    


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nickname=" + nickname + ", password=" + password + ", role=" + role + '}';
    }
    /**
     * This function its for validate the login user
     * @param username {String} username
     * @param password {String} password
     * @return {String[]} array strings to validate the login
     */
    public String[] loginUser(String username, String password) {
        //inicializate the userdao
        userdao=new UserDAO();
        //this function call to the function to find in the CSV
       return userdao.findUserLogin(username,password);
    }
    /**
     * This form its for ask the user the data to the new user
     * @return 
     */
    public Usuario FormUser() {
        Usuario user=new Usuario();
        String nickname,password,role;
        
        
        nickname=AskNickname();
        if(nickname==null){
            return user=null;
        }
        
        password=AskPassword();
        if(password==null){
            return user=null;
        }
        
        role="USER";
        user=new Usuario(nickname,password,role);
        
        return user;     
    }
    /**
     * This fuction its for ask to the user the nickname to add
     * @return {String} nickname
     */
    private String AskNickname() {
        Scanner sc = new Scanner(System.in);
        String nickname;
        System.out.println("Insert your nickname!");
        nickname=sc.nextLine();
        //[A-Za-z ]
          if(!nickname.matches("[a-zA-Z ]")){
            System.out.println("Not valid nickname!!!");
            return nickname=null;
        }else{
            return nickname;
        }
    }
    /**
     * This function will be
     * @return {String} password
     */
    private String AskPassword() {
        Scanner sc = new Scanner(System.in);
        String password;
        System.out.println("Insert your password!");
        password=sc.nextLine();
        //[A-Za-z ]
          if(!password.matches("[0-9]{1,5}")){
            System.out.println("Not valid password!!!");
            return password=null;
        }else{
            return password;
        }
    }
    /**
     * 
     * @param user 
     */
    public void AddNewUser(Usuario user) {
       userdao=new UserDAO();
       userdao.add_new_user(user);
    }
    
    
}
