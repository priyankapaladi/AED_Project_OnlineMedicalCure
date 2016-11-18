/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.StaffOrganization;
import Business.UserAccount.UserAccount;
import userinterface.StaffRole.StaffWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class StaffRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new StaffWorkAreaPanel(userProcessContainer, account, (StaffOrganization)organization, enterprise);
    }
    
    
}
