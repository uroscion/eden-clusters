package edu.bsu.cs120.grids;

import java.awt.Graphics;

/** Interface Cell defines that a cell class should be able to draw itself,
 * have a toString method and tell whether it is a alive or not.
 * 
 * @author Uroscion
 *
 */
public interface Cell 
{
    public void cellDrawler(Graphics g, int pixelX, int pixelY, int width);
    public String toString();
    public boolean isLive();
    
}
