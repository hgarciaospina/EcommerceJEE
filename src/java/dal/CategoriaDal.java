package dal;

import bean.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HENRY
 */
public class CategoriaDal {
    public static ArrayList<Categoria> listarCategoria(){
        try {
            String sql = "{sp_listarCategoriaSuperior()}";
            Connection objConnection = DBConnect.myConnection();
            CallableStatement sentence;
            ResultSet result;
            sentence = (CallableStatement) objConnection.prepareCall(sql);
            result = sentence.executeQuery();
            ArrayList<Categoria> listadoCategorias; 
            listadoCategorias = new ArrayList<>();
            while (result.next()) {                
                Categoria cat = new Categoria();
                cat.setCodigo(result.getInt("codigo"));
                cat.setNombre(result.getString("nombre"));
                listadoCategorias.add(cat);
            }
            return listadoCategorias;
        } catch (SQLException ex) {
            return null;
        }
    } 
}
