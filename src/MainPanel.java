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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainPanel extends JPanel implements MouseMotionListener, ActionListener, ChangeListener{
    private Color currColor;
    private int thickness;
    private LeftOptionPanel leftOptionPanel;
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private ArrayList<Color> color;
    private ArrayList<Integer> thick;

     public MainPanel(){
        x = new ArrayList<>();
        y = new ArrayList<>();
        color = new ArrayList<>();
        thick = new ArrayList<>();
        
        leftOptionPanel = new LeftOptionPanel();
        
        BorderLayout border = new BorderLayout();
        setLayout(border);
        add(leftOptionPanel, BorderLayout.NORTH);
        
        currColor = Color.BLACK;
        thickness = 5;
        
        leftOptionPanel.getBlue().addActionListener(this);
        leftOptionPanel.getRed().addActionListener(this);
        leftOptionPanel.getBlack().addActionListener(this);
        leftOptionPanel.getEraser().addActionListener(this);
        leftOptionPanel.getThick().addChangeListener(this);
        
        addMouseMotionListener(this);
        setBackground(Color.white);
        
    }
     
    @Override
    public void actionPerformed(ActionEvent w){
        JButton eventSource = (JButton)w.getSource();
        if (eventSource == leftOptionPanel.getBlue()){
            currColor = Color.BLUE;
        }
        if (eventSource == leftOptionPanel.getRed()){
            currColor = Color.RED;
        }
        if (eventSource == leftOptionPanel.getBlack()){
            currColor = Color.BLACK;
        }
        if (eventSource == leftOptionPanel.getEraser()){
            currColor = Color.WHITE;
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(currColor);
        g.fillRect(e.getX(), e.getY(), thickness, thickness);
        x.add(e.getX());
        y.add(e.getY());
        color.add(currColor);
        thick.add(thickness);
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        JSlider eventSource = (JSlider)ce.getSource();
        thickness = eventSource.getValue();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0; i < x.size();i++){
            g.setColor(color.get(i));
            g.fillRect(x.get(i), y.get(i), thick.get(i), thick.get(i));
        }
        
    }

}
