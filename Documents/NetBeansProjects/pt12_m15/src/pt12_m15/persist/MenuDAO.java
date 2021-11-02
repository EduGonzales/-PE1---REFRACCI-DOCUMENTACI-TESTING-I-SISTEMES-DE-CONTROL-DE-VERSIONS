/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt12_m15.persist;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class MenuDAO implements MenuInterface{

    @Override
    public String Conversion_DNA_to_RNA(String DNAInput) {
         String RNAString = "";
        
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

    public void Count_most_nitrogenous_bases(String DNAorRNA_STRAND) {
        String strand = DNAorRNA_STRAND.toLowerCase();//Pasa la cadena a minúsculas

        int contadorVocales = 0;
        char letraArray[] = strand.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<strand.length(); i++){
            switch(strand.charAt(i)){
                case 'a': case 'g': case 't': case 'c': case 'u':
                    contadorVocales++;
                    break;
            }
        }
        for(int j =0;j<letraArray.length;j++){
            int contador = 0;//Antes de recorrer el array pongo el contador en 0
            for(int k=0;k<letraArray.length;k++){
                if(letraArray[j] == letraArray[k]) //Letra encontrada
                    contador++;
            }
            if(contadorLetraRepetida < contador) { //Si la letra actual superó a la que había antes
                contadorLetraRepetida = contador; //Actualiza el contador de repeticiones con el número máximo
                letra = letraArray[j]; //Actualiza la letra
            }
        }
        System.out.println("La base '" + letra + "' es la mas repetida con  "+ contadorLetraRepetida + " veces.");
    }

    public void Count_less_nitrogenous_bases(String DNAorRNA_STRAND) {
        String strand = DNAorRNA_STRAND.toLowerCase();//Pasa la cadena a minúsculas
        
        int contadorVocales = 0;
        char letraArray[] = strand.toCharArray();
        char letra = letraArray[0];
        int contadorLetraRepetida = 0;

        for(int i=0; i<strand.length(); i++){
            switch(strand.charAt(i)){
                case 'a': case 'g': case 't': case 'c': case 'u':
                    contadorVocales++;
                    break;
            }
        }
        System.out.println("Hay " + contadorVocales + " vocales.");

        for(int j =0;j<letraArray.length;j++){
            int contador = 0;//Antes de recorrer el array pongo el contador en 0
            for(int k=0;k<letraArray.length;k++){
                if(letraArray[j] == letraArray[k]) //Letra encontrada
                    contador++;
            }
            if(contadorLetraRepetida < contador) { //Si la letra actual superó a la que había antes
                contadorLetraRepetida = contadorLetraRepetida; //Actualiza el contador de repeticiones con el número máximo
                letra = letraArray[j]; //Actualiza la letra
            }
        }

        System.out.println("La base '" + letra + "' es la menos repetida con  "+ contadorLetraRepetida + " veces.");
    }

    public String count_nitrogenous_bases(String DNAInput) {
        String RNAString = "";
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
            RNAString = RNAString + DNAInput.charAt(i);
        }
        System.out.println("Hay " + ProteinCounterA + " bases de A");
        System.out.println("Hay " + ProteinCounterC + " bases de C");
        System.out.println("Hay " + ProteinCounterG + " bases de G");
        if(ProteinCounterT==0){
            System.out.println("Hay " + ProteinCounterU + " bases de U");
        }else{
             System.out.println("Hay " + ProteinCounterT + " bases de T");
        }
        return RNAString;
    }

    public String Conversion_RNA_to_DNA(String DNAInput) {
        String error="";
        String RNAString = "";
        
        for (int i = 0; i < DNAInput.length(); i++)
        {
            if(DNAInput.charAt(i) == 'U')
            {
                RNAString = RNAString + "T";
            }
            else
            {                                      
                RNAString = RNAString + DNAInput.charAt(i);
            }
            
        }
        return RNAString;
    }

    public void ReverseString_function(String DNAInput) {
        StringBuilder stringreversed = new StringBuilder();
 
        // append a string into StringBuilder input1
        stringreversed.append(DNAInput);
 
        // reverse StringBuilder input1
        stringreversed.reverse();
 
        // print reversed String
        System.out.println(stringreversed);
    }

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
