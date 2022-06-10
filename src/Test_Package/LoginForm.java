/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Test_Package;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author michaelcalbay
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        exitButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        displayLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setName("frame"); // NOI18N
        setResizable(false);

        mainPane.setBackground(new java.awt.Color(51, 51, 51));
        mainPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLabel.setForeground(java.awt.Color.white);
        userLabel.setText("Username");
        mainPane.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        passLabel.setForeground(java.awt.Color.white);
        passLabel.setText("Password");
        mainPane.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));
        mainPane.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 67, 150, -1));

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        mainPane.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 117, 150, -1));

        exitButton.setBackground(new java.awt.Color(102, 102, 102));
        exitButton.setForeground(java.awt.Color.white);
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        mainPane.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 90, -1));

        registerButton.setBackground(new java.awt.Color(102, 102, 102));
        registerButton.setForeground(java.awt.Color.white);
        registerButton.setText("REGISTER");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        mainPane.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 90, -1));

        loginButton.setBackground(new java.awt.Color(102, 102, 102));
        loginButton.setForeground(java.awt.Color.white);
        loginButton.setText("LOGIN");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        mainPane.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 90, -1));

        displayLabel.setForeground(new java.awt.Color(255, 255, 255));
        displayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayLabel.setText(" ");
        mainPane.add(displayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 250, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("frame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("CLOSING WINDOW...");
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        this.displayLabel.setText("OPEN REGISTER BUTTON - PLEASE MODIFY");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        //RED if incorrect
        this.displayLabel.setForeground(Color.RED);
        this.displayLabel.setText("CORRECT LOGIN? INCORRECT?");

    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginForm loginForm = new LoginForm();
                loginForm.setLocationRelativeTo(null);
                loginForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel displayLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}
