package edu.bsu.cs120.grids;
import java.awt.Point;
/** A simple representation of a point value, (x and y value) in integers.
 * Can check if its equal to another point and can construct itself with point
 * values or another point.
 * 
 * @author Uroscion
 *
 */
public class Points {
    private int x;
    private int y;
    
    public Points()
    {
        this.x = 0;
        this.y = 0;
    }
    
    public Points(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Points(Point point)
    {
        this.x = point.x;
        this.y = point.y;
    }
    
    public String toString()
    {
        return"(" + x + "," + y + ")";
    }
    
    public int x()
    {
        return x;
    }
    
    public int y()
    {
        return y;
    }
    /** Checks whether this point is equal to a given point.
     * 
     * @param somePoint the point to check against.
     * @return true if they are the same, false if not.
     */
    public boolean equals(Points somePoint )
    {
        if(  (this.x == somePoint.x )  && (this.y == somePoint.y )  ) 
            return true;
        else return false;
    }
}
