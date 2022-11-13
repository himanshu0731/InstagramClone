
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class UserHome extends javax.swing.JFrame {

    boolean flag = false;
    String username;
//    String images[] = {"src/Pics/i1.png", "src/Pics/i2.jpg", "src/Pics/i3.jpg"};

    public UserHome() {
        initComponents();
        setSize(700, 500);
        setVisible(true);
    }

    UserHome(String username) {
        this.username = username;
        initComponents();
        lbwelcome.setText("Welcome " + username);
        btrefresh.setIcon(new ImageIcon("src/Pics/refresh.png"));
        jScrollPane1.setSize(750, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        new Thread(new LoadPosts()).start();
        setTitle("User Home");
        lbback.setSize(900, 800);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
        setSize(900, 800);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbwelcome = new javax.swing.JLabel();
        btchangepassword = new javax.swing.JButton();
        btsearchfriend = new javax.swing.JButton();
        btfollowers = new javax.swing.JButton();
        btfollowings = new javax.swing.JButton();
        btpoststory = new javax.swing.JButton();
        bteditprofile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        btrefresh = new javax.swing.JButton();
        btlogout = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbwelcome.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbwelcome.setText("jLabel1");
        getContentPane().add(lbwelcome);
        lbwelcome.setBounds(10, 40, 280, 40);

        btchangepassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btchangepassword.setText("Change Password");
        btchangepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchangepasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btchangepassword);
        btchangepassword.setBounds(0, 10, 160, 30);

        btsearchfriend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btsearchfriend.setText("Search Friend");
        btsearchfriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsearchfriendActionPerformed(evt);
            }
        });
        getContentPane().add(btsearchfriend);
        btsearchfriend.setBounds(160, 10, 120, 30);

        btfollowers.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btfollowers.setText("Followers");
        btfollowers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfollowersActionPerformed(evt);
            }
        });
        getContentPane().add(btfollowers);
        btfollowers.setBounds(280, 10, 110, 30);

        btfollowings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btfollowings.setText("Followings");
        btfollowings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btfollowingsActionPerformed(evt);
            }
        });
        getContentPane().add(btfollowings);
        btfollowings.setBounds(390, 10, 120, 30);

        btpoststory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btpoststory.setText("Post Story");
        btpoststory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpoststoryActionPerformed(evt);
            }
        });
        getContentPane().add(btpoststory);
        btpoststory.setBounds(510, 10, 130, 30);

        bteditprofile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bteditprofile.setText("Edit Profile");
        bteditprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteditprofileActionPerformed(evt);
            }
        });
        getContentPane().add(bteditprofile);
        bteditprofile.setBounds(640, 10, 140, 30);

        mainpanel.setBackground(new java.awt.Color(193, 248, 248));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 810, 420);

        btrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btrefresh);
        btrefresh.setBounds(810, 50, 40, 40);

        btlogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btlogout.setText("Logout");
        btlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btlogout);
        btlogout.setBounds(780, 10, 100, 30);

        lbback.setText("jLabel1");
        getContentPane().add(lbback);
        lbback.setBounds(-20, -10, 930, 560);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btchangepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btchangepasswordActionPerformed
        dispose();

        UserChangePassword obj = new UserChangePassword(username);


    }//GEN-LAST:event_btchangepasswordActionPerformed

    private void btsearchfriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchfriendActionPerformed
        UserSearchFriend obj = new UserSearchFriend(username);

    }//GEN-LAST:event_btsearchfriendActionPerformed

    private void btfollowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfollowersActionPerformed
        UserMyFollowers obj = new UserMyFollowers(username);
    }//GEN-LAST:event_btfollowersActionPerformed

    private void btfollowingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btfollowingsActionPerformed
        UserMyFollowings obj = new UserMyFollowings(username);
    }//GEN-LAST:event_btfollowingsActionPerformed

    private void btpoststoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpoststoryActionPerformed
        UserPostStory obj = new UserPostStory(username);
    }//GEN-LAST:event_btpoststoryActionPerformed

    private void bteditprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteditprofileActionPerformed
        UserEditProfile obj = new UserEditProfile(username);
    }//GEN-LAST:event_bteditprofileActionPerformed

    private void btrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrefreshActionPerformed
        flag = true;
        mainpanel.removeAll();
        loadPosts();
    }//GEN-LAST:event_btrefreshActionPerformed

    private void btlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogoutActionPerformed
        dispose();
        UserLogin obj = new UserLogin();
    }//GEN-LAST:event_btlogoutActionPerformed
