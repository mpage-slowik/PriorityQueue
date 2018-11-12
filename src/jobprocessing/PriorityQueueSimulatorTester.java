package jobprocessing;

import java.util.PriorityQueue;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class PriorityQueueSimulatorTester {

    private static final int[] maxNumberOfJobs = {100, 1000};
    
    public static void run() {
        StringBuilder sb = new StringBuilder();

        for (int currLength : maxNumberOfJobs) {
            //Instatiate Heap     
            ArrayHeap<Job> arrh = new ArrayHeap<>();

            Job[] jobsInputArray = new Job[currLength];
            populateJobs(jobsInputArray);

            long startTime = System.currentTimeMillis();
            populateQueue(jobsInputArray, arrh);
            //run CPU
            System.out.println("Array Heap");
            int[] numbers = runCPU(arrh, currLength);

            long endTime = System.currentTimeMillis();
            long ellapsedTime = endTime - startTime;
            //Print to file
            sb.append("Array Heap\r\n");
            sb.append("Current system time (cycles): ").append(numbers[1]).append("\r\n");
            sb.append("Total number of jobs executed: ").append(currLength).append(" jobs\r\n");
            sb.append("Average process waiting time: ").append(numbers[2]).append(" cycles\r\n");
            sb.append("Total number of priority changes: ").append(numbers[0]).append("\r\n");
            sb.append("Actual system time needed to execute all jobs: ").append(ellapsedTime).append(" ms\r\n");

            //Instantiate Unsorted List
            UnsortedList<Job> ul = new UnsortedList<>();

            Job[] jobsInputArray2 = new Job[currLength];
            populateJobs(jobsInputArray2);

            long startTime2 = System.currentTimeMillis();
            populateQueue(jobsInputArray2, ul);
            //run CPU
            System.out.println("Unsorted List");
            int[] numbers2 = runCPU(ul, currLength);
            
            long endTime2 = System.currentTimeMillis();
            long ellapsedTime2 = endTime2 - startTime2;

            //Print to file
            sb.append("Unsorted List\r\n");
            sb.append("Current system time (cycles): ").append(numbers2[1]).append("\r\n");
            sb.append("Total number of jobs executed: ").append(currLength).append(" jobs\r\n");
            sb.append("Average process waiting time: ").append(numbers2[2]).append(" cycles\r\n");
            sb.append("Total number of priority changes: ").append(numbers2[0]).append("\r\n");
            sb.append("Actual system time needed to execute all jobs: ").append(ellapsedTime2).append(" ms\r\n");
            
        }
        Utilities.WriteToFile(sb.toString());
    }

    private static void populateJobs(Job[] jobInputArray) {

        for (int i = 0; i < jobInputArray.length; i++) {
            Job j = new Job();
            j.setJobName("JOB_" + (i + 1));
            int jobLength = (int) (Math.random() * 70) + 1;
            j.setJobLength(jobLength);
            j.setCurrentJobLength(jobLength);
            int jobPriority = (int) (Math.random() * 40) + 1;
            j.setJobPriority(jobPriority);
            j.setFinalPriority(jobPriority);
            j.setEntryTime((i + 1));
            jobInputArray[i] = j;
        }
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
