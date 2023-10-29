package conf;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class conexion {
    String bd="proyecto_integrador";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="root1234";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    

    public conexion() {
    }
    
    public Connection conectar(){ 
        try {
            Class.forName(driver);
            cx=DriverManager.getConnection(url+bd,user,password);
            //JOptionPane.showMessageDialog(null,"SE CONECTO A LA BASE DE DATOS "+bd);
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("NO SE CONECTO A LA BASE DE DATOS "+bd);
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        conexion conexion=new conexion();
        conexion.conectar();
    
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}