/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkQueuePharmacy;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    private String ipAddress;
    private Employee employee;
    private Role role;
    private String email;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private WorkQueue workQueue;
    private WorkQueuePharmacy workQueuePharmacy;

    public UserAccount() {
        workQueue = new WorkQueue();
        workQueuePharmacy = new WorkQueuePharmacy();
    }
      
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public WorkQueuePharmacy getWorkQueuePharmacy() {
        return workQueuePharmacy;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}