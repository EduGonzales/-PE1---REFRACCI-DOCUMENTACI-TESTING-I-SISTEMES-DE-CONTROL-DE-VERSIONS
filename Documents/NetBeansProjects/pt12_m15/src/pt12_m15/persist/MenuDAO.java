/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.persist;

import java.util.Scanner;

/**
 *
 * @author daniel and jesus
 */
public class MenuDAO implements MenuInterface{
    /**
     * This function will be convert the strand dna to rna
     * @param DNAInput {String} dna_strand
     * @return {String} RNA_sTRAND
     */
    @Override
    public String Conversion_DNA_to_RNA(String DNAInput) {
        //variable null 
         String RNAString = "";
        //for for convers the t in u -> DNA TO RNA
        for (int i = 0; i < DNAInput.length(); i++)
        {
            if(DNAInput.charAt(i) == 'T')
            {
                RNAString = RNAString + "U";
            }
            else
            {                                     
                RNAString = RNAString + DNAInput.charAt(i);
            }
            
        }
        return RNAString;
    }
    /**
     * This function will be count the most nitrogenous bases in the strand
     * @param DNAorRNA_STRAND {String} strand of RNA OR DNA
     */
    public void Count_most_nitrogenous_bases(String DNAorRNA_STRAND) {
        String strand = DNAorRNA_STRAND.toLowerCase();//Pasa la cadena a minúsculas

        int Cont_nitrogenous_bases = 0;
        char charArray[] = strand.toCharArray();
        char chaR = charArray[0];
        int count_repeated = 0;

        for(int i=0; i<strand.length(); i++){
            switch(strand.charAt(i)){
                case 'a': case 'g': case 't': case 'c': case 'u':
                    Cont_nitrogenous_bases++;
                    break;
            }
        }
        for(int j =0;j<charArray.length;j++){
            int contador = 0;//counter to 0 
            for(int k=0;k<charArray.length;k++){
                if(charArray[j] == charArray[k]) //char founded
                    contador++;
            }
            if(count_repeated < contador) { //If the current letter exceeded the one before
                count_repeated = contador; //Update the rep counter with the maximum number
                chaR = charArray[j]; //update the char
            }
        }
        System.out.println("Nitrogenous base '" + chaR + "' is the most repeated with  "+ count_repeated + " TIMES.");
    }
    /**
     * This function will be count the LESS nitrogenous bases in the strand
     * @param DNAorRNA_STRAND {String} strand of RNA OR DNA
     */
    public void Count_less_nitrogenous_bases(String DNAorRNA_STRAND) {
        String strand = DNAorRNA_STRAND.toLowerCase();//Pasa la cadena a minúsculas
        
        int Count_char = 0;
        char charArray[] = strand.toCharArray();
        char chaR = charArray[0];
        int count_repeated = 0;

        for(int i=0; i<strand.length(); i++){
            switch(strand.charAt(i)){
                case 'a': case 'g': case 't': case 'c': case 'u':
                    Count_char++;
                    break;
            }
        }

        for(int j =0;j<charArray.length;j++){
            int contador = 0;//counter to 0 
            for(int k=0;k<charArray.length;k++){
                if(charArray[j] == charArray[k]) //char founded
                    contador++;
            }
            if(count_repeated < contador) { //If the current letter exceeded the one before
                count_repeated = count_repeated; //Update the rep counter with the maximum number
                chaR = charArray[j]; //update the char
            }
        }

        System.out.println("Nitrogenous base '" + chaR + "' is the less repeated with  "+ count_repeated + " TIMES.");
    }
    /**
     * This function will be count all the nitrogenous bases in the strand
     * @param DNAInput {String} dna or rna strand
     */
    public void count_nitrogenous_bases(String DNAInput) {
        int ProteinCounterA = 0;
        int ProteinCounterG = 0;
        int ProteinCounterC = 0;
        int ProteinCounterT = 0;
        int ProteinCounterU = 0;
        
        for (int i = 0; i < DNAInput.length(); i++)
        {
            if(DNAInput.charAt(i) == 'T')
            {
               ProteinCounterT++;
            }
            else if(DNAInput.charAt(i) == 'G'){
                ProteinCounterG++;
            }else if(DNAInput.charAt(i)== 'C'){
                ProteinCounterC++;
            }else if(DNAInput.charAt(i) == 'A'){
                ProteinCounterA++;
            }else if(DNAInput.charAt(i) == 'U'){
                ProteinCounterU++;
            }
        }
        System.out.println("Hay " + ProteinCounterA + " bases de A");
        System.out.println("Hay " + ProteinCounterC + " bases de C");
        System.out.println("Hay " + ProteinCounterG + " bases de G");
        if(ProteinCounterT==0){
            System.out.println("Hay " + ProteinCounterU + " bases de U");
        }else{
             System.out.println("Hay " + ProteinCounterT + " bases de T");
        }
    }
    /**
     * This function will ve conversion a strand of RNA TO DNA
     * @param RNA_STRAND {String} rna_Strand
     * @return {String} DNA_STRAND
     */
    public String Conversion_RNA_to_DNA(String RNA_STRAND) {
        //DEClarate variable for the DNA STRAND
        String DNA_sTRING = "";
        
        for (int i = 0; i < RNA_STRAND.length(); i++)
        {
            if(RNA_STRAND.charAt(i) == 'U')
            {
                DNA_sTRING = DNA_sTRING + "T";
            }
            else
            {                                      
                DNA_sTRING = DNA_sTRING + RNA_STRAND.charAt(i);
            }
            
        }
        return DNA_sTRING;
    }
    /**
     * this function will be reverse the strand 
     * @param DNAInput {String}strand_reversed
     */
    public void ReverseString_function(String DNAInput) {
        StringBuilder stringreversed = new StringBuilder();
 
        // append a string into StringBuilder stringreversed
        stringreversed.append(DNAInput);
 
        // reverse StringBuilder stringreversed
        stringreversed.reverse();
 
        // print reversed String
        System.out.println(stringreversed);
    }
    /**
     * This function its for validate the strand, RNA OR DNA
     * @return {String} dna or rna
     */
    public String Validate_strand_function() {
                Scanner sc=new Scanner(System.in);
        System.out.println("Introduce the strand : ");
        String strand_unvalidaded=sc.nextLine();
        
        char[] caractersADN = strand_unvalidaded.toCharArray();
          //declaring variables to count nitrogenous bases
        int ContA=0,ContT=0,ContG=0,ContC = 0,ContU=0;
        int index=0;
           for (char c : caractersADN) {
                    index++;
            switch (c) {
                case 'A':
                    ContA++;
                    break;
                case 'T':
                    ContT++;
                    break;
                case 'G':
                    ContG++;
                    break;
                case 'C':
                    ContC++;
                    break;
                case 'U':
                    ContU++;
                    break;
                default:
                    System.out.println("Error. Invalid DNA or RNA sequence.");
                    System.out.println("In position " + index + " there is one character that is not valid");
                    System.exit(0);
                    break;
            
        }
      
       
    }
           return strand_unvalidaded;
    }
    
}
