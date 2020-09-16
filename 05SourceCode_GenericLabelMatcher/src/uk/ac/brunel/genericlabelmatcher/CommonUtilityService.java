package uk.ac.brunel.genericlabelmatcher;

import java.util.*;
import uk.ac.brunel.iface.SpellCheckerIF;
import uk.ac.brunel.iface.StemmingAlgorithmIF;

public class CommonUtilityService {
private static ToolConfiguration toolConfiguration=new ToolConfiguration();

    public static String[] processStringArray(String[] arrayStr) {
        String[] processedStringArray = new String[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            processedStringArray[i] = processString(arrayStr[i]);
        }
        return processedStringArray;
    }

    public static String processString(String str1) {
        if (str1 == null) {
            str1 = "";
        }
        //1. Remove ending and traliing spaces and Convert to Lowercase.
        str1 = str1.trim().toLowerCase();
        
        //2. Remove all special character. Special character DOES NOT include the inbetween spaces.
        //ListSpecialCharacters={!,",�,$,%,^,&,*,(,),-,_,+,=,{,},[,],~,#,;,:,@,',<,>,.,?,/,`,�,\,|, ,}
        str1 = processForSpecialCharacter(str1);
        
        //Note: First remove the punctuation words like the, to etc and then remove the inbetween spaecs.
        //Do not do it the other way round.
        //This is because to remove the punctuation words at the very start of the string or at the very end of the string,
        //we need to split the string using the SPACE. And so we need the inbetween spaces for processing the string for
        //punctuation words.
        
                
        //3. Remove the inbetween extra spaces except one.
        str1 = processForInbetweenSpace(str1);

        //4. replace abbreviations with their expanded form
        str1 = processForAbbreviations(str1);
        
        //5. Spell check
        str1 = processForSpellCheck(str1);
        
        //6. Remove all the punctuation symbols.
        //ListPunctuationWords={the,or,and,if,but,is,are,do,did,has,have,been,for,an,at}
        str1 = processForStopwords(str1);
        
        //7. Stemming
        str1 = processForStemming(str1);
        
        return str1;
    }

public static String processForSpellCheck(String s1){
String str1=s1;
    //stemming algorithm
    String[][] spellcheckeralgorithms=toolConfiguration.spellcheckeralgorithms;
    for(int i=0;i<spellcheckeralgorithms.length;i++){
    String active=spellcheckeralgorithms[i][2];
  if(active.equalsIgnoreCase("true")){
	//this is the main active search algorithm  
	  //searchalgorithm[i][3] contains the name of the concrete class
	  
	  //String strNameOfConcreteClass=searchalgorithm[i][3];
          String strNameOfConcreteClass=toolConfiguration.PACKAGE_NAME+spellcheckeralgorithms[i][3];
	  
	   try{
    SpellCheckerIF spellCheckerIF=(SpellCheckerIF)Class.forName(strNameOfConcreteClass).newInstance();		   
    str1=spellCheckerIF.getSpellCheckedText(str1);
    
    }catch(ClassNotFoundException ex){
        System.out.println("Sorry the class [" + strNameOfConcreteClass + "] has not been found. Please either create it or if already created, place " +
                "it in the classpath. ");
        ex.printStackTrace();
    }catch(Exception ex){
        System.out.println("Sorry, other exception");
        ex.printStackTrace();
    }
    
    break;
	  }else{
		  continue;
		  }
    }
return str1;
}

public static String processForStemming(String s1){
    String str1=s1;
    //stemming algorithm
    String[][] stemmingalgorithms=toolConfiguration.stemmingalgorithms;
    for(int i=0;i<stemmingalgorithms.length;i++){
    String active=stemmingalgorithms[i][2];
  if(active.equalsIgnoreCase("true")){
	//this is the main active search algorithm  
	  //searchalgorithm[i][3] contains the name of the concrete class
	  
	  //String strNameOfConcreteClass=searchalgorithm[i][3];
          String strNameOfConcreteClass=toolConfiguration.PACKAGE_NAME+stemmingalgorithms[i][3];
	  
	   try{
    StemmingAlgorithmIF stemmingAlgorithmIF=(StemmingAlgorithmIF)Class.forName(strNameOfConcreteClass).newInstance();		   
    str1=stemmingAlgorithmIF.getStemText(str1);
    
    }catch(ClassNotFoundException ex){
        System.out.println("Sorry the class [" + strNameOfConcreteClass + "] has not been found. Please either create it or if already created, place " +
                "it in the classpath. ");
        ex.printStackTrace();
    }catch(Exception ex){
        System.out.println("Sorry, other exception");
        ex.printStackTrace();
    }
    
    break;
	  }else{
		  continue;
		  }
    }
return str1;
}    
    public static List getSpecialCharacterList() {
        List listSpecialCharacter = new ArrayList();
        String strWordList = ToolConstants.STR_SPECIAL_CHARACTER;
        String strSeparator = ToolConstants.SEPARATER1;

        String[] arrStr1 = strWordList.split(strSeparator);

        for (int i = 0; i < arrStr1.length; i++) {
            listSpecialCharacter.add(arrStr1[i]);
        }
        return listSpecialCharacter;
    }
    
    public static Map<String, String> getAbbreviationAndTheirExpandedForm(){
    Map<String, String> mapAbbreviationAndTheirExpandedForm=new HashMap<String, String>();
    mapAbbreviationAndTheirExpandedForm.put("msg", "message");
    mapAbbreviationAndTheirExpandedForm.put("exp", "expiry");
    
    return mapAbbreviationAndTheirExpandedForm;
    }

