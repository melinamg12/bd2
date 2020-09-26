import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

import oracle.net.aso.e;

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
        final JButton prueba = new JButton("Prueba");

        puntoUno.setBounds(225, 50, 250, 50);
        puntoDos.setBounds(225, 150, 250, 50);
        puntoTres.setBounds(225, 250, 250, 50);
        prueba.setBounds(225, 350, 250, 50);
        add(puntoUno);
        add(puntoDos);
        add(puntoTres);
        add(prueba);
        puntoUno.addActionListener(this);
        puntoDos.addActionListener(this);
        puntoTres.addActionListener(this);
        prueba.addActionListener(this);
        SwingUtilities.updateComponentTreeUI(App.frame);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Punto 1")) {
            App.frame.setContentPane(new interfazPuntoUno());
        } else if (e.getActionCommand().equals("Punto 2")) {
            App.frame.setContentPane(new interfazPuntoDos());
        } else if (e.getActionCommand().equals("Punto 3")) {
            System.out.println("Good Job Mt");
            // App.frame.setContentPane(new InterfazEstadisticas());
        } else {
            String args[] = new String[1000000];
            SquaredPaper.main(args);
        }

}
}