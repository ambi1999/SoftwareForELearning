package uk.ac.brunel.genericlabelmatcher;

public class ToolConstants
{
	public static String STR_SPECIAL_CHARACTER="!,\",£,$,%,^,&,*,(,),-,_,+,=,{,},[,],~,#,;,:,@,',<,>,.,?,/,`,\\,|";
	//public static String STR_SPECIAL_CHARACTER="!,\",£,$,%,^,&,\\*,\\(,\\),-,_,+,=,{,},[,],~,#,;,:,@,',<,>,.,?,/,`,\\,|, ,";
	//public static String STR_PUNCTUATION_WORD="the,or,and,if,but,is,are,do,did,has,have,been,for,an,at,to";

        //to do
        public static String STR_SPECIAL_CHARACTER_TO_BE_REPLACED_BY_SINGLE_SPACE="!,\",£,$,%,^,&,*,(,),-,_,+,=,{,},[,],~,#,;,:,@,',<,>,.,?,/,`,\\,|";
        
        //removed means to be replaced by no spaces. Like "today's" should be changed to "todays" and not to "today s"
        public static String STR_SPECIAL_CHARACTER_TO_BE_REMOVED="'";
        
	public static String SEPARATER1=",";
	public static String REPLACEMENT_CHARACTER1=" ";
	//public static String SPACE=" ";
        public static String SPACE="\\s+";
        public static String NOSPACE="";
        
	public static String STRING_PROCESSING_LEVEL_ONE="Level1";
	public static String STRING_PROCESSING_LEVEL_TWO="Level2";
	public static String STRING_PROCESSING_LEVEL_THREE="Level3";

	//added on 10 march 2008
	public static String STR_ENGLISH_LANGUAGE_ARTICLES="a,an,the,this,that";
	//public static String STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_LIST1="to,of,for,from,and,be,or,on,if,in,with,by,as,but,at";
        //remove the word 'if' from the list STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_LIST1
        public static String STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_LIST1="to,of,for,from,and,be,or,on,in,with,by,as,but,at";
	public static String STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_LIST2="i,he,she,it,we,you,they";
	public static String STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_HELPING_VERBS="is,am,are,do,did,was,were,has,have,been";

	public static String STR_PUNCTUATION_WORD=STR_ENGLISH_LANGUAGE_ARTICLES+ "," + 
												STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_LIST1+ "," + 
												STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_LIST2+ "," + 
												STR_ENGLISH_LANGUAGE_GRAMMER_WORDS_HELPING_VERBS;

}