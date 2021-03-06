/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.StaffRole;

import Business.Enterprise.Enterprise;
import Business.Organization.StaffOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequestPharmacy;
import Logging.LogReports;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author raunak
 */
public class StaffWorkAreaPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private StaffOrganization staffOrganization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    
    private BufferedImage image;

    LogReports staffLog = new LogReports();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
    }
    public StaffWorkAreaPanel(JPanel userProcessContainer, UserAccount account, StaffOrganization staffOrganization, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.staffOrganization = staffOrganization;
        this.enterprise = enterprise;
        this.userAccount = account;
        valueLabel.setText(enterprise.getName());
        populateRequestTable();
        populateRequestPharmacyTable();
        staffLog.logUserData("The user with Username "+account.getUsername() +" logged in.", account.getUsername());
        
//    final ListSelectionModel model = workRequestJTable.getSelectionModel();
//    model.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if(!model.isSelectionEmpty()){
//                    requestPharmBtn.setEnabled(true);
//                }
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });

     try {                
          image = ImageIO.read(new File("F:\\staff1.jpg"));
       
       } catch (IOException ex) {
            // handle exception...
                    System.out.println("Exception:" + ex);
       }
     valueLabel.setText(enterprise.getName());
    }
    
    public void populateRequestPharmacyTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestPharmacyJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequestPharmacy request : userAccount.getWorkQueuePharmacy().getWorkRequestPharmacyList()){
            Object[] row = new Object[5];
            row[0] = request.getResolveDate();//.getMessage();
            row[2] = request.getReceiver();
            row[1] = request.getRequestDate();
//            String result = request.getMessage();
//                    ((PharmacyWorkRequest) request).getAvailability();
//            row[3] = result == null ? "Waiting" : ((PharmacyWorkRequest) request).getAvailability();
//            
            row [3] = ((PharmacyWorkRequest) request).getAvailability();
            row[4] = ((PharmacyWorkRequest) request).getRequestId();
            model.addRow(row);
        } 
    }

    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request;//.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = request.getMessage();
                    ((LabTestWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : ((LabTestWorkRequest) request).getTestResult();
            row[4] = ((LabTestWorkRequest) request).getRequestId();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        requestPharmBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestPharmacyJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setBackground(new java.awt.Color(255, 153, 0));
        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Receiver", "Status", "Treatment", "Request ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workRequestJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 630, 290));

        requestTestJButton.setBackground(new java.awt.Color(0, 0, 0));
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Request to the Doctor");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 63, 170, 30));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Welcome to");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 127, 30));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 158, 26));

        requestPharmBtn.setBackground(new java.awt.Color(0, 0, 0));
        requestPharmBtn.setForeground(new java.awt.Color(255, 255, 255));
        requestPharmBtn.setText("Request Pharmacy");
        requestPharmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestPharmBtnActionPerformed(evt);
            }
        });
        add(requestPharmBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, 240, 30));

        workRequestPharmacyJTable.setBackground(new java.awt.Color(255, 153, 0));
        workRequestPharmacyJTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        workRequestPharmacyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Resolved Date", "Request Date", "Receiver", "Delivery", "Request ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(workRequestPharmacyJTable);
        if (workRequestPharmacyJTable.getColumnModel().getColumnCount() > 0) {
            workRequestPharmacyJTable.getColumnModel().getColumn(0).setResizable(false);
            workRequestPharmacyJTable.getColumnModel().getColumn(1).setResizable(false);
            workRequestPharmacyJTable.getColumnModel().getColumn(2).setResizable(false);
            workRequestPharmacyJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 690, 230));

        jLabel2.setIcon(new javax.swing.ImageIcon("F:\\arrow_down.jpg")); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 40, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon("F:\\arrow_right.jpg")); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon("F:\\arrow_down.jpg")); // NOI18N
        jLabel4.setText("jLabel1");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 40, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setText("Request nd wait for response");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 220, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel6.setText("Select and hit");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 210, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setText("Request nd get notified");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 270, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestLabTestJPanel", new StaffRequestToDoctor(userProcessContainer, userAccount, enterprise));
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void requestPharmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestPharmBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = workRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Select a row");
            return;
        }else{
                    LabTestWorkRequest request = (LabTestWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        //RequestToPharmacyJPanel requestToPharmacyJPanel = new RequestToPharmacyJPanel(userProcessContainer, userAccount, enterprise);
       if(!request.getStatus().equalsIgnoreCase("completed")){
                JOptionPane.showMessageDialog(null, "The request has not been completed by the doctor yet!");
                return;
            }

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestToPharmacyJPanel", new RequestToPharmacyJPanel(userProcessContainer, userAccount, enterprise, request));
        layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_requestPharmBtnActionPerformed

    private void workRequestJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workRequestJTableMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_workRequestJTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton requestPharmBtn;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestPharmacyJTable;
    // End of variables declaration//GEN-END:variables
}
