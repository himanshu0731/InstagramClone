
import java.awt.Image;
import javax.swing.ImageIcon;

public class MainScreen extends javax.swing.JFrame {

    public MainScreen() {
        initComponents();
        lbback.setSize(500, 400);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
        ImageIcon icon = new ImageIcon("src/Pics/i2.jpg");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(lbinsta.getWidth(), lbinsta.getHeight(), Image.SCALE_SMOOTH);
        lbinsta.setIcon(new ImageIcon(newimg));
        setSize(500, 400);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnewuser = new javax.swing.JButton();
        btexistinguser = new javax.swing.JButton();
        lbinsta = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnewuser.setText("New User");
        btnewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnewuserActionPerformed(evt);
            }
        });
        getContentPane().add(btnewuser);
        btnewuser.setBounds(50, 250, 160, 40);

        btexistinguser.setText("Existing User");
        btexistinguser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexistinguserActionPerformed(evt);
            }
        });
        getContentPane().add(btexistinguser);
        btexistinguser.setBounds(280, 250, 150, 40);
        getContentPane().add(lbinsta);
        lbinsta.setBounds(50, 60, 410, 160);

        lbback.setText("jLabel1");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 580, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnewuserActionPerformed
        UserSignUp obj = new UserSignUp();
    }//GEN-LAST:event_btnewuserActionPerformed

    private void btexistinguserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexistinguserActionPerformed
        UserLogin obj = new UserLogin();
    }//GEN-LAST:event_btexistinguserActionPerformed
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btexistinguser;
    private javax.swing.JButton btnewuser;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbinsta;
    // End of variables declaration//GEN-END:variables
}
