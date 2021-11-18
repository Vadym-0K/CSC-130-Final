/* This will handle the "Hot Key" system. */

package Main;
import logic.Control;
import timer.stopWatchX;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(25);//250
	public static stopWatchX timer = new stopWatchX(60);
	public static stopWatchX lTimer = new stopWatchX(300);
	public static int spriteIndex = 1;
	public static int spriteIndexShort = 1;
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;

		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
			
		case '$': //space
			{
				if (lTimer.isTimeUp())
				{
					if (Main.activate == false) 
						{
							Main.activate = true;
							if (sw.isTimeUp()) 
								{
									Main.activate = true; 
									sw.resetWatch();
								}
						}
					else Main.activate = false;
					lTimer.resetWatch();
				}
				
			}
			break;
			

		case 'w':
			if( Main.activate == false || Main.aText == false)
			{
				Main.face = 'u';
				if (timer.isTimeUp())
				{
					Main.sprite = "up" + spriteIndexShort;
					spriteIndexShort ++;
					timer.resetWatch();
				}
				if (spriteIndexShort == 9) spriteIndexShort = 1;			
				Main.vec1.adjustY(-(Main.step));
			}			
			break;
			
		case 's':
			if( Main.activate == false || Main.aText == false)
			{
				Main.face = 'd';
				if (timer.isTimeUp())
				{
					Main.sprite = "d" + spriteIndexShort;
					spriteIndexShort ++;
					timer.resetWatch();
				}
				
				if (spriteIndexShort == 9) spriteIndexShort = 1;
				Main.vec1.adjustY(+(Main.step));		
			}			
			break;
			
		case 'a':
			if( Main.activate == false || Main.aText == false)
			{
				Main.face = 'l';
				if (timer.isTimeUp())
				{
					Main.sprite = "fl" + spriteIndex;
					spriteIndex ++;
					timer.resetWatch();
				}
				if (spriteIndex == 9) spriteIndex = 1;
				Main.vec1.adjustX(-(Main.step));
			}
			break;
			
		case 'd':
			if (Main.activate == false || Main.aText == false)
			{
				Main.face = 'r';
				if (timer.isTimeUp())
				{
					Main.sprite = "fr" + spriteIndex;
					spriteIndex ++;
					timer.resetWatch();
				}
				if (spriteIndex == 9) spriteIndex = 1;		
				Main.vec1.adjustX(+(Main.step));
			}
			break;

		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}