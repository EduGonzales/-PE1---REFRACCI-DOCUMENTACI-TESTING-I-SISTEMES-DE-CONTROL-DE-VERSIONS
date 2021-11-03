/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pt12_m15.persist.MenuDAO;
import pt12_m15.persist.UserDAO;

/**
 *
 * @author alumne
 */
public class NewEmptyJUnitTest extends TestCase{
    private UserDAO userdao;
    private MenuDAO menudao;
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    // public void hello() {}
    /**
     * This test validates the convers the DNA-STRAND TO RNA_STRAN, the test must be true in this case
     */
    public void test1(){
        menudao = new MenuDAO();
        boolean resultado_previo=true;
        String DNAInput="AGTAGTC";
        String FINALE=menudao.Conversion_DNA_to_RNA(DNAInput);
        System.out.println(FINALE);
        
         boolean resultado_Real=true;
         
         if (FINALE.equals("Not correct strand")) {
             resultado_Real=false;
            }
         assertEquals(resultado_previo,resultado_Real);
    }
    /**
     * This test validates the convers the DNA-STRAND TO RNA_STRAN, the test must be false in this case
     */
    public void test2(){
        boolean resultado_previo=true;
        menudao = new MenuDAO();
        String DNAInput="AGTAGVC";
        String FINALE=menudao.Conversion_DNA_to_RNA(DNAInput);
        System.out.println(FINALE);
        
        boolean resultado_Real=true;
         
         if (FINALE.equals("Not correct strand")) {
             resultado_Real=false;
            }
         assertEquals(resultado_previo,resultado_Real);
    }
    
    /**
     * This test validates the user logins, the test must be true in order to prpceed.
     */
    public void test3(){
        userdao = new UserDAO();
        String username="jesus";
         String password="1234";
        boolean resultado_previo=true;
         String[] res=userdao.findUserLogin(username, password);
         //System.out.println(res);
         
         
         boolean resultado_Real=true;
         
         if (res[0].equals("error")) {
             resultado_Real=false;
        }
         assertEquals(resultado_previo,resultado_Real);
    }
    /**
     * This test validates the user logins, the test must be false in order to prpceed.
     */
    public void test4(){
        userdao = new UserDAO();
        String username="pedro";
         String password="124";
        boolean resultado_previo=true;
         String[] res=userdao.findUserLogin(username, password);
         //System.out.println(res);
         
         
         boolean resultado_Real=true;
         
         if (res[0].equals("error")) {
             resultado_Real=false;
        }
         assertEquals(resultado_previo,resultado_Real);
    }
    /**
     * This test validates the strand introduced by the user, the test must be true in this case
     */
    public void test5(){
        boolean resultado_previo=true;
        menudao=new MenuDAO();
        String strand="AGTAGTC";
        String comp=menudao.Validate_strand_function(strand);
        
         boolean resultado_Real=true;
         
         if (comp.equals("")) {
             resultado_Real=false;
        }
         assertEquals(resultado_previo,resultado_Real);
    }
    /**
     * This test validates the strand introduced by the user, the test must be false in this case
     */
    public void test6(){
        boolean resultado_previo=true;
        menudao=new MenuDAO();
        String strand="AGTYGC";
        String comp=menudao.Validate_strand_function(strand);
        
         boolean resultado_Real=true;
         
         if (comp.equals("")) {
             resultado_Real=false;
        }
         assertEquals(resultado_previo,resultado_Real);
    }
    
    public void test7(){
        boolean resultado_previo=true;
        menudao=new MenuDAO();
        String strand="AGTAGTCCATAG";
        boolean comp=menudao.Count_most_nitrogenous_bases(strand);
        
         boolean resultado_Real=true;
         
         if (!comp) {
             resultado_Real=false;
        }
         assertEquals(resultado_previo,resultado_Real);
    }
        
    public void test8(){
        boolean resultado_previo=true;
        menudao=new MenuDAO();
        String strand="AGTYGTCCATAG";
        boolean comp=menudao.Count_most_nitrogenous_bases(strand);
        
         boolean resultado_Real=true;
         
         if (!comp) {
             resultado_Real=false;
        }
         assertEquals(resultado_previo,resultado_Real);
    }
}
