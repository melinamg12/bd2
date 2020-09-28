import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.math.*;
import java.util.*;

public class interfazPuntoDos extends Container implements ActionListener {

    JTextArea coordenadas;
    JTextField vendedor;
    JComboBox ciudad;

    public interfazPuntoDos() throws SQLException {

        setSize(1000, 500);

        coordenadas = new JTextArea();
        coordenadas.setBounds(10, 100, 400, 300);

        ciudad = new JComboBox();
        listarCiudades();
        ciudad.setBounds(450, 150, 150, 30);

        vendedor = new JTextField();
        vendedor.setBounds(650, 150, 120, 30);

        final JButton insertarBoton = new JButton("Insertar");
        insertarBoton.setBounds(450, 270, 120, 50);

        final JButton volverBoton = new JButton("Volver");
        volverBoton.setBounds(680, 430, 100, 30);

        final JLabel infoPrincipalLabel = new JLabel("Ingreso de datos de las ventas de un vendedor en una Ciudad ");
        infoPrincipalLabel.setBounds(150, 10, 700, 50);
        infoPrincipalLabel.setFont(new java.awt.Font("Arial", 1, 20));

        final JLabel infoCiudadLabel = new JLabel("Seleccione la Ciudad");
        infoCiudadLabel.setBounds(450, 120, 200, 30);
        infoCiudadLabel.setFont(new java.awt.Font("Arial", 1, 14));

        final JLabel infoVendedorLabel = new JLabel("Código Vendedor");
        infoVendedorLabel.setBounds(650, 120, 200, 30);
        infoVendedorLabel.setFont(new java.awt.Font("Arial", 1, 14));

        add(coordenadas);
        add(ciudad);
        add(vendedor);
        add(insertarBoton);
        add(volverBoton);
        add(infoPrincipalLabel);
        add(infoCiudadLabel);
        add(infoVendedorLabel);

        insertarBoton.addActionListener(this);
        volverBoton.addActionListener(this);
        SwingUtilities.updateComponentTreeUI(App.frame);

    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Insertar")) {
            
            try {
                insertarDatos(coordenadas.getText(), ciudad.getSelectedItem().toString(), vendedor.getText());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            coordenadas.setText("");
            vendedor.setText("");
            ciudad.setSelectedItem(0);
            

        } else {
            App.frame.setContentPane(new interfazPrincipal());
        }

    }

    public void listarCiudades() throws SQLException {

        Connection conn;
        Statement sentencia = null;
        ResultSet resultado;

        try { // Se carga el driver JDBC-ODBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (Exception e1) {
            System.out.println("No se pudo cargar el driver JDBC");

        }

        try { // Se establece la conexión con la base de datos Oracle Express
            conn = DriverManager.getConnection("jdbc:oracle:thin:@LAPTOP-ANL3RGG0:1521:xe", "epalaciol", "admin");
            sentencia = conn.createStatement();

        } catch (SQLException e1) {
            System.out.println("No hay conexión con la base de datos.");

        }

        try {
            resultado = sentencia.executeQuery("SELECT Nombre_ciudad FROM CITY ORDER BY Nombre_Ciudad ASC");
            while (resultado.next()) {
                ciudad.addItem(resultado.getString(1).replace(" ", ""));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("No se pudo realizar la consulta");
        }

    }

    public void insertarDatos(String coordenadasXY, String nombreCiudad, String codigoVendedor) throws SQLException {

        System.out.println(coordenadasXY + "  " + nombreCiudad + "  " + codigoVendedor);
        HashMap<String, Integer> validacion = new HashMap<>();
        validacion.put("4,5", 10);
        String clave = "4,5";

        if (validacion.containsKey(clave)) {
            validacion.put(clave, validacion.get(clave) + 10);
        }
    }
}