import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.math.*;

public class interfazPrincipal extends Container implements ActionListener {

    public interfazPrincipal() {
        setBackground(Color.WHITE);
        setLayout(null);

        final JButton puntoUno = new JButton("Punto 1");
        final JButton puntoDos = new JButton("Punto 2");
        final JButton puntoTres = new JButton("Punto 3");
        final JButton puntoCuatro = new JButton("Punto 4");
        final JButton prueba = new JButton("Prueba");

        puntoUno.setBounds(225, 25, 250, 50);
        puntoDos.setBounds(225, 125, 250, 50);
        puntoTres.setBounds(225, 225, 250, 50);
        puntoCuatro.setBounds(225, 325, 250, 50);
        prueba.setBounds(225, 425, 250, 50);
        add(puntoUno);
        add(puntoDos);
        add(puntoTres);
        add(puntoCuatro);
        add(prueba);
        puntoUno.addActionListener(this);
        puntoDos.addActionListener(this);
        puntoTres.addActionListener(this);
        puntoCuatro.addActionListener(this);
        prueba.addActionListener(this);
        SwingUtilities.updateComponentTreeUI(App.frame);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Punto 1")) {
            App.frame.setContentPane(new interfazPuntoUno());
        } else if (e.getActionCommand().equals("Punto 2")) {
            try {
                App.frame.setContentPane(new interfazPuntoDos());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Punto 3")) {
        	try {
                App.frame.setContentPane(new interfazPuntoTres());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // App.frame.setContentPane(new InterfazEstadisticas());
        } else if (e.getActionCommand().equals("Punto 4")) {
            try {
                App.frame.setContentPane(new interfazPuntoCuatro());
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }else {
            String args[] = new String[1000000];
            SquaredPaper.main(args);
        }

}
}