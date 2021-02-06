/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.projectperson.servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.persons.model.Model;
import project.persons.model.Person;

/**
 *
 * @author Waner Kevin
 */
public class ProjectPersonServlet extends HttpServlet{
     private project.persons.model.Model model;
     
     public void init() throws ServletException{
         try {
             this.model = new Model();
         } catch (ParseException ex) {
             Logger.getLogger(ProjectPersonServlet.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     @Override
     protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
         procesRequest(request,response);
         //Reponde a peticiones del metodo get
     }
     
     @Override
     protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
         procesRequest(request,response);
         //En el request viene la informacion de la peticion
        //EL response tiene la informacion de la respuesta a la peticion
        //Hace peticiones del post
     }
     

    private void procesRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        listAllPersons(request,response);
        //listAllProjects(request,response);
        
    }

    private void listAllPersons(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        //List<Person> listEmployee = model.findAllPerson();
        List <Person> listEmployee = (List<Person>) model.findAllPerson();
        
        try(PrintWriter out = response.getWriter()){
            for (Person elem : listEmployee) {
                System.out.println(elem.toString());
                out.print(elem.toString());
            }
        }
    }
    
 /*  private void listAllProjects(HttpServletRequest request, HttpServletResponse response) throws IOException  {
        //List<Person> listEmployee = model.findAllPerson();
        List <Person> listEmployee = (List<Person>) model.findAllPerson();
        
        try(PrintWriter out = response.getWriter()){
            for (Person elem : listEmployee) {
                System.out.println(elem.toString());
                out.print(elem.toString());
            }
        }
    }*/
    
     
}
