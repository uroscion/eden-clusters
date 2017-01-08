package edu.bsu.cs120.grids;
import java.util.HashMap;

/** Grid is a hashmap that keeps track of points on the grid and the cells in 
 * them, but has a method to return point values.
 * 
 * @author Uroscion
 *
 */
public class Grid extends HashMap<Points, Cell> 
    {
    static final long serialVersionUID = 0000000001;
    /** Checks that the given point is on the grid.
     * 
     * @param pointToFind the point value to find the cell there.
     * @return returns a point object of the cell's point values.
     */
    public Points getPoint(Points pointToFind)
    {
        for (Points p: this.keySet())
        {
            if (p.x() == pointToFind.x() && p.y() == pointToFind.y())
                return p;
        }
            System.out.println("A random point was made that was not in grid");
                return this.getPoint(new Points(0,0));
    }
    }
