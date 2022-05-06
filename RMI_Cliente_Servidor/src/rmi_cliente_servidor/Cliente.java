
package rmi_cliente_servidor;

import java.rmi.Naming;
import javax.swing.JOptionPane;



public class Cliente {

    public static void main(String[] args) {
       String X="", y="";
       //String a="", b="";
       
        try {
            Suma s= (Suma) Naming.lookup("//192.168.0.22/Suma");
         //   Resta r= (Resta) Naming.lookup("//192.168.0.22/Resta");
            while (true ){
                String menu = JOptionPane.showInputDialog(null, "Suma de 2 numeros \n"
                + "1. Sumar \n"
                //+ "2. Resta \n"
                + "2. Salir \n", "Cliente Servidor RMI", JOptionPane.DEFAULT_OPTION);
                
              switch (menu){
                  case "1":
                      X= JOptionPane.showInputDialog(null, "Primer número", "Suma", JOptionPane.QUESTION_MESSAGE);
                      y= JOptionPane.showInputDialog(null, "Segundo número", "Suma", JOptionPane.QUESTION_MESSAGE);
                      
                       JOptionPane.showMessageDialog(null, "La suma es: " + s.suma(X, y));
                       
                       
                       break;
                      /* case "2":
                      X= JOptionPane.showInputDialog(null, "Primer saludo", "Suma", JOptionPane.QUESTION_MESSAGE);
                      y= JOptionPane.showInputDialog(null, "Segundo saludo", "Suma", JOptionPane.QUESTION_MESSAGE);
                      
                       JOptionPane.showMessageDialog(null, "La resta es: " + r.Resta(a, b)); 
                       
                       
                       break;*/
                  case "2":
                    JOptionPane.showMessageDialog(null, "Saliendo del servidor, gracias por su confianza", null, JOptionPane.WARNING_MESSAGE);
                      System.exit(0);
                      break;
              }    
                
            }
            
        } catch (Exception e) {
        }
        }
    }
   
