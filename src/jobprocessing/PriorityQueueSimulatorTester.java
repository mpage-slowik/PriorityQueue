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

    private static final int[] maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};

    public static void run() {
        //Instatiate Heap     
        ArrayHeap<Job> arrh = new ArrayHeap<>();

        Job[] jobsInputArray = new Job[maxNumberOfJobs[0]];
        int totalTime = populateJobs(jobsInputArray);
        populateQueue(jobsInputArray, arrh);
        //System.out.println(arrh.toString());
        runCPU(arrh, maxNumberOfJobs[0]);

        //Instantiate Unsorted List
        //UnsortedList<Job> ul = new UnsortedList<>();
    }

    private static int populateJobs(Job[] jobInputArray) {
        int totalTime = 0;
        for (int i = 0; i < maxNumberOfJobs[0]; i++) {
            Job j = new Job();
            j.setJobName("JOB_" + (i + 1));
            int jobLength = (int) (Math.random() * 70) + 1;
            j.setJobLength(jobLength);
            j.setCurrentJobLength(jobLength);
            totalTime += jobLength;
            int jobPriority = (int) (Math.random() * 40) + 1;
            j.setJobPriority(jobPriority);
            j.setEntryTime(i + 1);
            jobInputArray[i] = j;
        }
        return totalTime;
    }

    private static void populateQueue(Job[] jobInputArray, ArrayHeap<Job> pq) {
        for (Job job : jobInputArray) {
            pq.add(job);
        }
    }

    //after 30 jobs search for oldest job and increase priority to 1
    private static void runCPU(ArrayHeap<Job> pq, int totalTime) {
        int finishedJobs = 1;
        int timer = totalTime;

        while (pq.size() > 0) {
            Job j = pq.remove();
            System.out.println(j.toString());
            int time = j.getCurrentJobLength();

            time--;

            if (time > 0) { //if theres move time re add
                j.setCurrentJobLength(time);
                j.setWaitTime(timer);
                pq.add(j);
            } else { //if 0, dont re add its done
                finishedJobs++;
                j.setEndTime(timer);
            }
            if (finishedJobs % 30 == 0) {
                starvedResource(pq);
            }
            timer++;
        }
    }

    private static void starvedResource(PriorityQueue<Job> pq) {
        long time = 0;
        Job temp = new Job();
        for (Job j : pq) {
            if (j.getEntryTime() > time) {
                time = j.getEntryTime();
                temp = j;
            }
            pq.remove(temp);
            temp.setJobPriority(1);
            pq.add(temp);
        }
    }
}
