package edu.bsu.cs120.grids;

import javax.swing.JFrame;
/** The Main class, creates a JFrame to put the gui in, creates an Eden
 * ClusterPanel and puts it on screen.
 * @author Todd J Fleming (uroscion)
 */
public class EdenClusters 
{
        public static void main(String[] args) {
        JFrame frame = new JFrame("TestFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EdenClusterPanel grid = new EdenClusterPanel(51,10);
        frame.getContentPane().add(grid);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}//--End-of-Class---------------------------------------------------------------