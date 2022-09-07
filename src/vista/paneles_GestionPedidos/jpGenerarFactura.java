package vista.paneles_GestionPedidos;

import datos.GestionArchivo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author Pablo Restrepo
 */
public class jpGenerarFactura extends javax.swing.JPanel {

    private final ArrayList<clsTienda> lstTiendas;
    private final ArrayList<clsPedido> lstPedidos;
        
    int pos = -1;
    int aux = 0;
    int aux1 = 0;
    
    public jpGenerarFactura(ArrayList<clsTienda> lstTiendas , ArrayList<clsPedido> lstPedidos) {
        this.lstTiendas = lstTiendas;
        this.lstPedidos = lstPedidos;
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
        btnBuscarGenerar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        lblIDDelPedido = new javax.swing.JLabel();
        txtIDPedido = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Generar factura");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        btnBuscarGenerar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscarGenerar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnBuscarGenerar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarGenerar.setText("Buscar/Genenrar");
        btnBuscarGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 170, 40));

        tablaFactura.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "ID Cliente", "Valor pedido", "Total a pagar"
            }
        ));
        jScrollPane1.setViewportView(tablaFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 430, 150));

        lblIDDelPedido.setBackground(new java.awt.Color(0, 0, 0));
        lblIDDelPedido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblIDDelPedido.setForeground(new java.awt.Color(0, 0, 0));
        lblIDDelPedido.setText("ID del pedido:");
        jPanel1.add(lblIDDelPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 170, -1));

        txtIDPedido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(txtIDPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 150, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarGenerarActionPerformed
        try{
            if(this.txtIDPedido.getText().equals("")){
                JOptionPane.showMessageDialog(
                        this,
                        "Por favor diligenciar todos los campos.",
                        "Validación",
                        JOptionPane.ERROR_MESSAGE
                );
            }
            
            else{
                int txtIDPedido = Integer.parseInt(this.txtIDPedido.getText());
                
                for (int i = 0; i < this.lstPedidos.size(); i++) {
                        if (txtIDPedido == (this.lstPedidos.get(i).getCodigoFactura())) {
                            pos = 0;
                            aux = i;
                            break;
                        }
                }
                
                if (pos==0) {
                    JOptionPane.showMessageDialog(this,
                            "Pedido encontrado","Busqueda",
                            JOptionPane.INFORMATION_MESSAGE);

                    Object matriz [][] = new Object[1][4];

                    matriz[0][0] = this.lstPedidos.get(aux).getCodigoFactura();
                    matriz[0][1] = this.lstPedidos.get(aux).getObjCliente().getCedula();
                    matriz[0][2] = this.lstPedidos.get(aux).getValorPedido();
                    matriz[0][3] = this.lstPedidos.get(aux).calcularTotal();

                    tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
                        matriz,
                        new String [] {"Codigo", "ID Cliente", "Valor pedido", "Total a pagar"}
                    ));

                    pos = -1;
                }

                else{
                    JOptionPane.showMessageDialog(this,
                        "Pedido no encontrado","Busqueda",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        finally{
            this.txtIDPedido.setText(""); 
        }
    }//GEN-LAST:event_btnBuscarGenerarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarGenerar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIDDelPedido;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTextField txtIDPedido;
    // End of variables declaration//GEN-END:variables
}