package mundo;
import datos.GestionArchivo;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import modelo.*;
import vista.vtnPrincipal;

/**
 *
 * @author Pablo Restrepo
 */
public class clsPrincipal {

    private static ArrayList<clsTienda> lstTiendas;
    private static ArrayList<clsCliente> lstClientes;
    private static ArrayList<clsPedido> lstPedidos;
   
    public static void main(String[] args) throws IOException, ParseException{
        clsPrincipal.lstTiendas = new ArrayList<>();
        clsPrincipal.lstClientes = new ArrayList<>();
        clsPrincipal.lstPedidos = new ArrayList<>();
        
        clsTienda objTienda = new clsTienda("Justo y Bueno","CRA6 No.5-9",8234378,"La Paz");
        
        lstTiendas.add(objTienda);
        
        GestionArchivo GAP = new GestionArchivo();
        GAP.leerDatosProductos(lstTiendas);
        
        GestionArchivo GAC = new GestionArchivo();
        GAC.leerDatosClientes(lstTiendas,lstClientes);
        
        GestionArchivo GAE = new GestionArchivo();
        GAE.leerDatosEmpleados(lstTiendas);
        
        GestionArchivo GAPE = new GestionArchivo();
        GAPE.leerDatosPedidos(lstTiendas,lstPedidos);
        
        vtnPrincipal vtn = new vtnPrincipal(clsPrincipal.lstTiendas,clsPrincipal.lstPedidos,clsPrincipal.lstClientes);
        vtn.setVisible(true);
    }
}