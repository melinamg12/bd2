import javax.swing.*;


public class App extends JFrame {
    
	static JFrame frame;
    
    public static void main(String[] args) throws Exception {
        
    	frame = new interfaz();
		frame.setContentPane(new interfazPrincipal());     
    }
}
