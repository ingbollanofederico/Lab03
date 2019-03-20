package it.polito.tdp.spellchecher.model;
import java.util.*;
import java.io.*;

public class Dictionary {
	
	private Map<String,Boolean> dictionary; 
	
	
	public Dictionary() {
		this.dictionary= new TreeMap<String,Boolean>();
	}


	/**
	 * Controlla parola per parola se è corretta o meno e l'aggiunge alla lista delle parole controllate
	 * @param inputTextList lista parole in input
	 * @return lista parole controllate con valori true o false
	 */
	public List<RichWord> spellCheckText (List<String> inputTextList){ //**** creare lista parole
		List<RichWord> list = new ArrayList<RichWord>();
		
		
		for(String s : inputTextList) {
		
		if(this.dictionary.containsKey(s)) {
			RichWord r = new RichWord(s,true);
			list.add(r);
		}else {
			RichWord r= new RichWord(s,false);
			list.add(r);
		}
		

		}
		
		return list;
	}
	

	  

	  /**
	   * Lettura da file
	   * @param language desiderata di lettura
	   */
	public void loadDictionary(String language){ //**** dizionario in controller
	    	try {
	    	BufferedReader in = new BufferedReader(new FileReader("rsc/"+language+".txt"));
			String word;
			
			while((word = in.readLine()) != null) {
					
				this.dictionary.put(word, true);
					
			}
			in.close();
			
	    	} catch (IOException e) {
	    		System.out.println("Errore nella lettura del file");	
	    	}
	  }
	    	
	    
	public void removeDictionary() {
		this.dictionary.clear();
	}


}
