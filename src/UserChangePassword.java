
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserChangePassword extends javax.swing.JFrame {
String username,oldpassword,newpassword,confirmpassword;
    public UserChangePassword() {
                initComponents();

    }

    public UserChangePassword(String username){
        this.username=username;
         initComponents();
                 setTitle("Change Password");

        tfusername.setText(username);
        tfusername.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         lbback.setSize(500,500);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
       
        setSize(500,500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfoldpass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tfnewpass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tfconfirmpass = new javax.swing.JPasswordField();
        btchangepassword = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 30, 140, 30);
        getContentPane().add(tfusername);
        tfusername.setBounds(240, 30, 230, 30);

        jLabel2.setText("Old Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 84, 110, 20);
        getContentPane().add(tfoldpass);
        tfoldpass.setBounds(240, 80, 230, 30);

        jLabel3.setText("New Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 134, 100, 20);
        getContentPane().add(tfnewpass);
        tfnewpass.setBounds(240, 130, 230, 30);

        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 180, 90, 30);
        getContentPane().add(tfconfirmpass);
        tfconfirmpass.setBounds(240, 180, 230, 30);

        btchangepassword.setText("Change Password");
        btchangepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchangepasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btchangepassword);
        btchangepassword.setBounds(160, 263, 170, 40);

        lbback.setText("jLabel5");
        getContentPane().add(lbback);
        lbback.setBounds(-10, 0, 690, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btchangepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btchangepasswordActionPerformed
new Thread(new Runnable(){
    public void run(){
       oldpassword=tfoldpass.getText();
        newpassword=tfnewpass.getText();
        confirmpassword=tfconfirmpass.getText();
        if(oldpassword.isEmpty() || newpassword.isEmpty() || confirmpassword.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "All fields are required !");
        }
        else{
            if(newpassword.equals(confirmpassword)){
            try {
                HttpResponse httpresponse=Unirest.get(GlobalData.hostname+"/changepassword")
                        .queryString("username",username)
                        .queryString("opassword",oldpassword)
                        .queryString("npassword",newpassword)
                        .asString();
                if(httpresponse.getStatus()==200){
                    if(httpresponse.getBody().toString().equals("password changed")){
                        JOptionPane.showMessageDialog(rootPane, "Password changed successfully !");
                        dispose();
                        UserLogin u=new UserLogin();
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Invalid old password !");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "New password and Confirm password must match !");
            }
        } 
    }
}).start();
        
    }//GEN-LAST:event_btchangepasswordActionPerformed

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
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btchangepassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbback;
    private javax.swing.JPasswordField tfconfirmpass;
    private javax.swing.JPasswordField tfnewpass;
    private javax.swing.JPasswordField tfoldpass;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
