public class Posts extends javax.swing.JPanel {

    public Posts() {
        initComponents();
        setSize(200,800);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbphoto = new javax.swing.JLabel();
        lbcaption = new javax.swing.JLabel();
        lbusername = new javax.swing.JLabel();
        lbdate = new javax.swing.JLabel();
        lblike = new javax.swing.JLabel();
        lbliketext = new javax.swing.JLabel();
        lbcountlikes = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(null);

        lbphoto.setText("jLabel1");
        add(lbphoto);
        lbphoto.setBounds(40, 10, 170, 120);

        lbcaption.setText("jLabel1");
        add(lbcaption);
        lbcaption.setBounds(230, 10, 330, 30);

        lbusername.setText("jLabel1");
        add(lbusername);
        lbusername.setBounds(230, 60, 380, 30);

        lbdate.setText("jLabel1");
        add(lbdate);
        lbdate.setBounds(230, 100, 410, 30);

        lblike.setText("L");
        add(lblike);
        lblike.setBounds(10, 140, 30, 20);

        lbliketext.setText("Like");
        add(lbliketext);
        lbliketext.setBounds(50, 130, 60, 30);

        lbcountlikes.setText("jLabel1");
        add(lbcountlikes);
        lbcountlikes.setBounds(120, 130, 80, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lbcaption;
    public javax.swing.JLabel lbcountlikes;
    public javax.swing.JLabel lbdate;
    public javax.swing.JLabel lblike;
    public javax.swing.JLabel lbliketext;
    public javax.swing.JLabel lbphoto;
    public javax.swing.JLabel lbusername;
    // End of variables declaration//GEN-END:variables
}
