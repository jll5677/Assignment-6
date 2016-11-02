
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jll5677
 */
public class LeftOptionPanel extends JPanel{
    private JButton blueButton;
    private JButton redButton;
    private JButton blackButton;
    private JButton eraserButton;
    private JSlider thick;

    
    public LeftOptionPanel(){
        GridLayout grid = new GridLayout(2,1);
        setLayout(grid);
        
        blueButton = new JButton("Blue");
        add(blueButton);
        
        redButton = new JButton("Red");
        add(redButton);
        
        blackButton = new JButton("Black");
        add(blackButton);
        
        eraserButton = new JButton("Eraser");
        add(eraserButton);
        
        thick = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
        thick.setMajorTickSpacing(1);
        thick.setPaintTicks(true);
        thick.setPaintLabels(true);
        add(thick);
        
    }
    
    public JButton getBlue(){
        return blueButton;
    }
    
    public JButton getRed(){
        return redButton;
    }
    
    public JButton getBlack(){
        return blackButton;
    }
    
    public JButton getEraser(){
        return eraserButton;
    }
    
    public JSlider getThick(){
        return thick;
    }
    
}
