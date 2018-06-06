package fractal;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/*
# sergio cadena
*/

/**
 * This class represents the behavior of several Problems Solutions based on Strings
 * @author MSc. Carlos Andres Sierra, PhD. student
 */
public class main extends JApplet {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private int ca_lenght = 400; //la longitud del automata
	private int screen_size = 800; //tamaño 
	private int delay_time = 1; //tiempo de refrescamiento 
	
	/**
	 * This method defines the setup of the ppplet
	 */
	public void init() 
    {
        setSize(screen_size, screen_size); 
		setBackground(Color.white); 
    }
 	
	
	/**
	 * This method represents the process of paint the cellular automata
	 */
    public void paint(Graphics g) 
    {
        
    	Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
       
        int x = 0;//cordenadas
        int y = 0;//cordenadas
        
       
        int square_size = screen_size / ca_lenght;
 
       
        main cellular_automata = new main();
        
        
        while(true)
        {
        	int[][] matrix = cellular_automata.generate(ca_lenght); 
        	
        	y = 0; 
        	
        	
        	for(int i = 0; i < ca_lenght; i++)
        	{
        		//inicia en la pocision de izquierda
        		x = 0;
        		for(int j = 0; j < ca_lenght; j++)
        		{
        			//si es 0 se pinta de negro
	    		   if(matrix[i][j] == 0)
	    		   {
	    			   g2.setPaint(Color.black);
	    		   }
	    		   else  //si no entonces se pinta de verde
	    		   {
	    			   g2.setPaint(Color.green);
	    		   }
    		   
	    		   //pinta el cuadrado 
	    		   g2.fill(new Rectangle2D.Double(x, y, square_size, square_size));
	    		   
	    		   x += square_size; //mueve horizontalmente
	    		}
        		
        		y += square_size; //mueve verticalmente
        	}
       
        	//tiempo de espera
        	try 
        	{
        		Thread.sleep( delay_time );
        	} 
        	catch (InterruptedException e) 
        	{
        		e.printStackTrace();
        	}
       
       }
    }
 
    
    /**
     * This is the main method of the class. Here is where all the application starts.
     */
    public static void main(String args[])
    {
       
    	JFrame frame = new JFrame("CellularAutomata");

    	
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        
        
        JApplet applet = new main();
        
        //Add the applet to the frame
        frame.getContentPane().add("Center", applet);
        
        //Initialize the applet and run the simulation
        applet.init();
        
        //Add properties to the frame
        frame.pack();
        frame.setSize(new Dimension(800,800));
        frame.setVisible(true);
    }
    
}