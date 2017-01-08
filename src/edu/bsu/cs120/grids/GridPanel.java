package edu.bsu.cs120.grids;
import javax.swing.JPanel;
import java.awt.Graphics;
/** GridPanel is a JPanel that draws the grid to the screen, in which the cells
 * are drawn.
 * @author Uroscion
 */
public class GridPanel extends JPanel 
{
    static final long serialVersionUID = 00001;
    private int column; 
    private int row; 
    private int cellSize;
    private Grid grid;
    private int panelX;
    private int panelY;
    
    /** Constructor, take the number of rows, columns and cell size and compute
     * the size of rows and columns in the grid.
     * 
     * @param column number of columns to draw.
     * @param row the number of rows to draw.
     * @param cellSize the size of each cell space.
     */
    public GridPanel(int column, int row, int cellSize) 
    {
        this.column = column;
        this.row = row;
        this.cellSize = cellSize;
        panelX = ((column * cellSize)+(column - 1));
        panelY = ((row * cellSize)+(row - 1));
        setPreferredSize(new java.awt.Dimension(panelX+5,panelY+5));
        
        //create a grid hashmap to keep track of the points on the grid
        grid = new Grid();
        
        //compute the point locations of the corners of the grid cells and put
        //those points into the grid (Map).
        for (int i=0; i< row; i++)
        {
          for (int j=0; j< column; j++)
          {
            grid.put(new Points((row/2-i),(column/2-j)), 
                    new EmptyCell());
          }
        }  
    }
    
    /** Draws the gridlines on the panel. Then draws the cells.
     * 
     */
    public void paintComponent(Graphics g) 
    {
       g.setColor(java.awt.Color.RED);
       int lineX = 0; 
       for (int i = 1; i<= column + 1; i++)
       {
           g.drawLine(lineX, 0, lineX ,panelY + 1);
           lineX += cellSize + 1;
       }
       int lineY = 0; 
       for (int i = 1; i<= row + 1; i++)
        {
            g.drawLine(0, lineY, panelX + 1,lineY);
            lineY += cellSize + 1;
        }
          
        for (Points p: grid.keySet())
        {
            Cell c = grid.get(p);        
            c.cellDrawler(g, computeX(p), computeY(p), cellSize);   
        }    
    }
    
    /** Prints out a list of every cell in the grid to check the points.*/
    public void printDebug()
    {
            System.out.println("All the points and corresponding cells");
            for (Points p: grid.keySet())
            {
                Cell c = grid.get(p);
                System.out.println(p.toString() + " -> " + c.toString());
            }
    }
    
    /** Takes a point and if that point is on the grid, puts a cell there.
     * 
     * @param x
     * @param y
     * @param cell
     */
    public void setCellAt(int x, int y, Cell cell)
    {
        Points newPoint = new Points(x,y);
        if (cell != null)
        {
          for (Points p: grid.keySet())
          {
           if(p.equals(newPoint))
           {
            grid.put(p, cell);
            return;
           }
          }
        }
        else System.err.println("The Cell was Null");
        
        System.out.println("That Point is Not in the Grid");  
    }
    
    /**Does the math to get a pixel X value from a point.*/
    public int computeX(Points p)
    {
        int pointX = p.x();
        return (pointX + column/2) * cellSize + (pointX + column/2 +1);   
    }
    
    /**Does the math to get a pixel Y value from a point.*/
    public int computeY(Points p)
    {
        int pointY = p.y();
        return (-pointY + row/2) * cellSize + (-pointY + row/2 + 1);
    }
    
    /**Returns this GridPanel's Grid.*/
    public Grid getGrid()
    {
        return grid;
    }
}