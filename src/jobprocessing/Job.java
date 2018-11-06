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
public class Job{
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
     *  Returns the name of the current job
     * @return 
     */
    public String getJobName() {
        return jobName;
    }
    /**
     * Sets the job name
     * @param jobName 
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    /**
     * Gets the total length of the job(CPU cycles)
     * [1-70]
     * @return 
     */
    public int getJobLength() {
        return jobLength;
    }
    /**
     * Sets the total length of the job(CPU cycles)
     * [1-70]
     * @param jobLength 
     */
    public void setJobLength(int jobLength) {
        this.jobLength = jobLength;
    }
    /**
     * Gets the remaining length
     * @return 
     */
    public int getCurrentJobLength() {
        return currentJobLength;
    }
    /**
     * Sets the remaining length
     * @param currentJobLength 
     */
    public void setCurrentJobLength(int currentJobLength) {
        this.currentJobLength = currentJobLength;
    }
    /**
     * Gets the initial priority the job
     * [1-40]
     * @return 
     */
    public int getJobPriority() {
        return jobPriority;
    }
    /**
     * Sets the initial priority
     * [1-40]
     * @param jobPriority 
     */
    public void setJobPriority(int jobPriority) {
        this.jobPriority = jobPriority;
    }
    /**
     * Gets the final priority at termination
     * [1-40]
     * @return 
     */
    public int getFinalPriority() {
        return finalPriority;
    }
    /**
     * Sets the final priority at termination
     * [1-40]
     * @param finalPriority 
     */
    public void setFinalPriority(int finalPriority) {
        this.finalPriority = finalPriority;
    }
    /**
     * Gets the time entered the priority queue
     * @return 
     */
    public long getEntryTime() {
        return entryTime;
    }
    /**
     * Sets the entry time onto the priority queue
     * @param entryTime 
     */
    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
    /**
     * Gets the time which the job ended at
     * @return 
     */
    public long getEndTime() {
        return endTime;
    }
    /**
     * Sets the time which the job ended
     * @param endTime 
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    /**
     * Gets the time from which it was in the queue till the end of the job
     * @return 
     */
    public long getWaitTime() {
        return waitTime;
    }
    /**
     * Sets the time which the job waited from entering the queue to ending
     * @param waitTime 
     */
    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return "Job{" + "jobName=" + jobName + ", jobLength=" + jobLength + ", currentJobLength=" + currentJobLength + ", jobPriority=" + jobPriority + ", finalPriority=" + finalPriority + '}';
    }

}
