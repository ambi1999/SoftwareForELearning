package uk.ac.brunel.iface;

public interface SpellCheckerIF{

/*
 * This fucntion returns true if word has been misspelled otherwise false.
 **/
public boolean isMisspelled(String strWord);
	
/*
 * This function takes a single word or a sentence consisting of words separated by single or multiple space. 
 * It then returns the autocottected version of each word,	
 * This fucntion returns the first suggested word by the spell checker. 
 * Incase the word in not spelled incorrectly then this function returns the same word
 **/
 public String getSpellCheckedText(String strWord);

 /*
  * * This function takes an array of single words.
 * It then returns an array the autocottected version of each word,	
 * This fucntion returns the first suggested word by the spell checker. Incase the word in not spelled incorrectly then this function returns the same word
 **/
 public String[] getSpellCheckedText(String[] strWord);
	
}

