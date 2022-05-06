package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miam
 */
public class Crud {
    
    public Crud(){
        Conexion();
    }
    private Connection connection;
    private void Conexion(){
        String db = "jdbc:mysql://localhost:3306/rpc";                               //Reemplazar para usar ip
        String user="root";
        String pass = "";

        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(db, user,pass);
            if(connection!=null){
                System.out.println("Conectado a la base de datos");
            }

        }catch(SQLException ex){
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//seleccionar de base de datos
    public String getData(){
        String data ="";
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM biodata");     //Hacer selector por nombre en interfaz grafica
            while(rs.next()){
            data+=rs.getInt(1)+"."+rs.getString(2)+"."+rs.getString(3)+"."+rs.getString(4)+"\n";
            }
        }catch(SQLException ex){
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    return data;
    }
//insertar a base de datos
    public String insertData(String name, String lastname, String state){
        String data="";
        String sql = "INSERT into biodata values(null,?,?,?)";

        try{
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, lastname);
        ps.setString(3, state);
        int id = ps.executeUpdate();
        
        if(id>0){
            data="Insertado correctamente";                                     //Pasar a MESSAGEDIALOG
        }else{
            data="No se insertó la información";                                //Pasar a MESSAGEDIALOG
        }

        }catch(SQLException ex){
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    return data;
    }
}
