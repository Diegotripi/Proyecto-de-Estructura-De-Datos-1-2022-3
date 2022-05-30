/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;
import main.Graph;

/**
 *
 * @author mdetd
 */
public class AddNewRutesPage extends javax.swing.JFrame {

    String from = "";
    String direction = "";

    /**
     * Creates new form AddNewRutesPage
     */

    public AddNewRutesPage() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        receiverChooserComboBox.setEnabled(false);
        selectParamButton.setEnabled(false);
        costTextField.setEnabled(false);
        addNewRutesButton.setEnabled(false);

    }
    /**
     * fill the transmitter chooser combo box with the storages
     * @param g1 
     */
    public void fillTransmitterChooserCombo(Graph g1) {
        transmitterChooserComboBox.removeAllItems();
        String[] storage = g1.namenOnAString();
        for (int i = 0; i < storage.length; i++) {
            transmitterChooserComboBox.addItem(storage[i]);
        }
    }
    
    /**
     * fill the receiver chooser combo box with the storages
     * @param g1 
     */

    public void fillReceiverChooserCombo(Graph g1) {

        receiverChooserComboBox.removeAllItems();
        String[] storage = g1.namenOnAString();
        String[] arrayAux = InterfaceFunctions.fromTexttoArray(direction);
        for (int i = 0; i < storage.length; i++) {
            if (!storage[i].equalsIgnoreCase(from)) {
                boolean validator = true;
                for (int j = 0; j < arrayAux.length; j++) {
                    String[] aux = arrayAux[j].split(",");
                    if (aux[0].equalsIgnoreCase(storage[i])) {
                        validator = false;

                    }
                }
                if (validator) {
                    receiverChooserComboBox.addItem(storage[i]);

                }
            }
        }

    }
    
    /**
     * Get the graph information from GlobalUI
     * @param graph 
     */

    public void createGprah(Graph graph) {
        Graph g1 = graph;
        rutesTextArea.setEditable(false);
        fillTransmitterChooserCombo(g1);

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
        receiverChooserComboBox = new javax.swing.JComboBox<>();
        transmitterChooserComboBox = new javax.swing.JComboBox<>();
        selectParamButton = new javax.swing.JButton();
        costTextField = new javax.swing.JTextField();
        selectFromButton = new javax.swing.JButton();
        showStorageTransmitterLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rutesTextArea = new javax.swing.JTextArea();
        selectDistanceLabel = new javax.swing.JLabel();
        selectedRutesLabel = new javax.swing.JLabel();
        addReceiverLabel = new javax.swing.JLabel();
        addTransmitterLabel = new javax.swing.JLabel();
        transmitterStorage = new javax.swing.JLabel();
        backToTheMenuButton = new javax.swing.JButton();
        addNewRutesButton = new javax.swing.JButton();
        deleteAllButton = new javax.swing.JButton();
        blueBackground = new javax.swing.JPanel();
        Background = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiverChooserComboBox.setBackground(new java.awt.Color(255, 255, 255));
        receiverChooserComboBox.setForeground(new java.awt.Color(0, 0, 0));
        receiverChooserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiverChooserComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(receiverChooserComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 220, -1));

        transmitterChooserComboBox.setBackground(new java.awt.Color(255, 255, 255));
        transmitterChooserComboBox.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(transmitterChooserComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 220, -1));

        selectParamButton.setBackground(new java.awt.Color(255, 255, 255));
        selectParamButton.setForeground(new java.awt.Color(0, 0, 0));
        selectParamButton.setText("Seleccionar");
        selectParamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectParamButtonActionPerformed(evt);
            }
        });
        jPanel1.add(selectParamButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 220, -1));

        costTextField.setBackground(new java.awt.Color(255, 255, 255));
        costTextField.setForeground(new java.awt.Color(0, 0, 0));
        costTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(costTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 220, -1));

        selectFromButton.setBackground(new java.awt.Color(255, 255, 255));
        selectFromButton.setForeground(new java.awt.Color(0, 0, 0));
        selectFromButton.setText("Seleccionar");
        selectFromButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFromButtonActionPerformed(evt);
            }
        });
        jPanel1.add(selectFromButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 220, -1));

        showStorageTransmitterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showStorageTransmitterLabel.setForeground(new java.awt.Color(255, 255, 255));
        showStorageTransmitterLabel.setText("Seleccione un almacén primero");
        jPanel1.add(showStorageTransmitterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, -1, -1));

        rutesTextArea.setBackground(new java.awt.Color(255, 255, 255));
        rutesTextArea.setColumns(20);
        rutesTextArea.setForeground(new java.awt.Color(0, 0, 0));
        rutesTextArea.setRows(5);
        jScrollPane1.setViewportView(rutesTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 220, -1));

        selectDistanceLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectDistanceLabel.setText("Indique la distancia en Km:");
        jPanel1.add(selectDistanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 180, -1));

        selectedRutesLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectedRutesLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectedRutesLabel.setText("Rutas seleccionadas:");
        jPanel1.add(selectedRutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 180, -1));

        addReceiverLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addReceiverLabel.setForeground(new java.awt.Color(255, 255, 255));
        addReceiverLabel.setText("Seleccione almacén receptor:");
        jPanel1.add(addReceiverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 220, -1));

        addTransmitterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addTransmitterLabel.setForeground(new java.awt.Color(255, 255, 255));
        addTransmitterLabel.setText("Seleccione almacén emisor:");
        jPanel1.add(addTransmitterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, -1));

        transmitterStorage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        transmitterStorage.setForeground(new java.awt.Color(255, 255, 255));
        transmitterStorage.setText(" Almacén emisor:");
        jPanel1.add(transmitterStorage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 180, -1));

        backToTheMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        backToTheMenuButton.setForeground(new java.awt.Color(0, 0, 0));
        backToTheMenuButton.setText("Regresar al menú");
        backToTheMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToTheMenuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backToTheMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 150, 40));

        addNewRutesButton.setBackground(new java.awt.Color(255, 255, 255));
        addNewRutesButton.setForeground(new java.awt.Color(0, 0, 0));
        addNewRutesButton.setText("Agregar Rutas");
        addNewRutesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewRutesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addNewRutesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 120, 40));

        deleteAllButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteAllButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteAllButton.setText("Borrar Rutas");
        deleteAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteAllButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 110, 40));

        blueBackground.setBackground(new java.awt.Color(21, 110, 180));
        blueBackground.setForeground(new java.awt.Color(8, 43, 71));
        jPanel1.add(blueBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 440, 400));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Assets/output-onlinepngtools.png"))); // NOI18N
        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 490, 530));

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Assets/Amazon-Logo-Transparent-PNG (1).png"))); // NOI18N
        jPanel4.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 50, -1));

        Title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 0, 0));
        Title.setText("Modificar Rutas");
        jPanel4.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 210, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectParamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectParamButtonActionPerformed
        if (receiverChooserComboBox.getSelectedItem() != null) {
            String cost = costTextField.getText();
            String storage = receiverChooserComboBox.getSelectedItem().toString();
            System.out.println(storage);
            if (InterfaceFunctions.isANumber(cost)) {
                int distance = Integer.parseInt(cost);
                String output = "";
                direction += storage + "," + distance + "  ";
                fillReceiverChooserCombo(GlobalUI.getGraph());
                rutesTextArea.setText("");
                String[] directionArray = direction.split("  ");
                for (int i = 0; i < directionArray.length; i++) {
                    output += directionArray[i] + "\n";

                }
                rutesTextArea.setText(output);
                addNewRutesButton.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un numero válido en la distancia");
            }
        }

        costTextField.setText("");


    }//GEN-LAST:event_selectParamButtonActionPerformed

    private void selectFromButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFromButtonActionPerformed

        from = transmitterChooserComboBox.getSelectedItem().toString();
        fillReceiverChooserCombo(GlobalUI.getGraph());
        receiverChooserComboBox.setEnabled(true);
        selectParamButton.setEnabled(true);
        costTextField.setEnabled(true);
        transmitterChooserComboBox.setEnabled(false);
        selectFromButton.setEnabled(false);
        showStorageTransmitterLabel.setText(from);

    }//GEN-LAST:event_selectFromButtonActionPerformed

    private void receiverChooserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiverChooserComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiverChooserComboBoxActionPerformed

    private void costTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costTextFieldActionPerformed

    private void backToTheMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTheMenuButtonActionPerformed
        GlobalUI.getBackToMainPage();
    }//GEN-LAST:event_backToTheMenuButtonActionPerformed

    private void addNewRutesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewRutesButtonActionPerformed
        InterfaceFunctions.addNewRutesButton(direction, from);
        from = "";
        direction = "";
        receiverChooserComboBox.removeAllItems();
        transmitterChooserComboBox.setEnabled(true);
        selectFromButton.setEnabled(true);
        receiverChooserComboBox.setEnabled(false);
        selectParamButton.setEnabled(false);
        costTextField.setEnabled(false);
        addNewRutesButton.setEnabled(false);
        costTextField.setText("");
        rutesTextArea.setText("");
        showStorageTransmitterLabel.setText("Seleccione un almacén primero");
    }//GEN-LAST:event_addNewRutesButtonActionPerformed

    private void deleteAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllButtonActionPerformed
        from = "";
        direction = "";
        receiverChooserComboBox.removeAllItems();
        transmitterChooserComboBox.setEnabled(true);
        selectFromButton.setEnabled(true);
        receiverChooserComboBox.setEnabled(false);
        selectParamButton.setEnabled(false);
        costTextField.setEnabled(false);
        addNewRutesButton.setEnabled(false);
        costTextField.setText("");
        rutesTextArea.setText("");
        showStorageTransmitterLabel.setText("Seleccione un almacén primero");

    }//GEN-LAST:event_deleteAllButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewRutesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewRutesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewRutesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewRutesPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewRutesPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Title;
    private javax.swing.JButton addNewRutesButton;
    private javax.swing.JLabel addReceiverLabel;
    private javax.swing.JLabel addTransmitterLabel;
    private javax.swing.JButton backToTheMenuButton;
    private javax.swing.JPanel blueBackground;
    private javax.swing.JTextField costTextField;
    private javax.swing.JButton deleteAllButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> receiverChooserComboBox;
    private javax.swing.JTextArea rutesTextArea;
    private javax.swing.JLabel selectDistanceLabel;
    private javax.swing.JButton selectFromButton;
    private javax.swing.JButton selectParamButton;
    private javax.swing.JLabel selectedRutesLabel;
    private javax.swing.JLabel showStorageTransmitterLabel;
    private javax.swing.JComboBox<String> transmitterChooserComboBox;
    private javax.swing.JLabel transmitterStorage;
    // End of variables declaration//GEN-END:variables
}
