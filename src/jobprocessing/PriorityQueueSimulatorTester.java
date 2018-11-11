package jobprocessing;

import java.util.PriorityQueue;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class PriorityQueueSimulatorTester {

    private static final int[] maxNumberOfJobs = {100, 1000, 10000, 100000, 1000000};

    public static void run() {
        //Instatiate Heap     
        ArrayHeap<Job> arrh = new ArrayHeap<>();

        Job[] jobsInputArray = new Job[maxNumberOfJobs[0]];
        int totalTime = populateJobs(jobsInputArray);

        long startTime = System.currentTimeMillis();
        populateQueue(jobsInputArray, arrh);

        int[] numbers = runCPU(arrh, maxNumberOfJobs[0]);

        long endTime = System.currentTimeMillis();
        long ellapsedTime = endTime - startTime;

        //Instantiate Unsorted List
        UnsortedList<Job> ul = new UnsortedList<>();

        Job[] jobsInputArray2 = new Job[maxNumberOfJobs[0]];
        int totalTime2 = populateJobs(jobsInputArray2);

        long startTime2 = System.currentTimeMillis();
        populateQueue(jobsInputArray2, ul);

        int[] numbers2 = runCPU(ul, maxNumberOfJobs[0]);
        long endTime2 = System.currentTimeMillis();
        long ellapsedTime2 = endTime2 - startTime2;

        //Print to file
        System.out.println("Current system time (cycles): " + numbers2[1]);
        System.out.println("Total number of jobs executed: " + maxNumberOfJobs[0] + " jobs");
        System.out.println("Average process waiting time: " + numbers2[2] + " cycles");
        System.out.println("Total number of priority changes: " + numbers2[0]);
        System.out.println("Actual system time needed to execute all jobs: " + ellapsedTime + " ms");
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
            j.setFinalPriority(jobPriority);
            j.setEntryTime((i + 1));
            jobInputArray[i] = j;
        }
        return totalTime;
    }

    private static void populateQueue(Job[] jobInputArray, ArrayHeap<Job> pq) {
        for (Job job : jobInputArray) {
            pq.add(job);
        }
    }

    private static void populateQueue(Job[] jobInputArray, UnsortedList<Job> pq) {
        for (Job job : jobInputArray) {
            pq.add(job);
        }
    }

    //after 30 jobs search for oldest job and increase priority to 1
    private static int[] runCPU(PriorityQueue<Job> pq, int totalTime) {
        int finishedJobs = 1;
        int timer = totalTime;
        int priorityChange = 0;
        int averageWaitingTime = 0;
        int size = pq.size();

        while (pq.size() > 0) {
            Job j = pq.remove();
            int time = j.getCurrentJobLength();
            time--;
            System.out.println("Now executing " + j.getJobName() + ". Job length: "
                    + j.getJobLength() + " cycles; Current remaining length: "
                    + j.getCurrentJobLength() + " cycles; Initial priority: "
                    + j.getJobPriority() + "; Current priority: " + j.getFinalPriority());
            if (time > 0) { //if theres move time re add
                j.setCurrentJobLength(time);
                j.setWaitTime(timer);
                pq.add(j);
            } else { //if 0, dont re add its done
                finishedJobs++;
                j.setEndTime(timer);
                //System.out.println(j.toString());
                averageWaitingTime += timer;
            }
            if (finishedJobs % 30 == 0) {
                starvedResource(pq);
                priorityChange++;
            }

            timer++;
        }
        averageWaitingTime = (int) (averageWaitingTime / size);
        return new int[]{priorityChange, timer, averageWaitingTime};
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
            temp.setFinalPriority(1);
            pq.add(temp);
        }
    }
}
