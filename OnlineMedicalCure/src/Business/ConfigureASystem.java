package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.StaffRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Random;
import userinterface.StaffRole.StaffWorkAreaPanel;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    static int i;
    public static EcoSystem configure(){
     
        EcoSystem system = EcoSystem.getInstance();
        Random r = new Random();
        //Create a network
        Network network = new Network();
        network.setName("Boston Hospital Networks ");
        system.getNetworkList().add(network);
       //create an enterprise
        i = 90;
       String ip = "206.190.170." + i;


       Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise("Boston Hospital", Enterprise.EnterpriseType.Hospital);
       
        
//        //initialize some organizations
//        
        AdminOrganization adminOrganization = new AdminOrganization();
        enterprise.getOrganizationDirectory().createOrganization(Organization.Type.Admin);
        enterprise.getOrganizationDirectory().getOrganizationList().add(adminOrganization);
//        
//        //have some employees 
//        
//        //create user account
//        
//        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", 
                employee, new SystemAdminRole(), ip,"kaisertest01@gmail.com");
        i++;
        ip = "206.190.170." + i;
        
        return system;
    }
    
}
