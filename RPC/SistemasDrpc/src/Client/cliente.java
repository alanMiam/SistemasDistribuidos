package Client;

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

/**
 *
 * @author Miam
 */
public class cliente {
    Vector <String> vector = null;
    XmlRpcClient cliente = null;
    String serverUrl;

    public cliente() throws MalformedURLException{
        serverUrl="http://192.168.0.18:1999/RPC2";                                 //Cambiar para usar ip
        cliente = new XmlRpcClient(serverUrl);
        vector = new Vector<String>();
    }

    String showData(){                                                            //Pasar a interfaz grafica
        String ar = "";
        String data="";
        String dato ="";
        try{
            ar = (String) cliente.execute("ServerRPC.getData",vector);

        }catch(XmlRpcException | IOException ex){
            Logger.getLogger(cliente.getClass()).log(Level.SEVERE, null, ex); 
        }
        StringTokenizer st = new StringTokenizer (ar, "-");
        while(st.hasMoreTokens()){
            dato = st.nextToken();
            data=data+dato+"\n";
        }
        return data;
    }

    void insertData(String nombre, String apellido, String estado){                                                          //Pasar a interfaz grafica
        String ar="";
        try{
            vector.add(nombre);//Nombre
            vector.add(apellido);//Apellido
            vector.add(estado);//estado
            ar = (String)cliente.execute("ServerRPC.insertData", vector);
        vector=new Vector<>();
        }catch(XmlRpcException | IOException ex){
            Logger.getLogger(cliente.getClass()).log(Level.SEVERE, null, ex);
        }
        System.out.println(ar);
    }

}