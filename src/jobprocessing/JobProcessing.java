/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobprocessing;

/**
 *
 * @author Max Page-Slowik
 */
public class JobProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        UnsortedList list = new UnsortedList();
        
        list.add("Hi");
        list.add("Yo");
        list.add("Hola");
        System.out.println(list.toString());
        list.remove();
        System.out.println(list.toString());
        list.remove("Hola");
        System.out.println(list.toString());
                
    }
    
}
