/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.brunel.genericlabelmatcher;

import uk.ac.brunel.iface.SearchAlgorithmIF;
import uk.ac.brunel.iface.SyntaxAlgorithmIF;
import java.util.Arrays;

/**
 *
 * @author ambi
 */
//public class LabelMatcher implements LabelMatcherIF{
public class LabelMatcher{

private static ToolConfiguration toolConfiguration=null;
private static LabelMatcher labelMatcher=null;

private LabelMatcher(){
    toolConfiguration=new ToolConfiguration();
}

public static LabelMatcher getInstance(String STR_PATH_CONFIG_FOLDER){

if(labelMatcher==null){
labelMatcher=new LabelMatcher();
}
loadConfiguration(STR_PATH_CONFIG_FOLDER);
return labelMatcher;

}

//loads the configuration
/*
* STR_PATH_CONFIG_FOLDER : path of the folder contiining the config files
*/
private static void loadConfiguration(String STR_PATH_CONFIG_FOLDER){
toolConfiguration=new ToolConfiguration();
}

//public String[][] getMatchedStringPairs(String[] arrayStr1, String[] arrayStr2){
//	return null;
//	}

/* 
 * Note: each element of the array arrayStr1 and arrayStr2 is a single trimmed (no leading and tralining spaces) word with no inbetween spaces.
 * 
 * @return: a two dimensional array, with returnArray[i][0] containing value of the index in arrayStr1, returnArray[i][1] containing value of the index in arrayStr2 that matches the arrayStr1[i], and
 * returnArray[i][2] containing the corresponding similarity index value. If no matching index is present then returnArray[i][1]=-1 ,returnArray[i][2]=-1
 * and returnArray[i][1]=-1
 **/    
public double[][] getDetailsOfMatchedStringsFromSecondArray(String[] arrayStr1, String[] arrayStr2){
	double[][] arrayDetailsOfMatchedStringsFromSecondArray=new double[arrayStr1.length][];
	
	String[] processedArrayStr1=CommonUtilityService.processStringArray(arrayStr1);
	String[] processedArrayStr2=CommonUtilityService.processStringArray(arrayStr2);
	
	double[][] arraySimilarityIndex=new double[processedArrayStr1.length][processedArrayStr2.length];
        for(int i=0;i<arraySimilarityIndex.length;i++){
            for(int j=0;j<arraySimilarityIndex[i].length;j++){
            arraySimilarityIndex[i][j]=getSyntaxSimilarityIndex(processedArrayStr1[i],processedArrayStr2[j]);
            }
        }
        
        System.out.println("*********** " + Arrays.deepToString(arraySimilarityIndex));
        double threshold=toolConfiguration.threshold;
        //double threshold=0.2;
        arrayDetailsOfMatchedStringsFromSecondArray=getMatchedPairs(arraySimilarityIndex,threshold);
        return arrayDetailsOfMatchedStringsFromSecondArray;

}
/*
//Main function, by ambi on 12 April 2009
    //this is a fundamental function, it takes a 2D double array and returns matching pairs
    //Conceptual notion in the 2D array, First column= labels in model solution, first row labels in student diagram
    * @return: a two dimensional array, with returnArray[i][0] containing value of the index in arrayStr1, returnArray[i][1] containing value of the index in arrayStr2 that matches the arrayStr1[i], and
 * returnArray[i][2] containing the corresponding similarity index value. If no matching index is present then returnArray[i][1]=-1 ,returnArray[i][2]=-1
 * and returnArray[i][1]=-1
    */        
    public static double[][] getMatchedPairs(double[][] arraySimilarityIndex, double threshold){
        /*
         double[][] arraySimilarityIndex1={{0.40,0.10,0.90,0.82},
                                          {0.20,0.30,0.95,0.80},
                                          {0.25,0.30,0.70,0.81}};
         *
         * Rerutns as follows
         * double[][] arrayValueOfIndexesOfMatchingPairs={{0.0,3.0,0.82},
                                                          {1.0,2.0,0.95},
                                                          {2.0,1.0,0.30}};
         */
        
        double[][] arrayValueOfIndexesOfMatchingPairs=new double[arraySimilarityIndex.length][];
        
        for(int i=0;i<arraySimilarityIndex.length;i++){
            int n=arraySimilarityIndex[i].length-1;//max value, Arrays.sort() sorts in ascending order and not in descending order
            int valueOfIndexOfNthMaxValue=-10;
            double value1=-1.0;
            //while(n<arraySimilarityIndex[i].length){
            //while(true){
            while(n>=0){
             //System.out.println("n  " + n);
             valueOfIndexOfNthMaxValue=getIndexOfNthMaxValue(n,arraySimilarityIndex[i]);
             //double value1=arraySimilarityIndex[i][valueOfIndexOfNthMaxValue];
             value1=arraySimilarityIndex[i][valueOfIndexOfNthMaxValue];
             double[] array1=new double[arraySimilarityIndex.length];
             for(int k=0;k<array1.length;k++){
                 array1[k]=arraySimilarityIndex[k][valueOfIndexOfNthMaxValue];
             }
             int valueOfIndexOfNthMaxValue2=getIndexOfNthMaxValue(array1.length-1,array1);
             double value2=array1[valueOfIndexOfNthMaxValue2];
             if(value1>=value2){
             break;
             }
             n=n-1;
            }
            
            arrayValueOfIndexesOfMatchingPairs[i]=new double[3];
            arrayValueOfIndexesOfMatchingPairs[i][0]=i;
            System.out.println("%%% i=" + i+ " valueOfIndexOfNthMaxValue " + valueOfIndexOfNthMaxValue);
            //if(arraySimilarityIndex[i][valueOfIndexOfNthMaxValue]>=threshold){
            if(valueOfIndexOfNthMaxValue>=0 && arraySimilarityIndex[i][valueOfIndexOfNthMaxValue]>=threshold){
            arrayValueOfIndexesOfMatchingPairs[i][1]=valueOfIndexOfNthMaxValue;
            }else{
                arrayValueOfIndexesOfMatchingPairs[i][1]=-9;
            }
            //value of the similarity index
            arrayValueOfIndexesOfMatchingPairs[i][2]=value1;
            //arrayValueOfIndexesOfMatchingPairs[i]={i,valueOfIndexOfNthMaxValue};
        }
        return arrayValueOfIndexesOfMatchingPairs;
    }
//this function finds the value of index of nth maximum    
public static int getIndexOfNthMaxValue(int nthPosition, double[] numbers){
  int indexOfMaxValue=0;
  double maxValue = numbers[0];
  double[] cloneNumbers = numbers.clone();
  Arrays.sort(cloneNumbers);
  for(int i=0;i<numbers.length;i++){
    if(numbers[i] ==cloneNumbers[nthPosition]){
        indexOfMaxValue=i;
	  break;
	}
  }
  return indexOfMaxValue;
}

    
public double getSyntaxSimilarityIndex(String str1, String str2){
    
    String[][] syntaxalgorithms=ToolConfiguration.syntaxalgorithms;
    String[][] searchalgorithm=ToolConfiguration.searchalgorithm;
    
	double combinedSyntaxSimilarityIndex=0.0;
	//double[][] arraySyntaxSimilarityIndex=new double[syntaxalgorithms.length][2];
        String[][] arraySyntaxSimilarityIndex=new String[syntaxalgorithms.length][2];
	
	for(int i=0;i<syntaxalgorithms.length;i++){
	//String strNameOfConcreteClass="uk.ac.brunel.genericlabelmatcher.TestConcreteClass1";
	//syntaxalgorithms[i][3] contains the name of the concrete class
        //String strNameOfConcreteClass=syntaxalgorithms[i][3];
	String strNameOfConcreteClass=ToolConfiguration.PACKAGE_NAME+syntaxalgorithms[i][3];
	
     //syntaxalgorithms[i][0] contains the id of the syntax algorithm class
    arraySyntaxSimilarityIndex[i][0]=syntaxalgorithms[i][1];   
		
    try{
    SyntaxAlgorithmIF syntaxAlgorithmIF=(SyntaxAlgorithmIF)Class.forName(strNameOfConcreteClass).newInstance();
    arraySyntaxSimilarityIndex[i][1]=syntaxAlgorithmIF.similarity(str1,str2)+"";
    
    }catch(ClassNotFoundException ex){
        System.out.println("Sorry the class [" + strNameOfConcreteClass + "] has not been found. Please either create it or if already created, place " +
                "it in the classpath. ");
        ex.printStackTrace();
    arraySyntaxSimilarityIndex[i][1]=-1+"";
    
    }catch(Exception ex){
        System.out.println("Sorry, other exception");
        ex.printStackTrace();
    arraySyntaxSimilarityIndex[i][1]=-1+"";
    }
    }
    
    //search algorithm
    for(int i=0;i<searchalgorithm.length;i++){
    String active=searchalgorithm[i][2];
  if(active.equalsIgnoreCase("true")){
	//this is the main active search algorithm  
	  //searchalgorithm[i][3] contains the name of the concrete class
	  
	  //String strNameOfConcreteClass=searchalgorithm[i][3];
          String strNameOfConcreteClass=ToolConfiguration.PACKAGE_NAME+searchalgorithm[i][3];
	  
	   try{
    SearchAlgorithmIF searchAlgorithmIF=(SearchAlgorithmIF)Class.forName(strNameOfConcreteClass).newInstance();		   
    combinedSyntaxSimilarityIndex=searchAlgorithmIF.getCombinedSimilarity(arraySyntaxSimilarityIndex);
    
    }catch(ClassNotFoundException ex){
        System.out.println("Sorry the class [" + strNameOfConcreteClass + "] has not been found. Please either create it or if already created, place " +
                "it in the classpath. ");
        ex.printStackTrace();
    arraySyntaxSimilarityIndex[i][1]=-1+"";
    
    }catch(Exception ex){
        System.out.println("Sorry, other exception");
        ex.printStackTrace();
    arraySyntaxSimilarityIndex[i][1]=-1+"";
    }
    
    break;
	  }else{
		  continue;
		  }
    }
	
	return combinedSyntaxSimilarityIndex;
}

}
