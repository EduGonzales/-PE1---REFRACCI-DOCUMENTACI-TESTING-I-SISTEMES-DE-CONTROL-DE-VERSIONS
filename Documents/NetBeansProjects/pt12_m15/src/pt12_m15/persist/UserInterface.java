/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.persist;

import pt12_m15.model.Usuario;

/**
 *
 * @author J1E2S
 */
public interface UserInterface {
    /**
     * this function will be find in the csv the username , password and role to login
     * @param username {String} username
     * @param password {String} password
     * @return {String[]} string of arrays to validate the role
     */
    public String[] findUserLogin(String username, String password);
    /**
     * This function in a future will be use for add a new user in the csv
     * @param user 
     */
    public void add_new_user(Usuario user);
    
    
}
