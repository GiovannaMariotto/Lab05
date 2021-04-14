package it.polito.tdp.anagrammi.db;

public class TestDAO {

	public static void main(String[] args) {
		AnagrammaDAO anagramma = new AnagrammaDAO();
		anagramma.isCorrect("parola");
		System.out.println(anagramma.isCorrect("parola"));

	}

}
