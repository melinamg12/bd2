import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.scene.paint.Color;

import java.awt.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reglaCinco extends Container implements ActionListener{
    
    
    JTextArea T1, T2, T3, atributosT1, atributosT2, atributosT3,s1, s2,s3;
    Border border;
    public reglaCinco(){

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
        textoT2.setBounds(10,110,200 , 30);   
        textoT2.setText("Nombre de la tabla 2");

        JTextArea T2 = new JTextArea();
        T2.setBounds(200, 110, 300, 30);
        T2.setBorder(border);

        JLabel textoT3 = new JLabel();
        textoT3.setBounds(10,150,200 , 30);   
        textoT3.setText("Nombre de la tabla 3");

        JTextArea T3 = new JTextArea();
        T3.setBounds(200, 150, 300, 30);
        T3.setBorder(border);

        JLabel textoAtributosT1 = new JLabel();
        textoAtributosT1.setBounds(10,230,200 , 30);   
        textoAtributosT1.setText("Ingrese los Atributos de T1");

        JTextArea atributosT1 = new JTextArea();
        atributosT1.setBounds(200, 190, 300, 80);
        atributosT1.setBorder(border);
        
        
        JLabel textoAtributosT2 = new JLabel();
        textoAtributosT2.setBounds(10,320,200 , 30);   
        textoAtributosT2.setText("Ingrese los Atributos de T2");

        JTextArea atributosT2 = new JTextArea();
        atributosT2.setBounds(200, 280, 300, 80);
        atributosT2.setBorder(border);

        JLabel textoAtributosT3 = new JLabel();
        textoAtributosT3.setBounds(10,410,200 , 30);   
        textoAtributosT3.setText("Ingrese los Atributos de T3");

        JTextArea atributosT3 = new JTextArea();
        atributosT3.setBounds(200, 370, 300, 80);
        atributosT3.setBorder(border);

        JLabel textoS1 = new JLabel();
        textoS1.setBounds(10,490,200 , 30);   
        textoS1.setText("Ingrese los datos para crear S1");

        JTextArea s1 = new JTextArea(); 
        s1.setBounds(200, 460, 300, 80);
        s1.setBorder(border);

        JLabel textoS2 = new JLabel();
        textoS2.setBounds(10,580,200 , 30);   
        textoS2.setText("Ingrese los datos para crear S2");

        JTextArea s2 = new JTextArea();
        s2.setBounds(200, 550, 300, 80);
        s2.setBorder(border);

        JLabel textoS3 = new JLabel();
        textoS3.setBounds(10,680,200 , 30);   
        textoS3.setText("Ingrese los datos para crear S3");

        JTextArea s3 = new JTextArea();
        s3.setBounds(200, 650, 300, 80);
        s3.setBorder(border);


        JButton calcular = new JButton("Calcular");

        JButton volver = new JButton("Volver");
        volver.setBounds(200, 800, 200, 50);

        add(enunciado);
        add(textoT1);
        add(T1);
        add(textoT2);
        add(T2);
        add(textoT3);
        add(T3);
        add(textoAtributosT1);
        add(atributosT1);
        add(textoAtributosT2);
        add(atributosT2);
        add(textoAtributosT3);
        add(atributosT3);
        add(textoS1);
        add(s1);
        add(textoS2);
        add(s2);
        add(textoS3);
        add(s3);
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
    public void calcularQ() {

        String attrT1[] = atributosT1.getText().split(",");
        Set<String> T1tabla = new HashSet<String>();
        for (int i = 0; i < attrT1.length; i++) {
            T1tabla.add(attrT1[i].toLowerCase().replaceAll("\s", ""));
        }

        String attrT2[] = atributosT2.getText().split(",");
        String claveForanea = attrT2[1];
        Set<String> T2tabla = new HashSet<String>();
        for (int i = 0; i < attrT2.length; i++) {
            if (!attrT2[i].toLowerCase().replaceAll("\s", "").equals(claveForanea)) {
                T2tabla.add(attrT2[i].toLowerCase().replaceAll("\s", ""));
            }
        }

        String consultasS1[] = s1.getText().split(";");
        Set<Set> S1 = new HashSet<>();
        for (int i = 0; i < consultasS1.length; i++) {
            Set<String> temporal = new HashSet<>();
            String attr = consultasS1[i].replaceAll("[A-Z]{2,}", "");
            attr = attr.replaceAll(",", "");
            String li[] = attr.split("\s{1,}");
            for (int j = 0; j < li.length; j++) {
                if (T2tabla.contains(li[j]) && li[j] != claveForanea) {
                    temporal.add(li[j]);
                }

            }
            S1.add(temporal);
        }

        String consultasS2[] = s2.getText().split(";");
        Set<String> S2 = new HashSet<>();
        for (int i = 0; i < consultasS2.length; i++) {
            String attr = consultasS2[i].replaceAll("[A-Z]{2,}", "");
            attr = attr.replaceAll(",", "");
            String li[] = attr.split("\s{1,}");
            for (int j = 0; j < li.length; j++) {
                if ((T1tabla.contains(li[j]) || T2tabla.contains(li[j])) && li[j] != claveForanea) {
                    S2.add(li[j]);
                }
            }

        }
        Set<String> T2primaS2 = new HashSet<>();
        S2.retainAll(T2tabla);
        T2primaS2 = S2;
        String qprima = "Q' = {";
        Object[] t1Arr = T1tabla.toArray();
        // Llenar Q' Con atributos de T1tabla
        for (int i = 0; i < t1Arr.length; i++) {
            qprima += t1Arr[i].toString() + ", ";
            
        }
        Set union = new HashSet<>();        
        Object arrayTemp[] = S1.toArray();        
        for (int i = 0; i < arrayTemp.length; i++) {
            Set<String> item = (Set<String>) arrayTemp[i];
            Set<String> compara = new HashSet<>(item);
            item.removeAll(T2primaS2);
            if(item.size() != 0 && !(item.equals(compara))){
                Object tempo2[] = item.toArray();
                for (int j = 0; j < tempo2.length; j++) {
                    union.add(tempo2[j]);
                    
                }
                
            }
        }
        T2primaS2.addAll(union);
        Set<String> T2prima = T2primaS2;
        Object t2pri[] = T2prima.toArray();
        qprima += T2.getText()+"_OF_"+T1.getText()+":{";
        for (int i = 0; i < t2pri.length; i++) {
            if(i== t2pri.length-1){
                qprima += t2pri[i].toString();

            }else{
                qprima += t2pri[i].toString()+",";
            }
        }
        qprima += "}";
        
        
        qprima += ","+T2.getText()+"'':{ "; 
        Set unionDoble = new HashSet<>();        
        Object arrayTempDoble[] = S1.toArray();   
        for (int i = 0; i < arrayTempDoble.length; i++) {
            Set<String> item = (Set<String>) arrayTempDoble[i];
            Set<String> compara = new HashSet<>(item);
            item.retainAll(T2primaS2);
            if(item.size() == 0){
                unionDoble.add(compara);
            }
            System.out.println(arrayTempDoble[i]);
             
        }
        Object t2doblepri[] = unionDoble.toArray();
        for (int i = 0; i < t2doblepri.length; i++) {
            if(i== t2doblepri.length-1){
                qprima += t2doblepri[i].toString();

            }else{
                qprima += t2doblepri[i].toString()+",";
            }
        }
        
        qprima += "}}";
        System.out.println(qprima);
        
    }
    
}
    
