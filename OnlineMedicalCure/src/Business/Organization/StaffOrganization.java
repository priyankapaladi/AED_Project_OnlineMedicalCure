/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.Role.StaffRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class StaffOrganization extends Organization{

    public StaffOrganization() {
        super(Organization.Type.Staff.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new StaffRole());
        return roles;
    }
     
   
    
    
}
