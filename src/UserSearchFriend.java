
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserSearchFriend extends javax.swing.JFrame {

    String name, phoneno, photo, email, gender, username;

    ArrayList<User> al = new ArrayList<>();

    public UserSearchFriend() {
        initComponents();

    }

    UserSearchFriend(String username) {
        this.username = username;
        initComponents();
                setTitle("Search Friend");

        jScrollPane1.setBounds(30, 50, 500, 500);
        // mainpanel.setPreferredSize(new Dimension(450, count * 120));
//        mainpanel.setPreferredSize(new Dimension(460, 550));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         lbback.setSize(600,600);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
       
        setSize(600, 600);
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfsearch = new javax.swing.JTextField();
        btsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(tfsearch);
        tfsearch.setBounds(50, 20, 310, 30);

        btsearch.setText("Search");
        btsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btsearch);
        btsearch.setBounds(420, 20, 100, 30);

        mainpanel.setBackground(new java.awt.Color(204, 255, 255));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 550, 320);

        lbback.setText("jLabel1");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 600, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchActionPerformed
        new Thread(new Runnable() {
            public void run() {
                name = tfsearch.getText();
                String response;
                try {
                    HttpResponse httpres = Unirest.get(GlobalData.hostname + "/searchfriend")
                            .queryString("username", name)
                            .asString();
                    if (httpres.getStatus() == 200) {
                        response = httpres.getBody().toString();
                        al.clear();
                        mainpanel.removeAll();
                        mainpanel.repaint();
                        int x = 10, y = 10;
                        StringTokenizer st = new StringTokenizer(response, "~");
                        int count = st.countTokens();
                        System.out.println("Count:" + count);
                        //mainpanel.setBounds(x, y, , count*120);
                                mainpanel.setPreferredSize(new Dimension(460,(count*120)));

                        UserPanel[] aruser = new UserPanel[count];
                        int i = 0;
                        while (st.hasMoreTokens()) {
                            String s = st.nextToken();
                            StringTokenizer st2 = new StringTokenizer(s, ";");

                            final String name1 = st2.nextToken();
                            System.out.println("starting :" + name1);
                           
                            phoneno = st2.nextToken();
                            photo = st2.nextToken();
                            email = st2.nextToken();
                            gender = st2.nextToken();
                            User u = new User(name1, photo, email, phoneno, gender);
                            if (u.username.equals(username)) {

                            } else {
                                aruser[i] = new UserPanel();
                                aruser[i].setBounds(x, y, 460, 120);
                                 HttpResponse httpresp=Unirest.get(GlobalData.hostname+"/checkfollowing")
                                    .queryString("username",username)
                                    .queryString("name",name1)
                                    .asString();
                            if(httpresp.getStatus()==200){
                                String r=httpresp.getBody().toString();
                                if(r.equals("yes")){
                                    aruser[i].btfollow.setText("Followed");
                                }
                                else{
                                    aruser[i].btfollow.setText("Follow");
                                }
                            }
                                aruser[i].lbname.setText(name1);
                                aruser[i].lbemail.setText(email);
                                aruser[i].lbphoneno.setText(phoneno);
                                try {
                                    URL url = new URL(GlobalData.hostname + "/getresource/" + photo);
                                    BufferedImage img = ImageIO.read(url);
                                    BufferedImage newimg = resize(img, 90, 80);
                                    mainpanel.add(aruser[i]);
                                    y = y + 120;
                                    repaint();
                                    mainpanel.repaint();
                                    aruser[i].repaint();
                                    aruser[i].lbphoto.setIcon(new ImageIcon(newimg));
                                  final int a=i;
                                    aruser[i].btfollow.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mouseClicked(MouseEvent e) {
                                            new Thread(new Runnable(){
                                                public void run(){
                                                     try {
                                                System.out.println("Name in listener" + name1);
                                                HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/followrequest")
                                                        .queryString("username", username)
                                                        .queryString("name", name1)
                                                        .asString();
                                                if (httpresponse.getStatus() == 200) {
                                                    String r = httpresponse.getBody().toString();
                                                    if (r.equals("inserted")) {
                                                        
                                                        aruser[a].btfollow.setText("Followed");
                                                        
                                                    } else {
                                                      //  JOptionPane.showMessageDialog(rootPane, "Already followed !");
                                                    aruser[a].btfollow.setText("Follow");
                                                    }

                                                }
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            } 
                                                }
                                            }).start();
                                          

                                        }
                                    });

                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }

                                i++;
                            }
                        }
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();

    }//GEN-LAST:event_btsearchActionPerformed

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
            java.util.logging.Logger.getLogger(UserSearchFriend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSearchFriend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSearchFriend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSearchFriend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSearchFriend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btsearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField tfsearch;
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
