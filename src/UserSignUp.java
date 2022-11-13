
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UserSignUp extends javax.swing.JFrame {

    String username, password, phoneno, email, secques, secans, gender, photo;
    String arquestions[] = {"What is your nick name ?", "What is the name of your first school ?", "What is your pet name?"};

    public UserSignUp() {
        initComponents();
        cbgender.addItem("Male");
        cbgender.addItem("Female");
        for (int i = 0; i < arquestions.length; i++) {
            cbsecurityques.addItem(arquestions[i]);
        }
        lbback.setSize(600, 600);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfphno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbgender = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbsecurityques = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfsecurityans = new javax.swing.JTextField();
        btbrowse = new javax.swing.JButton();
        lbimg = new javax.swing.JLabel();
        btsignup = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Sign up to create user account");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 10, 170, 20);

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 54, 80, 20);
        getContentPane().add(tfusername);
        tfusername.setBounds(200, 50, 180, 30);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 94, 130, 20);
        getContentPane().add(tfpassword);
        tfpassword.setBounds(200, 90, 180, 30);

        jLabel4.setText("Email");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 134, 90, 20);
        getContentPane().add(tfemail);
        tfemail.setBounds(200, 130, 180, 30);

        jLabel5.setText("Phone Number");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 170, 90, 30);
        getContentPane().add(tfphno);
        tfphno.setBounds(200, 170, 180, 30);

        jLabel6.setText("Gender");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 214, 90, 30);

        getContentPane().add(cbgender);
        cbgender.setBounds(200, 210, 180, 30);

        jLabel7.setText("Security Question");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 264, 150, 20);

        getContentPane().add(cbsecurityques);
        cbsecurityques.setBounds(200, 250, 180, 30);

        jLabel8.setText("Photo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 340, 70, 30);

        jLabel9.setText("Security Answer");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 300, 110, 30);
        getContentPane().add(tfsecurityans);
        tfsecurityans.setBounds(200, 290, 180, 30);

        btbrowse.setText("Browse");
        btbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowse);
        btbrowse.setBounds(200, 340, 80, 23);

        lbimg.setText("jLabel10");
        getContentPane().add(lbimg);
        lbimg.setBounds(310, 334, 70, 60);

        btsignup.setText("Sign Up");
        btsignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsignupActionPerformed(evt);
            }
        });
        getContentPane().add(btsignup);
        btsignup.setBounds(130, 433, 160, 30);

        lbback.setText("jLabel10");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 550, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsignupActionPerformed
        new Thread(new Runnable() {
            public void run() {
                username = tfusername.getText();
                password = tfpassword.getText();
                phoneno = tfphno.getText();
                email = tfemail.getText();
                secans = tfsecurityans.getText();
                secques = cbsecurityques.getSelectedItem().toString();
                gender = cbgender.getSelectedItem().toString();

                if (username.isEmpty() || password.isEmpty() || phoneno.isEmpty() || email.isEmpty() || secans.isEmpty() || photo == null) {
                    JOptionPane.showMessageDialog(rootPane, "All fields are required !!");

                } else {
                    if (phoneno.length() < 10) {
                        JOptionPane.showMessageDialog(rootPane, "Enter valid phone number");
                    } else {
                        try {
                            HttpResponse httpresponse = Unirest.post(GlobalData.hostname + "/signup")
                                    .queryString("username", username)
                                    .queryString("password", password)
                                    .queryString("phoneno", phoneno)
                                    .queryString("email", email)
                                    .queryString("secques", secques)
                                    .queryString("secans", secans)
                                    .queryString("gender", gender)
                                    .field("photo", new File(photo)).asString();

                            if (httpresponse.getStatus() == 200) {
                                if (httpresponse.getBody().toString().equals("inserted")) {
                                    JOptionPane.showMessageDialog(rootPane, "Sign up successful !");
                                    dispose();
                                    UserLogin obj = new UserLogin();

                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "User already exists !");
                                }
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }//GEN-LAST:event_btsignupActionPerformed

    private void btbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowseActionPerformed
        JFileChooser jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            photo = f.getPath();
            try {
                BufferedImage img = ImageIO.read(f);
                BufferedImage newimg = resize(img, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(newimg));

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_btbrowseActionPerformed

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
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbrowse;
    private javax.swing.JButton btsignup;
    private javax.swing.JComboBox<String> cbgender;
    private javax.swing.JComboBox<String> cbsecurityques;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbimg;
    private javax.swing.JTextField tfemail;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfphno;
    private javax.swing.JTextField tfsecurityans;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

}
