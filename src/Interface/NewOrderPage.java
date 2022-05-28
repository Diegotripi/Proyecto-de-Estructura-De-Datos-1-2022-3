/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class NewOrderPage extends javax.swing.JFrame {

    /**
     * Creates new form NewOrderPage
     */
    public NewOrderPage() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * Returns invTextField
     *
     * @return javax.swing.JTextArea
     */
    public javax.swing.JTextArea getInvTextField() {
        return this.invTextField;
    }

    /**
     * Returns storageComboBox
     *
     * @return javax.swing.JComboBox
     */
    public javax.swing.JComboBox<String> getStorageComboBox() {
        return this.storageComboBox;
    }

    /**
     * Returns productComboBoc
     *
     * @return javax.swing.JComboBox
     */
    public javax.swing.JComboBox<String> getProductComboBox() {
        return this.productComboBox;
    }

    /**
     * Returns productQtyTextField
     *
     * @return javax.swing.JComboBox
     */
    public javax.swing.JTextField getProductQtyTextField() {
        return this.productQtyTextField;
    }

    public javax.swing.JTextArea getOrderTextArea() {
        return this.orderTextArea;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        backToMenuButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        invTextField = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        storageComboBox = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        orderTextArea = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        productComboBox = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        productQtyTextField = new javax.swing.JTextField();
        addProductButton = new javax.swing.JButton();
        restartOrderButton = new javax.swing.JButton();
        completeOrderButton = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        jPanel8.setBackground(new java.awt.Color(247, 209, 109));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 153, 102));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("DFS Recorrido de profundidad");
        jPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("DFS Recorrido de profundidad");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel10.setBackground(new java.awt.Color(255, 153, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("DFS Recorrido de profundidad");
        jPanel10.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("DFS Recorrido de profundidad");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel11.setBackground(new java.awt.Color(255, 153, 102));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("DFS Recorrido de profundidad");
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("DFS Recorrido de profundidad");
        jPanel11.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel13.setBackground(new java.awt.Color(255, 153, 102));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("DFS Recorrido de profundidad");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 40));

        jPanel14.setBackground(new java.awt.Color(255, 153, 102));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("DFS Recorrido de profundidad");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("DFS Recorrido de profundidad");
        jPanel14.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel15.setBackground(new java.awt.Color(255, 153, 102));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("DFS Recorrido de profundidad");
        jPanel15.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel20.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("DFS Recorrido de profundidad");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel16.setBackground(new java.awt.Color(255, 153, 102));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("DFS Recorrido de profundidad");
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel22.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("DFS Recorrido de profundidad");
        jPanel16.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel13.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, 220));

        jLabel23.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("DFS Recorrido en profundidad");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 40));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backToMenuButton.setBackground(new java.awt.Color(255, 255, 255));
        backToMenuButton.setForeground(new java.awt.Color(0, 0, 0));
        backToMenuButton.setText("Volver al menú");
        backToMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backToMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, -1));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Assets/Amazon-Logo-Transparent-PNG (1).png"))); // NOI18N
        logoLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoLabelMouseClicked(evt);
            }
        });
        jPanel7.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Nuevo  Pedido");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 200, 40));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 70));

        jPanel12.setBackground(new java.awt.Color(247, 209, 109));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 153, 102));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("DFS Recorrido de profundidad");
        jPanel17.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel25.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("DFS Recorrido de profundidad");
        jPanel17.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel18.setBackground(new java.awt.Color(255, 153, 102));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("DFS Recorrido de profundidad");
        jPanel18.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel27.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("DFS Recorrido de profundidad");
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel19.setBackground(new java.awt.Color(255, 153, 102));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("DFS Recorrido de profundidad");
        jPanel19.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel29.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("DFS Recorrido de profundidad");
        jPanel19.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel12.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel20.setBackground(new java.awt.Color(255, 153, 102));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("DFS Recorrido de profundidad");
        jPanel20.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 220, 40));

        jPanel21.setBackground(new java.awt.Color(255, 153, 102));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("DFS Recorrido de profundidad");
        jPanel21.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel32.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("DFS Recorrido de profundidad");
        jPanel21.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel22.setBackground(new java.awt.Color(255, 153, 102));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("DFS Recorrido de profundidad");
        jPanel22.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel34.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("DFS Recorrido de profundidad");
        jPanel22.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel23.setBackground(new java.awt.Color(255, 153, 102));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("DFS Recorrido de profundidad");
        jPanel23.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jLabel36.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("DFS Recorrido de profundidad");
        jPanel23.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 240, 40));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel20.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 260, 40));

        jPanel12.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, 220));

        jLabel38.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Inventario Disponible");
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 170, 40));

        jPanel24.setBackground(new java.awt.Color(204, 204, 255));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        invTextField.setEditable(false);
        invTextField.setBackground(new java.awt.Color(204, 204, 255));
        invTextField.setColumns(20);
        invTextField.setForeground(new java.awt.Color(0, 0, 0));
        invTextField.setLineWrap(true);
        invTextField.setRows(5);
        invTextField.setText("no text");
        jScrollPane4.setViewportView(invTextField);

        jPanel24.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 280));

        getContentPane().add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 170, 310));

        jPanel1.setBackground(new java.awt.Color(247, 209, 109));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Cantidad:");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, 30));

        storageComboBox.setBackground(new java.awt.Color(255, 255, 255));
        storageComboBox.setForeground(new java.awt.Color(0, 0, 0));
        storageComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                storageComboBoxItemStateChanged(evt);
            }
        });
        jPanel1.add(storageComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, -1));

        jLabel39.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Pedido a realizar");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, 30));

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        orderTextArea.setEditable(false);
        orderTextArea.setBackground(new java.awt.Color(204, 204, 255));
        orderTextArea.setColumns(20);
        orderTextArea.setForeground(new java.awt.Color(0, 0, 0));
        orderTextArea.setLineWrap(true);
        orderTextArea.setRows(5);
        jScrollPane5.setViewportView(orderTextArea);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 130));

        jLabel40.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Seleccione Almacén");
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 30));

        productComboBox.setBackground(new java.awt.Color(255, 255, 255));
        productComboBox.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(productComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, -1));

        jLabel41.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Seleccione Productos");
        jPanel1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 150, 30));

        jLabel42.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Producto:");
        jPanel1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 30));

        productQtyTextField.setBackground(new java.awt.Color(255, 255, 255));
        productQtyTextField.setForeground(new java.awt.Color(0, 0, 0));
        productQtyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productQtyTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productQtyTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 90, -1));

        addProductButton.setBackground(new java.awt.Color(255, 255, 255));
        addProductButton.setForeground(new java.awt.Color(0, 0, 0));
        addProductButton.setText("Agregar");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addProductButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 170, 350));

        restartOrderButton.setBackground(new java.awt.Color(255, 255, 255));
        restartOrderButton.setForeground(new java.awt.Color(0, 0, 0));
        restartOrderButton.setText("Reiniciar pedido");
        restartOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartOrderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restartOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 170, -1));

        completeOrderButton.setBackground(new java.awt.Color(255, 255, 255));
        completeOrderButton.setForeground(new java.awt.Color(0, 0, 0));
        completeOrderButton.setText("Completar Pedido");
        completeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeOrderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(completeOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 170, -1));

        Background.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/Assets/output-onlinepngtools.png"))); // NOI18N
        Background.setText("jLabel4");
        Background.setFocusable(false);
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 710, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuButtonActionPerformed
        GlobalUI.getBackToMainPage();
