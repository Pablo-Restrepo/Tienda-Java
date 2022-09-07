package vista.paneles_GestionProductos;

import datos.GestionArchivo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;

/**
 *
 * @author Pablo Restrepo
 */
public class jpImprimirProductos extends javax.swing.JPanel {

    private final ArrayList<clsTienda> lstTiendas;
    
    public jpImprimirProductos(ArrayList<clsTienda> lstTiendas) {
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
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnGuardarArchivo = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Imprimir productos");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        btnImprimir.setBackground(new java.awt.Color(51, 153, 255));
        btnImprimir.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(0, 0, 0));
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        tablaProductos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Co. de barras", "Fecha de Ven.", "Fecha de Fab.", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setEnabled(false);
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setResizable(false);
            tablaProductos.getColumnModel().getColumn(1).setResizable(false);
            tablaProductos.getColumnModel().getColumn(2).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 430, 300));

        btnGuardarArchivo.setBackground(new java.awt.Color(0, 153, 255));
        btnGuardarArchivo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        btnGuardarArchivo.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardarArchivo.setText("Guardar en archivo");
        btnGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, 30));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (this.lstTiendas.get(0).getLstProductos().size() > 0) {
            Object matriz [][] = new Object[this.lstTiendas.get(0).getLstProductos().size()][5];
        
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            for(int i=0; i<this.lstTiendas.get(0).getLstProductos().size(); i++){
                String fechafab = formato.format(this.lstTiendas.get(0).getLstProductos().get(i).getFechaFab().getTime());
                String fechaven = formato.format(this.lstTiendas.get(0).getLstProductos().get(i).getFechaVen().getTime());
                matriz[i][0] = this.lstTiendas.get(0).getLstProductos().get(i).getNombre();
                matriz[i][1] = this.lstTiendas.get(0).getLstProductos().get(i).getCodigoBarras();
                matriz[i][2] = fechaven;
                matriz[i][3] = fechafab;
                matriz[i][4] = this.lstTiendas.get(0).getLstProductos().get(i).getPrecio();
            }

            tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String [] {"Nombre", "Co. de barras", "Fecha de Ven.", "Fecha de Fab.", "Precio"}
            ));
        }
        else{
            DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel(); 
            model.setRowCount(0);
            JOptionPane.showMessageDialog(this,
                    "Crea un producto primero.",
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarArchivoActionPerformed
        GestionArchivo GA = new GestionArchivo();
        GA.escribirDatosProductos(this.lstTiendas);

        JOptionPane.showMessageDialog(null,
            "Datos guardados con éxito.",
            "Gestión escritura",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnGuardarArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarArchivo;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}