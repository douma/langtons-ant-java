package com.douma.langtonsant;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame f=new JFrame();
        f.add(new PixelCanvas());
        f.getContentPane().setBackground(Color.black);

        f.setSize(500,500);
        f.setVisible(true);
        f.setResizable(false);
    }
}

class PixelCanvas extends Canvas {
    @Override
    public void paint(Graphics g)  {
        super.paint(g);

        try
        {
            Ant ant = new Ant(new Position(430,430), new TurnDegree(0));
            Board board = new Board(ant,32000);
            board.moveAnt();

            g.setColor(new Color(255, 255, 255));

            for(Position position : board.markedPositions()) {
                g.drawLine(position.x(), position.y(), position.x(), position.y());

                super.repaint();
                Thread.sleep(5);
            }
        }
        catch(Exception e){}
    }
}
