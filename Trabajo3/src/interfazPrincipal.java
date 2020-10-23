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
        

        puntoUno.setBounds(175, 25, 250, 50);
        puntoDos.setBounds(175, 250, 250, 50);

        add(puntoUno);
        add(puntoDos);
        
        puntoUno.addActionListener(this);
        puntoDos.addActionListener(this);
        
        SwingUtilities.updateComponentTreeUI(App.frame);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand().equals("Punto 1")) {
            App.frame.setContentPane(new puntoUno());
        } else {
            App.frame.setContentPane(new puntoDos());

        }

    }
}