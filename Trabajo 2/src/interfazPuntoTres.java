import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;



public class interfazPuntoTres extends Container implements ActionListener {


    JComboBox ciudad;

    public interfazPuntoTres() throws SQLException{
        setSize(500, 500);


        ciudad = new JComboBox();
        listarCiudades();
        ciudad.setBounds(350, 150, 150, 30);

        final JButton graficar = new JButton("Graficar");
        graficar.setBounds(350, 270, 150, 50);

        final JButton volverBoton = new JButton("Volver");
        volverBoton.setBounds(500, 430, 100, 30);
        
        

        add(ciudad);
        add(graficar);
        add(volverBoton);

        graficar.addActionListener(this);;
        volverBoton.addActionListener(this);
        SwingUtilities.updateComponentTreeUI(App.frame);

    }


    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Graficar")) {
            
            solucionPuntoTres.recibirCiudad(ciudad.getSelectedItem().toString());            

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

    

}