package gameloop;

import Graphics.Sprites;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.List;

import Data.Sprite;
import Data.gameString;

public class Renderer{
	
	public static void render(Graphics g, List<gameString> gs, Sprites sps, Sprites overlays, float alpha, boolean isFade){
		/* This is a generic function that can start fresh for any new gaming project.
		 * All one has to do is wipe the contents and start new and it should work fine
		 * with the rest of the game engine. */
		
		// First sprites...
		Iterator<Sprite> it = sps.getIterator();
		while(it.hasNext()){
			Sprite tmp = it.next();
			g.drawImage(tmp.getSprite(), tmp.getX(), tmp.getY(), null);
		}
		
		// ... then text
		for(gameString a: gs){
			Font temp = a.getFont().deriveFont(Font.BOLD);
			g.setFont(temp);
			g.setColor(a.getColor());
			g.drawString(a.toString(), a.getX(), a.getY());
		}
		
		// For all overlays (above text even; e.g. custom mouse cursors)
		Iterator<Sprite> oit = overlays.getIterator();
		while(oit.hasNext()){
			Sprite tmp2 = oit.next();
			g.drawImage(tmp2.getSprite(), tmp2.getX(), tmp2.getY(), null);
		}
		
		// This is for the alpha?
		if(isFade){
			BufferedImage bi = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_ARGB);
			Graphics g2d = (Graphics2D) g;														// Access graphics handle
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);		// Create the alpha composite
			Graphics2D gbi = bi.createGraphics();												// Prepare image for java2d drawing/modifying
			gbi.setComposite(ac); 																// Set the alpha composite
			gbi.setColor(Color.BLACK);															// Set fade overlay to black
			gbi.fillRect(0, 0, 1280, 720);
			g2d.drawImage(bi, 0, 0, null);														// Draw the image
		}
	}
	
	public static BufferedImage toCompatibleImage(BufferedImage image)
	{
	    // obtain the current system graphical settings
	    GraphicsConfiguration gfxConfig = GraphicsEnvironment.
	        getLocalGraphicsEnvironment().getDefaultScreenDevice().
	        getDefaultConfiguration();

	    if (image.getColorModel().equals(gfxConfig.getColorModel()))
	        return image;

	    // image is not optimized, so create a new image that is
	    BufferedImage newImage = gfxConfig.createCompatibleImage(
	            image.getWidth(), image.getHeight(), image.getTransparency());

	    // get the graphics context of the new image to draw the old image on
	    Graphics2D g2d = newImage.createGraphics();

	    // actually draw the image and dispose of context no longer needed
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();

	    // return the new optimized image
	    return newImage; 
	}
}