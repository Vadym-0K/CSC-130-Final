/* This is a way to pass a sprite's key information in one entity. (x, y, tag) */

package Data;

public class spriteInfo {
	// Fields
		// Add private class fields to store x, y (use Vector2D for this) and tag (String) values given in class constructor
		private Vector2D vSpr;
		private String str1;

	// Constructor
	public spriteInfo(Vector2D v2d, String tag){
		// TODO: Save the constructor parameters into class fields
		str1 = tag;
		vSpr = v2d;//new Vector2D(v2d.getX(), v2d.getY());
	}

	// Methods
	public String getTag(){
		// Remove my placeholder code below (which is there to prevent an error) and replace it with returning the value of your private field tag
		return str1;
	}

	public Vector2D getCoords(){
		//Remove my placeholder code below (which is there to prevent an error) and replace it with returning the value of your private field v2d
		return vSpr;
	}

	public void setTag(String newTag){
		// Update the value of tag to be the value in newTag (Absolute assignment)
		str1 = newTag;
	}

	public void setCoords(Vector2D newV2D){
		// TODO: Update the value of v2d to be the value in newV2D (Absolute assignment)
		vSpr = new Vector2D(newV2D.getX(), newV2D.getY());
	}

	public void setCoords(int x, int y){
		// Overload the setCoords method to allow another way to set the coordinates. Place the x, y integers into v2d by changing the values of v2d to hold x and y (Absolute assignment)
		vSpr = new Vector2D(x, y);
	}

	public String toString(){
		//Create a "toString" method to test. Assume an x, y of 100, 50 and a tag of "star", this should return: [100, 50, star]
			// Remove my placeholder code below (which is there to prevent an error) and replace it with your proper toString method with specifications above
		return "["+ vSpr.getX() +", " + vSpr.getY() +", "+ str1 +"]";
	}
}
