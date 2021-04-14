package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	public Model() {
		
	}
	

	//Fare ricorsione di anagrammi
	//livello=numero di lettere già messe
	
	Set<String> anagrammi; //senza duplicati
	AnagrammaDAO a = new AnagrammaDAO();
	
	public Set<String> ricorsione(String parola) {
		List<String> risultato = new ArrayList<>() ;
		permuta("", parola, 0, risultato) ;
		anagrammi=new HashSet(risultato);
		return anagrammi;
		
		
	}
	
	
	public void permuta(String parziale, String lettere, int livello, List<String> risultato ){
		if(lettere.length()==0) {
			risultato.add(parziale);
		} else {
			for(int pos=0; pos<lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos) ; 
				String nuovaParziale = parziale + tentativo ;
				String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;
				
			}
			
		}
		
	
		
	}
	
	
	public boolean isCorrect(String parola) {
		return this.a.isCorrect(parola);	
	}
	
	
}
