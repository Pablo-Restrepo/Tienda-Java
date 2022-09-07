package modelo;

/**
 *
 * @author Pablo Restrepo
 */
public abstract class clsPersona {
    
    //ATRIBUTOS
    //Atributos de clase
    
    private String nombre;
    private long cedula;
    
    //Referencias
    
    //METODOS
    //Constructores

    public clsPersona(){}
    
    public clsPersona(String nombre, long cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    //Getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
}//fin de clase