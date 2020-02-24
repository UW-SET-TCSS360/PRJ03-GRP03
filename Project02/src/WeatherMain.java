

import java.awt.EventQueue;


public class WeatherMain {
    /**
     * The constructor for the PowerPaintMain class, set private so it can't be instantiated.
     */
    private WeatherMain() {
    }
    
    /**
     * The entry point for the Weather Console application.
     * 
     * @param theArgs the unused command line arguments
     */
    public static void main(final String[] theArgs) {        
        // start the GUI in a separate thread
        Alerts alert = new Alerts();
    	WeatherGUI gui = new WeatherGUI(alert);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui.start();
            }
        });
        
        WeatherStation station = new WeatherStation();
        Storage storage = new Storage();

        WeatherController controller = new WeatherController(station, gui, storage, alert);

        Thread thread = new Thread(controller);
        thread.start();
    }
}
