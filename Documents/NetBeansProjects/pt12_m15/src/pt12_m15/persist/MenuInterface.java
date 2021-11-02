/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.persist;

/**
 *
 * @author 
 */
public interface MenuInterface {
     public String Conversion_DNA_to_RNA(String DNAInput);
     
     public void Count_most_nitrogenous_bases(String DNAorRNA_STRAND);
     
     public void Count_less_nitrogenous_bases(String DNAorRNA_STRAND);
     
     public void count_nitrogenous_bases(String DNAInput);
     
     public void ReverseString_function(String DNAInput);
     
     public String Validate_strand_function();
}
