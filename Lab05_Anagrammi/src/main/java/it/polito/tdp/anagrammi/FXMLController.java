package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtparola;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private TextArea txtCorreti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	this.txtCorreti.clear();
    	this.txtErrati.clear();
    	this.txtCorreti.setDisable(false);
    	this.txtErrati.setDisable(false);
    	
    	String s = this.txtparola.getText();
    	if(s.contains("1")||s.contains("2")||s.contains("3")||s.contains("4")||s.contains("5")||s.contains("6")||s.contains("7")||s.contains("8")||s.contains("9")||s.contains("0")) {
    		this.txtErrati.setText("Parola non valida");
    		this.txtCorreti.setText("Parola non valida");
    	}
    	
    	Set<String> anagrammi=this.m.ricorsione(s);
    	for(String str : anagrammi) {
    		boolean correto= this.m.isCorrect(str);
    		if(correto==true) {
    			txtCorreti.setText(str);
    		}else if (correto==false) {
    			txtErrati.setText(str);
    		}
    	}
    	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtCorreti.clear();
    	this.txtErrati.clear();
    	this.txtparola.clear();
    	this.txtCorreti.setDisable(true);
    	this.txtErrati.setDisable(true);
    }

    @FXML
    void initialize() {
        assert txtparola != null : "fx:id=\"txtparola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorreti != null : "fx:id=\"txtCorreti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    Model m;
    public void setModel(Model model) {
    	this.m=model;
    }
    
}

	
	
	
