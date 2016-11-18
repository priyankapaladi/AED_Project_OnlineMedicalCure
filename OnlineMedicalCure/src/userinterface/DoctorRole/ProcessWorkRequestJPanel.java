/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.WorkQueue.LabTestWorkRequest;
import EmailValidation.SendMail;
import Logging.LogReports;
import PDFCreation.JavaPdf;
import SendSMSAlerts.SmsSender;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class ProcessWorkRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    LabTestWorkRequest request;
    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    private BufferedImage image;

    SendMail sendMail = new SendMail();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
    }

    LogReports doctorLog = new LogReports();
    SmsSender sms = new SmsSender();

    public ProcessWorkRequestJPanel(JPanel userProcessContainer, LabTestWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;

        try {
            image = ImageIO.read(new File("F:\\doctor.jpg"));

        } catch (IOException ex) {
            // handle exception...
            System.out.println("Exception:" + ex);
        }
        mailPrescBtn.setEnabled(true);
        issueLabel.setText("Issue: " + request.getMessage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mailPrescBtn = new javax.swing.JButton();
        prescriptionTxt = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        issueLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mailPrescBtn.setBackground(new java.awt.Color(0, 0, 0));
        mailPrescBtn.setForeground(new java.awt.Color(255, 255, 255));
        mailPrescBtn.setText("Mail Prescription");
        mailPrescBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailPrescBtnActionPerformed(evt);
            }
        });
        add(mailPrescBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 170, 30));

        prescriptionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescriptionTxtActionPerformed(evt);
            }
        });
        add(prescriptionTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 340, 200));

        backJButton.setIcon(new javax.swing.ImageIcon("F:\\back.png")); // NOI18N
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Doctor's suggested Treatment");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        issueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        issueLabel.setText("jLabel1");
        add(issueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void mailPrescBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailPrescBtnActionPerformed
//        // TODO add your handling code here:
//            Runtime rs = Runtime.getRuntime();
// 
//    try {
//      rs.exec("notepad");
//    } 
//    catch (IOException e) {
//      System.out.println(e);
//    }   
        int choice;
        JDialog.setDefaultLookAndFeelDecorated(true);
        choice = JOptionPane.showConfirmDialog(null, "Do you want to mail the prescription?", "No, don't mail", JOptionPane.INFORMATION_MESSAGE);

        switch (choice) {
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Mail was not sent");
                break;
            case JOptionPane.YES_OPTION:
                JavaPdf writePrescription = new JavaPdf();
                try {
                    writePrescription.createPDF("The prescription for your health concern : " + request.getMessage()
                            + "\n" + prescriptionTxt.getText(), request.getPatientName(), request.getRequestId());
                    Thread.sleep(1000);                 //1000 milliseconds is one second.

                    System.out.println("email address" + request.getEmailId());
                    new Thread(new Runnable() {
                        public void run() {
                            System.out.println("MAIL Thread");
                            sendMail.sendMailTo(request.getEmailId(), "F:/Logs_Prescriptions/" + request.getPatientName() + "/" + request.getRequestId());
                            JOptionPane.showMessageDialog(null, "The prescription for the RequestID: " + request.getRequestId() + " has been mailed successfully!");

                        }
                    }).start();
                    new Thread(new Runnable() {
                        public void run() {
                            System.out.println("SMS Thread");
                            sms.sendingSMS(request.getPhone());
                          

                        }
                    }).start();

                    Thread.sleep(1000);                 //1000 milliseconds is one second.

                } catch (IOException ex) {
                    Logger.getLogger(ProcessWorkRequestJPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProcessWorkRequestJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                        mailPrescBtn.setEnabled(false);

                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            default:
                break;
        }
        request.setTestResult("Treatment has been suggested");
        request.setStatus("Completed");
        doctorLog.logUserData("Mailed Prescription to " + request.getPatientName() + " with requestID " + request.getRequestId(), TOOL_TIP_TEXT_KEY);
    }//GEN-LAST:event_mailPrescBtnActionPerformed

    private void prescriptionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescriptionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prescriptionTxtActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaPanel prp = (DoctorWorkAreaPanel) component;
        prp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == evt.VK_PRINTSCREEN) {
            System.out.println("PrintScreen is pressed!");
        }

    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel issueLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton mailPrescBtn;
    private javax.swing.JTextField prescriptionTxt;
    // End of variables declaration//GEN-END:variables
}