/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueuePharmacy {
    
    private ArrayList<WorkRequestPharmacy> workRequestPharmacyList;

    public WorkQueuePharmacy() {
        workRequestPharmacyList = new ArrayList<>();
    }

    public ArrayList<WorkRequestPharmacy> getWorkRequestPharmacyList() {
        return workRequestPharmacyList;
    }
}