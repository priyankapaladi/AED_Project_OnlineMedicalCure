/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StaffRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.StaffOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import EmailValidation.EmailValidator;
import Logging.LogReports;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Priyanka
 */
public class StaffRequestToDoctor extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    /**
     * Creates new form RequestLabTestJPanel
     */
    private BufferedImage image;
boolean emailCheck;
     EmailValidator e = new EmailValidator();
    LogReports staffLog = new LogReports();
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
    }
    
    Random random = new Random();
    static int number;
    public StaffRequestToDoctor(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        valueLabel.setText(enterprise.getName());
        
           try {                
          image = ImageIO.read(new File("F:\\staff1.jpg"));
       
       } catch (IOException ex) {
            // handle exception...
                    System.out.println("Exception:" + ex);
       }
           requestTestJButton.setEnabled(true);
        messageJTextField.setEnabled(true);
        patientNameTxt.setEnabled(true);
        emailTxt.setEnabled(true);
        phoneTxt.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requestTestJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        patientNameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        requestIDTxt = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        Contact = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        requestTestJButton.setBackground(new java.awt.Color(0, 0, 0));
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Request for Diagnosis");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 280, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Health Concern");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 230, -1));

        messageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageJTextFieldActionPerformed(evt);
            }
        });
        add(messageJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 280, 70));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 130, 30));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Record a request for");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 220, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Patient's name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 260, -1));
        add(patientNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 280, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Request ID");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 240, -1));

        requestIDTxt.setEnabled(false);
        add(requestIDTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 280, -1));

        backBtn.setIcon(new javax.swing.ImageIcon("F:\\back.png")); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 31, 32));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("email");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 260, -1));
        add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 280, -1));

        phoneTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneTxtKeyPressed(evt);
            }
        });
        add(phoneTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 280, -1));

        Contact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Contact.setText("Contact");
        add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 260, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
                
        number = random.nextInt(100000) + 1000;
        requestIDTxt.setText(String.valueOf(number));
        
        String message = messageJTextField.getText().trim();
        String patientName = patientNameTxt.getText().trim();
        String random = requestIDTxt.getText().trim();
        String phone = phoneTxt.getText().trim();
        if(message.isEmpty() || patientName.isEmpty() || random.isEmpty() || phone.isEmpty()){
            
            JOptionPane.showMessageDialog(null, "enter all the fields");
            return;
            
        }else {
            if(phone.length() != 10){
                JOptionPane.showMessageDialog(null, "Please enter a valid email address");
                return;
            }
            
            if(emailTxt.getText().isEmpty()){
                  JOptionPane.showMessageDialog(null, "enter all the fields");
                  return;
                  
            }
            
              emailCheck = e.validate(emailTxt.getText().trim());
            if(!emailCheck){
                          JOptionPane.showMessageDialog(null, "Enter a valid email address");

                return;
            }
    
            
        }
        
        
        LabTestWorkRequest request = new LabTestWorkRequest();
        request.setMessage(message);
        request.setPatientName(patientName);
        request.setEmailId(emailTxt.getText().trim());
        request.setRequestId(String.valueOf(number));
        request.setSender(userAccount);
        request.setPhone(phone);
        request.setStatus("Sent to Doctor");
        
        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DoctorOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
        }
        staffLog.logUserData("A request was sent to the doctor for patient: "+request.getPatientName()+" and RequestID: "+request.getRequestId(),
                userAccount.getUsername());
        requestTestJButton.setEnabled(false);
        messageJTextField.setEnabled(false);
        patientNameTxt.setEnabled(false);
        emailTxt.setEnabled(false);
        phoneTxt.setEnabled(false);
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        StaffWorkAreaPanel dwjp = (StaffWorkAreaPanel) component;
        dwjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backBtnActionPerformed

    private void messageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageJTextFieldActionPerformed

    private void phoneTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTxtKeyPressed
        // TODO add your handling code here:
                // TODO add your handling code here:
        int key = evt.getKeyCode();
        if ((key <= evt.VK_NUMPAD9 && key >= evt.VK_NUMPAD0) || key == evt.VK_BACK_SPACE) {
            phoneTxt.setBackground(Color.white);
            phoneTxt.setEditable(true);

        } else {
            phoneTxt.setBackground(Color.red);
            phoneTxt.setEditable(false);

        }

    }//GEN-LAST:event_phoneTxtKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contact;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JTextField patientNameTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JTextField requestIDTxt;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
