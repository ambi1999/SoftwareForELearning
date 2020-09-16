/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.brunel.test;

import uk.ac.brunel.genericlabelmatcher.*;

/**
 *
 * @author ambi
 */
public class TestClass1 {

public static void main(String[] args){
    System.out.println("Hellooooo ");
    String strNameOfConcreteClass="uk.ac.brunel.genericlabelmatcher.LabelMatcher";
    try{
    //LabelMatcherIF labelMatcherIF=(LabelMatcherIF)Class.forName(strNameOfConcreteClass).newInstance();
    //labelMatcherIF.loadConfiguration("");
        
    LabelMatcher labelMatcher=LabelMatcher.getInstance("");    

    //String[] arrayStr1={"update","total"};
    //String[] arrayStr2={"up","amount","to", "updat"};
    
    String[] arrayStr1={"Select Recipe", "Assemble Ingredients", "Cook meal", "Set the table", "Eat"};

    //String[] arrayStr2={"turn up at arranged time", "eat the meal produced by friend", "must select a recipe for their meal", 
    //"assemble the ingredient", "cook the meal", "Set table", "eat meal"};
    
    String[] arrayStr2={"turn up at arranged time", "eat the meal produced by friend", "must select a recipe for their meal", 
    "assemble the ingredient", "cook the meal", "Set table", "eat meal", "recip selct"};
        
    double[][] arrayDetailsOfMatchedStringsFromSecondArray=labelMatcher.getDetailsOfMatchedStringsFromSecondArray(arrayStr1, arrayStr2);
    for(int i=0;i<arrayDetailsOfMatchedStringsFromSecondArray.length;i++){
        System.out.println(arrayDetailsOfMatchedStringsFromSecondArray[i][0] + "   " + arrayDetailsOfMatchedStringsFromSecondArray[i][1] + "   " +arrayDetailsOfMatchedStringsFromSecondArray[i][2] );
    }
    
    }catch(Exception ex){
        System.out.println("Sorry, other exception");
        ex.printStackTrace();
    }
}

}
