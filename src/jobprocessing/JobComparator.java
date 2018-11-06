/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobprocessing;

import java.util.Comparator;

/**
 *
 * @author Max Page-Slowik
 */
public class JobComparator implements Comparator<Job>{

    @Override
    public int compare(Job o1, Job o2) {
        if(o1.getJobPriority() ==o2.getJobPriority()){
            if(o1.getEntryTime()< o2.getEntryTime()){
                return 1;
            }
            else if(o1.getEntryTime()> o2.getEntryTime()){
                return -1;
            }
            else{
                 return 0;  
            }
        }
        else if(o1.getJobPriority()> o2.getJobPriority()){
            return 1;
        }
        else{
            return -1;
        }    }
    
}
