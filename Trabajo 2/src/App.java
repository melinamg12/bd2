import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.math.*;

public class App extends JFrame {
    
	static JFrame frame;
    
    public static void main(String[] args) throws Exception {
        
    	frame = new interfaz();
		frame.setContentPane(new interfazPrincipal());     
    }
}
