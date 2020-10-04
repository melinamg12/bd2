import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

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

            // QUITAR CCOMENTARIOS AL FINAL
            // if (coordenadas.getText().isEmpty() ||
            // ciudad.getSelectedItem().toString().isEmpty()
            // || vendedor.getText().isEmpty()) {
            //
            // JOptionPane.showMessageDialog(null, "Hay campos que aun no se han
            // diligenciado ", "Missing Data",
            // JOptionPane.INFORMATION_MESSAGE);
            //
            // } else {
            //
            // }
            try {
                insertarDatos(coordenadas.getText(), ciudad.getSelectedItem().toString(),
                        Integer.parseInt(vendedor.getText()));
            } catch (SQLException e1) {

            }

        } else {
            App.frame.setContentPane(new interfazPrincipal());
        }

    }

    public void listarCiudades() throws SQLException {
        
        Connection conn = Conexion.dbConexion();
        Statement sentencia = null;
        ResultSet resultado;

        sentencia = conn.createStatement();

       
        // Consulta para extraer la ciudades almacenadas en la tabla City
        try {
            resultado = sentencia.executeQuery("SELECT Nombre_ciudad FROM CITY ORDER BY Nombre_Ciudad ASC");
            while (resultado.next()) {
                ciudad.addItem(resultado.getString(1).replace("\n", ""));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("No se pudo realizar la consulta");
        }
        conn.commit();
        conn.close();

    }

    public void insertarDatos(String coordenadasXY, String nombreCiudad, Integer codigoVendedor) throws SQLException {

        Connection conn = Conexion.dbConexion();
        Statement sentencia = null;
        ResultSet resultado;

       
        sentencia = conn.createStatement();        

        // Consulta para extraer la ciudades almacenadas en la tabla City
        try {
            resultado = sentencia.executeQuery("SELECT codigoVendedor, ciudad FROM VVCITY");
            while (resultado.next()) {
                // System.out.println(resultado.getString(1)+" "+resultado.getString(2));
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("No se pudo realizar la consulta");
        }

        String formatoCoordenadas = coordenadasXY.replaceAll("\s", "");
        formatoCoordenadas = formatoCoordenadas.replace("\n", ",");
        String puntosVentas[] = formatoCoordenadas.split(",");

        HashMap<String, Integer> validacion = new HashMap<>();

        if (puntosVentas.length % 3 == 0) {

            for (int i = 0; i < puntosVentas.length; i += 3) {

                String clave = puntosVentas[i] + "," + puntosVentas[i + 1];
                Integer valor = Integer.parseInt(puntosVentas[i + 2]);

                if (validacion.containsKey(clave)) {
                    validacion.put(clave, validacion.get(clave) + valor);
                } else {
                    validacion.put(clave, valor);

                }

            }

            ArrayList<Integer> coordenadasInsertar = new ArrayList<>();

            for (String key : validacion.keySet()) {
                String clave[] = key.split(",");
                Integer valor = validacion.get(key);
                coordenadasInsertar.add(Integer.parseInt(clave[0]));
                coordenadasInsertar.add(Integer.parseInt(clave[1]));
                coordenadasInsertar.add(valor);
            }
            try {
                String anidada = "nest_ventas(ventas_tip(";
                int contador = 0;
                for (int i = 0; i < coordenadasInsertar.size(); i++) {
                    if (contador == 2) {
                        anidada += coordenadasInsertar.get(i) + ")";
                        if (i != coordenadasInsertar.size() - 1) {
                            anidada += ", ventas_tip(";
                        }
                        contador = 0;
                    } else {
                        anidada += coordenadasInsertar.get(i) + ",";
                        contador += 1;
                    }

                }
                anidada += "))";
                sentencia.executeQuery(
                        "INSERT INTO VVCITY VALUES(" + codigoVendedor + ",'" + nombreCiudad + "'," + anidada);

                JOptionPane.showMessageDialog(null,
                        "Los datos suministrados han sido añadidos correctamente",
                        "Datos Insertados", JOptionPane.INFORMATION_MESSAGE);
            }

            catch (SQLException e1) {
                if (e1.getErrorCode() == 1) {
                    System.out.println("Funciona");
                }
            }

        } else {
            // JOptionPane.showMessageDialog(null, "Las los datos suministrados de la
            // ubicación de las ventas al parecer estan incompletos ", "Missing Data",
            // JOptionPane.INFORMATION_MESSAGE);
            // System.out.println("Las coordenadas estan incompletas");
        }

        // Setear los valores de la GUI en blanco
        coordenadas.setText("");
        vendedor.setText("");
        ciudad.setSelectedItem(0);
    }
}