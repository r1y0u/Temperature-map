
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TemperatureMap {
	
	
	
	private int[][] data;
	
	public TemperatureMap(int[][] temperature) {
		
		data = temperature;
		
	}
	
	private Color getColor(int temperature) {
		Color color;
	       
		if (temperature <= 32) {
	           
			color = Color.BLUE;
		}
		else if (temperature <= 50) {
	          
			color = Color.GREEN;
		}
		else if (temperature <= 85) {
			color = Color.ORANGE;
		}
		else {
			color = Color.RED;
		}
	       
		return color;
		
	   }
	
	public void drawMap(Graphics2D g2) {
		
		final int SIDE = 10;
		int firstX = 0;
		int y = 0;
		
		for(int i = 0; i < data.length;i++) {
			
			int x = firstX;
			for(int j =0; j < data[0].length;j++) {
				
				int temperature = data[i][j];
				
				Rectangle square = new Rectangle(x,y,SIDE,SIDE);
				g2.setColor(getColor(temperature));
				g2.fill(square);
				x = x + SIDE;
				
			}
			y = y + SIDE;
		}
		
	}
	
	public int maxDifference() {
		
		int maxHigh = data[0][0];
		int minLow = maxHigh;
		int difference = 0;
		
		
		for(int i = 0; i < data.length;i++) {
			
			for(int j = 0; j < data[0].length;j++) {
				
				int points = data[i][j];
				
				if(points > maxHigh) {
					
					maxHigh = points;
				}
				else if (points < minLow){
					
					minLow = points;
				}
				
			difference = maxHigh - minLow;
			
			}
			
		}
		
		return difference;
		
	}
	  
}
