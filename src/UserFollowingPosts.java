
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UserFollowingPosts extends javax.swing.JFrame {
String username;
//UserHome obj;
    public UserFollowingPosts() {
        initComponents();
        setSize(800,800);
        setVisible(true);
    }
    public UserFollowingPosts(String username) {
        initComponents();
//        this.obj=obj;
        this.username=username;
        jScrollPane1.setSize(750,700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        new Thread(new LoadPosts()).start();
         lbback.setSize(800,800);
        lbback.setIcon(new ImageIcon("src\\Pics\\bg5.jpg"));
       
        setSize(800,800);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        lbback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 710, 480);

        lbback.setText("jLabel1");
        getContentPane().add(lbback);
        lbback.setBounds(0, 0, 740, 540);

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
            java.util.logging.Logger.getLogger(UserFollowingPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFollowingPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFollowingPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFollowingPosts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFollowingPosts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbback;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables

class LoadPosts implements Runnable{
   public void run(){
       try {
           HttpResponse httpresponse=Unirest.get(GlobalData.hostname+"/loadposts")
                   .queryString("username",username)
                   .asString();
           if(httpresponse.getStatus()==200){
               String res=httpresponse.getBody().toString();

               StringTokenizer st=new StringTokenizer(res,"~");
               int count=st.countTokens();
               
              mainpanel.setPreferredSize(new Dimension(750,count*170));

               Posts p[]=new Posts[count];
               System.out.println("Count"+count);
               int i=0;
               int x=10,y=10;
               while(st.hasMoreTokens()){
                   p[i]=new Posts();
                   p[i].setBounds(x, y, 750, 160);
                   String s=st.nextToken();
                   StringTokenizer st2=new StringTokenizer(s,";");
                   int pid=Integer.parseInt(st2.nextToken());
                   String user=st2.nextToken();
                   System.out.println(user);
                   String title=st2.nextToken();
                   String photo=st2.nextToken();
                   String datetime=st2.nextToken();
                                      final int u=i;

                   new Thread(new Runnable(){
                      public void run(){
                          try {
                              HttpResponse httpres=Unirest.get(GlobalData.hostname+"/countlikes")
                                      .queryString("pid",pid).asString();
                              if(httpres.getStatus()==200){
                                  int num=Integer.parseInt(httpres.getBody().toString());
                                  p[u].lbcountlikes.setText(num+" likes");
                              }
                          } catch (Exception ex) {
                              ex.printStackTrace();
                          }
                          
                      } 
                   }).start();
                   HttpResponse httpres=Unirest.get(GlobalData.hostname+"/checklikes")
                           .queryString("username",username)
                           .queryString("pid",pid)
                           .asString();
                   if(httpres.getStatus()==200){
                       if(httpres.getBody().toString().equals("exists")){
                           p[i].lbliketext.setText("Liked");
                           p[i].repaint();
                       }
                       else{
                            p[i].lbliketext.setText("Like");
                           p[i].repaint();

                       }
                   }
                   p[i].lbcaption.setText(title);
                   p[i].lbdate.setText(datetime);
                   p[i].lblike.setIcon(new ImageIcon("src/pics/like3.png"));
                   p[i].lbusername.setText("By: "+user);
                   URL url=new URL(GlobalData.hostname+"/getresource/"+photo);
                   BufferedImage img=ImageIO.read(url);
                   BufferedImage newimg=resize(img,p[i].lbphoto.getWidth(),p[i].lbphoto.getHeight());
                   p[i].lbphoto.setIcon(new ImageIcon(newimg));
                   
                   p[i].lbphoto.addMouseListener(new MouseAdapter() {
                       @Override
                       public void mouseClicked(MouseEvent e) {
                           StoriesUnderPosts obj=new StoriesUnderPosts(pid);
                       }
                   });
                   p[i].lblike.addMouseListener(new MouseAdapter(){
                       public void mouseClicked(MouseEvent e){
                           new Thread(new Runnable(){
                              public void run(){
                           try {
                               HttpResponse hr=Unirest.get(GlobalData.hostname+"/likepost")
                                       .queryString("username",username)
                                       .queryString("pid",pid)
                                       .asString();
                               if(hr.getStatus()==200){
                                   if(hr.getBody().toString().equals("deleted")){
                                       p[u].lbliketext.setText("Like");
                                       p[u].repaint();
                                   }
                                   else{
                                       p[u].lbliketext.setText("Liked");
                                        p[u].repaint();

                                   }
                                   new Thread(new Runnable(){
                      public void run(){
                          try {
                              HttpResponse httpres=Unirest.get(GlobalData.hostname+"/countlikes")
                                      .queryString("pid",pid).asString();
                              if(httpres.getStatus()==200){
                                  int num=Integer.parseInt(httpres.getBody().toString());
                                  p[u].lbcountlikes.setText(num+" likes");
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
                   y=y+170;
                   mainpanel.repaint();
                   p[i].repaint();
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
