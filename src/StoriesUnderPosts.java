
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class StoriesUnderPosts extends javax.swing.JFrame {

    int w, h, pid;
    String ar[];

    public StoriesUnderPosts() {
        initComponents();
    }

    public StoriesUnderPosts(int pid) {
        initComponents();
        this.pid = pid;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        System.out.println("Pid" + pid);
        setTitle("Wall");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w = (int) d.getWidth();
        h = (int) d.getHeight();
        setSize(w, h);
        progresspanel.setSize(w, 100);
        new Thread(new LoadStories()).start();
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progresspanel = new javax.swing.JPanel();
        lbimg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        progresspanel.setBackground(new java.awt.Color(204, 255, 255));
        progresspanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        progresspanel.setLayout(null);
        getContentPane().add(progresspanel);
        progresspanel.setBounds(10, 20, 520, 130);

        lbimg.setText("jLabel1");
        getContentPane().add(lbimg);
        lbimg.setBounds(190, 160, 630, 460);

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
            java.util.logging.Logger.getLogger(StoriesUnderPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoriesUnderPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoriesUnderPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoriesUnderPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoriesUnderPosts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbimg;
    private javax.swing.JPanel progresspanel;
    // End of variables declaration//GEN-END:variables

    class LoadStories implements Runnable {

        public void run() {
            try {

                HttpResponse httpres = Unirest.get(GlobalData.hostname + "/fetchstories")
                        .queryString("pid", pid)
                        .asString();
                if (httpres.getStatus() == 200) {
                    String res = httpres.getBody().toString();
                    StringTokenizer st = new StringTokenizer(res, ";");
                    int count = st.countTokens();
                    ar = new String[count];
                    int i = 0;
                    int width = (int) (w / (count));
                    int height = 20;
                    int x = 20, y = 20;
                    JProgressBar arprogress[] = new JProgressBar[count];
                    for (int k = 0; k < count; k++) {
                        x = (width * k) + 10;

                        arprogress[k] = new JProgressBar();
                        arprogress[k].setBounds(x, y, width, height);
                        progresspanel.add(arprogress[k]);
                        progresspanel.repaint();
                        repaint();

                    }
                    while (st.hasMoreTokens()) {
                        // arprogress[i].setStringPainted(true);

                        String photo = st.nextToken();
                        System.out.println("photo" + photo);
                        ar[i] = photo;
                        URL url = new URL(GlobalData.hostname + "/getresource/" + photo);
                        BufferedImage img = ImageIO.read(url);
                        BufferedImage newimg = resize(img, lbimg.getWidth(), lbimg.getHeight());
                        lbimg.setIcon(new ImageIcon(newimg));
                        for (int j = 1; j <= 100; j++) {
                            arprogress[i].setValue(j);
                            Thread.sleep(10);
                        }
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
