package pr_pip;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.io.File;

public class DesktopPaneLeft extends JDesktopPane{

    public void desktopPaneLeftInit(MainFrame frm){
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0, 0, 200, frm.getBounds().height);
        frm.getContentPane().add(this);
    }
    
    public void addIcons(){
        try {
            Image drawImage = ImageIO.read(new File("./src/images/drawIcon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon drawIcon = new ImageIcon(drawImage);

            Image addImage = ImageIO.read(new File("./src/images/plusSign.png")).getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            ImageIcon addIcon = new ImageIcon(addImage);
            
            Image cropImage = ImageIO.read(new File("./src/images/cropIcon.png")).getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon cropIcon = new ImageIcon(cropImage);


            JLabel drawLabel = new JLabel();
            drawLabel.setBounds((this.getBounds().width / 2) - (120 / 2) - 19, 87, 50, 50);
            drawLabel.setIcon(drawIcon);

            JLabel addLabel = new JLabel();
            addLabel.setBounds((this.getBounds().width / 2) - (120 / 2) - 17, 12, 50, 50);
            addLabel.setIcon(addIcon);
            
            JLabel cropLabel = new JLabel();
            cropLabel.setBounds((this.getBounds().width / 2) - (120 / 2) - 23, 170, 50, 50);
            cropLabel.setIcon(cropIcon);

            this.add(drawLabel);
            this.add(addLabel);
            this.add(cropLabel);
            
        }
        catch(Exception e){}
    }

}
