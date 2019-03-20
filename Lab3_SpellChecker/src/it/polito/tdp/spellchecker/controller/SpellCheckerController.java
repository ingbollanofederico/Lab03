package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ResourceBundle;

import java.util.*;

import it.polito.tdp.spellchecher.model.Dictionary;
import it.polito.tdp.spellchecher.model.RichWord;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class SpellCheckerController {
	
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboLanguage;

    @FXML
    private TextArea txtAreaWrite;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtAreaRead;

    @FXML
    private Text txtErrors;

    @FXML
    private Button btnClearText;

    @FXML
    private Text txtTimes;

    @FXML
    void doClearText(ActionEvent event) {
    	this.model.removeDictionary();
    	this.txtAreaRead.clear();
    	this.txtAreaWrite.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long start = System.nanoTime();

    	int errori=0;
    	
    	String language = comboLanguage.getValue();
    	language= language.toLowerCase();
    	
    	String testoInserito = this.txtAreaWrite.getText();
    	testoInserito=testoInserito.replaceAll("pippo", " ");
    	testoInserito=testoInserito.toLowerCase();
    	
    	List<String> listaParole = new ArrayList<String>();
    	listaParole.addAll(Arrays.asList(testoInserito.split("\\s+")));
    	
    	if(language.compareTo("english")==0 || language.compareTo("italian")==0) {
    		model.loadDictionary(language);
    	
    	
    	List<RichWord> listaParoleFatte = new ArrayList<RichWord>();
    	listaParoleFatte=model.spellCheckText(listaParole);
    	
    	this.txtAreaRead.appendText("Le parole errate sono: ");
    	
    	    	
    	for(RichWord r : listaParoleFatte) {
    		if(r.isStatus()==false) {
    			this.txtAreaRead.appendText("\n"+r.getWord());
    			errori++;
    		}
    	}
    	}
 
    	
    	this.txtErrors.setText("Il numero di parole inserite errate è: "+errori);
    	long finish = System.nanoTime();//VALUTAZIONE DEI TEMPI
    	this.txtTimes.setText("Tempo Impiegato per l'operazione: "+(finish-start)+"\n");
    	
    	
  
    	
    }

    @FXML
    void initialize() {
        assert comboLanguage != null : "fx:id=\"comboLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtAreaWrite != null : "fx:id=\"txtAreaWrite\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtAreaRead != null : "fx:id=\"txtAreaRead\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTimes != null : "fx:id=\"txtTimes\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }

	public void setModel(Dictionary model) {
		this.model=model;
		this.comboLanguage.getItems().addAll("English", "Italian");
	}
	
	
}
