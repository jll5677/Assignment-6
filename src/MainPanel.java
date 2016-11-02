/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jll5677
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements MouseMotionListener, ActionListener{
    private Color currColor;
    private int thickness;
    private LeftOptionPanel leftOptionPanel;
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;

     public MainPanel(){
         
        leftOptionPanel = new LeftOptionPanel();
        
        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(leftOptionPanel, BorderLayout.NORTH);
        
        leftOptionPanel.getBlue().addActionListener(this);
        leftOptionPanel.getRed().addActionListener(this);
        leftOptionPanel.getBlack().addActionListener(this);
        leftOptionPanel.getEraser().addActionListener(this);

        addMouseMotionListener(this);
        setBackground(Color.white);
        

    }
     
    @Override
    public void actionPerformed(ActionEvent w){
        JButton eventSource = (JButton)w.getSource();
        if (eventSource == leftOptionPanel.getBlue()){
            currColor = Color.BLUE;
            thickness = leftOptionPanel.getThick().getValue();
        }
        if (eventSource == leftOptionPanel.getRed()){
            currColor = Color.RED;
            thickness = leftOptionPanel.getThick().getValue();
        }
        if (eventSource == leftOptionPanel.getBlack()){
            currColor = Color.BLACK;
            thickness = leftOptionPanel.getThick().getValue();
        }
        if (eventSource == leftOptionPanel.getEraser()){
            currColor = Color.WHITE;
            thickness = leftOptionPanel.getThick().getValue();
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(currColor);
        g.fillRect(e.getX(), e.getY(), thickness, thickness);
        
        x = new ArrayList<>();
        for(int i=0;i< x.size();i++)
        {
            x.add(e.getX());
        }
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
    }
    
    
}
