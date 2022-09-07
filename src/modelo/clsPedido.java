package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Pablo Restrepo
 */
public class clsPedido implements iGestion{

    //ATRIBUTOS
    //Atributos de clase
    
    private long codigoFactura;
    private Calendar fechaFacturacion;
    private Calendar fechaPago;
    private double valorPedido;
    
    //Referencias
    
    private clsCliente objCliente;
    private ArrayList<clsProducto> lstProductos;
    
    //METODOS
    //Constructores
    
    public clsPedido() {
        this.lstProductos = new ArrayList<>();
    }

    public clsPedido(long codigoFactura, Calendar fechaFacturacion, Calendar fechaPago, double valorPedido) {
        this.codigoFactura = codigoFactura;
        this.fechaFacturacion = fechaFacturacion;
        this.fechaPago = fechaPago;
        this.valorPedido = valorPedido;
        this.lstProductos = new ArrayList<>();
    }
 
    //Getters y setters

    public long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Calendar getFechaFacturacion() {
        return fechaFacturacion;
    }

    public void setFechaFacturacion(Calendar fechaFacturacion) {
        this.fechaFacturacion = fechaFacturacion;
    }
    
    public Calendar getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Calendar fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }
    
    public clsCliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(clsCliente objCliente) {
        this.objCliente = objCliente;
    }
    
    public ArrayList<clsProducto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<clsProducto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    //Metodo de agregacion
    
    public void agregarProducto(clsProducto objProducto){
        this.lstProductos.add(objProducto);
        objProducto.setObjPedido(this);
    }

    @Override
    public double calcularTotal() {
        double IVA = this.valorPedido * 1.19;
        
        return IVA;
    }
    
    public String obtenerFormatoArchivo(){
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechafac = formato.format(this.getFechaFacturacion().getTime());
        String fechapag = formato.format(this.getFechaPago().getTime());

        String info =
                    this.codigoFactura+","+
                    fechafac+","+
                    fechapag+","+
                    this.valorPedido+","+
                    this.getObjCliente().getNombre()+","+
                    this.getObjCliente().getCedula()+","+
                    this.getObjCliente().getTelefono()+","+
                    this.getObjCliente().getDireccion()+"\n";
        
    return info;
    }
}//fin de clase