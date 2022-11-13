
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class UserAddStoryPics extends javax.swing.JFrame {

    JFileChooser jfc;
    String photo, caption;
    String username;
    int pid;
    BufferedImage img,newimg,changedimg;
    File f;
//ArrayList <Story> al=new ArrayList<>();

    public UserAddStoryPics()  {
                initComponents();
        setTitle("Add Story");

        lbback.setSize(700,1000);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));

        jfc=new JFileChooser();
        setSize(700,1000);
        setVisible(true);
        
    }
    

    public UserAddStoryPics(String username, int pid) {
        initComponents();
        this.username = username;
        this.pid = pid;
        jfc = new JFileChooser();
        lbback.setSize(850,800);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));

        jScrollPane1.setSize(750, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        new Thread(new Runnable() {
            public void run() {
                loadstories();
            }
        }).start();
        setSize(850, 800);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfcaption = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbimg = new javax.swing.JLabel();
        btbrowse = new javax.swing.JButton();
        btadd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
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
        jLabel1.setText("Add Story");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 0, 160, 40);

        jLabel2.setText("Caption");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 60, 120, 30);
        getContentPane().add(tfcaption);
        tfcaption.setBounds(170, 60, 270, 30);

        jLabel3.setText("Photo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 100, 80, 30);

        lbimg.setText("jLabel4");
        getContentPane().add(lbimg);
        lbimg.setBounds(170, 110, 230, 140);

        btbrowse.setText("Browse");
        btbrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrowseActionPerformed(evt);
            }
        });
        getContentPane().add(btbrowse);
        btbrowse.setBounds(420, 130, 100, 30);

        btadd.setText(" Add Story");
        btadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btaddActionPerformed(evt);
            }
        });
        getContentPane().add(btadd);
        btadd.setBounds(150, 270, 120, 40);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 320, 700, 150);

        filterpanel.setBackground(new java.awt.Color(153, 255, 255));
        filterpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        filterpanel.setLayout(null);

        btblur.setText("Blur");
        btblur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btblurActionPerformed(evt);
            }
        });
        filterpanel.add(btblur);
        btblur.setBounds(30, 60, 100, 30);

        btgrayscalefilter.setText("Gray Scale Filter");
        btgrayscalefilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgrayscalefilterActionPerformed(evt);
            }
        });
        filterpanel.add(btgrayscalefilter);
        btgrayscalefilter.setBounds(20, 160, 120, 30);

        btdarken.setText("Darken");
        btdarken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdarkenActionPerformed(evt);
            }
        });
        filterpanel.add(btdarken);
        btdarken.setBounds(180, 60, 110, 30);

        bthefe.setText("Hefe Filter");
        bthefe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthefeActionPerformed(evt);
            }
        });
        filterpanel.add(bthefe);
        bthefe.setBounds(190, 210, 110, 30);

        btlofi.setText("LoFi Filter");
        btlofi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlofiActionPerformed(evt);
            }
        });
        filterpanel.add(btlofi);
        btlofi.setBounds(20, 110, 120, 30);

        btnashville.setText("Nashville Filter");
        btnashville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnashvilleActionPerformed(evt);
            }
        });
        filterpanel.add(btnashville);
        btnashville.setBounds(20, 210, 120, 30);

        btnofilter.setText("No Filter");
        btnofilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnofilterActionPerformed(evt);
            }
        });
        filterpanel.add(btnofilter);
        btnofilter.setBounds(110, 250, 100, 30);

        btwalden.setText("Walden Filter");
        btwalden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btwaldenActionPerformed(evt);
            }
        });
        filterpanel.add(btwalden);
        btwalden.setBounds(180, 110, 110, 30);

        btbrighter.setText("Brighter Filter");
        btbrighter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbrighterActionPerformed(evt);
            }
        });
        filterpanel.add(btbrighter);
        btbrighter.setBounds(180, 160, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel4.setText("Apply Filters");
        filterpanel.add(jLabel4);
        jLabel4.setBounds(90, 10, 240, 40);

        getContentPane().add(filterpanel);
        filterpanel.setBounds(540, 10, 330, 300);

        btsave.setText("Save changes");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });
        getContentPane().add(btsave);
        btsave.setBounds(410, 180, 120, 40);
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 900, 560);

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
        caption = tfcaption.getText();
        if (caption.isEmpty() || photo == null) {
            JOptionPane.showMessageDialog(UserAddStoryPics.this, "All fields are required !!");
        } else {
            try {
                System.out.println("Path" + photo);
                System.out.println("Pid" + pid);
                HttpResponse httpresponse = Unirest.post(GlobalData.hostname + "/addstory")
                        .queryString("caption", caption)
                        .queryString("pid", pid + "")
                        .field("photo", f)
                        .asString();
                if (httpresponse.getStatus() == 200) {
                    if (httpresponse.getBody().equals("inserted")) {
                        JOptionPane.showMessageDialog(this, "Story Added !!");
                        loadstories();
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
            java.util.logging.Logger.getLogger(UserAddStoryPics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAddStoryPics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAddStoryPics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAddStoryPics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new UserAddStoryPics().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback;
    private javax.swing.JLabel lbimg;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField tfcaption;
    // End of variables declaration//GEN-END:variables

    BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }

    void loadstories() {
        
        mainpanel.removeAll();
        mainpanel.repaint();
        HttpResponse httpresponse;
        try {
            httpresponse = Unirest.get(GlobalData.hostname + "/getstories")
                    .queryString("pid", pid)
                    .asString();
            if (httpresponse.getStatus() == 200) {
                String res = httpresponse.getBody().toString();
                StringTokenizer st = new StringTokenizer(res, "~");
                int count = st.countTokens();
                mainpanel.setPreferredSize(new Dimension(750, 400));
                System.out.println("count" + count);
                StoryPanel sp[] = new StoryPanel[count];
                int i = 0;
                int x = 10, y = 10;
                int sid;
                // al.clear();
                while (st.hasMoreTokens()) {
                    sp[i] = new StoryPanel();
                    sp[i].setBounds(x, y, 150, 150);
                    String s = st.nextToken();
                    StringTokenizer st2 = new StringTokenizer(s, ";");
                    int id = Integer.parseInt(st2.nextToken());
                    String photo = st2.nextToken();
                    String caption = st2.nextToken();
                    // al.add(new Story(id,photo,caption));
                    sp[i].lbcaption.setText(caption);

                    try {
                        URL url = new URL(GlobalData.hostname + "/getresource/" + photo);
                        BufferedImage img = ImageIO.read(url);
                        BufferedImage newimg = resize(img, sp[i].lbimg.getWidth(), sp[i].lbimg.getHeight());
                        sp[i].lbimg.setIcon(new ImageIcon(newimg));
                        sp[i].btcross.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                try {
                                    HttpResponse httpres = Unirest.get(GlobalData.hostname + "/deletestory")
                                            .queryString("sid", id)
                                            .asString();
                                    if (httpres.getStatus() == 200) {
                                        if (httpres.getBody().equals("deleted")) {
                                            System.out.println("In listener");
                                            mainpanel.removeAll();
                                            loadstories();

                                        }
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }

                        });
                        mainpanel.add(sp[i]);
                        repaint();
                        mainpanel.repaint();
                        sp[i].repaint();
                        if (x < 550) {
                            System.out.println(x);
                            x = x + 180;
                        } else {
                            y = y + 180;
                            x = 10;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    i++;
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
