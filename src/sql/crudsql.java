
package sql;

import getset.variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import sql.conexionsql;
import java.sql.ResultSet;

public class crudsql extends conexionsql{
    
    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();
    
 
    public void insertar(String nombre, String apellido, String puesto){
        
        try {

            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "INSERT INTO empleados(nombre,apellido,puesto) VALUES ('" + nombre + "','" + apellido + "','" + puesto + "')";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardo " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }


    }
    
    public void mostrar (String idempleado){
    
        try {
            Connection conexion = conectar();
            st=conexion.createStatement();
            String sql="SELECT * FROM empleados WHERE   idempleado='"+idempleado+"'; ";
            rs =st.executeQuery(sql);
            
            if(rs.next()){
            
                var.setIdempleado(rs.getString("idempleado"));
                var.setNombre(rs.getString("nombre"));
                var.setApellido(rs.getString("apellido"));
                var.setPuesto(rs.getString("puesto"));
                
                
            } else {
            
               var.setIdempleado("");
                var.setNombre("");
                var.setApellido("");
                var.setPuesto("");
                JOptionPane.showMessageDialog(null, "No se encontro registro","Sin registro",JOptionPane.INFORMATION_MESSAGE);
            
            
            }
            st.close();
            conexion.close();
            
            
        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error en el sistema de buscar","Error busqueda",JOptionPane.ERROR_MESSAGE);

        }
        
        
        
    
    
    
    }
    
    public void actualizar(String nombre, String apellido,String puesto,  String idempleado){
    
    
        try {
            
            Connection conexion = conectar();
            st=conexion.createStatement();
            String sql="UPDATE empleados SET nombre='"+nombre+"',apellido='"+apellido+"',puesto='"+puesto+"' WHERE idempleado='"+idempleado+"' ";
            st.executeUpdate(sql);
            
            st.close();
            conexion.close();
            
            JOptionPane.showMessageDialog(null, "El registro de actualizo","Exito",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            
                        JOptionPane.showMessageDialog(null, "Eror al actualizar "+e,"Error",JOptionPane.ERROR_MESSAGE);

        }
    
    
    
    }
    
        public void eliminar(String idempleado){
    
        try {
            
            Connection conexion = conectar();
            st=conexion.createStatement();
            
            String sql="DELETE FROM empleados WHERE idempleado='"+idempleado+"' ";
            st.executeUpdate(sql);
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            
            JOptionPane.showMessageDialog(null,"Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Error al eliminar registro "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    
    
}
