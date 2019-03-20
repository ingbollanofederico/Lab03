package it.polito.tdp.spellchecher.model;

public class RichWord {
	
	private String word;
	private boolean status;
	
	public RichWord(String word, boolean status) {
		this.word = word;
		this.status = status;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
