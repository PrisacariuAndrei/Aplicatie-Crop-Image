package pr_pip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CropButton extends JButton{

    public CropButton(String s){
        super(s);
    }
    public void cropButtonInit(DesktopPaneLeft dsktPane){

    	this.setBounds((dsktPane.getBounds().width / 2)-30, 180, 120, 30);
        dsktPane.add(this);
    }
	public void CreateCropButton(RightPanel rp) throws IOException{
		
		BufferedImage rgbimage=new BufferedImage(rp.buffer.getWidth(),rp.buffer.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
		ColorConvertOp op = new ColorConvertOp(null);
		op.filter(rp.buffer,rgbimage);
			rp.x *= rp.resizeFactor;
			rp.y *= rp.resizeFactor;
			rp.x2 *= rp.resizeFactor;
			rp.y2 *= rp.resizeFactor;
		if(rp.x2>rp.x && rp.y2<rp.y){
			int result_y=rp.y-rp.y2;
			rp.y-=result_y;
			rp.y2+=result_y;
		}
		if(rp.x>rp.x2 && rp.y>rp.y2 ){
			int result_x=rp.x-rp.x2;
			int result_y=rp.y-rp.y2;
			rp.y-=result_y;
			rp.y2+=result_y;
			rp.x-=result_x;
			rp.x2+=result_x;
		}
		if(rp.x>rp.x2 && rp.y2>rp.y){
			int result_x=rp.x-rp.x2;
			rp.x-=result_x;
			rp.x2+=result_x;
		}
		BufferedImage crp = rgbimage.getSubimage(rp.x,rp.y,rp.x2-rp.x ,rp.y2-rp.y);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		File file = new File("./src/Cropped/" + rp.userChoice);
		file.mkdir();
		File outputfile= new File("./src/Cropped/"+ rp.userChoice + "/" + rp.userChoice + "_" + dtf.format(now) + ".jpg");
		ImageIO.write(crp, "jpg", outputfile);
		JOptionPane.showMessageDialog(rp, "Cropped successfully!");

	}
	public void cropImage(RightPanel rightPanel)
	{
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					if(rightPanel.imageLoaded) {
						CreateCropButton(rightPanel);
					}
					else {
						JOptionPane.showMessageDialog(rightPanel, "Load image first!");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block

				}

			}
		});
	}
}

