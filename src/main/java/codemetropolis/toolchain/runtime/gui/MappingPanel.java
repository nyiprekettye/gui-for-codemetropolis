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

public class MappingPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = -8972729565063336741L;
	MainGUI mainGUI;
	private JLabel codeMetroloisMappingPath = new JLabel(Labels.mappingPanel_CodeMetropolis_mapping_defaultPath);
	private JButton codeMetroloisMappingBtn = new JButton(Labels.mappingPanel_CodeMetropolis_mapping_btn);
	
	private JButton inputbtn =  new JButton(Labels.mappingPanel_title_inputButton);
	private JLabel inputFilePath = new JLabel(Labels.mappingPanel_title_inputFile_Path);
	private JButton mappingOutputFilePathBtn =  new JButton(Labels.mappingPanel_title_mappingOutputFilePathBtn);
	private JLabel mappingOutputFilePath =  new JLabel(Labels.mappingPanel_title_mappingOutputFilePath_Default);
	private JLabel mappingOutputFileTitle = new JLabel(Labels.mappingPanel_title_renderOutputFileName);
	private JTextField mappingOutputFileName =  new JTextField("mappingToPlacing");
	private JButton mappingFileBtn =  new JButton(Labels.mappingPanel_title_mappingFileBtn);
	private JLabel mappingFilePath =  new JLabel(Labels.mappingPanel_title_mappingFilePath);
	private JButton mappingBtn =  new JButton(Labels.mappingPanel_title_mappingButton);
	
	public MappingPanel(MainGUI mainGUI) {
		this.mainGUI = mainGUI;
		codeMetroloisMappingBtn.addActionListener(this);
		inputbtn.addActionListener(this);
		mappingOutputFilePathBtn.addActionListener(this);
		mappingBtn.addActionListener(this);
		mappingFileBtn.addActionListener(this);
		
		JPanel codeMetropolisMappingPanel =  new JPanel();
		codeMetropolisMappingPanel.setLayout(new BorderLayout());
		codeMetropolisMappingPanel.add(codeMetroloisMappingBtn,BorderLayout.WEST);
		codeMetropolisMappingPanel.add(codeMetroloisMappingPath,BorderLayout.CENTER);
		
		JPanel fileSelectPanel =  new JPanel();
		fileSelectPanel.setLayout(new BorderLayout());
		fileSelectPanel.add(inputbtn,BorderLayout.WEST);
		fileSelectPanel.add(inputFilePath,BorderLayout.CENTER);		

		JPanel outputFileNamePanel = new JPanel();
		outputFileNamePanel.setLayout(new BorderLayout());
		outputFileNamePanel.add(mappingOutputFileTitle,BorderLayout.WEST);
		outputFileNamePanel.add(mappingOutputFileName,BorderLayout.CENTER);
		
		JPanel outputFilePathPanel = new JPanel();
		outputFilePathPanel.setLayout(new BorderLayout());
		outputFilePathPanel.add(mappingOutputFilePathBtn,BorderLayout.WEST);
		outputFilePathPanel.add(mappingOutputFilePath,BorderLayout.CENTER);
		
		JPanel mappingFilePanel = new JPanel();
		mappingFilePanel.setLayout(new BorderLayout());
		mappingFilePanel.add(mappingFileBtn,BorderLayout.WEST);
		mappingFilePanel.add(mappingFilePath,BorderLayout.CENTER);
		
		JPanel mappingStart = new JPanel();
		mappingStart.setLayout(new BorderLayout());
		mappingStart.add(mappingBtn,BorderLayout.EAST);
		
		
		setLayout(new GridLayout(6,1));
		add(codeMetropolisMappingPanel);
		add(fileSelectPanel);
		add(outputFileNamePanel);
		add(outputFilePathPanel);	
		add(mappingFilePanel);
		add(mappingStart);
	}

	public void actionPerformed(ActionEvent event) {
		String actionCommand = event.getActionCommand();		
		System.out.println("A következőt mezőt választota a felhasználó:" + actionCommand);
		
		 if (actionCommand == (Labels.mappingPanel_title_inputButton)) {        			  
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
				fileChooser.setDialogTitle(Labels.MappingPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    inputFilePath.setText(selectedFile.getPath());
				    				    
				}
	      } else if (actionCommand == (Labels.mappingPanel_title_mappingFileBtn)) {        			  
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
				fileChooser.setDialogTitle(Labels.MappingPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    mappingFilePath.setText(selectedFile.getPath());
				    				    
				}
	      } else if (actionCommand == (Labels.mappingPanel_title_mappingOutputFilePathBtn)) {        			  
				JFileChooser directoryChooser = new JFileChooser();
				directoryChooser.setDialogTitle(Labels.mappingPanel_title_JFileChooser_outputDirectory);				
				directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);		
				directoryChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = directoryChooser.showOpenDialog(this);			
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = directoryChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    mappingOutputFilePath.setText(selectedFile.getPath());				    					    
				}
	      }else if (actionCommand == (Labels.mappingPanel_CodeMetropolis_mapping_btn)) {        			  
	    	  JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("jar files (*.jar)", "jar");
				fileChooser.setDialogTitle(Labels.ConvertelPanel_title_JFileChooser);				
				fileChooser.setFileFilter(xmlfilter);				
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int result = fileChooser.showOpenDialog(this);				
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    System.out.println("Selected file: " + selectedFile.getPath());
				    codeMetroloisMappingPath.setText(selectedFile.getPath());
				    				    
				}
	      }if (actionCommand == (Labels.mappingPanel_title_mappingButton)) {   
	    	  mainGUI.getController().startMapping();
	      }
		
	}

	public JLabel getCodeMetroloisMappingPath() {
		return codeMetroloisMappingPath;
	}

	public JLabel getInputFilePath() {
		return inputFilePath;
	}

	public JLabel getMappingOutputFilePath() {
		return mappingOutputFilePath;
	}

	public JTextField getMappingOutputFileName() {
		return mappingOutputFileName;
	}

	public JButton getMappingBtn() {
		return mappingBtn;
	}

	public JLabel getMappingFilePath() {
		return mappingFilePath;
	}
}
