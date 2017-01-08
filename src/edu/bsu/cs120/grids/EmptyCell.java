package edu.bsu.cs120.grids;
import java.awt.Graphics;
/** Empty cells are grey, print they are empty, and return false to isLive().*/
public class EmptyCell implements Cell 
{

    public void cellDrawler(Graphics g, int pixelX, int pixelY, int width) 
    {
        g.setColor(java.awt.Color.gray);
        g.fillRect(pixelX, pixelY, width, width); 
    }  
    
    public String toString()
    {
        return"Empty Cell";
    }
    public boolean isLive()
    {
        return false;
    }
}
