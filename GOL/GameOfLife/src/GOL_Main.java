package GameOfLife;
import processing.core.PApplet;

/**
 * 
 * @author Laura Santacruz
 * Game of life main
 */

public class GOL_Main extends PApplet {

	public static void main(String[] args) 
	{
		PApplet.main("GameOfLife.GOL_Main");
	}
	
	//This is the main of our game
	int square_size = 8, width = 75, height = 75; //This is the information of the squares 
	
	GOL_Estructura gol = new GOL_Estructura(width , height); //The width and the height it is passed to the structure of the game
	
	public void settings() 
	{
		  size(width * square_size , height * square_size); //This is the size of the all the square
	}
		public void draw() //This is where are assigned the colors for the squares alive and dead
		{
			for(int i = 0 ; i< height ; i++)
			{
				for(int j = 0; j < width; j++)
				{
					if(gol.Cellular_automata[i][j] == 1)
				  
						fill(255,0,255);
					else
						fill(0);
					rect(j * square_size , i * square_size , square_size , square_size);
				}	  
			  try //The try is used for prevent problems in the program
			  { 
				  Thread.sleep(20);
				  gol.nextIteration();				  
			  }
			  catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			}	
		}	
}