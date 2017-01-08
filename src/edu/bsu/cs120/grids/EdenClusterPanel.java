package edu.bsu.cs120.grids;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
/** GridPanel is a JPanel that draws the gridPanel to the screen, 
 * draws the cells, and the button.
 * @author Uroscion
 *
 */
public class EdenClusterPanel extends JPanel 
{
    static final long serialVersionUID = 0000000001;
    private GridPanel gridPanel;
    
    private Points seedCellPoint;
    /** Constructor, sets a seed cell at 0,0 and then draws the rest of the
     * panel.
     * 
     * @param gridSize
     * @param cellSize
     */
    public EdenClusterPanel(int gridSize, int cellSize) 
    {
      //create the random starting x and y (in point values, not pixels) for the
      //seed cell
      this.seedCellPoint = new Points(0,0);
      
      //here is code for making the seedcell start place random;      
      //this.seedCellX = (int)(Math.random()*(2*(gridSize/2)+ 1)) + -gridSize/2;  
      //this.seedCellY = (int)(Math.random()*(2*(gridSize/2)+ 1)) + -gridSize/2; 
      
      // create the grid panel
      gridPanel = new GridPanel(gridSize,gridSize,cellSize);
      
      //add the seed cell to the Grid in gridPanel
      gridPanel.setCellAt(seedCellPoint.x(), seedCellPoint.y(), new LiveCell());
      
      // put the grid panel in this panel
      this.add(gridPanel);
      
      //print out the debug list.
      gridPanel.printDebug();
      
      //ADD THE BUTTON AND ACTIONLISTENER
      JButton growButton = new JButton("Grow!");  
      ActionListener growListener = new GrowListener();
      growButton.addActionListener(growListener);
      this.add(growButton);
      
    }
    
    /** Create a new cell attached to the present cells. Find the cells that 
     * are currently live by what's in the grid map.
     */
    public void grow()
    {
        Grid theGrid = gridPanel.getGrid();
        
        for (Points p: theGrid.keySet())
        {
            if (theGrid.get(p).isLive())
            {
                for (int i = 1; i <=8; i++)
                {
                int randX = (int)(Math.random()*3) + -1;
                int randY = (int)(Math.random()*3) + -1;
                Points nextCell = new Points(p.x() + randX,p.y() + randY);
                
                //if the cell next door is not live, don't draw this,
                //if the cell is not live, make this cell.
                if (!theGrid.get(theGrid.getPoint(nextCell)).isLive())
                {
                 gridPanel.setCellAt(nextCell.x(),nextCell.y(), new LiveCell());
                 //the cell is added, call repaint.
                 this.repaint();
                 return;
                }
                
                }
            }   
        }  
    }
    
//--Inner-Class-GrowListner--Action-Listener-for-GrowButton---------------------    
private class GrowListener implements ActionListener
{
	/** This actionlistener for the button, calls the grow method.*/
        public void actionPerformed(ActionEvent e)
        {
            grow();
        }
}//--End-of-Inner-Class---------------------------------------------------------

}/*--End-of-Class-------------------------------------------------------------*/