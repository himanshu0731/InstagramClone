
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class MyServerFrame extends javax.swing.JFrame {
 MyServer obj;
    public MyServerFrame() {
        initComponents();
        setSize(500,500);
         lbback.setSize(500,500);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
       
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btstart = new javax.swing.JButton();
        btstop = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btstart.setBackground(new java.awt.Color(255, 255, 255));
        btstart.setText("Start Server");
        btstart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstartActionPerformed(evt);
            }
        });
        getContentPane().add(btstart);
        btstart.setBounds(90, 60, 160, 40);

        btstop.setBackground(new java.awt.Color(255, 255, 255));
        btstop.setText("Stop Server");
        btstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btstopActionPerformed(evt);
            }
        });
        getContentPane().add(btstop);
        btstop.setBounds(90, 140, 160, 40);

        lbback.setText("jLabel1");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 400, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btstartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstartActionPerformed
        try {
           obj=new MyServer(9000);
            btstart.setEnabled(false);
            btstop.setEnabled(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_btstartActionPerformed

    private void btstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btstopActionPerformed
        obj.shutdown();
        btstart.setEnabled(true);
        btstop.setEnabled(false);
    }//GEN-LAST:event_btstopActionPerformed
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
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyServerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btstart;
    private javax.swing.JButton btstop;
    private javax.swing.JLabel lbback;
    // End of variables declaration//GEN-END:variables
}
