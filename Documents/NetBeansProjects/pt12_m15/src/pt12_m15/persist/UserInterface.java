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
    
    public String[] findUserLogin(String username, String password);
    
    public void add_new_user(Usuario user);
    
    
}
