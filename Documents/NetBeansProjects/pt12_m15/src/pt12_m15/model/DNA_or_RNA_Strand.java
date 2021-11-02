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
 * @author 
 */
public class DNA_or_RNA_Strand {
    private MenuDAO menudao;
    
    
    public String ConvertDNA_to_RNA(String DNAInput){
        menudao=new MenuDAO();
        return menudao.Conversion_DNA_to_RNA(DNAInput);
       
    }

    public void ContarBaseRepetida(String DNAorRNA_STRAND) {
        menudao=new MenuDAO();
        menudao.Count_most_nitrogenous_bases(DNAorRNA_STRAND);       
    }

    public void ContarBaseMenosRepitada(String DNAorRNA_STRAND) {
        menudao=new MenuDAO();
        menudao.Count_less_nitrogenous_bases(DNAorRNA_STRAND);
        
        
    }

    public String bases_count(String DNAInput) {
        menudao=new MenuDAO();
        
        return menudao.count_nitrogenous_bases(DNAInput);
        
    }

    public String ConvertRNA_to_DNA(String DNAInput) {
        menudao=new MenuDAO();
        return menudao.Conversion_RNA_to_DNA(DNAInput);
        
    }

    public void ReverseString(String DNAInput) {
        menudao=new MenuDAO();
        menudao.ReverseString_function(DNAInput);
        
    }

    public String Validate_strand() {
        
        menudao=new MenuDAO();
        return menudao.Validate_strand_function();

    }
}
