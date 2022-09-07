package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import modelo.*;
import vista.paneles_GestionPedidos.*;

/**
 *
 * @author Pablo Restrepo
 */
public class jDialogGestionPedidos extends javax.swing.JDialog {
    
    private final ArrayList<clsTienda> lstTiendas;
    private final ArrayList<clsPedido> lstPedidos;
    
    private final jpCrearPedidos panelCrearPedidos;
    private final jpEliminarPedido panelEliminarPedido;
    private final jpImprimirPedidos panelImprimirPedidos;
    private final jpGenerarFactura panelGenerarFactura;
    
    public jDialogGestionPedidos(java.awt.Frame parent, boolean modal, ArrayList<clsTienda> lstTiendas, ArrayList<clsPedido> lstPedidos) {
        super(parent, modal);
        
        this.lstTiendas = lstTiendas;
        this.lstPedidos = lstPedidos;
        
        this.panelCrearPedidos = new jpCrearPedidos(this.lstTiendas,this.lstPedidos);
        this.panelEliminarPedido = new jpEliminarPedido(this.lstTiendas,this.lstPedidos);
        this.panelImprimirPedidos = new jpImprimirPedidos(this.lstTiendas,this.lstPedidos);
        this.panelGenerarFactura = new jpGenerarFactura(this.lstTiendas,this.lstPedidos);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCrearPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        btnImprimirPedido = new javax.swing.JButton();
        btnGenenrarFactura = new javax.swing.JButton();
        jPanelCentro = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(680, 590));

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setPreferredSize(new java.awt.Dimension(877, 110));
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Gestión de pedidos");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(160, 30, 377, 43);

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Imagen12.png"))); // NOI18N
        Logo.setPreferredSize(new java.awt.Dimension(677, 280));
        jPanel1.add(Logo);
        Logo.setBounds(10, -170, 650, 290);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(240, 240, 240));
        jPanel2.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 380));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrearPedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCrearPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Imagen14.png"))); // NOI18N
        btnCrearPedido.setToolTipText("");
        btnCrearPedido.setBorder(null);
        btnCrearPedido.setBorderPainted(false);
        btnCrearPedido.setContentAreaFilled(false);
        btnCrearPedido.setFocusPainted(false);
        btnCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 90));

        btnEliminarPedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEliminarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Imagen13.png"))); // NOI18N
        btnEliminarPedido.setToolTipText("");
        btnEliminarPedido.setBorder(null);
        btnEliminarPedido.setBorderPainted(false);
        btnEliminarPedido.setContentAreaFilled(false);
        btnEliminarPedido.setFocusPainted(false);
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, -1));

        btnImprimirPedido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnImprimirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Imagen15.png"))); // NOI18N
        btnImprimirPedido.setToolTipText("");
        btnImprimirPedido.setBorder(null);
        btnImprimirPedido.setBorderPainted(false);
        btnImprimirPedido.setContentAreaFilled(false);
        btnImprimirPedido.setFocusPainted(false);
        btnImprimirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimirPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 150, 90));

        btnGenenrarFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnGenenrarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Imagen17.png"))); // NOI18N
        btnGenenrarFactura.setToolTipText("");
        btnGenenrarFactura.setBorder(null);
        btnGenenrarFactura.setBorderPainted(false);
        btnGenenrarFactura.setContentAreaFilled(false);
        btnGenenrarFactura.setFocusPainted(false);
        btnGenenrarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenenrarFacturaActionPerformed(evt);
            }
        });
        jPanel2.add(btnGenenrarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 150, 90));

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanelCentro.setBackground(new java.awt.Color(240, 240, 240));
        jPanelCentro.setForeground(new java.awt.Color(240, 240, 240));
        jPanelCentro.setPreferredSize(new java.awt.Dimension(310, 370));
        jPanelCentro.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPedidoActionPerformed
        this.jPanelCentro.remove(this.panelEliminarPedido);
        this.jPanelCentro.remove(this.panelImprimirPedidos);
        this.jPanelCentro.remove(this.panelGenerarFactura);
        this.jPanelCentro.add(this.panelCrearPedidos,BorderLayout.CENTER);
        this.jPanelCentro.revalidate();
        this.jPanelCentro.repaint();
    }//GEN-LAST:event_btnCrearPedidoActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        this.jPanelCentro.remove(this.panelCrearPedidos);
        this.jPanelCentro.remove(this.panelImprimirPedidos);
        this.jPanelCentro.remove(this.panelGenerarFactura);
        this.jPanelCentro.add(this.panelEliminarPedido,BorderLayout.CENTER);
        this.jPanelCentro.revalidate();
        this.jPanelCentro.repaint();
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnGenenrarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenenrarFacturaActionPerformed
        this.jPanelCentro.remove(this.panelEliminarPedido);
        this.jPanelCentro.remove(this.panelImprimirPedidos);
        this.jPanelCentro.remove(this.panelCrearPedidos);
        this.jPanelCentro.add(this.panelGenerarFactura,BorderLayout.CENTER);
        this.jPanelCentro.revalidate();
        this.jPanelCentro.repaint();
    }//GEN-LAST:event_btnGenenrarFacturaActionPerformed

    private void btnImprimirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirPedidoActionPerformed
        this.jPanelCentro.remove(this.panelEliminarPedido);
        this.jPanelCentro.remove(this.panelCrearPedidos);
        this.jPanelCentro.remove(this.panelGenerarFactura);
        this.jPanelCentro.add(this.panelImprimirPedidos,BorderLayout.CENTER);
        this.jPanelCentro.revalidate();
        this.jPanelCentro.repaint();
    }//GEN-LAST:event_btnImprimirPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btnCrearPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnGenenrarFactura;
    private javax.swing.JButton btnImprimirPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCentro;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}