        public static String processForAbbreviations(String str1) {
        String str2 = "";
        //for punctuation words
        Map<String, String> mapAbbreviationAndTheirExpandedForm = CommonUtilityService.getAbbreviationAndTheirExpandedForm();
        //List listStr1 = Arrays.asList(str1.split(ToolConstants.SPACE));
        //System.out.println("listStr1.getClass().getName(): ["+listStr1.getClass().getName()+"]");
        //System.out.println("listStr1: ["+listStr1+"]");

        String[] arrString1 = str1.split(ToolConstants.SPACE);
        String[] arrString2= new String[arrString1.length];
        
        for (int i = 0; i < arrString1.length; i++) {
            String key1=arrString1[i];
            System.out.println("*********** [" + key1 + "]    ");
           if(mapAbbreviationAndTheirExpandedForm.containsKey(key1)){
            String expandedForm=mapAbbreviationAndTheirExpandedForm.get(key1);
            //replace will not work because it will replace all
            //str2=str2.replace(key1, expandedForm);
            arrString2[i]=expandedForm;
           }else{
            arrString2[i]=key1;
           }
        }
        
        for (int i = 0; i < arrString2.length; i++) {
            if(str2.equals("")){
                str2=arrString2[i];
            }else{
            str2=str2+ " " + arrString2[i];
            }
        }
        
        return str2;
    }

        
    public static List getPunctuationWordList() {
        List listPunctuationWord = new ArrayList();
        String strWordList = ToolConstants.STR_PUNCTUATION_WORD;
        String strSeparator = ToolConstants.SEPARATER1;

        String[] arrStr1 = strWordList.split(strSeparator);

        for (int i = 0; i < arrStr1.length; i++) {
            listPunctuationWord.add(arrStr1[i]);
        }
        return listPunctuationWord;
    }
    
    //Note: This function in a way removes double or more in between spaces also because the split function
    //by defaut trims each word in the string. So no need to call the function processForInbetweenSpace() after
    //calling this function processForPunctuationWord().
    //public static String processForPunctuationWord(String str1) {
    public static String processForStopwords(String str1) {
        String str2 = "";
        //for punctuation words
        List listPunctuationWord = CommonUtilityService.getPunctuationWordList();
        List listStr1 = Arrays.asList(str1.split(ToolConstants.SPACE));
        //System.out.println("listStr1.getClass().getName(): ["+listStr1.getClass().getName()+"]");
        //System.out.println("listStr1: ["+listStr1+"]");

        List listString1 = new ArrayList();
        String[] arrString1 = str1.split(ToolConstants.SPACE);
        for (int i = 0; i < arrString1.length; i++) {
            listString1.add(arrString1[i]);
        }
        listString1.removeAll(listPunctuationWord);
        for (int i = 0; i < listString1.size(); i++) {
            if (str2.equals("")) {
                str2 = (String) listString1.get(i);
            } else {
                str2 = str2 + " " + (String) listString1.get(i);
            }
        }
        return str2;
    }

    public static String processForSpecialCharacter(String str1) {
        //for special characters
        List listSpecialCharacter = CommonUtilityService.getSpecialCharacterList();
        String strReplacement = ToolConstants.REPLACEMENT_CHARACTER1;
        for (int i = 0; i < listSpecialCharacter.size(); i++) {
            String strSpecialCharacter = (String) listSpecialCharacter.get(i);
            if (str1.contains(strSpecialCharacter)) {
                str1 = str1.replace(strSpecialCharacter, strReplacement);
            }
        }
        return str1;
    }

    //this function removes all the extra inbetween spaces except one.
    public static String processForInbetweenSpace(String inputText) {
        //for Inbetween Spaces
        StringTokenizer line = new StringTokenizer("");
        String outputText = "";

        line = new StringTokenizer(inputText);
        try {
            while (line.hasMoreTokens()) {
                String word = new String();
                word = line.nextToken();
                word = word.trim();
                if (outputText.equals("")) {
                    outputText = word;
                } else {
                    outputText = outputText + " " + word;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputText;

    }

    public static void main(String[] args) {

        //System.out.println("UMLCommonUtilityService.getSpecialCharacterList(): "+CommonUtilityService.getSpecialCharacterList());
        //System.out.println("UMLCommonUtilityService.getPunctuationWordList(): "+CommonUtilityService.getPunctuationWordList());
        //System.out.println("UMLCommonUtilityService.processStringLevel2(): "+CommonUtilityService.processStringLevel2(" SThe * (( tohel the loto na theme to  '\*))\"  "));
        //System.out.println("UMLCommonUtilityService.processStringLevel2(): "+CommonUtilityService.processStringLevel3("invalid audible warning"));

        //System.out.println("UMLCommonUtilityService.processStringLevel2(): ["+CommonUtilityService.processForRemovingEmbeddedSpaces("invalid    audible     warning  ") + "]");

        //System.out.println("UMLCommonUtilityService.processStringLevel2(): " + CommonUtilityService.processString("invalid        audible     warning"));
        
        //System.out.println("UMLCommonUtilityService.processForInbetweenSpace(): " + CommonUtilityService.processForInbetweenSpace("       invalid        audible     warning     "));
        //System.out.println("UMLCommonUtilityService.processForInbetweenSpace(): " + new CommonUtilityService().processString("       invalid        audible     warning     "));
        System.out.println("UMLCommonUtilityService.processForInbetweenSpace(): " + new CommonUtilityService().processForAbbreviations("      msg invalid       msg  audible     expwarning   exp  "));
        
        

    }
}