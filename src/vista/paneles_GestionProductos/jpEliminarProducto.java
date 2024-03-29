package vista.paneles_GestionProductos;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author Pablo Restrepo
 */
public class jpEliminarProducto extends javax.swing.JPanel {

    private final ArrayList<clsTienda> lstTiendas;
    
    int pos = -1;
    int posi = 0;
    
    public jpEliminarProducto(ArrayList<clsTienda> lstTiendas) {
        this.lstTiendas = lstTiendas;
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
        lblCodigodeBarras = new javax.swing.JLabel();
        txtCodigodeBarras = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblNombreProducto = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Eliminar producto");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        lblCodigodeBarras.setBackground(new java.awt.Color(0, 0, 0));
        lblCodigodeBarras.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblCodigodeBarras.setForeground(new java.awt.Color(0, 0, 0));
        lblCodigodeBarras.setText("Codigo de barras:");
        jPanel1.add(lblCodigodeBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, -1));

        txtCodigodeBarras.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jPanel1.add(txtCodigodeBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 150, -1));

        lblNombre.setBackground(new java.awt.Color(0, 0, 0));
        lblNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 160, 20));

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        lblNombreProducto.setBackground(new java.awt.Color(0, 0, 0));
        lblNombreProducto.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreProducto.setText("Nombre del producto:");
        jPanel1.add(lblNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, -1));

        btnEliminar.setBackground(new java.awt.Color(51, 153, 255));
        btnEliminar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
            if(this.txtCodigodeBarras.getText().equals("")){
               JOptionPane.showMessageDialog(
                       this,
                       "Por favor diligenciar todos los campos.",
                       "Validación",
                       JOptionPane.ERROR_MESSAGE
               );
            }
            
            else{
                int codigoBarras = Integer.parseInt(this.txtCodigodeBarras.getText());

                for (int i = 0; i < this.lstTiendas.get(0).getLstProductos().size(); i++) {
                    if (codigoBarras == (this.lstTiendas.get(0).getLstProductos().get(i).getCodigoBarras())) {
                        pos = 0;
                        posi = i;
                        break;
                    }
                }

                if (pos==0) {

                    JOptionPane.showMessageDialog(this,
                    "Producto encontrado","Busqueda",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                    pos = -1;
                    this.btnEliminar.setEnabled(true);
                    this.lblNombre.setText(this.lstTiendas.get(0).getLstProductos().get(posi).getNombre());
                }
                else{  
                    JOptionPane.showMessageDialog(this,
                    "Producto no encontrado","Busqueda",
                    JOptionPane.ERROR_MESSAGE);
                    this.lblNombre.setText("");
                }
            }
        }
        
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,
                    "Error al ingresar datos númericos.",
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(this,
                    "No hay espacio para guardar datos.",
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(this,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally{
            this.txtCodigodeBarras.setText("");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try{
            this.lstTiendas.get(0).getLstProductos().remove(posi);
            JOptionPane.showMessageDialog(this,
                        "Producto eliminado","Busqueda",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this,
                    "El producto ya fue eliminado.",
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally{
            this.lblNombre.setText("");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCodigodeBarras;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCodigodeBarras;
    // End of variables declaration//GEN-END:variables
}
