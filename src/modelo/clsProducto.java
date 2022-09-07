package modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author Pablo Restrepo
 */
public class clsProducto{
    
    //ATRIBUTOS
    //Atributos de clase
    
    private long codigoBarras;
    private String nombre;
    private Calendar fechaVen;
    private Calendar fechaFab;
    private double precio;
    
    //Referencias
    
    private clsPedido objPedido;
    private clsTienda objTienda;
    
    //METODOS
    //Constructores
    
    public clsProducto(){}
    
    public clsProducto(long codigoBarras, String nombre, Calendar fechaVen, Calendar fechaFab, double precio) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.fechaVen = fechaVen;
        this.fechaFab = fechaFab;
        this.precio = precio;
    }
    
    //Getters y setters

    public long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(Calendar fechaVen) {
        this.fechaVen = fechaVen;
    }

    public Calendar getFechaFab() {
        return fechaFab;
    }

    public void setFechaFab(Calendar fechaFab) {
        this.fechaFab = fechaFab;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public clsPedido getObjPedido() {
        return objPedido;
    }

    public void setObjPedido(clsPedido objPedido) {
        this.objPedido = objPedido;
    }
    
    public clsTienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(clsTienda objTienda) {
        this.objTienda = objTienda;
    }
    
    public String obtenerFormatoArchivo(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechafab = formato.format(this.getFechaFab().getTime());
        String fechaven = formato.format(this.getFechaVen().getTime());
        String info =
                    this.codigoBarras+","+
                    this.nombre+","+
                    fechafab+","+
                    fechaven+","+
                    this.precio+"\n";               
        
    return info;
    }
}//fin de clase