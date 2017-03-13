package codemetropolis.toolchain.runtime.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import codemetropolis.toolchain.runtime.gui.view.Labels;

public class PlacingPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = -5744455611057540917L;
	MainGUI mainGUI;
	private JLabel codeMetroloisPlacingPath = new JLabel(Labels.placingPanel_CodeMetropolis_placing_defaultPath);
	private JButton codeMetroloisPlacingBtn = new JButton(Labels.placingPanel_CodeMetropolis_placing_btn);
	
	private JButton inputbtn =  new JButton(Labels.placingPanel_title_inputButton);
	private JLabel inputFilePath = new JLabel(Labels.placingPanel_title_inputFile_Path);
	private JButton placingOutputFilePathBtn =  new JButton(Labels.placingPanel_title_placingOutputFilePathBtn);
	private JLabel placingOutputFilePath =  new JLabel(Labels.placingPanel_title_placingOutputFilePath_Default);
	private JLabel placingOutputFileTitle = new JLabel(Labels.placingPanel_title_renderOutputFileName);
	private JTextField placingOutputFileName =  new JTextField("placingToRendering");
	private JButton placingBtn =  new JButton(Labels.placingPanel_title_placingButton);
	
	public PlacingPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		codeMetroloisPlacingBtn.addActionListener(this);
		inputbtn.addActionListener(this);
		placingOutputFilePathBtn.addActionListener(this);
		placingBtn.addActionListener(this);
		
		JPanel codeMetropolisplacingPanel =  new JPanel();
		codeMetropolisplacingPanel.setLayout(new BorderLayout());
		codeMetropolisplacingPanel.add(codeMetroloisPlacingBtn,BorderLayout.WEST);
		codeMetropolisplacingPanel.add(codeMetroloisPlacingPath,BorderLayout.CENTER);
		
		JPanel fileSelectPanel =  new JPanel();
		fileSelectPanel.setLayout(new BorderLayout());
		fileSelectPanel.add(inputbtn,BorderLayout.WEST);
		fileSelectPanel.add(inputFilePath,BorderLayout.CENTER);		

		JPanel outputFileNamePanel = new JPanel();
		outputFileNamePanel.setLayout(new BorderLayout());
		outputFileNamePanel.add(placingOutputFileTitle,BorderLayout.WEST);
		outputFileNamePanel.add(placingOutputFileName,BorderLayout.CENTER);
		
		JPanel outputFilePathPanel = new JPanel();
		outputFilePathPanel.setLayout(new BorderLayout());
		outputFilePathPanel.add(placingOutputFilePathBtn,BorderLayout.WEST);
		outputFilePathPanel.add(placingOutputFilePath,BorderLayout.CENTER);
		
		JPanel placingStart = new JPanel();
		placingStart.setLayout(new BorderLayout());
		placingStart.add(placingBtn,BorderLayout.EAST);
		
		
		setLayout(new GridLayout(5,1));
		add(codeMetropolisplacingPanel);
		add(fileSelectPanel);
		add(outputFileNamePanel);
		add(outputFilePathPanel);
		add(placingStart);
	}
	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();		
		System.out.println("A következőt mezőt választota a felhasználó:" + actionCommand);
		
		 if (actionCommand == (Labels.placingPanel_title_inputButton)) {        			  
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
				fileChooser.setDialogTitle(Labels.placingPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    inputFilePath.setText(selectedFile.getPath());
				    				    
				}
	      } else if (actionCommand == (Labels.placingPanel_title_placingOutputFilePathBtn)) {        			  
				JFileChooser directoryChooser = new JFileChooser();
				directoryChooser.setDialogTitle(Labels.placingPanel_title_JFileChooser_outputDirectory);				
				directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);		
				directoryChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = directoryChooser.showOpenDialog(this);			
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = directoryChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    placingOutputFilePath.setText(selectedFile.getPath());				    					    
				}
	      }else if (actionCommand == (Labels.placingPanel_CodeMetropolis_placing_btn)) {        			  
	    	  JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("jar files (*.jar)", "jar");
				fileChooser.setDialogTitle(Labels.placingPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    codeMetroloisPlacingPath.setText(selectedFile.getPath());
				    				    
				}
	      }if (actionCommand == (Labels.placingPanel_title_placingButton)) {   
	    	  mainGUI.getController().startPlacing();
	      }
		
	}
	public JLabel getInputFilePath() {
		return inputFilePath;
	}

	public JLabel getPlacingOutputFilePath() {
		return placingOutputFilePath;
	}

	public JTextField getPlacingOutputFileName() {
		return placingOutputFileName;
	}

	public JButton getPlacingBtn() {
		return placingBtn;
	}

	public JLabel getCodeMetroloisplacingPath() {
		return codeMetroloisPlacingPath;
	}
	
}
