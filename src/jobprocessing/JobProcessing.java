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
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(4);
        
        list.remove(2);
        System.out.println(list);
        
        ArrayHeap list2 = new ArrayHeap();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(8);
        list2.add(4);
        
        list2.remove(2);

        System.out.println(list2.toString());

    }

}
