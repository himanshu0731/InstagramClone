public class UserPanel extends javax.swing.JPanel {

    public UserPanel() {
        initComponents();
        setSize(200,500);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbphoto = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbphoneno = new javax.swing.JLabel();
        lbemail = new javax.swing.JLabel();
        btfollow = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(null);

        lbphoto.setText("jLabel1");
        add(lbphoto);
        lbphoto.setBounds(10, 10, 90, 80);

        lbname.setText("jLabel1");
        add(lbname);
        lbname.setBounds(140, 10, 120, 30);

        lbphoneno.setText("jLabel1");
        add(lbphoneno);
        lbphoneno.setBounds(140, 50, 160, 20);

        lbemail.setText("jLabel1");
        add(lbemail);
        lbemail.setBounds(140, 90, 170, 30);

        btfollow.setText("Follow");
        add(btfollow);
        btfollow.setBounds(330, 40, 120, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btfollow;
    public javax.swing.JLabel lbemail;
    public javax.swing.JLabel lbname;
    public javax.swing.JLabel lbphoneno;
    public javax.swing.JLabel lbphoto;
    // End of variables declaration//GEN-END:variables
}
