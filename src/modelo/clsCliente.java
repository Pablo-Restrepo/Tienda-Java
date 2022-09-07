package modelo;
import java.util.ArrayList;
/**
 *
 * @author Pablo Restrepo
 */
public class clsCliente extends clsPersona {
    
    //ATRIBUTOS
    //Atributos de clase
    
    private String direccion;
    private long telefono;
    
    //Referencias
    
    private clsTienda objTienda;
    private ArrayList<clsPedido> lstPedidos;
    
    //METODOS
    //Constructores
    
    public clsCliente() {
        this.lstPedidos = new ArrayList<>();
    }
    
    public clsCliente(String nombre,long cedula,String direccion, long telefono) {
        super(nombre,cedula);
        this.direccion = direccion;
        this.telefono = telefono;
        this.lstPedidos = new ArrayList<>();
    }
    
    //Getters y setters

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public clsTienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(clsTienda objTienda) {
        this.objTienda = objTienda;
    }

    public ArrayList<clsPedido> getLstPedidos() {
        return lstPedidos;
    }

    public void setLstPedidos(ArrayList<clsPedido> lstPedidos) {
        this.lstPedidos = lstPedidos;
    }
    
    public void agregarPedido(clsPedido objPedido){
        this.lstPedidos.add(objPedido);
        objPedido.setObjCliente(this);
    }
    
    public String obtenerFormatoArchivo(){
        String info =
                    super.getNombre()+","+
                    super.getCedula()+","+
                    this.telefono+","+
                    this.direccion+"\n";
        
    return info;
    }
    
}//fin de clase