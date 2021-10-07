package Graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Data.Sprite;

/* This class will handle the details concerning image files. It won't render them as that is the job of the
 * renderer. But it will handle the linked list, setting up, etc. Hopefully, this can become a robust sprite
 * engine! */

public class Sprites{
	private List<Sprite> sprites;
	public Sprites(){
		sprites = new ArrayList<Sprite>();
	}
	
	public void addSprite(int x, int y, String fileName, String tag){
		Sprite temp = new Sprite(x, y, fileName, tag);
		if(temp != null)
			sprites.add(temp);
	}
	
	public void addSprite(Sprite s){
		sprites.add(s);
	}
	
	public Sprite getSprite(int index){
		if(sprites.size() <= index)		return null;
		return sprites.get(index);
	}
	
	public Sprite getSpriteByTag(String tag){
		// Tags are ALWAYS case insensitive!
		for(Sprite s : sprites){
			if(s == null)			return null;
			String sTag = s.getTag().toLowerCase();
			tag = tag.toLowerCase();
			if(sTag.equals(tag))
				return s;
		}
		return null;
	}
	
	public boolean isTagInBuffer(String tag){
		// Tags are ALWAYS case insensitive!
		for(Sprite s : sprites){
			String sTag = s.getTag().toLowerCase();
			tag = tag.toLowerCase();
			if(sTag.equals(tag))
				return true;
		}
		return false;
	}
	
	public void delSprite(int index){
		sprites.remove(index);
	}
	
	public void changeSprite(int index, String fileName){
		Sprite t1 = sprites.get(index);
		int x = t1.getX();
		int y = t1.getY();
		String tag = t1.getTag();
		Sprite temp = new Sprite(x, y, fileName, tag);
		sprites.set(index, temp);
	}
	
	public void changeSprite(int index, Sprite newSprite){
		sprites.set(index, newSprite);
	}
	
	public void clearSprites(){
		sprites.clear();
	}
	
	public int size(){
		return sprites.size();
	}
	
	public Iterator<Sprite> getIterator(){
		Iterator<Sprite> it = sprites.iterator();
		return it;
	}
}