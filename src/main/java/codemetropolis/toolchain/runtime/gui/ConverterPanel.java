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

public class ConverterPanel extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 2979856761506651393L;
	MainGUI mainGUI;
	private JLabel codeMetroloisConverterPath = new JLabel(Labels.ConvertelPanel_CodeMetropolis_Converter_defaultPath);
	private JButton codeMetroloisConverterBtn = new JButton(Labels.ConvertelPanel_CodeMetropolis_Converter_btn);
	
	private JButton inputbtn =  new JButton(Labels.ConvertelPanel_title_inputButton);
	private JLabel inputGraphFilePath = new JLabel(Labels.ConvertelPanel_title_inputGraphFile_Path);
	private JButton converterOutputFilePathBtn =  new JButton(Labels.convertelPanel_title_converterOutputFilePathBtn);
	private JLabel converterOutputFilePath =  new JLabel(Labels.convertelPanel_title_converterOutputFilePath_Default);
	private JLabel converterOutputFileTitle = new JLabel(Labels.ConvertelPanel_title_renderOutputFileName);
	private JTextField converterOutputFileName =  new JTextField("converterToMapping");
	private JButton converterBtn =  new JButton(Labels.ConverterPanel_title_ConverterButton);
	
	public ConverterPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI; 
		inputbtn.addActionListener(this);		
		converterBtn.addActionListener(this);
		codeMetroloisConverterBtn.addActionListener(this);
		converterOutputFilePathBtn.addActionListener(this);
		
		JPanel codeMetropolisConverterPanel =  new JPanel();
		codeMetropolisConverterPanel.setLayout(new BorderLayout());
		codeMetropolisConverterPanel.add(codeMetroloisConverterBtn,BorderLayout.WEST);
		codeMetropolisConverterPanel.add(codeMetroloisConverterPath,BorderLayout.CENTER);
		
		JPanel graphFileSelect =  new JPanel();
		graphFileSelect.setLayout(new BorderLayout());
		graphFileSelect.add(inputbtn,BorderLayout.WEST);
		graphFileSelect.add(inputGraphFilePath,BorderLayout.CENTER);
		
		JPanel converterOutputFilePathPanel = new JPanel();
		converterOutputFilePathPanel.setLayout(new BorderLayout());
		converterOutputFilePathPanel.add(converterOutputFilePathBtn,BorderLayout.WEST);
		converterOutputFilePathPanel.add(converterOutputFilePath,BorderLayout.CENTER);
		
		JPanel converterOutputFileNamePanel = new JPanel();
		converterOutputFileNamePanel.setLayout(new BorderLayout());
		converterOutputFileNamePanel.add(converterOutputFileTitle,BorderLayout.WEST);
		converterOutputFileNamePanel.add(converterOutputFileName,BorderLayout.CENTER);
		
		JPanel converterStart = new JPanel();
		converterStart.setLayout(new BorderLayout());
		converterStart.add(converterBtn,BorderLayout.EAST);

		
		setLayout(new GridLayout(5,1));
		add(codeMetropolisConverterPanel);
		add(graphFileSelect);
		add(converterOutputFileNamePanel);
		add(converterOutputFilePathPanel);
		add(converterStart);
	}
	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();		
		System.out.println("A következőt mezőt választota a felhasználó:" + actionCommand);
		
		 if (actionCommand == (Labels.ConvertelPanel_title_inputButton)) {        			  
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("graph files (*.graph)", "graph");
				fileChooser.setDialogTitle(Labels.ConvertelPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    inputGraphFilePath.setText(selectedFile.getPath());
				    				    
				}
	      } else if (actionCommand == (Labels.convertelPanel_title_converterOutputFilePathBtn)) {        			  
				JFileChooser directoryChooser = new JFileChooser();
				directoryChooser.setDialogTitle(Labels.ConvertelPanel_title_JFileChooser_outputDirectory);				
				directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);		
				directoryChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = directoryChooser.showOpenDialog(this);			
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = directoryChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    converterOutputFilePath.setText(selectedFile.getPath());				    					    
				}
	      }else if (actionCommand == (Labels.ConvertelPanel_CodeMetropolis_Converter_btn)) {        			  
	    	  JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("jar files (*.jar)", "jar");
				fileChooser.setDialogTitle(Labels.ConvertelPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    codeMetroloisConverterPath.setText(selectedFile.getPath());
				    				    
				}
	      }if (actionCommand == (Labels.ConverterPanel_title_ConverterButton)) {   
	    	  mainGUI.getController().startConvertel();
	      }
		
	}
	public JLabel getInputGraphFilePath() {
		return inputGraphFilePath;
	}
	public JTextField getConverterOutputFileName() {
		return converterOutputFileName;
	}
	public JButton getConverterBtn() {
		return converterBtn;
	}
	public JLabel getCodeMetroloisConverterPath() {
		return codeMetroloisConverterPath;
	}
	public JLabel getConverterOutputFilePath() {
		return converterOutputFilePath;
	}

}
