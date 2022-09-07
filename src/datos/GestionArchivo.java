package datos;

import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Calendar;
import modelo.*;


/**
 *
 * @author Pablo Restrepo
 */
public class GestionArchivo {
    //atributos
    FileInputStream archivoLectura;
    DataInputStream datosOrigen;
    FileOutputStream archivoEscritura;
    DataOutputStream datosDestino;
    
    String linea; 
    String [] partes;
    
    //metodos
    public GestionArchivo(){}
    
    public void escribirDatosProductos(ArrayList<clsTienda> lstTiendas){

        try {  
            this.archivoEscritura= new FileOutputStream("productos.txt");
            this.datosDestino = new DataOutputStream(archivoEscritura);
            
            clsProducto auxP;
            for(int i=0; i<lstTiendas.get(0).getLstProductos().size(); i++){
                auxP = lstTiendas.get(0).getLstProductos().get(i);
                
                linea = auxP.obtenerFormatoArchivo();
                
                datosDestino.writeUTF(linea); 
            }
        } 
        
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);       
        }
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error en la escritura de datos",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally{
            try {
                this.archivoEscritura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void leerDatosProductos(ArrayList<clsTienda> lstTiendas) throws ParseException{
        boolean bandera = true;
        
        try {
            this.archivoLectura = new FileInputStream("productos.txt");
            this.datosOrigen = new DataInputStream(archivoLectura);
            
            while(bandera){
                linea = this.datosOrigen.readUTF();
                partes = linea.split(",");
                
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                cal.setTime(sdf.parse(partes[2]));
                
                Calendar cal2 = Calendar.getInstance();
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                cal2.setTime(sdf2.parse(partes[3]));
                
                lstTiendas.get(0).crearProducto(Long.parseLong(partes[0]), partes[1], cal, cal2, Double.parseDouble(partes[4]));
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch(EOFException ex){
            JOptionPane.showMessageDialog(null,
                    "Carga de datos con exito",
                    "Gestión lectura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IOException ex) {
           JOptionPane.showMessageDialog(null,
                    "Error en la lectura de datos",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
                try {
                    this.archivoLectura.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);                
            }
        }
    }
    
    public void escribirDatosClientes(ArrayList<clsTienda> lstTiendas){
        try {  
            this.archivoEscritura= new FileOutputStream("clientes.txt");
            this.datosDestino = new DataOutputStream(archivoEscritura);
            
            clsCliente auxC;
            
            for(int i=0; i<lstTiendas.get(0).getLstClientes().size(); i++){
                auxC = lstTiendas.get(0).getLstClientes().get(i);
                
                linea = auxC.obtenerFormatoArchivo();
                if(!linea.isEmpty())
                    datosDestino.writeUTF(linea); 
            }
        }
        
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);       
        }
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error en la escritura de datos",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally{
            try {
                this.archivoEscritura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void leerDatosClientes(ArrayList<clsTienda> lstTiendas, ArrayList<clsCliente> lstClientes){
        boolean bandera = true;
        
        
        try {
            this.archivoLectura = new FileInputStream("clientes.txt");
            this.datosOrigen = new DataInputStream(archivoLectura);
            
            while(bandera){
                linea = this.datosOrigen.readUTF();
                partes = linea.split(",");
                
                clsCliente objCliente = new clsCliente(partes[0],Long.parseLong(partes[1]),partes[3],Long.parseLong(partes[2]));
                
                lstTiendas.get(0).getLstClientes().add(objCliente);
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch(EOFException ex){
            JOptionPane.showMessageDialog(null,
                    "Carga de datos con exito",
                    "Gestión lectura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IOException ex) {
           JOptionPane.showMessageDialog(null,
                    "Error en la lectura de datos",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
                try {
                    this.archivoLectura.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);                
            }
        }
    }
    
    public void escribirDatosEmpleados(ArrayList<clsTienda> lstTiendas){
        try {  
            this.archivoEscritura= new FileOutputStream("empleados.txt");
            this.datosDestino = new DataOutputStream(archivoEscritura);
            
            clsEmpleado auxE;
            
            for(int i=0; i<lstTiendas.get(0).getLstEmpleados().size(); i++){
                auxE = lstTiendas.get(0).getLstEmpleados().get(i);
                linea = auxE.obtenerFormatoArchivo();
                if(!linea.isEmpty())
                    datosDestino.writeUTF(linea); 
            }
        } 
        
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);       
        }
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error en la escritura de datos",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally{
            try {
                this.archivoEscritura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void leerDatosEmpleados(ArrayList<clsTienda> lstTiendas){
        boolean bandera = true;
        
        try {
            this.archivoLectura = new FileInputStream("empleados.txt");
            this.datosOrigen = new DataInputStream(archivoLectura);
            
            while(bandera){
                linea = this.datosOrigen.readUTF();
                partes = linea.split(",");
                
                tipoCargo enumE;

                if(partes[2].equals("Auxiliar")){
                    enumE = tipoCargo.Auxiliar;
                }
                else{
                    if(partes[2].equals("Cajero")){
                        enumE = tipoCargo.Cajero;
                    }
                    else{
                        if(partes[2].equals("Coordinador")){
                            enumE = tipoCargo.Coordinador;
                        }
                        else{
                            enumE = tipoCargo.Jefe;
                        }
                    }
                }
                lstTiendas.get(0).crearEmpleado(partes[0], Long.parseLong(partes[1]), enumE, partes[4], Integer.parseInt(partes[3]));
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch(EOFException ex){
            JOptionPane.showMessageDialog(null,
                    "Carga de datos con exito",
                    "Gestión lectura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IOException ex) {
           JOptionPane.showMessageDialog(null,
                    "Error en la lectura de datos",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
                try {
                    this.archivoLectura.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);                
            }
        }
    }
    
    public void escribirDatosPedidos(ArrayList<clsTienda> lstTiendas){
        try {  
            this.archivoEscritura= new FileOutputStream("pedidos.txt");
            this.datosDestino = new DataOutputStream(archivoEscritura);
            
            clsPedido auxP;
            
            for(int i=0; i<lstTiendas.get(0).getLstClientes().size(); i++){
                for (int j = 0; j < lstTiendas.get(0).getLstClientes().get(i).getLstPedidos().size(); j++) {
                    auxP = lstTiendas.get(0).getLstClientes().get(i).getLstPedidos().get(j);
                    
                    linea = auxP.obtenerFormatoArchivo();
                    if(!linea.isEmpty())
                        datosDestino.writeUTF(linea); 
                }
            }
        } 
        
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);       
        }
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error en la escritura de datos",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally{
            try {
                this.archivoEscritura.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión escritura",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void leerDatosPedidos(ArrayList<clsTienda> lstTiendas, ArrayList<clsPedido> lstPedidos) throws ParseException{
        boolean bandera = true;
        
        try {
            this.archivoLectura = new FileInputStream("Pedidos.txt");
            this.datosOrigen = new DataInputStream(archivoLectura);
            
            while(bandera){
                linea = this.datosOrigen.readUTF();
                partes = linea.split(",");
                
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                cal.setTime(sdf.parse(partes[1]));
                
                Calendar cal2 = Calendar.getInstance();
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                cal2.setTime(sdf2.parse(partes[2]));
                
                clsCliente objCliente = new clsCliente(partes[4],Long.parseLong(partes[5]),partes[7],Long.parseLong(partes[6]));
                
                lstTiendas.get(0).getLstClientes().add(objCliente);
                
                clsPedido objPedido = new clsPedido(Long.parseLong(partes[0]),cal,cal2,Double.parseDouble(partes[3]));
                lstPedidos.add(objPedido);
                
                objCliente.agregarPedido(objPedido);
            }
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,
                    "Archivo no encontrado",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch(EOFException ex){
            JOptionPane.showMessageDialog(null,
                    "Carga de datos con exito",
                    "Gestión lectura",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        catch (IOException ex) {
           JOptionPane.showMessageDialog(null,
                    "Error en la lectura de datos",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        catch (HeadlessException e){            
               JOptionPane.showMessageDialog(null,
                    "Error interno en el programa."+e.getMessage(),
                    "Validación.",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        finally {
                try {
                    this.archivoLectura.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,
                    "Error en el cierre del archivo",
                    "Gestión lectura",
                    JOptionPane.ERROR_MESSAGE);                
            }
        }
    }
}
