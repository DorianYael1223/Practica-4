import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazUsuario extends JFrame {

    private JTextField textId, textNombre, textApellido, textCorreo, textContrasena;

    private UsuarioDAOMySQL usuarioDAO;

    public InterfazUsuario() {
        usuarioDAO = new UsuarioDAOMySQL();

        // Configuración de la interfaz
        setTitle("Interfaz CRUD Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear panel
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        // Crear etiquetas
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 20, 80, 25);
        panel.add(lblId);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 50, 80, 25);
        panel.add(lblNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(10, 80, 80, 25);
        panel.add(lblApellido);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(10, 110, 80, 25);
        panel.add(lblCorreo);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(10, 140, 80, 25);
        panel.add(lblContrasena);

        // Crear cajas de texto
        textId = new JTextField(20);
        textId.setBounds(100, 20, 120, 25);
        panel.add(textId);

        textNombre = new JTextField(20);
        textNombre.setBounds(100, 50, 120, 25);
        panel.add(textNombre);

        textApellido = new JTextField(20);
        textApellido.setBounds(100, 80, 120, 25);
        panel.add(textApellido);

        textCorreo = new JTextField(20);
        textCorreo.setBounds(100, 110, 120, 25);
        panel.add(textCorreo);

        textContrasena = new JTextField(20);
        textContrasena.setBounds(100, 140, 120, 25);
        panel.add(textContrasena);

        // Crear botones
        JButton btnInsertar = new JButton("Insertar");
        btnInsertar.setBounds(10, 180, 100, 25);
        panel.add(btnInsertar);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBounds(120, 180, 120, 25);
        panel.add(btnSeleccionar);

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(250, 180, 120, 25);
        panel.add(btnActualizar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(10, 220, 100, 25);
        panel.add(btnEliminar);

        // Acciones de los botones
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarUsuario();
            }
        });

        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarUsuario();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
    }

    private void insertarUsuario() {
        // Obtener los valores de las cajas de texto y realizar la inserción
        usuarioDAO.id = textId.getText();
        usuarioDAO.nom = textNombre.getText();
        usuarioDAO.ap = textApellido.getText();
        usuarioDAO.correo = textCorreo.getText();
        usuarioDAO.con = textContrasena.getText();

        usuarioDAO.insertar();

        // Limpiar los campos después de la inserción
        limpiarCampos();
    }

    private void seleccionarUsuario() {
        // Obtener el ID de la caja de texto y realizar la selección
        usuarioDAO.id = textId.getText();
        usuarioDAO.selecreg();

        // Mostrar los datos seleccionados en las cajas de texto
        textNombre.setText(usuarioDAO.nom);
        textApellido.setText(usuarioDAO.ap);
        textCorreo.setText(usuarioDAO.correo);
        textContrasena.setText(usuarioDAO.con);
    }

    private void actualizarUsuario() {
        // Obtener los valores de las cajas de texto y realizar la actualización
        usuarioDAO.id = textId.getText();
        usuarioDAO.nom = textNombre.getText();
        usuarioDAO.ap = textApellido.getText();
        usuarioDAO.correo = textCorreo.getText();
        usuarioDAO.con = textContrasena.getText();

        usuarioDAO.actreg();

        // Limpiar los campos después de la actualización
        limpiarCampos();
    }

    private void eliminarUsuario() {
        // Obtener el ID de la caja de texto y realizar la eliminación
        usuarioDAO.id = textId.getText();
        usuarioDAO.elimreg();

        // Limpiar los campos después de la eliminación
        limpiarCampos();
    }

    private void limpiarCampos() {
        // Limpiar todas las cajas de texto
        textId.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textCorreo.setText("");
        textContrasena.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazUsuario().setVisible(true);
            }
        });
    }
}
