package edu.bsu.cs120.grids;
import java.awt.Graphics;
/** Live cells are Red, print they are Live, and return true to isLive().*/
public class LiveCell implements Cell 
{     
	
     public void cellDrawler(Graphics g, int pixelX, int pixelY, int width) 
     {
         g.setColor(java.awt.Color.RED);
         g.fillRect(pixelX, pixelY, width, width); 
     }  
     
     public String toString()
     {
         return "Live Cell";
     }
     
     public boolean isLive()
     {
         return true;
     }
}//--End-of-Class---------------------------------------------------------------