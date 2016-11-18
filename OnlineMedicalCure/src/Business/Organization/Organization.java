/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkQueuePharmacy;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private WorkQueuePharmacy workQueuePharmacy;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter;
    
    public enum Type{
        Admin("Admin Organization"), Doctor("Doctor Organization"), Staff("Staff Organization"), Pharmacist("Pharmacy Organization"),
        Patient("Patient Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        workQueuePharmacy = new WorkQueuePharmacy();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    
    public WorkQueuePharmacy getWorkQueuePharmacy() {
        return workQueuePharmacy;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public void setWorkQueue(WorkQueuePharmacy workQueuePharmacy) {
        this.workQueuePharmacy = workQueuePharmacy;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
