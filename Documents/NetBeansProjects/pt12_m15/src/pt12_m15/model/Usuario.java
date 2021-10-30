/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.model;

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

    public String[] loginUser(String username, String password) {
        userdao=new UserDAO();
       return userdao.findUserLogin(username,password);
    }
    
    
}
