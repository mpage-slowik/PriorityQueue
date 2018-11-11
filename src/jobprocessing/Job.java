package jobprocessing;

import java.util.Iterator;

/**
 *
 * @author Max Page-Slowik
 * @author Jesse Silber
 */
public class Job implements Comparable<Job>{

    private String jobName;
    private int jobLength;
    private int currentJobLength;
    private int jobPriority;
    private int finalPriority;
    private long entryTime;
    private long endTime;
    private long waitTime;

    public Job() {
    }

    /**
     * Returns the name of the current job
     *
     * @return Job name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the job name
     *
     * @param jobName Job Name
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Gets the total length of the job(CPU cycles) [1-70]
     *
     * @return Job length
     */
    public int getJobLength() {
        return jobLength;
    }

    /**
     * Sets the total length of the job(CPU cycles) [1-70]
     *
     * @param jobLength Job length
     */
    public void setJobLength(int jobLength) {
        this.jobLength = jobLength;
    }

    /**
     * Gets the remaining length
     *
     * @return Current job length
     */
    public int getCurrentJobLength() {
        return currentJobLength;
    }

    /**
     * Sets the remaining length
     *
     * @param currentJobLength Current job length
     */
    public void setCurrentJobLength(int currentJobLength) {
        this.currentJobLength = currentJobLength;
    }

    /**
     * Gets the initial priority the job [1-40]
     *
     * @return Job Priority
     */
    public int getJobPriority() {
        return jobPriority;
    }

    /**
     * Sets the initial priority [1-40]
     *
     * @param jobPriority Job priority
     */
    public void setJobPriority(int jobPriority) {
        this.jobPriority = jobPriority;
    }

    /**
     * Gets the final priority at termination [1-40]
     *
     * @return Final priority
     */
    public int getFinalPriority() {
        return finalPriority;
    }

    /**
     * Sets the final priority at termination [1-40]
     *
     * @param finalPriority Final priority
     */
    public void setFinalPriority(int finalPriority) {
        this.finalPriority = finalPriority;
    }

    /**
     * Gets the time entered the priority queue
     *
     * @return Entry time
     */
    public long getEntryTime() {
        return entryTime;
    }

    /**
     * Sets the entry time onto the priority queue
     *
     * @param entryTime Entry time
     */
    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    /**
     * Gets the time which the job ended at
     *
     * @return End time
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Sets the time which the job ended
     *
     * @param endTime End time
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the time from which it was in the queue till the end of the job
     *
     * @return Wait time
     */
    public long getWaitTime() {
        return waitTime;
    }

    /**
     * Sets the time which the job waited from entering the queue to ending
     *
     * @param waitTime Wait time
     */
    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return "jobName=" + jobName + ", currentJobLength=" + currentJobLength+ ", jobPriority=" + jobPriority;
    }

    @Override
    public int compareTo(Job o) {
        if (this.getFinalPriority()== o.getFinalPriority()) {
            if (this.getEntryTime() < o.getEntryTime()) {
                return 1;
            } else if (this.getEntryTime() > o.getEntryTime()) {
                return -1;
            } else {
                return 0;
            }
        } else if (this.getFinalPriority() > o.getFinalPriority()) {
            return 1;
        } else {
            return -1;
        }
    }
}
