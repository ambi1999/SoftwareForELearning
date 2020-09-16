package uk.ac.brunel.genericlabelmatcher;

public class CommonPaths {

    public static String DATASTORE_BASE_PATH = "";
    public static String DATA_SET_NAME = "";
    public static String DATA_PATH = "";
    public static String REPORTS_PATH = "";
    public static String DATADICTIONARY_FILE_PATH = "";
    public static String FEATURES_PROPERTIES_PATH = "";
    public static String LABEL_MATCHING_ALGORITHM_PROPERTIES_PATH = "";
    public static String ALGORITHM_PROPERTIES_PATH = "";
    public static String STUDENT_ANSWER_PATH = "";
    public static String CORRECT_ANSWER_PATH = "";
    public static String PaiceHusk_Stemmer_RULES_FILE_PATH = "";
    public static String MASTER_DECISION_FILE_PATH = "";
    public static String WORDNET_HOME_PATH="";
    public static String WORDNET_BASE_PATH="";
    public static String WORDNET_RESOURCES_PATH = "";
    
    public static String TEMP_FOLDER_PATH = "";


    //set paths
    static {
        /*
        BASE_PATH="C:/SoftwareDev/0001_A_Brunel Electronic Assessment Software/MAMCAASYSTEM/datastore/set3/dataWithPics/";
        REPORTS_BASE_PATH="C:/SoftwareDev/0001_A_Brunel Electronic Assessment Software/MAMCAASYSTEM/datastore/set3/reports/";
        DATADICTIONARY_FILE_PATH="C:/SoftwareDev/0001_A_Brunel Electronic Assessment Software/MAMCAASYSTEM/datastore/set3/datadictionary/datadictionary.properties";
         **/

        /*    
        BASE_PATH="C:/01SwDev/0001_BEAS/01_SOFTWARE/MAMCAASYSTEM/datastore/set4/data/";
        REPORTS_BASE_PATH="C:/01SwDev/0001_BEAS/01_SOFTWARE/MAMCAASYSTEM/datastore/set4/reports/";
        DATADICTIONARY_FILE_PATH="C:/01SwDev/0001_BEAS/01_SOFTWARE/MAMCAASYSTEM/datastore/set4/datadictionary/datadictionary.properties";
        DATASTORE_PATH="C:/01SwDev/0001_BEAS/01_SOFTWARE/MAMCAASYSTEM/datastore/";
         */

        //DATASTORE_BASE_PATH="C:/02SwDev/0001_BEAS/01_SOFTWARE/MAMCAASYSTEM1/datastore/";

        //DATASTORE_BASE_PATH="/media/disk/02SwDev/0001_BEAS/01_SOFTWARE/MAMCAASYSTEM1/datastore/";
        //DATASTORE_BASE_PATH="/media/disk-1/02_SVN_MASTER_COPY_OF_TOOL_27APR08/0001_BEAS/01_SOFTWARE/01DATASTORE/";
        //DATASTORE_BASE_PATH = "/media/My Passport/01MYRES/02SwDev/0001_BEAS/01_SOFTWARE/01DATASTORE/";
        //DATASTORE_BASE_PATH="/media/My Passport_/01MYRES/02SwDev/0001_BEAS/01_SOFTWARE/01DATASTORE/";   
        DATASTORE_BASE_PATH = "/home/ambi/01MYRES/02SwDev/0001_BEAS/01_SOFTWARE/01DATASTORE/";

        //DATA_SET_NAME="set7";
        //DATA_SET_NAME = "set09";
        //DATA_SET_NAME="set_test";
        DATA_SET_NAME = "set10";

        DATA_PATH = DATASTORE_BASE_PATH + DATA_SET_NAME + "/data/";
        REPORTS_PATH = DATASTORE_BASE_PATH + DATA_SET_NAME + "/reports/";
        //REPORTS_PATH="/home/ambi/REPORTS_FOR_EASSESSMENT_TOOL/";
        DATADICTIONARY_FILE_PATH = DATASTORE_BASE_PATH + DATA_SET_NAME + "/datadictionary/datadictionary.properties";
        FEATURES_PROPERTIES_PATH = DATASTORE_BASE_PATH + DATA_SET_NAME + "/features/features.properties";

        STUDENT_ANSWER_PATH = DATA_PATH + "studentanswer/";
        CORRECT_ANSWER_PATH = DATA_PATH + "correctanswer/";


        PaiceHusk_Stemmer_RULES_FILE_PATH = DATASTORE_BASE_PATH + "stemming/stemrules.txt";

        LABEL_MATCHING_ALGORITHM_PROPERTIES_PATH = DATASTORE_BASE_PATH + "properties/label_matching_algorithm.properties";

        //MASTER_DECISION_FILE_PATH = DATASTORE_BASE_PATH + "MASTER_LABLE_DECISION_FILE2.xls";
        
        //MASTER_DECISION_FILE_PATH = DATASTORE_BASE_PATH + "New Processing Of Labels on 22June2008/Main_07JUL2008_ALL_LEVEL_ALL_DETAILS.xls";
        //MASTER_DECISION_FILE_PATH = DATASTORE_BASE_PATH + "New Processing Of Labels on 22June2008/Main_08JUL2008_ALL_LEVEL_ALL_DETAILS.xls";
        
        MASTER_DECISION_FILE_PATH = DATASTORE_BASE_PATH + "Report for Framework/Main Reports/Syntax Algo Conparision Report/level3_And_spell_check_And_Stemming/raw data/Main_09JUL2008_ALL_LEVEL_ALL_DETAILS.xls";
        
        //WORDNET_RESOURCES_PATH=DATASTORE_BASE_PATH + "resources/wordnet/";
                
        WORDNET_BASE_PATH=DATASTORE_BASE_PATH + "resources/wordnet/";
        
        WORDNET_RESOURCES_PATH=WORDNET_BASE_PATH + "wordnet_configuration/";
        
        WORDNET_HOME_PATH=WORDNET_BASE_PATH + "WordNet-3.0/";
        
                
        TEMP_FOLDER_PATH=DATASTORE_BASE_PATH + "tempfolder/";
        
        
    }
    
    public static String LTDU_Project_Data_File_Path="/home/ambi/01MYRES/01Am/LTDU/LTDU Project Stuff/";
}
