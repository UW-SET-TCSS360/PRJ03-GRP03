package Weather;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.UIManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeatherLFTest {

    @BeforeEach
    void setUp() throws Exception {
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
    }

    @Test
    void testLookAndFeel() {
        assertEquals("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", UIManager.getSystemLookAndFeelClassName());
        
    }

}
