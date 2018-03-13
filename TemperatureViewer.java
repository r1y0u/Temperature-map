import javax.swing.*;
/**
 * Displays a TemperatureMap
 */
public class TemperatureMapViewer
{


    public static void main(String[] args)
    {
       JFrame frame = new JFrame();

       frame.setSize(300, 400);
       frame.setTitle("Teperature Map");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       TemperatureMapComponent component = new TemperatureMapComponent();
       frame.add(component);

       frame.setVisible(true);

    }
}
