/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import java.util.ArrayList;
import kom.Komunikacija;
import konstante.Operacije;
import logic.KlijentskiKontroler;
import transfer.Request;
import transfer.Response;

/**
 *
 * @author Bosko
 */
public class FrmKlijent extends javax.swing.JFrame {

    /**
     * Creates new form FrmKlijent
     */
    public FrmKlijent() {
        initComponents();
        KlijentskiKontroler.getInstance().setFk(this);
        popuniCb();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbPoruka = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtPoruka = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSvePoruke = new javax.swing.JTextArea();
        btnPosalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbPoruka.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Poruka");

        txtSvePoruke.setColumns(20);
        txtSvePoruke.setRows(5);
        jScrollPane1.setViewportView(txtSvePoruke);

        btnPosalji.setText("Posalji");
        btnPosalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPosaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(cbPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPosalji))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPosalji))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPosaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPosaljiActionPerformed
        String kome=(String) cbPoruka.getSelectedItem();
        String poruka=txtPoruka.getText();
        Request req=new Request();
        req.setOperacija(Operacije.POSALJI);
        req.setKorisnickoIme(KlijentskiKontroler.getInstance().getUlogovani());
        req.setPoruka(poruka);
        req.setKome(kome);
        Komunikacija.getInstance().posaljiZahtev(req);
    }//GEN-LAST:event_btnPosaljiActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmKlijent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKlijent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKlijent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKlijent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKlijent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPosalji;
    private javax.swing.JComboBox cbPoruka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtPoruka;
    private javax.swing.JTextArea txtSvePoruke;
    // End of variables declaration//GEN-END:variables

    private void popuniCb() {
        cbPoruka.removeAllItems();
        Request req=new Request();
        req.setOperacija(Operacije.VRATIULOGOVANE);
        req.setKorisnickoIme(KlijentskiKontroler.getInstance().getUlogovani());
        Komunikacija.getInstance().posaljiZahtev(req);
    }

    public void setCB(ArrayList<String> ulogovani) {
        for(String ime:ulogovani){
            cbPoruka.addItem(ime);
        }
        cbPoruka.addItem("Svima");
    }

    public void postaviPoruku(Response res) {
        String nalepi=txtSvePoruke.getText();
        nalepi+=res.getPoruka()+"\n";
        txtSvePoruke.setText(nalepi);
    }
}