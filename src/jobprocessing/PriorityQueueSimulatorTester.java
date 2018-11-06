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
public class PriorityQueueSimulatorTester {
    private static final int[] maxNumberOfJobs = {100,1000,10000,100000,1000000};
    public static void run(){
        //Instantiate List
        //Instatiate Heap
        
    }
    
    private static void populateJobs(){
        for(int i = 0; i<maxNumberOfJobs[0] ;i++){
            Job j = new Job();
            j.setJobName("JOB_"+(i+1));
            j.setJobLength((int)(Math.random()*70)+1);
            int jobPriority=(int)(Math.random()*40)+1;
            j.setJobPriority(jobPriority);
            
        }
    }
}
