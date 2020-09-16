/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.brunel.genericlabelmatcher;

import java.io.File;

/**
 *
 * @author ambi
 */
public class ToolConfiguration{

public static boolean casesensitive=true;
public static boolean trimming=true;

//global settings
public static boolean useSpecialcharacterxml=true;
public static boolean useStopwordxml=true;
public static boolean useAbbreviationxml=true;
public static boolean useSpellcheckeralgorithm=true;
public static boolean useStemmer=true;
public static boolean useSynonymxml=true;


public static String specialcharacterxml="";
public static String stopwordxml="";
public static String abbreviationxml="";
public static String spellcheckeralgorithm="";
public static String stemmer="";
public static String synonymxml="";

public static double threshold=0.0;

/*<!--The value attribute of the packagename tag defines the package for all the concrete classes-->
<packagename value="uk.ac.brunel.concreteclasses"></packagename>
 */
public static String PACKAGE_NAME="";
//Note: The path strPathEnglishDictionary should contain two files named en_GB.dic and en_GB.aff
//String strEnglishDictionaryBaseFileName="C:/01Am/01_Res EAss/04-Tools/Spell Checker/Dictionaries/en_GB/en_GB";
//String strEnglishDictionaryBaseFileName="/media/My Passport/01MYRES/01Am/01_Res EAss/02-Work/04-Tools/Spell Checker/Dictionaries/en_GB/en_GB";
//String strEnglishDictionaryBaseFileName="/home/ambi/01MYRES/01Am/01_Res EAss/02-Work/04-Tools/Spell Checker/Dictionaries/en_GB/en_GB";
//public static String strEnglishDictionaryBaseFileName="/home/ambi/01MYRES/02SwDev/0001_BEAS/01_SOFTWARE/02BrunelLabelMatcher/BrunelMatcher/resources/Dictionaries/en_GB/en_GB";
//public static String strEnglishDictionaryBaseFileName="resources/Dictionaries/en_GB/en_GB";
//public static String strEnglishDictionaryBaseFileName="resources"+File.separator+"Dictionaries/en_GB/en_GB";
public static String strEnglishDictionaryBaseFileName="resources"+File.separator+"Dictionaries"+File.separator+"en_GB"+File.separator+"en_GB";
    
//="ExactMatchSyntaxAlgorithm" id="ExactMatchSyntaxAlgorithm" active="true" weight="0.1" concreteclass
//two dimensional array syntaxalgorithms[i][0]=name, syntaxalgorithms[i][1]=id, syntaxalgorithms[i][2]=active, syntaxalgorithms[i][3]=concreteclass, 
//syntaxalgorithms[i][4]=weight
public static String[][] syntaxalgorithms=null;

//searchalgorithm[0][0]=name, searchalgorithm[0][1]=id, searchalgorithm[0][2]=active,searchalgorithm[0][3]=concreteclass
public static String[][] searchalgorithm=null;

public static String[][] spellcheckeralgorithms=null;

public static String[][] stemmingalgorithms=null;

public ToolConfiguration(){
test();
}

public void test(){

PACKAGE_NAME="uk.ac.brunel.concreteclasses.";

casesensitive=true;
trimming=true;

specialcharacterxml="";
stopwordxml="";
abbreviationxml="";
spellcheckeralgorithm="";
String stemmer="";
String synonymxml="";

//="ExactMatchSyntaxAlgorithm" id="ExactMatchSyntaxAlgorithm" active="true" weight="0.1" concreteclass
//two dimensional array syntaxalgorithms[i][0]=name, syntaxalgorithms[i][1]=id, syntaxalgorithms[i][2]=active, syntaxalgorithms[i][3]=concreteclass, 
//syntaxalgorithms[i][4]=weight
//syntaxalgorithms=null;


//String[][] syntaxalgorithms={{"ExactMatchSyntaxAlgorithm","ExactMatchSyntaxAlgorithm","true","ExactMatchSyntaxAlgorithm","1"},
//{"SoundexSyntaxAlgorithm","SoundexSyntaxAlgorithm","true","SoundexSyntaxAlgorithm","1"}};
String[][] syntaxalgorithms={{"ExactMatchSyntaxAlgorithm","ExactMatchSyntaxAlgorithm","true","ExactMatchSyntaxAlgorithm","1"},
{"EditDistanceSyntaxAlgorithm","EditDistanceSyntaxAlgorithm","true","EditDistanceSyntaxAlgorithm","1"},
{"QGramDistanceSyntaxAlgorithm","QGramDistanceSyntaxAlgorithm","true","QGramDistanceSyntaxAlgorithm","1"},
{"SimonWhiteSyntaxAlgorithm","SimonWhiteSyntaxAlgorithm","true","SimonWhiteSyntaxAlgorithm","1"},
{"SoundexSyntaxAlgorithm","SoundexSyntaxAlgorithm","true","SoundexSyntaxAlgorithm","1"}};
this.syntaxalgorithms=syntaxalgorithms;

//searchalgorithm[0][0]=name, searchalgorithm[0][1]=id, searchalgorithm[0][2]=active,searchalgorithm[0][3]=concreteclass
//searchalgorithm=null;
String[][] searchalgorithm={{"MaxSearchAlgorithm","MaxSearchAlgorithm","true","MaxSearchAlgorithm"}};
this.searchalgorithm=searchalgorithm;

//two dimensional array stemmingalgorithms[i][0]=name, stemmingalgorithms[i][1]=id, stemmingalgorithms[i][2]=active, stemmingalgorithms[i][3]=concreteclass
String[][] spellcheckeralgorithms={{"HunspellSpellChecker","HunspellSpellChecker","true","HunspellSpellChecker"}};
this.spellcheckeralgorithms=spellcheckeralgorithms;
        
//two dimensional array stemmingalgorithms[i][0]=name, stemmingalgorithms[i][1]=id, stemmingalgorithms[i][2]=active, stemmingalgorithms[i][3]=concreteclass
String[][] stemmingalgorithms={{"PaiceStemmingAlgorithm","PaiceStemmingAlgorithm","true","PaiceStemmingAlgorithm"}};
this.stemmingalgorithms=stemmingalgorithms;
        
threshold=0.6;

}

}
