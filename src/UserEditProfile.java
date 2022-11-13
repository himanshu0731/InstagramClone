
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

public class UserEditProfile extends javax.swing.JFrame {
String username;
String email,phoneno,gender,photo;
    public UserEditProfile() {
        initComponents();
    }
    public UserEditProfile(String username) {
        initComponents();
        this.username=username;
        tfusername.setText(username);
                setTitle("Edit Profile");

        tfusername.setEnabled(false);
        jComboBox1.addItem("Male");
        jComboBox1.addItem("Female");
         lbback.setSize(500,500);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfphoneno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lbimg = new javax.swing.JLabel();
        btbrowse = new javax.swing.JButton();
        btedit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Email");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 60, 60, 20);
        getContentPane().add(tfemail);
        tfemail.setBounds(140, 50, 250, 30);

        jLabel2.setText("Phone Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 90, 110, 30);
        getContentPane().add(tfphoneno);
        tfphoneno.setBounds(140, 90, 250, 30);

        jLabel3.setText("Gender");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 140, 80, 30);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(140, 140, 250, 30);

        jLabel4.setText("Photo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 190, 70, 30);

        lbimg.setText("jLabel5");
        getContentPane().add(lbimg);
        lbimg.setBounds(120, 190, 100, 90);

        btbrowse.setText("Browse");
        btbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowse);
        btbrowse.setBounds(260, 200, 90, 30);

        btedit.setText("Edit");
        btedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditActionPerformed(evt);
            }
        });
        getContentPane().add(btedit);
        btedit.setBounds(100, 300, 120, 40);

        jLabel5.setText("Username");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 14, 60, 20);
        getContentPane().add(tfusername);
        tfusername.setBounds(140, 10, 250, 30);

        lbback.setText("jLabel6");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 600, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowseActionPerformed
        JFileChooser jfc=new JFileChooser();
        int ans=jfc.showOpenDialog(this);
        if(ans==JFileChooser.APPROVE_OPTION){
            File f=jfc.getSelectedFile();
            photo=f.getPath();
            
            try {
                BufferedImage img=ImageIO.read(f);
                BufferedImage newimg=resize(img,lbimg.getWidth(),lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(newimg));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            
        }
    }//GEN-LAST:event_btbrowseActionPerformed

    private void bteditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditActionPerformed
        new Thread(new Runnable(){
            public void run(){
            phoneno=tfphoneno.getText();
        email=tfemail.getText();
        gender=jComboBox1.getSelectedItem().toString();
        if(phoneno.isEmpty() || email.isEmpty() || gender.isEmpty() || photo==null){
            JOptionPane.showMessageDialog(rootPane, "All fields are required !!");
        }
        else{
            try {
                HttpResponse httpres=Unirest.post(GlobalData.hostname+"/editprofile")
                        .queryString("username",username)
                        .queryString("phoneno",phoneno)
                        .queryString("email",email)
                        .queryString("gender",gender)
                        .field("photo",new File(photo))
                        .asString();
                if(httpres.getStatus()==200){
                    if(httpres.getBody().toString().equals("updated")){
                        JOptionPane.showMessageDialog(rootPane, "Updated Record !!");
                        dispose();
                       // UserLogin obj=new UserLogin();
                        
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        }
            
            
            }   
        }).start();
       
        
    }//GEN-LAST:event_bteditActionPerformed

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
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEditProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbrowse;
    private javax.swing.JButton btedit;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbimg;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tfphoneno;
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


