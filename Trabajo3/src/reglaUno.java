
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.scene.paint.Color;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class reglaUno extends Container implements ActionListener {

    Border border;
    public reglaUno(){

        JLabel enunciado = new JLabel();
        enunciado.setBounds(10,10, 600, 40);
        enunciado.setText("Ingrese los datos solicitados para poder crear Q\'");
        enunciado.setFont(new java.awt.Font("Arial", 1,16));

        JLabel textoT1 = new JLabel(); 
        textoT1.setBounds(10, 70,200 , 30);   
        textoT1.setText("Nombre de la tabla 1");    

        border = BorderFactory.createLineBorder(java.awt.Color.BLACK,1);

        JTextArea T1 = new JTextArea();
        T1.setBounds(200, 70, 300, 30);
        T1.setBorder(border);
        
        JLabel textoT2 = new JLabel();
        textoT2.setBounds(10,115,200 , 30);   
        textoT2.setText("Nombre de la tabla 2");

        JTextArea T2 = new JTextArea();
        T2.setBounds(200, 110, 300, 30);
        T2.setBorder(border);

        JLabel textoAtributosT1 = new JLabel();
        textoAtributosT1.setBounds(10,190,200 , 30);   
        textoAtributosT1.setText("Ingrese los Atributos de T1");

        JTextArea atributosT1 = new JTextArea();
        atributosT1.setBounds(200, 150, 300, 80);
        atributosT1.setBorder(border);
        
        
        JLabel textoAtributosT2 = new JLabel();
        textoAtributosT2.setBounds(10,280,200 , 30);   
        textoAtributosT2.setText("Ingrese los Atributos de T2");

        JTextArea atributosT2 = new JTextArea();
        atributosT2.setBounds(200, 240, 300, 80);
        atributosT2.setBorder(border);

        JLabel textoS1 = new JLabel();
        textoS1.setBounds(10,370,200 , 30);   
        textoS1.setText("Ingrese los datos para crear S1");

        JTextArea s1 = new JTextArea(); 
        s1.setBounds(200, 330, 300, 80);
        s1.setBorder(border);

        JLabel textoS2 = new JLabel();
        textoS2.setBounds(10,460,200 , 30);   
        textoS2.setText("Ingrese los datos para crear S2");

        JTextArea s2 = new JTextArea();
        s2.setBounds(200, 420, 300, 80);
        s2.setBorder(border);


        JButton calcular = new JButton("Calcular");

        JButton volver = new JButton("Volver");
        volver.setBounds(200, 700, 200, 50);

        add(enunciado);
        add(textoT1);
        add(T1);
        add(textoT2);
        add(T2);
        add(textoAtributosT1);
        add(atributosT1);
        add(textoAtributosT2);
        add(atributosT2);
        add(textoS1);
        add(s1);
        add(textoS2);
        add(s2);
        add(calcular);
        add(volver);

        calcular.addActionListener(this);
        volver.addActionListener(this);

        SwingUtilities.updateComponentTreeUI(App.frame);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals("Calcular")){

        }else{
            App.frame.setContentPane(new puntoUno());
        }

    }
    
}