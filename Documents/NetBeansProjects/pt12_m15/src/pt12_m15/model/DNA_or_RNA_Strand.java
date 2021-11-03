/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.model;

import java.util.Scanner;
import pt12_m15.persist.MenuDAO;

/**
 *
 * @author Daniel
 */
public class DNA_or_RNA_Strand {
    //To import the MenuDao
    private MenuDAO menudao;
    
    /**
     * This function will be call another function to converse the DNA STRADN TO RNA
     * @param DNAInput {String} strand_DNA
     * @author Daniel
     * @return {String} strand RNA
     */
    public String ConvertDNA_to_RNA(String DNAInput){
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call the another function in MenuDAO In this case function to convers
        return menudao.Conversion_DNA_to_RNA(DNAInput);
       
    }
    /**
     * This function will be call another function to count the most nitrogenous_base
     * @param DNAorRNA_STRAND {String STRAND of dna or rna}
     * @author Daniel
     */
    public boolean Count_base_most_repeated(String DNAorRNA_STRAND) {
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call the another function in the MENuDAO to count the most repeated nitrogenous_bases
        return menudao.Count_most_nitrogenous_bases(DNAorRNA_STRAND);       
    }
    /**
     * This function will be call another function to count the less nitrogenous_base
     * @param DNAorRNA_STRAND {String STRAND of dna or rna}
     * @author Daniel
     */
    public void Count_base_less_repeated(String DNAorRNA_STRAND) {
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call another function in menudao to count the less repeated nitrogenous_base
        menudao.Count_less_nitrogenous_bases(DNAorRNA_STRAND);
        
        
    }
    /**
     * This function will be call another function to count the number of nitrogenous_bases
     * @param DNAInput {String STRAND of dna or rna}
     * @author Daniel
     */
    public void bases_count(String DNAInput) {
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call another function in menudao to count the nitrogenous_base
        menudao.count_nitrogenous_bases(DNAInput);
        
    }
    /**
     * This function will be call another function to convers the strand_rna to Dna
     * @param DNAInput {String dna_Strand}
     * @return {String} strand of RNA
     * @author Daniel
     */
    public String ConvertRNA_to_DNA(String DNAInput) {
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call another function in menudao to count the convers the strand of RNA TO DNA
        return menudao.Conversion_RNA_to_DNA(DNAInput);
        
    }
    /**
     * This function will be call another function to reverse the strand introduced by the user
     * @param DNAInput {Strand of DNA OR RNA}
     * @author jesus
     */
    public void ReverseString(String DNAInput) {
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call another function in menudao to Reverse the strand
        menudao.ReverseString_function(DNAInput);
        
    }
    /**
     * This function its for validate the dna strand
     * @return {String} reversed strand
     * @author jesus
     */
    public String Validate_strand(String strand_unvalidaded) {
        //inicializate the menudao -> MenuDao and interface
        menudao=new MenuDAO();
        //call another function in menudao to validate the strand
        return menudao.Validate_strand_function(strand_unvalidaded);

    }
}
