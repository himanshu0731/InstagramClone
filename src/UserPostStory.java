
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

public class UserPostStory extends javax.swing.JFrame {

    JFileChooser jfc;
    String title, photo;
    String username;
    int pid;
    File f;
    BufferedImage img, changedimg;

    public UserPostStory(String username) {
        initComponents();
        this.username = username;
        jfc = new JFileChooser();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        lbback.setSize(600, 600);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
        setTitle("Post Story");

        setSize(600, 600);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tftitle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbimg = new javax.swing.JLabel();
        btbrowse = new javax.swing.JButton();
        btadd = new javax.swing.JButton();
        filterpanel = new javax.swing.JPanel();
        btblur = new javax.swing.JButton();
        btgrayscalefilter = new javax.swing.JButton();
        btdarken = new javax.swing.JButton();
        bthefe = new javax.swing.JButton();
        btlofi = new javax.swing.JButton();
        btnashville = new javax.swing.JButton();
        btnofilter = new javax.swing.JButton();
        btwalden = new javax.swing.JButton();
        btbrighter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btsave = new javax.swing.JButton();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Add Post");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 4, 140, 30);

        jLabel2.setText("Title");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 44, 90, 30);
        getContentPane().add(tftitle);
        tftitle.setBounds(200, 50, 250, 30);

        jLabel3.setText("Cover Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 110, 90, 50);

        lbimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lbimg);
        lbimg.setBounds(200, 120, 250, 160);

