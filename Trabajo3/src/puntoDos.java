import javax.swing.*;

import javafx.scene.paint.Color;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class puntoDos extends Container implements ActionListener{

    JButton generar, visualizar, volver;

    public puntoDos(){

        generar = new JButton("generar");
        generar.setBounds(225, 150, 150, 60);

        visualizar = new JButton("visualizar");
        visualizar.setBounds(225, 300, 150 , 60);

        volver = new JButton("Volver");
        volver.setBounds(200, 500, 200, 50);

        add(generar);
        add(visualizar);
        add(volver);

        generar.addActionListener(this);
        visualizar.addActionListener(this);
        volver.addActionListener(this);
        SwingUtilities.updateComponentTreeUI(App.frame);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("generar")){

        }
        else if (e.getActionCommand().equals("visualizar")){

        }
        else {
            App.frame.setContentPane(new interfazPrincipal());
        }

    }
    
}