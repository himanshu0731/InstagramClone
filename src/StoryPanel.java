public class StoryPanel extends javax.swing.JPanel {

    public StoryPanel() {
        initComponents();
        
        setSize(150,150);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbimg = new javax.swing.JLabel();
        lbcaption = new javax.swing.JLabel();
        btcross = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setLayout(null);

        lbimg.setText("jLabel1");
        add(lbimg);
        lbimg.setBounds(10, 10, 100, 100);

        lbcaption.setText("jLabel1");
        add(lbcaption);
        lbcaption.setBounds(10, 120, 190, 30);

        btcross.setBackground(new java.awt.Color(255, 255, 255));
        btcross.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btcross.setForeground(new java.awt.Color(255, 0, 0));
        btcross.setText("X");
        add(btcross);
        btcross.setBounds(110, 10, 40, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btcross;
    public javax.swing.JLabel lbcaption;
    public javax.swing.JLabel lbimg;
    // End of variables declaration//GEN-END:variables
}
