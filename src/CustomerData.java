
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.lang.Math;
import javax.swing.border.LineBorder;



public class CustomerData extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public CustomerData() {
        initComponents();
        conn=Database.ConnectDb();
        pdc.setVisible(false);
        dayLabel.setVisible(false);
        
        try
        {
            String sql= "select bandwidth, price, perDay_cost from plans";
            pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
            {
                plan.addItem(rs.getString("bandwidth"));
            }
            rs.close();
            pst.close();
            
            String sql2= "select period, days from billing_period";
            pst=conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            while(rs.next())
            {
                period.addItem(rs.getString("period"));
            }
            pst.close();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public boolean AreFieldsEmpty()
    {
        boolean status = false;
        
        if(cust_name.getText().isEmpty())
        {
           status = true;
           cust_name.setBorder(new LineBorder(Color.RED));
        }
        if(mobile_no.getText().isEmpty())
        {
           status = true;
           mobile_no.setBorder(new LineBorder(Color.RED));
        }
        if(cust_email.getText().isEmpty())
        {
           status = true;
           cust_email.setBorder(new LineBorder(Color.RED));
        }
        if(address_field.getText().isEmpty())
        {
           status = true;
           address_field.setBorder(new LineBorder(Color.RED));
        }
        if(gender.getSelectedIndex()==0)
        {
           status = true;
           gender.setBorder(new LineBorder(Color.RED));
        }
        if(plan.getSelectedIndex()==0)
        {
           status = true;
           plan.setBorder(new LineBorder(Color.RED));
        }
        if(period.getSelectedIndex()==0)
        {
           status = true;
           period.setBorder(new LineBorder(Color.RED));
        }
        if(stat.getSelectedIndex()==0)
        {
           status = true;
           stat.setBorder(new LineBorder(Color.RED));
        }
        return status;
    }
    
    public void edit()
    {
        try{
            pst = conn.prepareStatement("UPDATE customers SET name=?, plan=?, billing_cycle=?, days=?, rental=?, phone=?, email=?, gender=?, address=?, purpose=?, status=? WHERE id=?");
            
            pst.setString(1, cust_name.getText());
            pst.setString(2, (String) plan.getSelectedItem());
            pst.setString(3, (String) period.getSelectedItem());
            pst.setInt(4,Integer.parseInt(dayLabel.getText()));
            pst.setInt(5, Integer.parseInt(total_bill.getText()));
            pst.setString(6, mobile_no.getText());
            pst.setString(7, cust_email.getText());
            pst.setString(8, (String) gender.getSelectedItem());
            pst.setString(9, address_field.getText());
            pst.setString(10, (String) purpose.getSelectedItem());
            pst.setString(11,(String) stat.getSelectedItem());
            pst.setString(12,cust_id.getText());
            
            pst.executeUpdate();
            pst.close();
            setVisible(false);
            JOptionPane.showMessageDialog(rootPane, "Customer Updated..!!!");            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public void add()
    {
        if(AreFieldsEmpty())
        {
            Msg.setText("Please enter all details.");
        }
        else
        {
            try{
            String sql = "INSERT INTO customers(name, plan, billing_cycle, days, rental, phone, email, gender, address, purpose, status) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
             pst=conn.prepareStatement(sql);

               pst.setString(1, cust_name.getText());
               pst.setString(2, (String) plan.getSelectedItem());
               pst.setString(3, (String) period.getSelectedItem());
                pst.setInt(4,Integer.parseInt(dayLabel.getText()));
                pst.setInt(5, Integer.parseInt(total_bill.getText()));
               pst.setString(6, mobile_no.getText());
               pst.setString(7, cust_email.getText());
               pst.setString(8, (String) gender.getSelectedItem());
               pst.setString(9, address_field.getText());
               pst.setString(10, (String) purpose.getSelectedItem());
               pst.setString(11,(String) stat.getSelectedItem());
               pst.execute();
               pst.close();
               JOptionPane.showMessageDialog(rootPane, "Customer Added..!!!");
            }catch(HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
            Customers ob = new Customers();
            ob.jTable1();
            setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mobile_no = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cust_name = new javax.swing.JTextField();
        plan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cust_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        address_field = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        purpose = new javax.swing.JComboBox<>();
        plan_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cust_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        period = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        total_bill = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dayLabel = new javax.swing.JLabel();
        pdc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        stat = new javax.swing.JComboBox<>();
        Msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel1.setText("Customer Details");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        mobile_no.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Plan");

        cust_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        plan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        plan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        plan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                planItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mobile No");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email ID:");

        cust_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Gender");

        gender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "MALE", "FEMALE" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Address");

        address_field.setColumns(20);
        address_field.setRows(5);
        jScrollPane1.setViewportView(address_field);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Purpose");

        purpose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        purpose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HOME", "BUSINESS" }));

        plan_price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        plan_price.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        plan_price.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Price");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cust_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cust_id.setText("auto-generate");
        cust_id.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("ID");

        period.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        period.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        period.setToolTipText("");
        period.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                periodItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Billing Period");

        total_bill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        total_bill.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        total_bill.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Total Amt.");

        dayLabel.setText("   ");

        pdc.setText("perDayCost");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Status");

        stat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Active", "Inactive" }));
        stat.setToolTipText("");

        Msg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Msg.setForeground(new java.awt.Color(255, 0, 0));
        Msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Msg.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(mobile_no)
                                        .addGap(83, 83, 83))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cust_email, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel1))
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(plan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                            .addComponent(purpose, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(plan_price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dayLabel)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(total_bill, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pdc)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mobile_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cust_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(purpose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(plan_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(total_bill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(period, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayLabel)
                    .addComponent(pdc))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(stat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Msg)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void planItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_planItemStateChanged
        try
        {
            String sql= "select price, perDay_cost from plans where bandwidth=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1, (String) plan.getSelectedItem());
            rs = pst.executeQuery();
            if(rs.next())
            {
                plan_price.setText(Integer.toString(rs.getInt("price")));
                pdc.setText(Double.toString(rs.getDouble("perDay_cost")));
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_planItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(jButton2.getText().equals("ADD"))
        {
            add();
        }
        else if(jButton2.getText().equals("UPDATE"))
        {
            edit();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void periodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_periodItemStateChanged
        int days = 0;
        try
        {
            String sql= "select days from billing_period where period=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,(String) period.getSelectedItem());
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                days = rs.getInt("days");
                dayLabel.setText(rs.getString("days"));
                int total_amt = (int) Math.floor((Double.parseDouble(pdc.getText())*days)+0.5);
                total_bill.setText(String.valueOf(total_amt));
                rs.close();
                pst.close();
            }   
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_periodItemStateChanged

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
            java.util.logging.Logger.getLogger(CustomerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Msg;
    public javax.swing.JTextArea address_field;
    public javax.swing.JTextField cust_email;
    public javax.swing.JTextField cust_id;
    public javax.swing.JTextField cust_name;
    private javax.swing.JLabel dayLabel;
    public javax.swing.JComboBox<String> gender;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField mobile_no;
    private javax.swing.JLabel pdc;
    public javax.swing.JComboBox<String> period;
    public javax.swing.JComboBox<String> plan;
    public javax.swing.JTextField plan_price;
    public javax.swing.JComboBox<String> purpose;
    public javax.swing.JComboBox<String> stat;
    public javax.swing.JTextField total_bill;
    // End of variables declaration//GEN-END:variables
}
