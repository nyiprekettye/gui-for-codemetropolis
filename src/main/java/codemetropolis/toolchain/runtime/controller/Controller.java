package codemetropolis.toolchain.runtime.controller;



import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import codemetropolis.toolchain.runtime.gui.MainGUI;

public class Controller {
	MainGUI mainGUI ;
	public Controller() {
		mainGUI =  new MainGUI(this);
		mainGUI.setVisible(true);
	}
	public void startConvertel() {
		String codeMetropolisConverterJar = mainGUI.getConverterPanel().getCodeMetroloisConverterPath().getText();
		String inputGraphFile = mainGUI.getConverterPanel().getInputGraphFilePath().getText();
		String converterOutputFilePath = mainGUI.getConverterPanel().getConverterOutputFilePath().getText();
		String converterOutputFileName=  mainGUI.getConverterPanel().getConverterOutputFileName().getText();
		System.out.println("Indul a konvertálás");
		mainGUI.getConverterPanel().getConverterBtn().setEnabled(false);
		
		String run= "java -jar C:\\codemetropolis_minden\\codemetropolis>codemetropolis-toolchain-converter-1.4.0.jar";
		run="C:\\codemetropolis_minden\\TEST.bat valami";
		
	
	   try {
		   
	        ProcessBuilder pb = new ProcessBuilder("java", "-jar", codeMetropolisConverterJar
	        		,"-i",inputGraphFile
	        		,"-t","sourcemeter"
	        		,"-o",converterOutputFilePath + "\\" + converterOutputFileName + ".xml");	  
	        pb.redirectErrorStream(true);
	        pb.directory(new File("C:\\"));
	       // System.out.println("Directory: " + pb.directory().getAbsolutePath());
	        Process p = pb.start();
	        InputStream is = p.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	        	mainGUI.getConsole().append(line+"\n");
	        }
	        p.waitFor(); 
		
       } catch(Exception e) {
    	   	System.out.println(e.toString());
	   		e.printStackTrace();
       }finally {
    	   	System.out.println("Vége a konvertálásnak");
			mainGUI.getConverterPanel().getConverterBtn().setEnabled(true);
			mainGUI.getTabbedPane().setSelectedIndex(1);
		}
		   

	}
	public void startMapping() {
		String codeMetropolisMappingJar = mainGUI.getMappingPanel().getCodeMetroloisMappingPath().getText();
		String inputFile = mainGUI.getMappingPanel().getInputFilePath().getText();
		String otputFilePath = mainGUI.getMappingPanel().getMappingOutputFilePath().getText();
		String outputFileName=  mainGUI.getMappingPanel().getMappingOutputFileName().getText();
		String mappingFile=  mainGUI.getMappingPanel().getMappingFilePath().getText();
		System.out.println("Indul az Összerakás");
		mainGUI.getMappingPanel().getMappingBtn().setEnabled(false);
	
	   try {
		   
	        ProcessBuilder pb = new ProcessBuilder("java", "-jar", codeMetropolisMappingJar
	        		,"-i",inputFile
	        		,"-m",mappingFile
	        		,"-o",otputFilePath + "\\" + outputFileName + ".xml");	  
	        pb.redirectErrorStream(true);
	        pb.directory(new File("C:\\"));
	       // System.out.println("Directory: " + pb.directory().getAbsolutePath());
	        Process p = pb.start();
	        InputStream is = p.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	        	mainGUI.getConsole().append(line+"\n");
	        }
	        p.waitFor(); 
		
       } catch(Exception e) {
    	   	System.out.println(e.toString());
	   		e.printStackTrace();
       }finally {
    	   	System.out.println("Vége az összerakásnak");
    	   	mainGUI.getMappingPanel().getMappingBtn().setEnabled(true);
			mainGUI.getTabbedPane().setSelectedIndex(2);
		}
	}
	public void startPlacing() {
		String codeMetropolisplacingJar = mainGUI.getPlacingPanel().getCodeMetroloisplacingPath().getText();
		String inputFile = mainGUI.getPlacingPanel().getInputFilePath().getText();
		String otputFilePath = mainGUI.getPlacingPanel().getPlacingOutputFilePath().getText();
		String outputFileName=  mainGUI.getPlacingPanel().getPlacingOutputFileName().getText();		
		System.out.println("Indul az Összerakás");
		mainGUI.getPlacingPanel().getPlacingBtn().setEnabled(false);
	
	   try {
		   
	        ProcessBuilder pb = new ProcessBuilder("java", "-jar", codeMetropolisplacingJar
	        		,"-i",inputFile
	        		,"-o",otputFilePath + "\\" + outputFileName + ".xml");	  
	        pb.redirectErrorStream(true);
	        pb.directory(new File("C:\\"));
	       // System.out.println("Directory: " + pb.directory().getAbsolutePath());
	        Process p = pb.start();
	        InputStream is = p.getInputStream();
	        BufferedReader br = new BufferedReader(new InputStreamReader(is));
	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	        	mainGUI.getConsole().append(line+"\n");
	        }
	        p.waitFor(); 
		
       } catch(Exception e) {
    	   	System.out.println(e.toString());
	   		e.printStackTrace();
       }finally {
    	   	System.out.println("Vége az összerakásnak");
    	   	mainGUI.getPlacingPanel().getPlacingBtn().setEnabled(true);
			//mainGUI.getTabbedPane().setSelectedIndex(3);
		}
	}

}
