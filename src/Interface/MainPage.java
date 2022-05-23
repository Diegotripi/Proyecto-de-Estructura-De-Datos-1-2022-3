/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;
import main.File;

/**
 *
 * @author isaac
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form mainPage
     */
    public MainPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveDataButton = new javax.swing.JButton();
        newStorageButton = new javax.swing.JButton();
        invReportButton = new javax.swing.JButton();
        invManagementButton = new javax.swing.JButton();
        newOrderButton = new javax.swing.JButton();
        storageMapButton = new javax.swing.JButton();
        uploadDataButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Assets/Amazon-Logo-Transparent-PNG (1).png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("RED DE ALMACENES AMAZON");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 430, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 70));

        saveDataButton.setText("Guardar Datos");
        saveDataButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataButtonActionPerformed(evt);
            }
        });
        jPanel3.add(saveDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 200, 120));

        newStorageButton.setText("Crear Nuevo Almacén");
        newStorageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newStorageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStorageButtonActionPerformed(evt);
            }
        });
        jPanel3.add(newStorageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 190, 120));

        invReportButton.setText("Reporte de inventario");
        invReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invReportButtonActionPerformed(evt);
            }
        });
        jPanel3.add(invReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 200, 120));

        invManagementButton.setText("Gestión de Inventario");
        invManagementButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invManagementButtonActionPerformed(evt);
            }
        });
        jPanel3.add(invManagementButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 190, 120));

        newOrderButton.setText("Nuevo Pedido");
        newOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderButtonActionPerformed(evt);
            }
        });
        jPanel3.add(newOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 200, 120));

        storageMapButton.setText("Mapa de Almacenes");
        storageMapButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(storageMapButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 200, 120));

        uploadDataButton.setText("Cargar Datos");
        uploadDataButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadDataButtonActionPerformed(evt);
            }
        });
        jPanel3.add(uploadDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 200, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Assets/output-onlinepngtools.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setFocusable(false);
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 960, 540));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Triggers page change to NewStoragePage on press
     */
    private void newStorageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStorageButtonActionPerformed
        // TODO add your handling code here:
           GlobalUI.openNewStoragePage();
    }//GEN-LAST:event_newStorageButtonActionPerformed

    private void invManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invManagementButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invManagementButtonActionPerformed

    private void saveDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataButtonActionPerformed
        File f = new File();
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        System.out.println(resp);
        
        if (resp == 0) {
            
            try{
                f.writeFile(GlobalUI.getGraph(), GlobalUI.getDirection());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error guardando la información");
            }
            
        }
    }//GEN-LAST:event_saveDataButtonActionPerformed

    private void newOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newOrderButtonActionPerformed

    private void uploadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadDataButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uploadDataButtonActionPerformed

    private void invReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invReportButtonActionPerformed
        // TODO add your handling code here:
        GlobalUI.openShowInvPage();
    }//GEN-LAST:event_invReportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton invManagementButton;
    private javax.swing.JButton invReportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton newOrderButton;
    private javax.swing.JButton newStorageButton;
    private javax.swing.JButton saveDataButton;
    private javax.swing.JButton storageMapButton;
    private javax.swing.JButton uploadDataButton;
    // End of variables declaration//GEN-END:variables
}
