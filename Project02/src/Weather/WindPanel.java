package Weather;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 * The panel that shows the wind speed and direction graphically.
 * 
 * @author Group 6
 *
 */
public class WindPanel extends JPanel {
	
	/**
	 * The unique ID for the Serializable interface
	 */
	private static final long serialVersionUID = -7614555071611756523L;
	
	/**
	 * The wind speed sensor data
	 */
	private int speed;
	/**
	 * The wind direction sensor data
	 */
	private int dir;
	/**
	 * The Stroke that will be used to draw the WindPanel
	 */
	private Stroke myStroke;
	
	/**
	 * The constructor for the WindPanel
	 * 
	 * @param diam the diameter of the circular wind panel
	 */
	public WindPanel(int diam) {
		super();
		speed = 0;
		dir = 0;
		myStroke = new BasicStroke(1);
		this.setPreferredSize(new Dimension(diam, diam));
		this.setMinimumSize(new Dimension(diam, diam));
	}
	
	/**
	 * Updates the value of the wind speed and direction sensor data
	 * 
	 * @param speed the wind speed sensor data
	 * @param dir the wind direction sensor data
	 */
	public void updateWind(int speed, int dir) {
		this.speed = speed;
		this.dir = dir;
		repaint();
	}
	
	/**
	 * Retrieves the last wind speed sensor data
	 * 
	 * @return the last wind speed sensor data
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Retrieves the last wind direction sensor data
	 * 
	 * @return the last wind speed sensor data
	 */
	public int getDir() {
		return dir;
	}
	
	/**
	 * Paints the wind panel
	 * 
	 * @param theGraphics the graphics device onto which to paint the wind panel
	 */
	@Override
	public void paintComponent(final Graphics theGraphics) {
		super.paintComponent(theGraphics);
		final Graphics2D g2d = (Graphics2D)theGraphics;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                 RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                 RenderingHints.VALUE_STROKE_PURE);
		
		g2d.setColor(Color.white);
		g2d.setStroke(myStroke);
		
		// only use 90% of the bounding rectangle in each dimension
		double innerDiam = getWidth()*0.9;
		
		// draw the background circle
		g2d.draw(new Ellipse2D.Double((getWidth()-innerDiam)/2, (getHeight()-innerDiam)/2, innerDiam, innerDiam));
		
		// draw the speed text string
		g2d.drawString(Integer.toString(speed) + " mph", getWidth()*(0.25f), getHeight()/2.0f);
		
		// draw the direction triangle
		g2d.translate(getWidth()/2.0, getHeight()/2.0);
		g2d.rotate(dir * Math.PI/180);
		g2d.fillPolygon(new int[] {-getWidth()/10, 0, getWidth()/10},
						new int[] {(int) (getHeight()*(-0.85)/2) , (int) (-getHeight()/2.0), (int) (getHeight()*(-0.85)/2)}, 3);
		g2d.rotate(dir * -Math.PI/180);
		g2d.translate(-getWidth()/2.0, -getHeight()/2.0);
		
		g2d.dispose();
	}
}
