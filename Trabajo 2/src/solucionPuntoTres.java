import javax.swing.JFrame;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class solucionPuntoTres extends JFrame {

    public static String ciudadBusqueda;

    public void paint(Graphics g) {
        Dimension d = getSize();
        int x = d.width;
        int y = d.height;

        
        g.setColor(Color.white);
        g.fillRect(0, 0, x, y);
        Connection conn = Conexion.dbConexion();
        Statement sentencia = null;
        ResultSet resultado;

        try {
            sentencia = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        HashMap<String, ArrayList> puntosVentas = new HashMap<>();

        try {
            resultado = sentencia.executeQuery(
                    "SELECT t2.* FROM VVCITY t, TABLE (t.ventas) t2 WHERE Ciudad ='" + ciudadBusqueda + "'");
            Integer contador = 0;
            while (resultado.next()) {
                ArrayList<Integer> puntosConsulta = new ArrayList<>();
                String clave = "p" + contador;
                puntosConsulta.add(resultado.getInt(1));
                puntosConsulta.add(resultado.getInt(2));
                puntosConsulta.add(resultado.getInt(3));
                puntosVentas.put(clave, puntosConsulta);

                contador += 1;

            }
            //System.out.println(contador);
        } catch (Exception e) {
            System.out.println("ERRor");
        }

        ArrayList<Integer> puntos = new ArrayList<>();
        try {

            // Se obtienen las coordenadas del rectangulo
            resultado = sentencia.executeQuery(
                    "select c.locales.extract('/locales/rectangulo').getStringVal()  FROM CITY c where nombre_ciudad='"
                            + ciudadBusqueda + "'");
            while (resultado.next()) {
                String formato = resultado.getString(1).replaceAll("<\\w*>", "");
                String formatoFinal = formato.replaceAll("</\\w*>", "");
                formatoFinal = formatoFinal.replaceAll("\\n", "");
                String Lista[] = formatoFinal.split("\\s");
                for (int i = 0; i < Lista.length; i++) {
                    if (Lista[i].equals("")) {
                        // puntos[i] = Integer.parseInt(Lista[i]);
                    } else {
                        puntos.add(Integer.parseInt(Lista[i]));
                    }

                }

                for (int i = 0; i < puntos.size(); i += 4) {
                    g.setColor(Color.blue);
                    g.drawRect(puntos.get(i), puntos.get(i + 1), puntos.get(i + 2), puntos.get(i + 3));

                    Integer x1 = puntos.get(i);
                    Integer y1 = puntos.get(i + 1);
                    Integer x2 = (puntos.get(i) + puntos.get(i + 3));
                    Integer y2 = (puntos.get(i + 1) + puntos.get(i + 2));

                    Integer valorCompras = 0;
                    String borrar = "";

                    for (String key : puntosVentas.keySet()) {

                        Integer xPunto = (Integer) puntosVentas.get(key).get(0);
                        Integer yPunto = (Integer) puntosVentas.get(key).get(1);
                        Integer valor=(Integer) puntosVentas.get(key).get(2);
                        System.out.println(xPunto);
                        String valor1 = Integer.toString(valor);
                        g.setColor(Color.green);
                        g.drawString("$ " + valor1, xPunto,yPunto);
                        g.drawRect(xPunto,yPunto,2,2);
                      
                        g.fillOval(xPunto,yPunto, 4, 4);
                    }
                    String borrado[] = borrar.split(" ");
                    for (int j = 0; j < borrado.length; j++) {
                        puntosVentas.remove(borrado[j]);
                    }


                }

            }

        } catch (SQLException e1) {
            System.out.println("Error: " + e1.getMessage());

        }
        

        // Se cierra la conexion con la BD
        try {
            conn.close();
        } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }

    public static void main(String args[]) {

        solucionPuntoTres DrawWindow = new solucionPuntoTres();

        DrawWindow.setSize(500, 500);
        DrawWindow.setResizable(false);
        DrawWindow.setLocation(200, 50);
        DrawWindow.setTitle("Locales y sus ventas en la ciudad de: " + solucionPuntoTres.ciudadBusqueda);
        DrawWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        DrawWindow.setVisible(true);
    }

    public static void recibirCiudad(String ciudad) {
        solucionPuntoTres.ciudadBusqueda = ciudad;
        String args[] = new String[1000000];
        solucionPuntoTres.main(args);

    }

}