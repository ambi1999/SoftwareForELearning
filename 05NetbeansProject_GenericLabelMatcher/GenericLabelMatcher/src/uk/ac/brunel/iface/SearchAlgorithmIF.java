package uk.ac.brunel.iface;

public interface SearchAlgorithmIF{
    
/*
 * syntaxalgorithms[i][0] contains the id of the syntax algorithm class
 * syntaxalgorithms[i][1] contains the double value of the similarity index for the corresponding syntax algorithm in the  syntaxalgorithms[i][0]
 **/
    
public double getCombinedSimilarity(String[][] arraySyntaxSimilarityIndex);
}
