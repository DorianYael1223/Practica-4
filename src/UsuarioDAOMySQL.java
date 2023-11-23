import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

public class UsuarioDAOMySQL {
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/usuarios";
    private static final String usr = "root";
    private static final String pass = "";

    public String id;
    public String nom;
    public String ap;
    public String correo;
    public String con;

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading the driver");
            e.printStackTrace();
        }
    }

    // Establish a database connection
    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Error in connection");
            e.printStackTrace();
        }
        return con;
    }

    // Insert a new user record into the database
    public void insertar() {
        try {
            Connection cn = conectar();
            String insertar = "insert into usuarios value (?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(insertar);
            pstm.setString(1, id);
            pstm.setString(2, nom);
            pstm.setString(3, ap);
            pstm.setString(4, correo);
            pstm.setString(5, con);

            pstm.executeUpdate();

            System.out.println("Record inserted");
            JOptionPane.showMessageDialog(null, "Record Added");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error inserting record");
            e.printStackTrace();
        }
    }

    // Select a user record based on ID and update local fields
    public void selecreg() {
        try {
            Connection cn = conectar();
            // Add code to select a record based on ID
            // and update the values of nom, ap, correo, con

            // Example:
            String seleccionar = "select nombre, apellido, CorreoElectronico, contraseña from usuarios where id=?";
            PreparedStatement pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, id);

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nom = rs.getString("nombre");
                ap = rs.getString("apellido");
                correo = rs.getString("CorreoElectronico");
                con = rs.getString("contraseña");
            }

            rs.close();
            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error selecting record");
            e.printStackTrace();
        }
    }

    // Update an existing user record in the database
    public void actreg() {
        try {
            Connection cn = conectar();
            // Add code to update the record based on ID
            // with the new values of nom, ap, correo, con

            // Example:
            String actualizar = "update usuarios set nombre=?, apellido=?, CorreoElectronico=?, contraseña=? where id=?";
            PreparedStatement pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, nom);
            pstm.setString(2, ap);
            pstm.setString(3, correo);
            pstm.setString(4, con);
            pstm.setString(5, id);

            pstm.executeUpdate();

            System.out.println("Record updated");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error updating record");
            e.printStackTrace();
        }
    }

    // Delete a user record from the database based on ID
    public void elimreg() {
        try {
            Connection cn = conectar();
            // Add code to delete the record based on ID

            // Example:
            String eliminar = "delete from usuarios where id=?";
            PreparedStatement pstm = cn.prepareStatement(eliminar);
            pstm.setString(1, id);

            pstm.executeUpdate();

            System.out.println("Record deleted");

            pstm.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error deleting record");
            e.printStackTrace();
        }
    }

    // Methods for UserDAO interface (placeholders, not implemented)
    public void crearUsuario(Usuario usuario1) {
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return null;
    }

    public void actualizarUsuario(Usuario usuario1) {
    }

    public void eliminarUsuario(int i) {
    }
}
