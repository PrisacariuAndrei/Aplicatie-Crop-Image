package pr_pip;

import java.awt.*;


public class GUI {
	private String[] choiceList = {"-","Car","Traffic Light","Road Sign","Building","+ADD Option"};

	private MainFrame mainFrame = new MainFrame();
	private DesktopPaneLeft paneLeft = new DesktopPaneLeft();
	private RightPanel rightPanel = new RightPanel();
	private AddButton addButton = new AddButton("ADD IMAGE");
	private DrawButton drawButton = new DrawButton(choiceList);
	private CropButton cropButton = new CropButton("CROP IMAGE");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame.frmInit();
		rightPanel.rightPanelInit(mainFrame);
		paneLeft.desktopPaneLeftInit(mainFrame);
		addButton.addButtonInit(paneLeft);
		drawButton.drawButtonInit(paneLeft);
		cropButton.cropButtonInit(paneLeft);
		
		
		mainFrame.frameResize(rightPanel, paneLeft);

		paneLeft.addIcons();
		
		addButton.loadImage(rightPanel, mainFrame);
		cropButton.cropImage(rightPanel);
		rightPanel.getUserChoice(drawButton);
		
	}
}
