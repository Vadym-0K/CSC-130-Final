package Main;
import java.awt.Point;

public class BoundingBox { 
    private double x1, y1; 
    private double x2, y2;  
   
    public BoundingBox(double x1, double y1, double x2, double y2) 
    {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }

    public BoundingBox(Point u, Point i) 
    {
        this(u.x, u.y, i.x, i.y);
    }


    public boolean contains(Point e) 
    {
        return (e.x >= x1 && e.x <= x2 && e.y >= y1 && e.y <= y2);
    }


    public boolean intersects(BoundingBox i) 
    {
        BoundingBox b = this;
        return (b.x2 >= i.x1 && b.y2 >= i.y1 && i.x2 >= b.x1 && i.y2 >= b.y1);
    }

}


