/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdministrativeRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import EmailValidation.EmailValidator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.Patient.PatientRequestToDoctor;

/**
 *
 * @author Administrator
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private BufferedImage image;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
    }

    private JPanel container;
    private Enterprise enterprise;
    static int i = 50;
    String ip = "208.118.227." + i;
    boolean emailCheck;
    EmailValidator e = new EmailValidator();

    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;

        popOrganizationComboBox();
        // employeeJComboBox.removeAllItems();
        popData();
        userNameTxt.setEnabled(true);
        passwordJTextField.setEnabled(true);
        nameTxt.setEnabled(true);
        emailTxt.setEnabled(true);
        //phoneTxt.setEnabled(true);
        organizationJComboBox.setEnabled(true);
        employeeJComboBox.setEnabled(true);
        roleJComboBox.setEnabled(true);

        saveBtn.setEnabled(false);
        modifyBtn.setEnabled(true);
        try {
            image = ImageIO.read(new File("F:\\hospital.jpg"));

        } catch (IOException ex) {
            // handle exception...
            System.out.println("Exception:" + ex);
        }

    }

    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
        }
    }

    public void populateEmployeeComboBox(Organization organization) {
        employeeJComboBox.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            employeeJComboBox.addItem(employee);

        }

    }

    public void loadUsernamePassword(Organization organization) {
        UserAccountDirectory ud = new UserAccountDirectory();

        Employee employee = (Employee) employeeJComboBox.getSelectedItem();

        for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
            System.out.println("inside for");

            if (ua.getEmployee().equals(employee)) {
                try {
                    System.out.println("ua.getEmployee().equals(employee)  " + ua.getEmployee().equals(employee));
                    userNameTxt.setEnabled(false);
                    passwordJTextField.setEnabled(false);

                    userNameTxt.setText(ua.getUsername());
                    System.out.println("username " + ua.getUsername());
                    String password;
                    password = UserAccountDirectory.decrypt(ua.getPassword());
                    System.out.println("passwprd" + password);
                    passwordJTextField.setText(password);
                    //            ipAddressTxt.setText(ua.getIpAddress());
                } catch (GeneralSecurityException ex) {
                    Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ManageUserAccountJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                userNameTxt.setEnabled(true);
                passwordJTextField.setEnabled(true);
//                ipAddressTxt.setText("");
                userNameTxt.setText("");
                passwordJTextField.setText("");
            }

        }
    }

    private void populateRoleComboBox(Organization organization) {
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()) {
            roleJComboBox.addItem(role);
        }
    }

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[4];
                row[0] = ua;
                row[1] = ua.getRole();
                row[2] = ua.getEmployee().getName();
                row[3] = ua.getIpAddress();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
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

        createUserJButton = new javax.swing.JButton();
        userNameTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        passwordJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        employeeJComboBox = new javax.swing.JComboBox();
        backjButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        modifyBtn = new javax.swing.JButton();
        nameTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        refreshbtn = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        createUserJButton.setBackground(new java.awt.Color(0, 0, 0));
        createUserJButton.setForeground(new java.awt.Color(255, 255, 255));
        createUserJButton.setText("Create");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 180, 30));

        userNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameTxtKeyPressed(evt);
            }
        });
        add(userNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 150, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("User Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, -1));

        userJTable.setBackground(new java.awt.Color(255, 153, 0));
        userJTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role", "Name", "IP Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 670, 190));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        passwordJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordJTextFieldKeyPressed(evt);
            }
        });
        add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 150, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Employee");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        employeeJComboBox.setBackground(new java.awt.Color(0, 153, 153));
        employeeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        employeeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeJComboBoxActionPerformed(evt);
            }
        });
        add(employeeJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 146, -1));

        backjButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        backjButton1.setIcon(new javax.swing.ImageIcon("F:\\back.png")); // NOI18N
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });
        add(backjButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 30, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Organization");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        organizationJComboBox.setBackground(new java.awt.Color(0, 153, 153));
        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 146, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Role");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 10));

        roleJComboBox.setBackground(new java.awt.Color(0, 153, 153));
        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 146, -1));

        modifyBtn.setBackground(new java.awt.Color(0, 0, 0));
        modifyBtn.setForeground(new java.awt.Color(255, 255, 255));
        modifyBtn.setText("Modify Username/Password");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });
        add(modifyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, -1, 30));

        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTxtKeyPressed(evt);
            }
        });
        add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Name");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        saveBtn.setBackground(new java.awt.Color(0, 0, 0));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Save Modified Details");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 150, 30));

        refreshbtn.setBackground(new java.awt.Color(0, 0, 0));
        refreshbtn.setIcon(new javax.swing.ImageIcon("F:\\arrows_refresh.png")); // NOI18N
        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });
        add(refreshbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 30, 30));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLabel.setText("e-mail");
        add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(616, 120, 40, -1));

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
        add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Manage and Create Useraccount for Employees");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        // for creating employee

        if (nameTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the name");

        } else {
            // check if the fields are empty
            if (userNameTxt.getText().isEmpty() || passwordJTextField.getText().isEmpty() || emailTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, " Please enter all the fields - Username,Password, Phone Number and email address ");
                return;
            } 

            // check if the vaild email address has been typed
            emailCheck = e.validate(emailTxt.getText().trim());
            if (!emailCheck) {
                JOptionPane.showMessageDialog(null, "Enter a valid email address");

                return;
            }
//            enterprise.getOrganizationDirectory();
            Organization organization = (Organization) organizationJComboBox.getSelectedItem();

            // check if employee name exists 
            for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
                if (e.getName().equalsIgnoreCase(nameTxt.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Employee exists! Add initials or numbers to distinguish!"
                    );
                    return;
                }

            }
            for (UserAccount account : organization.getUserAccountDirectory().getUserAccountList()) {
                if (account.getUsername().equalsIgnoreCase(userNameTxt.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Employee exists! Add initials or numbers to distinguish!"
                            + "Hit modify");
                    return;
                }
            }

            // create employee
            Employee employee = organization.getEmployeeDirectory().createEmployee(nameTxt.getText());

            // create username and password
            Role role = (Role) roleJComboBox.getSelectedItem();

            String userName = userNameTxt.getText().trim();
            String password = passwordJTextField.getText().trim();
//            String phoneNumber = phoneTxt.getText().trim();
            ip = "192.168.0." + i;
            //ipAddressTxt.setText(ip);
            String emailID = emailTxt.getText().trim();
            System.out.println("role-" + role);
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role, ip, emailID);
            i++;
            popData();
            userNameTxt.setEnabled(false);
            passwordJTextField.setEnabled(false);
            nameTxt.setEnabled(false);
            emailTxt.setEnabled(false);
        }
    }//GEN-LAST:event_createUserJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void employeeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeJComboBoxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_employeeJComboBoxActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = userJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        } else {

            organizationJComboBox.setEnabled(false);
            employeeJComboBox.setEnabled(false);
            roleJComboBox.setEnabled(false);
            UserAccount ua = (UserAccount) userJTable.getValueAt(selectedRow, 0);

            nameTxt.setText(ua.getEmployee().getName());
            nameTxt.setEnabled(false);
//            ipAddressTxt.setText(ua.getIpAddress());
            userNameTxt.setText("");
            passwordJTextField.setText("");
            userNameTxt.setEnabled(true);
            passwordJTextField.setEnabled(true);
            saveBtn.setEnabled(true);
            emailTxt.setEnabled(true);
            emailTxt.setText("");
            modifyBtn.setEnabled(false);
            createUserJButton.setEnabled(false);
        }


    }//GEN-LAST:event_modifyBtnActionPerformed

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:

        int selectedRow = userJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        } else {

            saveBtn.setEnabled(false);
            modifyBtn.setEnabled(true);

            UserAccount ua = (UserAccount) userJTable.getValueAt(selectedRow, 0);

            String userName = userNameTxt.getText().trim();
            String password = passwordJTextField.getText().trim();
            String emailID = emailTxt.getText().trim();
//            String phone = phoneTxt.getText().trim();

            if (userName.isEmpty() || password.isEmpty() || emailID.isEmpty()) {
                JOptionPane.showMessageDialog(null, " Please enter both Username,Password and email address ");
                return;

            } 

            emailCheck = e.validate(emailTxt.getText().trim());
            if (!emailCheck) {
                JOptionPane.showMessageDialog(null, "Enter a valid email address");

                return;
            }
            Organization organization = (Organization) organizationJComboBox.getSelectedItem();
            for (UserAccount account : organization.getUserAccountDirectory().getUserAccountList()) {
                if (account.getUsername().equalsIgnoreCase(userNameTxt.getText().trim())) {
                    JOptionPane.showMessageDialog(null, "Username exists! Add initials or numbers to distinguish!"
                    );
                    return;
                }
            }
            organization.getUserAccountDirectory().modifyDetails(ua, userName, password, emailID);
//            ua.setUsername(userName);
//            ua.setPassword(password);
//     
            popData();
            userNameTxt.setEnabled(false);
            passwordJTextField.setEnabled(false);
            emailTxt.setEnabled(false);

            organizationJComboBox.setEnabled(true);
            employeeJComboBox.setEnabled(true);
            roleJComboBox.setEnabled(true);

        }

    }//GEN-LAST:event_saveBtnActionPerformed

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshbtnActionPerformed
        // TODO add your handling code here:
        userNameTxt.setEnabled(true);
        userNameTxt.setText("");
        passwordJTextField.setEnabled(true);
        passwordJTextField.setText("");
        nameTxt.setEnabled(true);
        nameTxt.setText("");
        organizationJComboBox.setEnabled(true);
        employeeJComboBox.setEnabled(true);
        roleJComboBox.setEnabled(true);
        createUserJButton.setEnabled(true);


    }//GEN-LAST:event_refreshbtnActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void nameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || (key <= evt.VK_9 && key >= evt.VK_0)) {
            nameTxt.setBackground(Color.white);
            nameTxt.setEditable(true);

        } else {
            nameTxt.setBackground(Color.red);
            nameTxt.setEditable(false);

        }

    }//GEN-LAST:event_nameTxtKeyPressed

    private void userNameTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameTxtKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || (key <= evt.VK_9 && key >= evt.VK_0)) {
            userNameTxt.setBackground(Color.white);
            userNameTxt.setEditable(true);

        } else {
            userNameTxt.setBackground(Color.red);
            userNameTxt.setEditable(false);

        }

    }//GEN-LAST:event_userNameTxtKeyPressed

    private void passwordJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordJTextFieldKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || (key <= evt.VK_9 && key >= evt.VK_0)) {
            passwordJTextField.setBackground(Color.white);
            passwordJTextField.setEditable(true);

        } else {
            passwordJTextField.setBackground(Color.red);
            passwordJTextField.setEditable(false);

        }

    }//GEN-LAST:event_passwordJTextFieldKeyPressed

    private void emailTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key >= KeyEvent.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || (key <= evt.VK_9 && key >= evt.VK_0)
                || key == evt.VK_AMPERSAND || key == evt.VK_DOLLAR || key == evt.VK_EXCLAMATION_MARK || key == evt.VK_PERIOD
                || key == evt.VK_UNDERSCORE || key == evt.VK_MINUS) {
            emailTxt.setBackground(Color.white);
            emailTxt.setEditable(true);

        } else {
            emailTxt.setBackground(Color.red);
            emailTxt.setEditable(false);

        }

    }//GEN-LAST:event_emailTxtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JComboBox employeeJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JButton refreshbtn;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable userJTable;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
