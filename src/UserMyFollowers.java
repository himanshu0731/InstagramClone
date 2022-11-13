
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class UserMyFollowers extends javax.swing.JFrame {
    String phoneno, photo, email, gender, username;

    public UserMyFollowers() {
        initComponents();
//          jScrollPane1.setBounds(30, 50, 500, 500);
//        // mainpanel.setPreferredSize(new Dimension(450, count * 120));
//        mainpanel.setPreferredSize(new Dimension(460, 550));
//
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setSize(600,600);
//        setVisible(true);
    }
    public UserMyFollowers(String username){
        this.username=username;
        initComponents();
        setTitle("My Followers");
          jScrollPane1.setBounds(30, 50, 500, 500);
        // mainpanel.setPreferredSize(new Dimension(450, count * 120));
        mainpanel.setPreferredSize(new Dimension(460, 550));
        new Thread(new Myjob()).start();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         lbback.setSize(600,600);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
       
        setSize(600,600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainpanel.setBackground(new java.awt.Color(204, 255, 255));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 40, 340, 280);

        jLabel1.setText("My Followers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 10, 140, 20);

        lbback.setText("jLabel2");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 400, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UserMyFollowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMyFollowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMyFollowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMyFollowers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMyFollowers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables

class Myjob implements Runnable{
    public void run(){
        try {
            HttpResponse httpresponse=Unirest.get(GlobalData.hostname+"/getfollowers")
                    .queryString("username",username)
                    .asString();
            int x=10,y=10;
            if(httpresponse.getStatus()==200){
                String res=httpresponse.getBody().toString();
                System.out.println(res);
                StringTokenizer st=new StringTokenizer(res,"~");
                int count=st.countTokens();
                System.out.println(count+"count");
                UserPanel aruser[]=new UserPanel[count];
                int i=0;
                while(st.hasMoreTokens()){
                    String s=st.nextToken();
                   StringTokenizer st2=new StringTokenizer(s,";");
                   String name=st2.nextToken();
                   phoneno=st2.nextToken();
                   email=st2.nextToken();
                   photo=st2.nextToken();
                   gender=st2.nextToken();
                   aruser[i]=new UserPanel();
                   aruser[i].setBounds(x,y,460,120);
                   aruser[i].btfollow.setVisible(false);
                   aruser[i].lbemail.setText(email);
                   aruser[i].lbname.setText(name);
                   aruser[i].lbphoneno.setText(phoneno);
                   
                   URL url=new URL(GlobalData.hostname+"/getresource/"+photo);
                   BufferedImage img=ImageIO.read(url);
                   BufferedImage newimg=resize(img,90,80);
                   aruser[i].lbphoto.setIcon(new ImageIcon(newimg));
                   
                   mainpanel.add(aruser[i]);
                   repaint();
                   mainpanel.repaint();
                   aruser[i].repaint();
                   y=y+140;
                   
                   i++;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
}
