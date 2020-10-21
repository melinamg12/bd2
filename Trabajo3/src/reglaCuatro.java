import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javafx.scene.paint.Color;

import java.awt.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reglaCuatro extends Container implements ActionListener{
    
    JTextArea T1, T2, T3, atributosT1, atributosT2, atributosT3,s1, s2,s3;
    Border border;
    public reglaCuatro(){

        JLabel enunciado = new JLabel();
        enunciado.setBounds(10,10, 600, 40);
        enunciado.setText("Ingrese los datos solicitados para poder crear Q\'");
        enunciado.setFont(new java.awt.Font("Arial", 1,16));

        JLabel textoT1 = new JLabel(); 
        textoT1.setBounds(10, 70,200 , 30);   
        textoT1.setText("Nombre de la tabla 1");    

        border = BorderFactory.createLineBorder(java.awt.Color.BLACK,1);

        T1 = new JTextArea();
        T1.setBounds(200, 70, 300, 30);
        T1.setBorder(border);
        
        JLabel textoT2 = new JLabel();
        textoT2.setBounds(10,110,200 , 30);   
        textoT2.setText("Nombre de la tabla 2");

        T2 = new JTextArea();
        T2.setBounds(200, 110, 300, 30);
        T2.setBorder(border);

        JLabel textoT3 = new JLabel();
        textoT3.setBounds(10,150,200 , 30);   
        textoT3.setText("Nombre de la tabla 3");

        T3 = new JTextArea();
        T3.setBounds(200, 150, 300, 30);
        T3.setBorder(border);

        JLabel textoAtributosT1 = new JLabel();
        textoAtributosT1.setBounds(10,230,200 , 30);   
        textoAtributosT1.setText("Ingrese los Atributos de T1");

        atributosT1 = new JTextArea();
        atributosT1.setBounds(200, 190, 300, 80);
        atributosT1.setBorder(border);
        
        
        JLabel textoAtributosT2 = new JLabel();
        textoAtributosT2.setBounds(10,320,200 , 30);   
        textoAtributosT2.setText("Ingrese los Atributos de T2");

         atributosT2 = new JTextArea();
        atributosT2.setBounds(200, 280, 300, 80);
        atributosT2.setBorder(border);

        JLabel textoAtributosT3 = new JLabel();
        textoAtributosT3.setBounds(10,410,200 , 30);   
        textoAtributosT3.setText("Ingrese los Atributos de T3");

        atributosT3 = new JTextArea();
        atributosT3.setBounds(200, 370, 300, 80);
        atributosT3.setBorder(border);

        JLabel textoS1 = new JLabel();
        textoS1.setBounds(10,490,200 , 30);   
        textoS1.setText("Ingrese los datos para crear S1-T2");

        s1 = new JTextArea(); 
        s1.setBounds(200, 460, 300, 80);
        s1.setBorder(border);

        JLabel textoS2 = new JLabel();
        textoS2.setBounds(10,580,200 , 30);   
        textoS2.setText("Ingrese los datos para crear S1-T3");

        s2 = new JTextArea();
        s2.setBounds(200, 550, 300, 80);
        s2.setBorder(border);

        JLabel textoS3 = new JLabel();
        textoS3.setBounds(10,680,200 , 30);   
        textoS3.setText("Ingrese los datos para crear S3");

        s3 = new JTextArea();
        s3.setBounds(200, 650, 300, 80);
        s3.setBorder(border);


        JButton calcular = new JButton("Calcular");
        calcular.setBounds(225, 740, 150, 50);

        JButton volver = new JButton("Volver");
        volver.setBounds(200, 840, 200, 50);

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
            this.calcularQ();

        }else{
            App.frame.setContentPane(new puntoUno());
        }

    }


    public void calcularQ() {

        String attrT1[] = atributosT1.getText().split(",");
        Set<String> T1tabla = new HashSet<String>();
        for (int i = 0; i < attrT1.length; i++) {
            T1tabla.add(attrT1[i].toLowerCase());
        }

        String attrT2[] = atributosT2.getText().split(",");
        String claveForaneaT2 = attrT2[1].toLowerCase();
        Set<String> T2tabla = new HashSet<String>();
        for (int i = 0; i < attrT2.length; i++) {
            if (!attrT2[i].toLowerCase().replaceAll("\s", "").equals(claveForaneaT2)) {
                T2tabla.add(attrT2[i].toLowerCase());
            }
        }
        String attrT3[] = atributosT3.getText().split(",");
        String claveForaneaT3 = attrT3[1].toLowerCase();
        Set<String> T3tabla = new HashSet<String>();
        for (int i = 0; i < attrT3.length; i++) {
            if (!attrT3[i].toLowerCase().equals(claveForaneaT3)) {
                T3tabla.add(attrT3[i].toLowerCase());
            }
        }
        System.out.println("AtrT1: "+ T1tabla+"\n AtrT2: "+T2tabla+"\n AtrT3: "+ T3tabla);

        String consultasS1[] = s1.getText().split(";");
        Set<Set> S1 = new HashSet<>();
        for (int i = 0; i < consultasS1.length; i++) {
            Set<String> temporal = new HashSet<>();
            String attr = consultasS1[i].replaceAll("[A-Z]{2,}", "");
            attr = attr.replaceAll(",", "");
            String li[] = attr.split("\s{1,}");
            for (int j = 0; j < li.length; j++) {
                if (T2tabla.contains(li[j]) && li[j] != claveForaneaT2) {
                    temporal.add(li[j]);
                }

            }
            S1.add(temporal);
        }

        String consultasS2[] = s2.getText().split(";");
        Set<Set> S2 = new HashSet<>();
        for (int i = 0; i < consultasS2.length; i++) {
            Set<String> temporal = new HashSet<>();
            String attr = consultasS2[i].replaceAll("[A-Z]{2,}", "");
            attr = attr.replaceAll(",", "");
            String li[] = attr.split("\s{1,}");
            for (int j = 0; j < li.length; j++) {
                if (T3tabla.contains(li[j]) && li[j] != claveForaneaT3) {
                    temporal.add(li[j]);
                }

            }
            S2.add(temporal);
        } 
        

        

        String consultasS3[] = s3.getText().split(";");
        Set<String> S3 = new HashSet<>();
        for (int i = 0; i < consultasS3.length; i++) {
            String attr = consultasS3[i].replaceAll("[A-Z]{2,}", "");
            attr = attr.replaceAll(",", "");
            String li[] = attr.split("\s{1,}");
            for (int j = 0; j < li.length; j++) {
                if ((T1tabla.contains(li[j]) || T2tabla.contains(li[j]))||T3tabla.contains(li[j]) && (li[j] != claveForaneaT2 && li[j] != claveForaneaT3)) {
                    S3.add(li[j]);
                }
            }

        }
        System.out.println("S1(T2): "+S1);
        System.out.println("S1(T3): "+S2);
        System.out.println("S3: "+S3);
        
        String qprima = "Q' = {";
        Object[] t1Arr = T1tabla.toArray();
        // Llenar Q' Con atributos de T1tabla
        for (int i = 0; i < t1Arr.length; i++) {
            qprima += t1Arr[i].toString() + ", ";
            
        }
        
        // Calcular T'2(S3)
        Set<String> T2primaS3 = new HashSet<>(S3);
        T2primaS3.retainAll(T2tabla);

        Set union = new HashSet<>();        
        Object arrayTemp[] = S1.toArray();        
        for (int i = 0; i < arrayTemp.length; i++) {
            Set<String> item = (Set<String>) arrayTemp[i];
            Set<String> compara = new HashSet<>(item);
            item.removeAll(T2primaS3);
            if(item.size() != 0 && !(item.equals(compara))){
                Object tempo2[] = item.toArray();
                for (int j = 0; j < tempo2.length; j++) {
                    union.add(tempo2[j]);
                    
                }
                
            }
        }
        //Realizar y poner T'2 en Q'
        T2primaS3.addAll(union);
        Set<String> T2prima = new HashSet<>(T2primaS3);
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
        
        //Calcular T''2
        qprima += ", "+T2.getText()+"``:{ "; 
        Set unionDoblepriS3 = new HashSet<>();        
        Object arrayTempDobleS3[] = S1.toArray();   
        for (int i = 0; i < arrayTempDobleS3.length; i++) {
            Set<String> item = (Set<String>) arrayTempDobleS3[i];
            Set<String> compara = new HashSet<>(item);
            item.retainAll(T2primaS3);
            if(item.size() == 0){
                unionDoblepriS3.add(compara);
            }
             
        }
        // Realizar y poner T''2 en Q'
        Object t2doblepri[] = unionDoblepriS3.toArray();
        for (int i = 0; i < t2doblepri.length; i++) {
            if(i== t2doblepri.length-1){
                qprima += t2doblepri[i].toString().replace("\\[|]", "");

            }else{
                qprima += t2doblepri[i].toString().replace("\\[|]", "")+",";
            }
        }
        
        qprima += "}, ";

        // Calcular T'3(S3)
        Set<String> T3primaS3 = new HashSet<>(S3);
        T3primaS3.retainAll(T3tabla);

        Set unionS3  = new HashSet<>();        
        Object arrayTempS3[] = S2.toArray();        
        for (int i = 0; i < arrayTempS3.length; i++) {
            Set<String> item = (Set<String>) arrayTempS3[i];
            Set<String> compara = new HashSet<>(item);
            item.removeAll(T3primaS3);
            if(item.size() != 0 && !(item.equals(compara))){
                Object tempo2[] = item.toArray();
                for (int j = 0; j < tempo2.length; j++) {
                    unionS3.add(tempo2[j]);
                    
                }
                
            }
        }
        //Realizar y poner T'3 en Q'
        T3primaS3.addAll(unionS3);
        Set<String> T3prima = new HashSet<>(T3primaS3);
        System.out.println("T'3: "+T3prima);
        Object t3pri[] = T3prima.toArray();
        qprima += T3.getText()+"_OF_"+T1.getText()+":{";
        for (int i = 0; i < t3pri.length; i++) {
            if(i== t3pri.length-1){
                qprima += t3pri[i].toString();

            }else{
                qprima += t3pri[i].toString()+",";
            }
        }
        qprima += "} ";
        
        //Calcular T''3
        qprima += ","+T3.getText()+"``:{ "; //
        Set unionDoblepriS3T3 = new HashSet<>();        
        Object arrayTempDoblePriS3[] = S2.toArray();   
        for (int i = 0; i < arrayTempDoblePriS3.length; i++) {
            Set<String> item = (Set<String>) arrayTempDoblePriS3[i];
            Set<String> compara = new HashSet<>(item);
            item.retainAll(T3primaS3);
            if(item.size() == 0){
                unionDoblepriS3T3.add(compara);
            }
             
        }
        // Realizar y poner T''3 en Q'
        Object t3doblepri[] = unionDoblepriS3T3.toArray();
        for (int i = 0; i < t3doblepri.length; i++) {
            if(i== t3doblepri.length-1){
                qprima += t3doblepri[i].toString();

            }else{
                qprima += t3doblepri[i].toString()+",";
            }
        }
        
        qprima += "}}";



        System.out.println(qprima);
        
    }
    
}