package Server;

import org.apache.xmlrpc.WebServer;

/**
 *
 * @author Miam
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebServer ws = new WebServer(1999);
        ws.addHandler("ServerRPC", new Crud());
        ws.start();
        System.out.println("Inciado");
    }
    
}
