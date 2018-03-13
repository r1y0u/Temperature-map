import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;
public class TemperatureMapComponent extends JComponent
{
   private static final long serialVersionUID = 1L;

   public void paintComponent(Graphics g)
   {
      // Recover Graphics2D
      Graphics2D g2 = (Graphics2D) g;
      final int DIMENSION = 20;
      final int MAX_TEMPERATURE = 105;
      final int MIN_TEMPERATURE = -10;

      int[][] mapData =  new int[DIMENSION][DIMENSION];
      Random gen = new Random(987654321);

      for (int row = 0; row < DIMENSION; row++)
      {
         for (int column = 0; column < DIMENSION; column++)
         {
            // get temperatures between min and max degrees
            int temp = gen.nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE) + MIN_TEMPERATURE;
            mapData[row][column] = temp;
         }
      }

      TemperatureMap map = new TemperatureMap(mapData);
      map.drawMap(g2);
      int diff = map.maxDifference();
      String message = "Difference: " + diff;
      g2.setColor(Color.BLACK);
      g2.drawString(message, 0, 300);

      //print(mapData);


   }

   public static void print(int[][] map)
   {
      for (int row = 0; row < map.length; row++)
      {
         for (int column = 0; column < map[0].length; column++)
         {

            System.out.print(map[row][column] + " " );
         }
         System.out.println();
      }
   }
}
