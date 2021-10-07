package Data;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

public class gameString{
	private String _str;
	private Color _color;
	private int _x, _y;
	private Font cFont;
	
	public gameString(Color color,
			int x, int y, String str, Font font, float scaleFactor){
		_str = str;
		_color = color;
		_x = (int) (x * scaleFactor);
		_y = (int) (y * scaleFactor);
		cFont = font;
	}
	
	public int getX(){
		return _x;
	}
	
	public int getY(){
		return _y;
	}
	
	public Color getColor(){
		return _color;
	}
	
	public String toString(){
		return _str;
	}
	
	public Font getFont(){
		return cFont;
	}
	
	public void resetString(String newStr){
		_str = newStr;
	}
	
	/* Get width of a string in pixels */
	private static int getStringWidth(Graphics g, Font f, String s) {	
	    FontMetrics fm   = g.getFontMetrics(f);
	    java.awt.geom.Rectangle2D rect = fm.getStringBounds(s, g);
	    return (int)(rect.getWidth() + (s.length() * 2));
	}
	
	/* Try to center text between two x points */
	public static int getCenteredXPosition(Graphics g, Font f, 
			String s, int x1, int x2, float scaleFactor){
		int textWidth = getStringWidth(g, f, s);
		//textWidth += s.length() * 2;	// Account for spacing! (This is a 2020 improvement over the original!)
		int normalizedWidth = (int) (textWidth / scaleFactor);
		normalizedWidth /= 2;
		int rectWidth = x2 - x1;
		rectWidth /= 2;
		int centerX = x1 + (rectWidth - normalizedWidth);
		return centerX;
	}
	
	/* Find out which token to stop at...*/
	public static String[] wordWrapX(String[] tokens, int max, Graphics g, Font f){
		ArrayList<String> lines = new ArrayList<String>();
		String test = "";
		String line = "";
		for(int i = 0; i < tokens.length; i++){
			test += tokens[i];
			if(getStringWidth(g, f, test) > max){
				lines.add(line);
				test = tokens[i] + " ";
			}else{
				test += " ";
			}
			line = test;
		}
		lines.add(line);		// Add the remainder of line at the end
		String[] linesArray = new String[lines.size()];
		for(int i = 0; i < linesArray.length; i++)
			linesArray[i] = lines.get(i);
		return linesArray;
	}
}