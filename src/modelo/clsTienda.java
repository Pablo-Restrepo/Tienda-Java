package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Pablo Restrepo
 */
public class clsTienda {
        
    //ATRIBUTOS
    //Atributos de clase
    
    private String nombre;
    private String direccion;
    private Integer telefono;
    private String ubicacion;
    
    //Referencias
    
    private ArrayList<clsProducto> lstProductos;
    private ArrayList<clsEmpleado> lstEmpleados;
    private ArrayList<clsCliente> lstClientes;
    
    //METODOS
    //Constructores
    
    public clsTienda() {
        this.lstProductos = new ArrayList<>();
        this.lstEmpleados = new ArrayList<>();
        this.lstClientes = new ArrayList<>();
    }
    
    //Getters y setters
    
    public clsTienda(String nombre, String direccion, Integer telefono, String ubicacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.lstProductos = new ArrayList<>();
        this.lstEmpleados = new ArrayList<>();
        this.lstClientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<clsProducto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProductos(ArrayList<clsProducto> lstProductos) {
        this.lstProductos = lstProductos;
    }

    public ArrayList<clsEmpleado> getLstEmpleados() {
        return lstEmpleados;
    }

    public void setLstEmpleados(ArrayList<clsEmpleado> lstEmpleados) {
        this.lstEmpleados = lstEmpleados;
    }

    public ArrayList<clsCliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(ArrayList<clsCliente> lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    //Metodo de agregacion
    
    public void agregarCliente(clsCliente objCliente){
        this.lstClientes.add(objCliente);
        objCliente.setObjTienda(this);
    }
    
    //Metodo de composicion
    
    public void crearEmpleado(String nombre, long cedula, tipoCargo cargo, String experiencia, int sueldo){
        clsEmpleado objEmpleado = new clsEmpleado(nombre,cedula,cargo,experiencia,sueldo);
        this.lstEmpleados.add(objEmpleado);
        objEmpleado.setObjTienda(this);
    }
    
    public void crearProducto(long codigoBarras, String nombre, Calendar fechaVen, Calendar fechaFab, double precio){
        clsProducto objProducto = new clsProducto(codigoBarras,nombre,fechaVen,fechaFab,precio);
        this.lstProductos.add(objProducto);
        objProducto.setObjTienda(this);
    }
    
}//fin de clase