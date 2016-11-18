/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import userinterface.StaffRole.StaffWorkAreaPanel;
import javax.swing.JPanel;
import userinterface.Patient.PatientWorkAreaPanel;

/**
 *
 * @author raunak
 */
public class PatientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PatientWorkAreaPanel(userProcessContainer, account, (PatientOrganization)organization, enterprise);
    }
    
    
}
