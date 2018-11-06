/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobprocessing;

import java.util.PriorityQueue;

/**
 *
 * @author Max Page-Slowik
 */
public class PriorityQueueSimulatorTester {
    private static final int[] maxNumberOfJobs = {100,1000,10000,100000,1000000};
    public static void run(){
        //Instatiate Heap     
        ArrayHeap<Job> arrh = new ArrayHeap<>();
        //Instantiate Unsorted List
        UnsortedList<Job> ul = new UnsortedList<>();
        populateJobs(arrh);
        //System.out.println(arrh.toString());
        runCPU(arrh);
    }
    
    private static int populateJobs(PriorityQueue<Job> pq){
        int totalTime =0;
        for(int i = 0; i<maxNumberOfJobs[0] ;i++){
            Job j = new Job();
            j.setJobName("JOB_"+(i+1));
            int jobLength = (int)(Math.random()*70)+1;
            j.setJobLength(jobLength);
            j.setCurrentJobLength(jobLength);
             totalTime+=jobLength;
            int jobPriority=(int)(Math.random()*40)+1;
            j.setJobPriority(jobPriority);
            j.setEntryTime(i+1);
            pq.add(j);
        }
        return totalTime;
    }
    //after 30 jobs search for oldest job and increase priority to 1
    private static void runCPU(PriorityQueue<Job> pq){
        int totalTime = 0;
        for(int i = 0;i<pq.size() ;i++){
            Job j = pq.remove();
            int time = j.getCurrentJobLength();
            time--;
            if(time >0){
                j.setCurrentJobLength(time);
                pq.add(j);
            }
        }
    }
}
