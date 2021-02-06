/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.projectperson.lib;
import javax.servlet.http.HttpServletRequest;
import project.persons.model.Person;

/**
 *
 * @author Edu y Carla
 */
public class ProjectPersonForm {
    public static Person ofPersonForm(HttpServletRequest request){
        Person person = null;
        
        try {
            //String id = request.getParameter("id");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            //Date birthday = request.getParameter("birthday");
            String role = request.getParameter("role");
            if(/*id == null ||*/ name == null || surname ==null ||/* birthday == null || */role == null){
                person = null;
            }else{
                person = new Person(name, surname, role);
            }
        } catch (NumberFormatException e) {
            person = null;
        }
        return person;
    }
    
    public static RequestResult getParameters(HttpServletRequest request){
        RequestResult result = null;
        Person person = null;
        int code = 0;
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String role = request.getParameter("role");
            if(name == null){
                code = -1;
            }else if(surname == null){
                code = -2;
            }else if(role == null){
                code = -3;
            }else{
                person = new Person(name, surname, role);
            }
        } catch (NumberFormatException e) {
            code = -4;
        }
        if(person != null){
            result = new RequestResult(person, 1);
        }else{
            result = new RequestResult("Error in parameters",code);
        }
        return result;
    }

    public static Person Person(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
