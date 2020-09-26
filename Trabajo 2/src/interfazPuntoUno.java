import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import oracle.net.aso.e;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.concurrent.FutureTask;
import java.math.*;


public class interfazPuntoUno extends Container implements ActionListener {

    JTextArea coordenadas;
    JTextField ciudad;


    public interfazPuntoUno(){
        setLayout(null);
        
        coordenadas = new JTextArea();
        coordenadas.setBounds(10, 100, 400, 300);

        ciudad = new JTextField();
        ciudad.setBounds(450, 150, 250, 100);

        JButton insertarBoton = new JButton("Insertar");
        insertarBoton.setBounds(450, 270,120, 50);

        JButton  volverBoton = new JButton("Volver");
        volverBoton.setBounds(680, 430,100, 30);

        JLabel infoPrincipalLabel = new JLabel("Ingreso de datos de las ventas de un vendedor en una Ciudad ");
        infoPrincipalLabel.setBounds(200, 10,  700, 50);
        infoPrincipalLabel.setFont(new java.awt.Font("Arial", 1, 20));

        JLabel infoCiudadLabel = new JLabel("Seleccione la Ciudad");
        infoCiudadLabel.setBounds(450, 120,  200, 30);
        infoCiudadLabel.setFont(new java.awt.Font("Arial", 1, 14));


        add(coordenadas);
        add(ciudad);
        add(insertarBoton);
        add(volverBoton);
        add(infoPrincipalLabel);
        add(infoCiudadLabel);
    
        insertarBoton.addActionListener(this);        
        volverBoton.addActionListener(this);
        SwingUtilities.updateComponentTreeUI(App.frame);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Ingresar")){
            String valor; 
            valor = ciudad.getText();
            System.out.println(valor);
        } else {
            App.frame.setContentPane(new interfazPrincipal());
        }

    }
    
}