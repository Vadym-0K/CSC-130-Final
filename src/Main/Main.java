package Main;

import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
	public static Color light_green = new Color(149, 179, 136);
	public static stopWatchX timer = new stopWatchX(60);
	public static Vector2D vec1 = new Vector2D(0, 250);

	public static Queue<Vector2D> vecs1 = new LinkedList<>();
	public static Queue<Vector2D> vecs2 = new LinkedList<>();
	public static Vector2D currentVec = new Vector2D(-100,-100);
	public static int step = 8;
	public static int i = 1;
	public static int int_random;
//	CP3
	public static ArrayList<spriteInfo> sprites = new ArrayList<>();
	public static int currentSpriteIndex = 0;
//	CP4
	public static HashMap<String, String> map = new HashMap<>();
	// End Static fields...

	public static void main(String[] args)
	{
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();						    // Do NOT remove
//		System.out.printf("number: "+ int_random);
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
		int_random = 1 + new Random().nextInt(5);
	}

	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl)
		{
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		String randomString = map.get("string"+ int_random); // Pass the first Key
		ctrl.drawString(100, 250, randomString, light_green);
		}

	// Additional Static methods below...(if needed)

}
