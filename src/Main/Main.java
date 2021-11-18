//1280 x 720

package Main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import Data.Vector2D;
import Data.spriteInfo;
import FileIO.EZFileRead;
import logic.Control;
import timer.stopWatchX;

public class Main
{
	// Fields (Static) below...
	public static boolean isImageDrawn = false;
	public static Color brown = new Color(129, 79, 40);
	public static stopWatchX timer = new stopWatchX(60);
	public static Vector2D vec1 = new Vector2D(1120, 250); //(1120, 250);
	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100,-100);
	public static int step = 4;
	public static int i = 1;
	public static int int_random;
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static int currentSpriteIndex = 0;
	public static HashMap<String, String> map = new HashMap<>();
	public static char face;
	public static String sprite = "idleLeft";
	public static Vector2D vecTemp = new Vector2D(0, 0);
	public static ArrayList<BoundingBox> solid  = new ArrayList<>();
	public static BoundingBox player;
	public static BoundingBox house;
	public static boolean stop = false;
	public static boolean activate = false;
	public static boolean aText = false;
	
	// End Static fields...

	public static void main(String[] args)
	{
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();						    // Do NOT remove!
		System.out.printf("" + player.intersects(solid.get(4)));
	
	}

	/* This is your access to things BEFORE the game loop starts */
	public static void start()
	{

		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)

		EZFileRead ezr = new EZFileRead("cp4.txt");
		StringTokenizer st;
		String Key, Value, str;
		for (int i = 0; i < ezr.getNumLines(); i++)
		{
			str = ezr.getLine(i);
			st = new StringTokenizer(str, "*");
			Key = st.nextToken();
			Value = st.nextToken();
			map.put(Key, Value);
		}
		house  = new BoundingBox (110, 110, 750, 540);
		BoundingBox border1 = new BoundingBox (0,0,1279,20);
		BoundingBox border2 = new BoundingBox (0,20,20,719);
		BoundingBox border3 = new BoundingBox (20,700,1279,719);
		BoundingBox border4 = new BoundingBox (1260,20,1279,700);
		
		BoundingBox wall1 = new BoundingBox (100,200,720,210);
		BoundingBox wall2 = new BoundingBox (100,540,720,550);
		BoundingBox wall3 = new BoundingBox (100,210,110,540);
		BoundingBox wall4 = new BoundingBox (710,210,720,230);
		BoundingBox wall5 = new BoundingBox (710,370,720,540);
		
		BoundingBox tv = new BoundingBox (600,490,710,520);
		BoundingBox chair = new BoundingBox (150,240,180,280);
		BoundingBox bed = new BoundingBox (110,480,240,540);

		solid.add(border1);
		solid.add(border2);
		solid.add(border3);
		solid.add(border4);
		solid.add(wall1);
		solid.add(wall2);
		solid.add(wall3);
		solid.add(wall4);
		solid.add(wall5);
		solid.add(tv);
		solid.add(chair);
		solid.add(bed);

	}

	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl)
		{
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		String tvString1 = map.get("string1"); // Pass the first Key
		String tvString2 = map.get("string2");
		String tvString3 = map.get("string3");
		String plString1 = map.get("string4");
		String plString2 = map.get("string5");
		String plString3 = map.get("string6");
		
		ctrl.addSpriteToFrontBuffer(0, 0, "background1");
		player = new BoundingBox (vec1.getX() + 30, vec1.getY() + 74,vec1.getX() + 86,vec1.getY() + 120);
		if (player.intersects(house)) ctrl.addSpriteToFrontBuffer(0, 0, "background2");
		BoundingBox tv_active = new BoundingBox (480,490,590,520);
		BoundingBox chair_active = new BoundingBox (110,310,220,390);
		BoundingBox bed_active = new BoundingBox (130,450,240,480);
		
		for (int i = 0; i < Main.solid.size(); i++)
		{
			if(player.intersects(solid.get(i)) == true) stop = true;
		}
		
		if (stop == true)
		{
			if (face == 'u')
				{
					vec1.adjustY(+(step));
					stop = false;
				}
			if (face == 'd')
				{
					stop = false;
					vec1.adjustY(-(step));
				}
			if (face == 'r')
				{
					stop = false;
					vec1.adjustX(-(step));
				}
			if (face == 'l')
				{
					stop = false;
					vec1.adjustX(+(step));
				}
		}

		aText = false;
		ctrl.addSpriteToFrontBuffer(vec1.getX(), vec1.getY(), sprite);
		if (player.intersects(house))ctrl.addSpriteToFrontBuffer(0, 0, "tv");
		if (player.intersects(tv_active) && activate && face == 'r') 
			{
			 ctrl.addSpriteToFrontBuffer(0, 0, "textUI");
			 ctrl.drawString(140, 570, tvString1, brown);
			 ctrl.drawString(140, 600, tvString2, brown);
			 ctrl.drawString(140, 630, tvString3, brown);
			 aText = true;
			}
		if (player.intersects(bed_active) && activate && face == 'd') 
		{
		 ctrl.addSpriteToFrontBuffer(0, 0, "textUI");
		 ctrl.drawString(140, 570, plString1, brown);
		 aText = true;
		}
		
		if (player.intersects(chair_active) && activate && face == 'u') 
		{
		 ctrl.addSpriteToFrontBuffer(0, 0, "textUI");
		 ctrl.drawString(140, 570, plString2, brown);
		 ctrl.drawString(140, 600, plString3, brown);
		 aText = true;
		}
	}

	// Additional Static methods below...(if needed)
	public static void resetAnimation()
	{
		if (face == 'u') sprite = "idleUp";
		else if (face == 'd') sprite = "idleDown";
		else if (face == 'r') sprite = "idleRight";
		else if (face == 'l') sprite = "idleLeft";
	}
}