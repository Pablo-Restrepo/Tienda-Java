package modelo;

/**
 *
 * @author Pablo Restrepo
 */
public class clsEmpleado extends clsPersona {
    
    //ATRIBUTOS
    //Atributos de clase
    
    private tipoCargo cargo;
    private int sueldo;
    private String experiencia;
    
    //Referencias
    
    private clsTienda objTienda;
    
    //METODOS
    //Constructores

    public clsEmpleado(String nombre, long cedula, tipoCargo cargo, String experiencia, int sueldo) {
        super(nombre, cedula);
        this.cargo = cargo;
        this.experiencia = experiencia;
        this.sueldo = sueldo;
    }

    //Getters y setters

    public tipoCargo getCargo() {
        return cargo;
    }

    public void setCargo(tipoCargo cargo) {
        this.cargo = cargo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public clsTienda getObjTienda() {
        return objTienda;
    }

    public void setObjTienda(clsTienda objTienda) {
        this.objTienda = objTienda;
    }
    
    public String obtenerFormatoArchivo(){
        String info =
                    super.getNombre()+","+
                    super.getCedula()+","+
                    this.cargo+","+
                    this.sueldo+","+
                    this.experiencia+"\n";
                    
        
    return info;
    }

}//fin de clase