/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.brunel.genericlabelmatcher;

/**
 *
 * @author ambi
 */
public interface LabelMatcherIF {

//loads the configuration
/*
* STR_PATH_CONFIG_FOLDER : path of the folder contiining the config files
*/
public LabelMatcher getInstance(String STR_PATH_CONFIG_FOLDER);

/* 
 * Note: each element of the array arrayStr1 and arrayStr2 is a single trimmed (no leading and tralining spaces) word with no inbetween spaces.
 * 
 * @return: a two dimensional array, with returnArray[i][0] containing value of the index in arrayStr2 that matches the arrayStr1[i], and
 * returnArray[i][1] containing the corresponding similarity index value. If no matching index is present then returnArray[i][0]=-1 
 * and returnArray[i][1]=-1
 **/    
public String[][] getMatchedStringPairs(String[] arrayStr1, String[] arrayStr2);
}
