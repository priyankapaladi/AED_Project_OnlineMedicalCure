/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Registration;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Role.AdminRole;
import Business.Role.PatientRole;
import Business.UserAccount.UserAccount;
import EmailValidation.EmailValidator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Priyanka
 */
public class RegistrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegistrationJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    String ip;
    static int i;
    boolean emailCheck;
    EmailValidator e;
      private BufferedImage image;

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
    }
  
private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public RegistrationJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateNetworkComboBox();
        e = new EmailValidator();
           try {                
          image = ImageIO.read(new File("F:\\patients.jpg"));
       
       } catch (IOException ex) {
            // handle exception...
                    System.out.println("Exception:" + ex);
       }
  

    }

    private void populateNetworkComboBox() {
        networkJComboBox1.removeAllItems();

        for (Network network : system.getNetworkList()) {
            networkJComboBox1.addItem(network);
        }
    }

    private void populateEnterpriseComboBox(Network network) {
        enterpriseJComboBox.removeAllItems();

        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseJComboBox.addItem(enterprise);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameJTextField = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        networkJComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        passwordJTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Patient Registration");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 21, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 93, -1, -1));

        usernameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameJTextFieldKeyPressed(evt);
            }
        });
        add(usernameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 93, 188, -1));

        nameJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameJTextFieldKeyPressed(evt);
            }
        });
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 170, 188, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 170, -1, -1));

        registerBtn.setBackground(new java.awt.Color(0, 0, 0));
        registerBtn.setForeground(new java.awt.Color(255, 255, 255));
        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 190, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Network Of Hospitals");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        networkJComboBox1.setBackground(new java.awt.Color(0, 153, 153));
        networkJComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkJComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBox1ActionPerformed(evt);
            }
        });
        add(networkJComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 136, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Hospitals");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        enterpriseJComboBox.setBackground(new java.awt.Color(0, 153, 153));
        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });
        add(enterpriseJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 136, -1));

        passwordJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJTextFieldActionPerformed(evt);
            }
        });
        passwordJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordJTextFieldKeyPressed(evt);
            }
        });
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 131, 188, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Password");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 131, -1, -1));

        backBtn.setIcon(new javax.swing.ImageIcon("F:\\back.png")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 30, 30));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("e-mail");
        add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 208, -1, -1));

        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        emailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTxtKeyPressed(evt);
            }
        });
        add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 208, 188, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:

        if (nameJTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the name");

        } else if (usernameJTextField.getText().isEmpty() || passwordJTextField.getText().isEmpty()){
               
            JOptionPane.showMessageDialog(null, " Please enter all the fields");
            return;
        } 
        emailCheck = e.validate(emailTxt.getText().trim());
        
        if (!emailCheck) {
            JOptionPane.showMessageDialog(null, "Enter a valid email address");

            return;
        }
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        
        ip = "206.200.170." + i;
       // ipAddressTxt.setText(ip);

        //ip = "206.200.170" + i;
        String username = usernameJTextField.getText().trim();
        String password = String.valueOf(passwordJTextField.getText());
        String emailID = emailTxt.getText().trim();
        String name = nameJTextField.getText().trim();
        //String phone = phoneTxt.getText().trim();
       
        //  Employee employee = enterprise.getEmployeeDirectory().createEmployee(name);

        
        
        
        for (Employee employee : enterprise.getEmployeeDirectory().getEmployeeList()) {
            if (employee.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null, "Employee name exists! Please add initials or numbers to have a clear distinction");
                return;
            } 
        }
        PatientOrganization patOrg = null;
         for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
             if(org instanceof PatientOrganization){
                 patOrg = (PatientOrganization) org;
                 break;
             }
         }

        for (Employee employee : patOrg.getEmployeeDirectory().getEmployeeList()) {
            if (employee.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null, "Employee name exists! Please add initials or numbers to have a clear distinction");
                return;
            } 
        }
         for (UserAccount account : patOrg.getUserAccountDirectory().getUserAccountList()) {
                if (account.getUsername().equalsIgnoreCase(usernameJTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Employee exists! Add initials or numbers to distinguish!"
                            + "Hit modify");
                    return;
                }
            }

        Employee employee = patOrg.getEmployeeDirectory().createEmployee(name);
       
        UserAccount account = patOrg.getUserAccountDirectory().createUserAccount(username, password, employee, new PatientRole(), ip,emailID);
        i++;
        usernameJTextField.setEnabled(false);
        nameJTextField.setEnabled(false);
        passwordJTextField.setEnabled(false);
        emailTxt.setEnabled(false);
