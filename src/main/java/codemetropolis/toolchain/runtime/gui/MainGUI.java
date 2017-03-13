package codemetropolis.toolchain.runtime.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import codemetropolis.toolchain.runtime.controller.Controller;
import codemetropolis.toolchain.runtime.gui.view.Labels;

public class MainGUI extends JFrame{

	private static final long serialVersionUID = 12690932794827463L;
	private Controller con;
	private JTabbedPane tabbedPane;
	private JTextArea  console;
	
	private ConverterPanel converterPanel;
	private MappingPanel mappingPanel;
	private PlacingPanel placingPanel;
	private RenderingPanel renderingPanel;

	public MainGUI(Controller controller) {
		con = controller;
		console  =new JTextArea();
		console.setEditable(false);
		JScrollPane scrollConsole = new JScrollPane(console);
		
		converterPanel = new ConverterPanel(this);
		mappingPanel =  new MappingPanel(this);
		placingPanel =  new PlacingPanel(this);
		renderingPanel =  new RenderingPanel();
		initTabbet();
		
		setSize(800,500);
		setLayout(new BorderLayout());	
		
		add(tabbedPane, BorderLayout.NORTH);
		add(scrollConsole,BorderLayout.CENTER);
		
	}

	private void initTabbet() {
		tabbedPane = new JTabbedPane();
		//ImageIcon icon = createImageIcon("images/middle.gif");
		tabbedPane.addTab(Labels.MainGUI_tabbetPane_Title_convertelPanel,converterPanel);
		tabbedPane.addTab(Labels.MainGUI_tabbetPane_Title_mappingPanel,mappingPanel);	
		tabbedPane.addTab(Labels.MainGUI_tabbetPane_Title_placingPanel,placingPanel);	
		//tabbedPane.addTab(Labels.MainGUI_tabbetPane_Title_renderingPanel,renderingPanel);	
		
	}

	public Controller getController() {
		return con;
	}

	public ConverterPanel getConverterPanel() {
		return converterPanel;
	}

	public MappingPanel getMappingPanel() {
		return mappingPanel;
	}

	public PlacingPanel getPlacingPanel() {
		return placingPanel;
	}

	public RenderingPanel getRenderingPanel() {
		return renderingPanel;
	}

	public JTextArea getConsole() {
		return console;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	

}
