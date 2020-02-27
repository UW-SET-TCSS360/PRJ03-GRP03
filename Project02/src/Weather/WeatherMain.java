package Weather;


import java.awt.EventQueue;

import javax.swing.UIManager;


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
       System.out.println(UIManager.getSystemLookAndFeelClassName());
        try {
            //here you can put the selected theme class name in JTattoo
            UIManager.setLookAndFeel( "com.jtattoo.plaf.noire.NoireLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