//        getStorageComboBox().removeAllItems();

    }//GEN-LAST:event_backToMenuButtonActionPerformed

    private void logoLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoLabelMouseClicked
        GlobalUI.getBackToMainPage();
    }//GEN-LAST:event_logoLabelMouseClicked

    private void storageComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_storageComboBoxItemStateChanged
        InterfaceFunctions.setAvailableProducts(getStorageComboBox().getSelectedItem().toString());

    }//GEN-LAST:event_storageComboBoxItemStateChanged

    private void restartOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartOrderButtonActionPerformed
        InterfaceFunctions.resetOrder();
    }//GEN-LAST:event_restartOrderButtonActionPerformed

    private void productQtyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productQtyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productQtyTextFieldActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed

        if ((getProductComboBox().getSelectedItem() != null)) {
            if (InterfaceFunctions.isANumber(getProductQtyTextField().getText())) {
                if (Integer.parseInt(getProductQtyTextField().getText()) > 0) {
                    InterfaceFunctions.updateOrderDisplay(getOrderTextArea().getText());
                    getStorageComboBox().setEnabled(false);
                    getProductComboBox().removeItem(getProductComboBox().getSelectedItem());
                } else {
                    JOptionPane.showMessageDialog(null, "Alerta, la cantidad de producto no puede ser 0 o menor");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Número de cantidad inválido, por favor intente de nuevo");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Alerta, ya se agregaron todos los productos del almacén");
        }


    }//GEN-LAST:event_addProductButtonActionPerformed

    private void completeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeOrderButtonActionPerformed
        InterfaceFunctions.completeOrder(getOrderTextArea().getText(), getStorageComboBox().getSelectedItem().toString());
    }//GEN-LAST:event_completeOrderButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewOrderPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton addProductButton;
    private javax.swing.JButton backToMenuButton;
    private javax.swing.JButton completeOrderButton;
    private javax.swing.JTextArea invTextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextArea orderTextArea;
    private javax.swing.JComboBox<String> productComboBox;
    private javax.swing.JTextField productQtyTextField;
    private javax.swing.JButton restartOrderButton;
    private javax.swing.JComboBox<String> storageComboBox;
    // End of variables declaration//GEN-END:variables
}
