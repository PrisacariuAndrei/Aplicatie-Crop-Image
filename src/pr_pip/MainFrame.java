package pr_pip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainFrame extends JFrame{

    public JFrame getFrame(){
        return this;
    }

    public void frmInit(){
    	this.setTitle("Annotations App");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

    }

    public void frameResize(RightPanel dsktRight, DesktopPaneLeft dsktLeft){
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (e.getSource() == this) {
                    dsktRight.setBounds(200, 0, getBounds().width-220, getBounds().height-50);
                    dsktLeft.setBounds(0, 0, 200, getBounds().height);
                }
            }});
        this.revalidate();
    }

}