        btbrowse.setText("Browse");
        btbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowse);
        btbrowse.setBounds(470, 120, 90, 30);

        btadd.setText(" Add  Post");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(160, 500, 190, 30);

        filterpanel.setBackground(new java.awt.Color(153, 255, 255));
        filterpanel.setLayout(null);

        btblur.setText("Blur");
        btblur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btblurActionPerformed(evt);
            }
        });
        filterpanel.add(btblur);
        btblur.setBounds(20, 70, 100, 30);

        btgrayscalefilter.setText("Gray Scale Filter");
        btgrayscalefilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgrayscalefilterActionPerformed(evt);
            }
        });
        filterpanel.add(btgrayscalefilter);
        btgrayscalefilter.setBounds(130, 70, 140, 30);

        btdarken.setText("Darken");
        btdarken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdarkenActionPerformed(evt);
            }
        });
        filterpanel.add(btdarken);
        btdarken.setBounds(280, 70, 110, 30);

        bthefe.setText("Hefe Filter");
        bthefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthefeActionPerformed(evt);
            }
        });
        filterpanel.add(bthefe);
        bthefe.setBounds(400, 70, 140, 30);

        btlofi.setText("LoFi Filter");
        btlofi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlofiActionPerformed(evt);
            }
        });
        filterpanel.add(btlofi);
        btlofi.setBounds(10, 110, 120, 30);

        btnashville.setText("Nashville Filter");
        btnashville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnashvilleActionPerformed(evt);
            }
        });
        filterpanel.add(btnashville);
        btnashville.setBounds(140, 110, 120, 30);

        btnofilter.setText("No Filter");
        btnofilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnofilterActionPerformed(evt);
            }
        });
        filterpanel.add(btnofilter);
        btnofilter.setBounds(210, 150, 100, 30);

        btwalden.setText("Walden Filter");
        btwalden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btwaldenActionPerformed(evt);
            }
        });
        filterpanel.add(btwalden);
        btwalden.setBounds(280, 110, 110, 30);

        btbrighter.setText("Brighter Filter");
        btbrighter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrighterActionPerformed(evt);
            }
        });
        filterpanel.add(btbrighter);
        btbrighter.setBounds(410, 110, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("Apply Filters");
        filterpanel.add(jLabel4);
        jLabel4.setBounds(20, 10, 240, 40);

        getContentPane().add(filterpanel);
        filterpanel.setBounds(10, 290, 570, 190);

        btsave.setText("Save changes");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btsave);
        btsave.setBounds(460, 200, 130, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 600, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrowseActionPerformed
        int ans = jfc.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
             f = jfc.getSelectedFile();
            photo = f.getPath();
            try {
                img = ImageIO.read(f);
                BufferedImage newimg = resize(img, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(newimg));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_btbrowseActionPerformed

    private void btaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btaddActionPerformed
        new Thread(new Runnable() {
            public void run() {
                title = tftitle.getText();
                if (title.isEmpty() || photo == null) {
                    JOptionPane.showMessageDialog(UserPostStory.this, "All fields are required !!");
                } else {

//                ImageIO.write(changedimg,"jpg",new File(photo));
                    try {
                        HttpResponse httpresponse = Unirest.post(GlobalData.hostname + "/addpost")
                                .queryString("title", title)
                                .queryString("username", username)
                                .field("photo", f)
                                .asString();
                        if (httpresponse.getStatus() == 200) {
                            String res = httpresponse.getBody().toString();
                            pid = Integer.parseInt(res);
                            dispose();
                            UserAddStoryPics obj = new UserAddStoryPics(username, pid);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }

            }
        }).start();

    }//GEN-LAST:event_btaddActionPerformed

    private void btblurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btblurActionPerformed
        new Thread(new Runnable() {
            public void run() {
                lbimg.setIcon(new ImageIcon("src/Pics/progresss.gif"));

                BlurFilter obj = new BlurFilter();
                BufferedImage blurimg = obj.filter(img);
                changedimg = resize(blurimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();

            }
        }).start();

    }//GEN-LAST:event_btblurActionPerformed

    private void btgrayscalefilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgrayscalefilterActionPerformed
        new Thread(new Runnable() {
            public void run() {
                GrayscaleFilter obj = new GrayscaleFilter();
                BufferedImage grayimg = obj.filter(img);
                changedimg = resize(grayimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();

    }//GEN-LAST:event_btgrayscalefilterActionPerformed

    private void btdarkenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdarkenActionPerformed
        new Thread(new Runnable() {
            public void run() {
                DarkerFilter obj = new DarkerFilter();
                BufferedImage darkimg = obj.filter(img);
                changedimg = resize(darkimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();

            }
        }).start();

    }//GEN-LAST:event_btdarkenActionPerformed

    private void bthefeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthefeActionPerformed
        new Thread(new Runnable() {
            public void run() {
                HefeFilter obj = new HefeFilter();
                BufferedImage himg = obj.filter(img);
                changedimg = resize(himg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));

                repaint();
            }
        }).start();

    }//GEN-LAST:event_bthefeActionPerformed

    private void btlofiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlofiActionPerformed
        new Thread(new Runnable() {
            public void run() {
                LoFiFilter obj = new LoFiFilter();
                BufferedImage loimg = obj.filter(img);
                changedimg = resize(loimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();

    }//GEN-LAST:event_btlofiActionPerformed

    private void btnashvilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnashvilleActionPerformed
        new Thread(new Runnable() {
            public void run() {
                NashvilleFilter obj = new NashvilleFilter();
                BufferedImage nimg = obj.filter(img);
                changedimg = resize(nimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();

    }//GEN-LAST:event_btnashvilleActionPerformed

    private void btnofilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnofilterActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                NoFilter obj = new NoFilter();
                BufferedImage nofilterimg = obj.filter(img);
                changedimg = resize(nofilterimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();

            }
        }).start();

    }//GEN-LAST:event_btnofilterActionPerformed

    private void btwaldenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btwaldenActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                WaldenFilter obj = new WaldenFilter();
                BufferedImage wimg = obj.filter(img);
                changedimg = resize(wimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();

    }//GEN-LAST:event_btwaldenActionPerformed

    private void btbrighterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbrighterActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                BrighterFilter obj = new BrighterFilter();
                BufferedImage brighterimg = obj.filter(img);
                changedimg = resize(brighterimg, lbimg.getWidth(), lbimg.getHeight());
                lbimg.setIcon(new ImageIcon(changedimg));

                repaint();
            }
        }).start();

    }//GEN-LAST:event_btbrighterActionPerformed

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        int ans = jfc.showSaveDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
            System.out.println(f.getPath());
            try {
                // File outputfile = new File("image.jpg");
                ImageIO.write(changedimg, "jpg", f);
                JOptionPane.showMessageDialog(this, "File saved successfully !");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btsaveActionPerformed

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
            java.util.logging.Logger.getLogger(UserPostStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPostStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPostStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPostStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new UserPostStory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btadd;
    private javax.swing.JButton btblur;
    private javax.swing.JButton btbrighter;
    private javax.swing.JButton btbrowse;
    private javax.swing.JButton btdarken;
    private javax.swing.JButton btgrayscalefilter;
    private javax.swing.JButton bthefe;
    private javax.swing.JButton btlofi;
    private javax.swing.JButton btnashville;
    private javax.swing.JButton btnofilter;
    private javax.swing.JButton btsave;
    private javax.swing.JButton btwalden;
    private javax.swing.JPanel filterpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbimg;
    private javax.swing.JTextField tftitle;
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
