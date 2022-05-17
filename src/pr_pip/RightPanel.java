package pr_pip;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RightPanel extends JPanel{
    public Image img;
    public JLabel label;
    public String userChoice = "";
    public BufferedImage buffer;
    boolean weightResized = false;
    boolean heightResized = false;
    double resizeFactor;
    boolean imageLoaded=false;
    public int x, y, x2, y2;


    RightPanel(){
        x = y = x2 = y2 = 0;
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }


    public void rightPanelInit(MainFrame frm){
        label = new JLabel();
        label.setBounds(200, 0, frm.getBounds().width-230, frm.getBounds().height-50);
        this.setBounds(200, 0, frm.getBounds().width-200, frm.getBounds().height);
        frm.getContentPane().add(this);
        frm.getContentPane().add(label);
    }

    public void setStartPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setEndPoint(int x, int y) {
        x2 = (x);
        y2 = (y);
        if(x2>this.getWidth()){
            x2=this.getWidth();
        }
        if(y2>this.getHeight()){
            y2=this.getHeight();
        }
    }

    public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
        int px = Math.min(x,x2);
        int py = Math.min(y,y2);
        int pw=Math.abs(x-x2);
        int ph=Math.abs(y-y2);
        g.drawRect(px, py, pw, ph);
    }

    class MyMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            setStartPoint(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }

        public void mouseReleased(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }
    }

    public void getUserChoice(DrawButton btn){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userChoice = btn.getSelectedItem().toString();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        if (this.imageLoaded) {
            Graphics2D g = (Graphics2D) g2;
            g.setStroke(new BasicStroke(3));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

            switch (userChoice) {
                case "-":
                case "+ADD Option":
                    break;
                case "Car":
                    g.setColor(Color.RED);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
                case "Traffic Light":
                    g.setColor(Color.YELLOW);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
                case "Road Sign":
                    g.setColor(Color.GREEN);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
                case "Building":
                    g.setColor(Color.BLUE);
                    drawPerfectRect(g, x, y, x2, y2);
                    break;
            }


        }

    }
}
