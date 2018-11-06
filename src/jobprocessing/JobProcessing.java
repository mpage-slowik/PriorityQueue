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

//        ArrayHeap list2 = new ArrayHeap();
//
////        list2.add(1);
////        list2.add(2);
////        list2.add(3);
////        list2.add(8);
////        list2.add(4);
////
////        list2.remove(2);
//        Job job = new Job();
//        job.setJobPriority(5);
//        
//        Job job2 = new Job();
//        job2.setJobPriority(1);
//        
//        list2.add(job);
//        list2.add(job2);
//        //list2.remove(job2);
//        System.out.println(list2.toString());
        UnsortedList list2 = new UnsortedList();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(8);
        list2.add(4);

        list2.remove();
        System.out.println(list2.toString());
        PriorityQueueSimulatorTester.run();
    }

}
