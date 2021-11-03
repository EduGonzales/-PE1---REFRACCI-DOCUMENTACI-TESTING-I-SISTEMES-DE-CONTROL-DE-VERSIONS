/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.persist;

/**
 *
 * @author jesus
 */
public interface MenuInterface {
    /**
     * This function will be convert the strand dna to rna
     * @param DNAInput {String} dna_strand
     * @return {String} RNA_sTRAND
     */
     public String Conversion_DNA_to_RNA(String DNAInput);
     
    /**
     * This function will be count the most nitrogenous bases in the strand
     * @param DNAorRNA_STRAND {String} strand of RNA OR DNA
     * @return {boolean} comp
     */
     public boolean Count_most_nitrogenous_bases(String DNAorRNA_STRAND);
    /**
     * This function will be count the LESS nitrogenous bases in the strand
     * @param DNAorRNA_STRAND {String} strand of RNA OR DNA
     */
     public void Count_less_nitrogenous_bases(String DNAorRNA_STRAND);
    /**
     * This function will be count all the nitrogenous bases in the strand
     * @param DNAInput {String} dna or rna strand
     */
     public void count_nitrogenous_bases(String DNAInput);
    /**
     * This function will ve conversion a strand of RNA TO DNA
     * @param RNA_STRAND {String} rna_Strand
     * @return {String} DNA_STRAND
     */
     public String Conversion_RNA_to_DNA(String RNA_STRAND);
    /**
     * this function will be reverse the strand 
     * @param DNAInput {String}strand_reversed
     */
     public void ReverseString_function(String DNAInput);
    /**
     * This function its for validate the strand, RNA OR DNA
     * @return {String} dna or rna
     */
     public String Validate_strand_function(String strand_unvalidaded);
}
