package GameOfLife;
import java.util.Random;

/**
 * 
 * @author SergioCadena
 *Game of life structure
 */

public class GOL_Estructura {

	public int [][] Cellular_automata; //This is the matrix where is the  size of the square
	
	public GOL_Estructura (int width , int height)
	{
		this.Cellular_automata = new int [height][width];
		this.random_popupalition(width, height);
	}
	public void random_popupalition (int width , int height)
	{
		Random rd = new Random();
		
		double alive_probability = 0.09; //Square alive probability
		
		for (int i = 0; i < height; i++) 
		{
			for (int j = 0; j < width; j++) 
			{
				this.Cellular_automata[i][j] = 
						rd.nextDouble() < alive_probability ? 1 : 0; 
			}
		}
	}
	public void nextIteration(){
		
		int counter;
		
		int n1 = this.Cellular_automata.length;
		int n2 = this.Cellular_automata[0].length;
		
		for(int i = 0; i < n1 ; i++)
		{
			for(int j = 0 ; j < n2 ; j++)
			{	
				//Sum of the positions in the matrix
				counter = this.Cellular_automata[(i - 1 + n1) % n1][(j - 1 + n2) % n2]
					+ this.Cellular_automata[(i - 1 + n1) % n1][j]
					+ this.Cellular_automata[(i - 1 + n1) % n1][(j + 1) % n2]
					+ this.Cellular_automata[i][(j - 1 + n2) % n2]
					+ this.Cellular_automata[i][(j + 1) % n2]
					+ this.Cellular_automata[(i + 1) % n1][(j - 1 + n2) % n2]
					+ this.Cellular_automata[(i + 1) % n1][j]
					+ this.Cellular_automata[(i + 1) % n1][(j + 1) % n2];
							
							if(this.Cellular_automata[i][j] == 1)
								this.Cellular_automata[i][j] = (counter < 2 || counter >3) ? 0 : 1;
								else
									this.Cellular_automata[i][j] = counter == 3 ? 1 : 0;		
			}
		}
	}

}