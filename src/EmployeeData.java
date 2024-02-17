
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


public class EmployeeData extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public EmployeeData() {
        initComponents();
        conn=Database.ConnectDb();
        
    }
    
    public boolean AreFieldsEmpty()
    {
        boolean status = false;
        
        if(e_name.getText().isEmpty())
        {
           status = true;
           e_name.setBorder(new LineBorder(Color.RED));
        }
        if(e_username.getText().isEmpty())
        {
           status = true;
           e_username.setBorder(new LineBorder(Color.RED));
        }
        if(e_email.getText().isEmpty())
        {
           status = true;
           e_email.setBorder(new LineBorder(Color.RED));
        }
        if(e_pass.getText().isEmpty())
        {
           status = true;
           e_pass.setBorder(new LineBorder(Color.RED));
        }
        if(S_Que.getSelectedIndex()==0)
        {
           status = true;
           S_Que.setBorder(new LineBorder(Color.RED));
        }
        if(S_Ans.getText().isEmpty())
        {
           status = true;
           S_Ans.setBorder(new LineBorder(Color.RED));
        }
        
        return status;
    }
    
    public void add()
    {
        int a = S_Que.getSelectedIndex();
        String b = null; 
        if(a==1)
        {
            b = "SQ_Ans1";
        }
        else if(a==2)
        {
            b = "SQ_Ans2";
        }
        if(AreFieldsEmpty())
        {
            Msg.setText("Please enter all details.");
        }
        else
        {
            try{
            String sql = "INSERT INTO employees(emp_name, emp_username, email, emp_password, "+b+", status) VALUES(?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);

            pst.setString(1, e_name.getText());
            pst.setString(2,e_username.getText());
            pst.setString(3,e_email.getText());
            pst.setString(4, e_pass.getText());
            pst.setString(5,S_Ans.getText());
            pst.setString(6,(String) accStatus.getSelectedItem());

            pst.execute();
            pst.close();
            JOptionPane.showMessageDialog(rootPane, "Employee Registered!!!");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
            Employees ob = new Employees();
            ob.jTable1();
            setVisible(false);
        }
    }

    public void edit()
    {
        int a = S_Que.getSelectedIndex();
        String b = null; 
        if(a==1)
        {
            b = "SQ_Ans1=?";
        }
        else if(a==2)
        {
            b = "SQ_Ans2=?";
        }
        if(AreFieldsEmpty())
        {
            Msg.setText("Please enter all details.");
        }
        else
        {
            try{
                 pst = conn.prepareStatement("UPDATE employees SET emp_name=?, emp_username=?, email=?, emp_password=?, "+b+", status=? WHERE id=?");

                 pst.setString(1, e_name.getText());
                 pst.setString(2,e_username.getText());
                 pst.setString(3,e_email.getText());
                 pst.setString(4, e_pass.getText());
                 pst.setString(5,S_Ans.getText());
                 pst.setString(6,(String) accStatus.getSelectedItem());
                 pst.setInt(7, Integer.parseInt(emp_id.getText()));
                 pst.executeUpdate();
                 pst.close();
                 JOptionPane.showMessageDialog(rootPane, "Employee Data Updated..!!!");            
             }catch(SQLException e){
                 JOptionPane.showMessageDialog(rootPane, e);
             }
             Employees ob = new Employees();
             ob.jTable1();
             setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        emp_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        e_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        e_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        e_username = new javax.swing.JTextField();
        e_pass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        accStatus = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        S_Que = new javax.swing.JComboBox<>();
        S_Ans = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setText("Employee Data");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("REGISTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Employee ID:");

        emp_id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emp_id.setText("auto-generate");
        emp_id.setEnabled(false);
        emp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_idActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Employee Name: ");

        e_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_nameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Email ID:");

        e_email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_emailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Username:");

        e_username.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_usernameActionPerformed(evt);
            }
        });

        e_pass.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        e_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_passActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Account Status:");

        accStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enabled", "Disabled" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Security Question:");

        S_Que.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        S_Que.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Security Question", "What is your first school name?", "What is your first phone brand?" }));
        S_Que.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_QueActionPerformed(evt);
            }
        });

        S_Ans.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        S_Ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_AnsActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Security Answer:");

        Msg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Msg.setForeground(new java.awt.Color(204, 0, 0));
        Msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Msg.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Msg, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(e_username)
                                    .addComponent(e_email)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(e_name, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                        .addComponent(e_pass, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(S_Que, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(S_Ans)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(e_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(e_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(S_Que, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S_Ans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(accStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(Msg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if(jButton2.getText().equals("REGISTER"))
        {
            add();
        }
        else if(jButton2.getText().equals("UPDATE"))
        {
            edit();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void emp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_idActionPerformed

    private void e_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_nameActionPerformed

    private void e_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_emailActionPerformed

    private void e_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_usernameActionPerformed

    private void e_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_passActionPerformed

    private void S_QueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_QueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_QueActionPerformed

    private void S_AnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_AnsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_AnsActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Msg;
    public javax.swing.JTextField S_Ans;
    public javax.swing.JComboBox<String> S_Que;
    public javax.swing.JComboBox<String> accStatus;
    public javax.swing.JTextField e_email;
    public javax.swing.JTextField e_name;
    public javax.swing.JTextField e_pass;
    public javax.swing.JTextField e_username;
    public javax.swing.JTextField emp_id;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