//        phoneTxt.setEnabled(false);
        // after registration
           userProcessContainer.removeAll();
        JPanel blankJP = new JPanel();
        userProcessContainer.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
         dB4OUtil.storeSystem(system);

    }//GEN-LAST:event_registerBtnActionPerformed

    private void passwordJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJTextFieldActionPerformed

    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBoxActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_enterpriseJComboBoxActionPerformed

   
    private void networkJComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBox1ActionPerformed

        Network network = (Network) networkJComboBox1.getSelectedItem();
        if (network != null) {
            populateEnterpriseComboBox(network);
        }
    }//GEN-LAST:event_networkJComboBox1ActionPerformed


    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.removeAll();
        JPanel blankJP = new JPanel();
        userProcessContainer.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
         dB4OUtil.storeSystem(system);
//        userProcessContainer.remove(this);
//        Component[] componentArray = userProcessContainer.getComponents();
//        Component component = componentArray[componentArray.length - 1];
//        StaffWorkAreaPanel dwjp = (StaffWorkAreaPanel) component;
//        dwjp.populateRequestTable();
//        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
//        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backBtnActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void usernameJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameJTextFieldKeyPressed
        // TODO add your handling code here:
                          int key = evt.getKeyCode();
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE ||  (key<=evt.VK_NUMPAD9 && key >= evt.VK_NUMPAD0)) {
            usernameJTextField.setBackground(Color.white);
            usernameJTextField.setEditable(true);
        } else {
            usernameJTextField.setBackground(Color.red);
                        usernameJTextField.setEditable(false);

        }
        


    }//GEN-LAST:event_usernameJTextFieldKeyPressed

    private void passwordJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordJTextFieldKeyPressed
        // TODO add your handling code here:
                          int key = evt.getKeyCode();
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || (key<=evt.VK_NUMPAD9 && key >= evt.VK_NUMPAD0)) {
            passwordJTextField.setBackground(Color.white);
            passwordJTextField.setEditable(true);

        } else {
            passwordJTextField.setBackground(Color.red);
                        passwordJTextField.setEditable(false);
                        JOptionPane.showMessageDialog(null, "Please enter only alphabets and numbers!");

        }
        
    }//GEN-LAST:event_passwordJTextFieldKeyPressed

    private void nameJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameJTextFieldKeyPressed
        // TODO add your handling code here:
              int key = evt.getKeyCode();
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE ||  (key<=evt.VK_NUMPAD9 && key >= evt.VK_NUMPAD0)) {
            nameJTextField.setBackground(Color.white);
                        nameJTextField.setEditable(true);


        } else {
            nameJTextField.setBackground(Color.red);
                        nameJTextField.setEditable(false);

           
        }
        
    }//GEN-LAST:event_nameJTextFieldKeyPressed

    private void emailTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyPressed
        // TODO add your handling code here:
               int key = evt.getKeyCode();
        if ((key >= KeyEvent.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE ||  (key<=evt.VK_9 && key >= evt.VK_0)
                || key == evt.VK_AMPERSAND || key == evt.VK_DOLLAR || key == evt.VK_EXCLAMATION_MARK || key == evt.VK_PERIOD ||
                key == evt.VK_UNDERSCORE || key == evt.VK_MINUS) {
            emailTxt.setBackground(Color.white);
                        emailTxt.setEditable(true);


        } else {
            emailTxt.setBackground(Color.red);
                        emailTxt.setEditable(false);

           
        }
       
    }//GEN-LAST:event_emailTxtKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox networkJComboBox1;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameJTextField;
    // End of variables declaration//GEN-END:variables
}
