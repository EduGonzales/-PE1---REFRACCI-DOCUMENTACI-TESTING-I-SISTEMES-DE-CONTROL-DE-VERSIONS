/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.projectperson.servelts;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.persons.model.Model;
import project.persons.model.Person;
import project.persons.model.Project;
import proven.projectperson.lib.ProjectPersonForm;
import proven.projectperson.lib.RequestResult;

/**
 *
 * @author Waner Kevin
 */
public class ProjectPersonServletJson extends HttpServlet{
    private project.persons.model.Model model;
    
    @Override
    public void init() throws ServletException {
        try {
            this.model = new Model();
        } catch (ParseException ex) {
            Logger.getLogger(ProjectPersonServletJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String action = request.getParameter("action");
        //Para saber que accion quiere realizar el cleinte
        //Lo cogemos del action con el request.getParameter("action");
        
        if(action!=null){
            switch (action) {
                case "listAllPersons":
                        listAllPersons(request,response);
                    break;
                case "listAllProjects":
                        listAllProjects(request,response);
                    break;
                case "searchPersonById":
                    searchPersonById(request,response);
                    break;
                case "searchPersonByName":
                    searchPersonByName(request,response);
                    break;
                case "searchPersonBySurmame":
                    searchPersonBySurname(request,response);
                    break;
                case "searchPersonByRole":
                   searchPersonByRole(request,response);
                    break;
                case "searchProjectById":
                   searchProjectById(request,response);
                    break;                  
                default:
                    //El metodo que tendremos en caso de error
                    redirectError(request,response, "method_not_allowed");
                    break;
            }
        }else{
            redirectError(request, response,"no_action");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String action = request.getParameter("action");
        
        if(action != null){
            switch(action){
                case "addPerson":
                    addNewPerson(request,response);
                    break;
                case "addProject":
                    addNewProject(request,response);
                    break;
                case "modifyPerson":
                    modifyPerson(request,response);
                    break;
                case "deletePerson":
                     deletePerson(request,response);
                    break;
                default:
                    redirectError(request, response,"method_not_allowed");
                    break;
            }
        }else{
            redirectError(request, response,"no_action");
        }
    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redirectError(request, response, "method_not_allowed");
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redirectError(request, response, "method_not_allowed");
    }

    private void listAllPersons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //List<Person> listPerson = model.findAllPerson();
        List <Person> listPerson = (List<Person>) model.findAllPerson();
        RequestResult result = new RequestResult(listPerson, 1);
        request.setAttribute("result", result);
            RequestDispatcher rd = getServletContext().getNamedDispatcher("/WEB-INF/jsp/json-result.jsp");
            rd.forward(request, response); */
       
        List<Person> entityList = (List<Person>) model.findAllPerson();
        RequestResult result = new RequestResult(entityList, 1);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
            .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    private void listAllProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* //List<Person> listPerson = model.findAllPerson();
        List <Person> listPerson = (List<Person>) model.findAllPerson();
        RequestResult result = new RequestResult(listPerson, 1);
        request.setAttribute("result", result);
            RequestDispatcher rd = getServletContext().getNamedDispatcher("/WEB-INF/jsp/json-result.jsp");
            rd.forward(request, response); */
       
        List<Project> entityList = (List<Project>) model.findAllProjects();
        RequestResult result = new RequestResult(entityList, 1);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
            .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    private void searchPersonById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        RequestResult result;
        if(id != null){
            long longId = new Long(Long.parseLong(id));
            //Person personId = model.findPersonById(longId);
            //Person person = new Person(longId);
            Person fundPerson = model.findById(longId);
            if(fundPerson != null){
                result = new RequestResult(fundPerson, 1);
            }else{
                result = new RequestResult(null, -2);
            }
            
        }else{
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result",result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);    
   
    }
    private void searchPersonByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        RequestResult result;
        if(name != null){
            String longId = name;
            //Person personId = model.findPersonById(longId);
            //Person person = new Person(longId);
            List<Person> fundPerson = model.findByName(longId);
            if(fundPerson != null){
                result = new RequestResult(fundPerson, 1);
            }else{
                result = new RequestResult(null, -2);
            }
            
        }else{
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result",result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);    
   
    }
    private void searchPersonBySurname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("surname");
        RequestResult result;
        if(name != null){
            String longId = name;
            //Person personId = model.findPersonById(longId);
            //Person person = new Person(longId);
            List<Person> fundPerson = model.findBySurname(longId);
            if(fundPerson != null){
                result = new RequestResult(fundPerson, 1);
            }else{
                result = new RequestResult(null, -2);
            }
            
        }else{
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result",result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);    
   
    }
    private void searchPersonByRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        RequestResult result;
        if(role != null){
            String rol = role;
            //Person personId = model.findPersonById(longId);
            //Person person = new Person(longId);
            List<Person> fundPerson = model.findByRole(rol);
            if(fundPerson != null){
                result = new RequestResult(fundPerson, 1);
            }else{
                result = new RequestResult(null, -2);
            }
            
        }else{
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result",result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);    
   
    }
    private void searchProjectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        RequestResult result;
        if(id != null){
            long longId = new Long(Long.parseLong(id));
            //Person personId = model.findPersonById(longId);
            //Person person = new Person(longId);
            Project fundPerson = model.findProjectById(longId);
            if(fundPerson != null){
                result = new RequestResult(fundPerson, 1);
            }else{
                result = new RequestResult(null, -2);
            }
            
        }else{
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result",result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);    
   
    }
    //arreglar
   /* private void searchPersonByBirthdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("birhdate");
        RequestResult result;
        if(name != null){
            Date longId = name;
            //Person personId = model.findPersonById(longId);
            //Person person = new Person(longId);
            List<Person> fundPerson = model.findByBirthdate(longId);
            if(fundPerson != null){
                result = new RequestResult(fundPerson, 1);
            }else{
                result = new RequestResult(null, -2);
            }
            
        }else{
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result",result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);    
   
    }*/
    private void redirectError(HttpServletRequest request, HttpServletResponse response, String error) throws IOException {
    String errorMsg;
        int errorCode;
        switch (error) {
            case "bad_parameter": // bad parameter action
                errorMsg = "Invalid action parameter";
                errorCode = HttpServletResponse.SC_BAD_REQUEST;
                break;
            case "method_not_allowed": //method not allowed.
                errorMsg = "Method not allowed";
                errorCode = HttpServletResponse.SC_METHOD_NOT_ALLOWED;
                break;
            default: // need parameter action
                errorMsg = "Parameter action needed";
                errorCode = HttpServletResponse.SC_BAD_REQUEST;
                break;
        }
        response.sendError(errorCode, errorMsg);
    }

    private void addNewPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int resultCode = -1;
        Person newPerson;
        newPerson = ProjectPersonForm.Person(request);
        if(newPerson != null){
            boolean condicion = model.addPerson(newPerson);
            if(condicion){
                resultCode = 1;
            }else{
                resultCode = -1;
            }
        }else{
            resultCode = -1;
        }
        RequestResult result = new RequestResult(newPerson, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    private void addNewProject(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void modifyPerson(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("EN OBRAS!!");
        System.out.println("TO DO");
    }

    private void deletePerson(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
