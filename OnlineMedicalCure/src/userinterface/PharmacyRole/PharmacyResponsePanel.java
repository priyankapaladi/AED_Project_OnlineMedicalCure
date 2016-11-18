    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequestPharmacy;
import Logging.LogReports;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Priyanka
 */
public class PharmacyResponsePanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private  UserAccount userAccount;
    private  Enterprise enterprise;
    private  PharmacyOrganization pharmacyOrganization;

    /**
     * Creates new form PharmacyResponseRole
     */
    private BufferedImage image;
    LogReports pharmLog = new LogReports();

    ArrayList  <WorkRequestPharmacy> pharmacyRequests;
ArrayList<WorkRequestPharmacy> pharmacyRequestsNoDup;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawImage(image, 0, 0,this.getWidth(), this.getHeight(), null); // see javadoc for more info on the parameters            
    }
    
    
    public PharmacyResponsePanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
       this.enterprise = enterprise;

        this.pharmacyOrganization = (PharmacyOrganization)organization;
                populateTable();
                  valueLabel.setText(enterprise.getName());
                try {                
          image = ImageIO.read(new File("F:\\pharm.jpg"));
       
       } catch (IOException ex) {
            // handle exception...
                    System.out.println("Exception:" + ex);
       }
pharmLog.logUserData("The user with Username "+account.getUsername() +" logged in.", account.getUsername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        processJButton = new javax.swing.JButton();
        valueLabel = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setBackground(new java.awt.Color(255, 153, 0));
        workRequestJTable.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prescriptions", "Request Sent By", "Request Received By", "Delivery"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 810, 260));

        processJButton.setBackground(new java.awt.Color(0, 0, 0));
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 300, 30));

        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(428, 10, 210, 30));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Welcome to");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 10, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            
            JOptionPane.showMessageDialog(null, "Please select a row");
            
            return;
        }

        // Assigning it to the pharmacist
         WorkRequestPharmacy request = (WorkRequestPharmacy)workRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateTable();
       
        
        
        PharmacyWorkRequest phRequest = (PharmacyWorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        phRequest.setStatus("Processing");
        PharmacyProcessWorkRequestJPanel processWorkRequestJPanel = new PharmacyProcessWorkRequestJPanel(userProcessContainer, phRequest,userAccount);
        userProcessContainer.add("pharmacyProcessWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
//        removeDuplicates();
//        for(WorkRequestPharmacy request : pharmacyRequestsNoDup){
       for(WorkRequestPharmacy request : pharmacyOrganization.getWorkQueuePharmacy().getWorkRequestPharmacyList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
        }
    }

    public void removeDuplicates(){
//       
       pharmacyRequests = pharmacyOrganization.getWorkQueuePharmacy().getWorkRequestPharmacyList();
       HashSet<WorkRequestPharmacy> hashSet = new HashSet<WorkRequestPharmacy>(pharmacyRequests);

     pharmacyRequestsNoDup = new ArrayList<WorkRequestPharmacy>(hashSet);
//int i = 0;
//            ArrayList <WorkRequestPharmacy> arr1 = pharmacyOrganization.getWorkQueuePharmacy().getWorkRequestPharmacyList();
//            ArrayList <WorkRequestPharmacy> arr2 = pharmacyOrganization.getWorkQueuePharmacy().getWorkRequestPharmacyList();;
//            ((PharmacyWorkRequest) arr1.get(i)).getRequestId();
          
          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