// UserFollowingPosts-Wall

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
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btchangepassword;
    private javax.swing.JButton bteditprofile;
    private javax.swing.JButton btfollowers;
    private javax.swing.JButton btfollowings;
    private javax.swing.JButton btlogout;
    private javax.swing.JButton btpoststory;
    private javax.swing.JButton btrefresh;
    private javax.swing.JButton btsearchfriend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbwelcome;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables

    void loadPosts() {
        new Thread(new LoadPosts()).start();
    }

    class LoadPosts implements Runnable {

        public void run() {
            try {
                HttpResponse httpresponse = Unirest.get(GlobalData.hostname + "/loadposts")
                        .queryString("username", username)
                        .asString();
                if (httpresponse.getStatus() == 200) {
                    String res = httpresponse.getBody().toString();

                    StringTokenizer st = new StringTokenizer(res, "~");
                    int count = st.countTokens();
                    if (count == 0 && flag == false) {
                        JLabel lb = new JLabel("Follow friends for better experience !");
                        lb.setFont(new Font("Tahoma", Font.BOLD, 36));
                        lb.setBounds(10, 10, 700, 60);
                        mainpanel.add(lb);

                        repaint();
                        mainpanel.repaint();
                    } else {
                        mainpanel.setPreferredSize(new Dimension(730, count * 170));

                        Posts p[] = new Posts[count];
                        System.out.println("Count" + count);
                        int i = 0;
                        int x = 10, y = 10;
                        while (st.hasMoreTokens()) {
                            p[i] = new Posts();
                            p[i].setBounds(x, y, 750, 160);
                            String s = st.nextToken();
                            StringTokenizer st2 = new StringTokenizer(s, ";");
                            int pid = Integer.parseInt(st2.nextToken());
                            String user = st2.nextToken();
                            System.out.println(user);
                            String title = st2.nextToken();
                            String photo = st2.nextToken();
                            String datetime = st2.nextToken();
                            final int u = i;

                            new Thread(new Runnable() {
                                public void run() {
                                    try {
                                        HttpResponse httpres = Unirest.get(GlobalData.hostname + "/countlikes")
                                                .queryString("pid", pid).asString();
                                        if (httpres.getStatus() == 200) {
                                            int num = Integer.parseInt(httpres.getBody().toString());
                                            p[u].lbcountlikes.setText(num + " likes");
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }

                                }
                            }).start();
                            HttpResponse httpres = Unirest.get(GlobalData.hostname + "/checklikes")
                                    .queryString("username", username)
                                    .queryString("pid", pid)
                                    .asString();
                            if (httpres.getStatus() == 200) {
                                if (httpres.getBody().toString().equals("exists")) {
                                    p[i].lbliketext.setText("Liked");
                                    p[i].repaint();
                                } else {
                                    p[i].lbliketext.setText("Like");
                                    p[i].repaint();

                                }
                            }
                            p[i].lbcaption.setText(title);
                            p[i].lbdate.setText(datetime);
                            p[i].lblike.setIcon(new ImageIcon("src/pics/like3.png"));
                            p[i].lbusername.setText("By: " + user);
                            URL url = new URL(GlobalData.hostname + "/getresource/" + photo);
                            BufferedImage img = ImageIO.read(url);
                            BufferedImage newimg = resize(img, p[i].lbphoto.getWidth(), p[i].lbphoto.getHeight());
                            p[i].lbphoto.setIcon(new ImageIcon(newimg));

                            p[i].lbphoto.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    StoriesUnderPosts obj = new StoriesUnderPosts(pid);
                                }
                            });
                            p[i].lblike.addMouseListener(new MouseAdapter() {
                                public void mouseClicked(MouseEvent e) {
                                    new Thread(new Runnable() {
                                        public void run() {
                                            try {
                                                HttpResponse hr = Unirest.get(GlobalData.hostname + "/likepost")
                                                        .queryString("username", username)
                                                        .queryString("pid", pid)
                                                        .asString();
                                                if (hr.getStatus() == 200) {
                                                    if (hr.getBody().toString().equals("deleted")) {
                                                        p[u].lbliketext.setText("Like");
                                                        p[u].repaint();
                                                    } else {
                                                        p[u].lbliketext.setText("Liked");
                                                        p[u].repaint();

                                                    }
                                                    new Thread(new Runnable() {
                                                        public void run() {
                                                            try {
                                                                HttpResponse httpres = Unirest.get(GlobalData.hostname + "/countlikes")
                                                                        .queryString("pid", pid).asString();
                                                                if (httpres.getStatus() == 200) {
                                                                    int num = Integer.parseInt(httpres.getBody().toString());
                                                                    p[u].lbcountlikes.setText(num + " likes");
                                                                }
                                                            } catch (Exception ex) {
                                                                ex.printStackTrace();
                                                            }

                                                        }
                                                    }).start();
                                                }
                                            } catch (Exception ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }).start();

                                }

                            });
                            System.out.println(count);
                            mainpanel.add(p[i]);
                            repaint();
                            y = y + 170;
                            mainpanel.repaint();
                            p[i].repaint();
                            i++;
                        }
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
