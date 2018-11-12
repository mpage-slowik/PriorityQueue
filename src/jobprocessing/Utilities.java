/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobprocessing;

import java.io.*;

/**
 *
 * @author Max Page-Slowik
 */
public class Utilities {
    /**
     * Write the output to the file
     * @param str the final string to be written
     */
    public static void WriteToFile(String str){

        try (BufferedWriter buff =  new BufferedWriter(new FileWriter("./SimulatorPerformanceResults.txt"))) {
                buff.write(str);
            }
        catch (IOException ioe){
            System.out.println("Error writing to file \n" +ioe.getMessage());
        }
       
    }
}
