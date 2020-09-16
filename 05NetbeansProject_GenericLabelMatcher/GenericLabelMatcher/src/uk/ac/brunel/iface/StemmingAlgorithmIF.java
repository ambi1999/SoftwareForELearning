/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.brunel.iface;

/**
 *
 * @author ambi
 */
public interface StemmingAlgorithmIF{
    

 /*   
This function takes a single word or a sentence consisting of words separated by single or multiple space. It then returns the stem of each word,	
//inputText can wither be a single word or be a sentence consisting of words separated by single or multiple space
*/
	
public String getStemText(String inputText);
    

}
