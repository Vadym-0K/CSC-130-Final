package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Data.Vector2D;
import Data.spriteInfo;
import logic.Control;
import timer.stopWatchX;

//int vindexN3 = isSupported(1280, 720, 32, dms);
public class Main
{
	// Fields (Static) below...
	public static boolean isImageDrawn = false;
	public static Color light_green = new Color(149, 179, 136);
	public static stopWatchX timer = new stopWatchX(5);
	public static Vector2D vec1 = new Vector2D(0, 250);

	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100,-100);
	public static int step = 2;
	//CP3
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static int currentSpriteIndex = 0;
	// End Static fields...

	public static void main(String[] args)
	{
		//Control ctrl = new Control();				// Do NOT remove!
		//ctrl.gameLoop();						    // Do NOT remove

		 //TESTINGS
		Vector2D vecTemp = new Vector2D(250, 250);
		//int x = -100;

		// while (vecTemp.getX() <= 1280)
		// {
		// 	vecs1.add(vecTemp);
		// 	vecTemp = new Vector2D(x, 250);
		// 	x+=step;
		// }
		//System.out.printf("size: "+ vecs2.size());

		spriteInfo newObj = new spriteInfo(vecTemp, "star");
		newObj.setCoords(50, 90);
		
		System.out.printf("  TEST1: " + newObj.toString()); //currentVec.getX()
		System.out.printf("  TEST2: " + vecTemp.getX() + "   " + vecTemp.getY());
	}

	/* This is your access to things BEFORE the game loop starts */
	public static void start()
	{

		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)

//CP2
		Vector2D vecTemp = new Vector2D(0, 250);
		int i = 1;
		spriteInfo newObj = new spriteInfo(vecTemp, "fr"+i);
		int x = -100;

		while (vecTemp.getX() <= 1280)
		{
			sprites.add(newObj);
			vecTemp = new Vector2D(x, 320);
			newObj = new spriteInfo(vecTemp, "fr"+i);
			x+=step;
			i+=1;
			if(i==9) i = 1;
		}
		vecs1.remove();

	}

	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl)
		{
		// TODO: This is where you can code! (Starting code below is just to show you how it works)

		//ctrl.drawString(0, 700, "x: "+ vecs1.toString(), light_green);
//CP2
		if(timer.isTimeUp())
		 {
			currentVec = vecs1.remove();
			//ctrl.drawString(700, 700, "x: "+ currentVec.getX() + "  size_vecs2: " + vecs2.size() + "  size_vecs1: " + vecs1.size(), light_green);
			vecs2.add(currentVec);

			if(!vecs1.isEmpty())
				ctrl.addSpriteToFrontBuffer(currentVec.getX(), currentVec.getY(), "idle");
			else if (vecs1.size()==0 && vecs2.size() == 0) System.exit(0);
			vecs1.add(vecs2.remove());
		    timer.resetWatch();
		 }
		}
		


	// Additional Static methods below...(if needed)

}
