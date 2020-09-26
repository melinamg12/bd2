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


public class interfazPuntoDos extends Container implements ActionListener {

    JTextArea coordenadas;
    JTextField vendedor;
    JComboBox ciudad;

    public interfazPuntoDos() {
        
        setSize(1000, 500);

        coordenadas = new JTextArea();
        coordenadas.setBounds(10, 100, 400, 300);

        ciudad = new JComboBox<>();
        ciudad.setBounds(450, 150, 150, 30);
        
        vendedor = new JTextField();
        vendedor.setBounds(650, 150, 120, 30);

        JButton insertarBoton = new JButton("Insertar");
        insertarBoton.setBounds(450, 270,120, 50);

        JButton  volverBoton = new JButton("Volver");
        volverBoton.setBounds(680, 430,100, 30);

        JLabel infoPrincipalLabel = new JLabel("Ingreso de datos de las ventas de un vendedor en una Ciudad ");
        infoPrincipalLabel.setBounds(150, 10,  700, 50);
        infoPrincipalLabel.setFont(new java.awt.Font("Arial", 1, 20));

        JLabel infoCiudadLabel = new JLabel("Seleccione la Ciudad");
        infoCiudadLabel.setBounds(450, 120,  200, 30);
        infoCiudadLabel.setFont(new java.awt.Font("Arial", 1, 14));

        JLabel infoVendedorLabel = new JLabel("Código Vendedor");
        infoVendedorLabel.setBounds(650, 120,  200, 30);
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
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("Insertar")){
            String valor; 
            valor = vendedor.getText();
            System.out.println(valor);
        } else {
            App.frame.setContentPane(new interfazPrincipal());
        }

    }


    
}