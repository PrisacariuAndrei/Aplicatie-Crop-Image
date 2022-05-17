package pr_pip;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class DrawButton extends JComboBox{

    public DrawButton(String[] s){
        super(s);
    }

    public void drawButtonInit(DesktopPaneLeft dsktPane){
        this.setBounds((dsktPane.getBounds().width / 2)-30, 100, 120, 30);
        dsktPane.add(this);
    }
 
}
