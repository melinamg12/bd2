import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class puntoUno extends Container implements ActionListener{

    JLabel enunciado;
    JButton regla1, regla4, regla5, volver ;

    public puntoUno(){
    
        enunciado = new JLabel();
        enunciado.setBounds(10,10, 600, 40);
        enunciado.setText("A Continuación escoga cual de las reglas desea probara para conocer Q\'");
        enunciado.setFont(new java.awt.Font("Arial", 1,16));
        


        regla1 = new JButton("Regla 1");
        regla1.setBounds(225,70, 150, 50);

        regla4 = new JButton("Regla 4");
        regla4.setBounds(225,150, 150, 50);

        regla5 = new JButton("Regla 5");
        regla5.setBounds(225,230, 150, 50);

        volver = new JButton("Volver");
        volver.setBounds(200, 500, 200, 50);

        add(enunciado);
        add(regla1);
        add(regla4);
        add(regla5);
        add(volver);

        regla1.addActionListener(this);
        regla4.addActionListener(this);
        regla5.addActionListener(this);
        volver.addActionListener(this);

        SwingUtilities.updateComponentTreeUI(App.frame);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("Regla 1")){
            App.frame.setContentPane(new reglaUno());
        }
        else if(e.getActionCommand().equals("Regla 4")){
            App.frame.setContentPane(new reglaCuatro());

        }
        else if(e.getActionCommand().equals("Regla 5")){
            App.frame.setContentPane(new reglaCinco());
        }
        else{
            App.frame.setContentPane(new interfazPrincipal());
        }

    }
    
}