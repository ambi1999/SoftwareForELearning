package uk.ac.brunel.xmi;

import javax.xml.parsers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.*;
import org.w3c.dom.Node.*;

/**
 * Java API to access the labels present in a diagram represented as an XMI file.
 *
 * @version 1.0
 * @author  Ambikesh Jayal ambi1999@gmail.com
 * @Note  Original file taken from Jeffrey M. Hunter  (jhunter@idevelopment.info), http://www.idevelopment.info
 * -----------------------------------------------------------------------------
 */

public class XMIDOMDataLoader {

    private static final String UMLActionState = "UML:ActionState";
    private static final String UMLModelElementtaggedValue = "UML:ModelElement.taggedValue";
    private static final String UMLTaggedValuedataValue = "UML:TaggedValue.dataValue";
    private static String strFilePath = "/home/ambi/01MYRES/01Am/LTDU/LTDU Symposium/v3_Correct Diagrams.xmi";
    //for testing
    public static void main(String[] args) {
        XMIDOMDataLoader xmiDOMDataLoader = new XMIDOMDataLoader();
        String strFilePath = "/home/ambi/01MYRES/01Am/LTDU/LTDU Symposium/v3_Correct Diagrams.xmi";
        new XMIDOMDataLoader().getDetailsOfAllLabels(strFilePath);

    }
    
    /*
     * This function returns list of labels. string[i][0]="lablel", string[i][1]="xmiid", string[i][2]="positive feedback", 
     * string[i][3]="negative feedback"
     * 
     */
    public String[][] getDetailsOfAllLabels(String strXMIFilePath) {
        String[][] strArrayLabelDetails = null;
        if (!strXMIFilePath.endsWith(".xmi")) {
            //file does not end with xmi, so do nothing
            strArrayLabelDetails = null;
        } else {
            //now it ends with .xmi and hence probaby it is indeed an xmi file, process it

            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(strXMIFilePath);
                strArrayLabelDetails = processDocument(document);
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

        System.out.println("Arrays.deepToString(strArrayLabelDetails) " + Arrays.deepToString(strArrayLabelDetails));
        return strArrayLabelDetails;
    }

    /*
     * +---------------------------------------------+
     * | METHOD: printElements                       |
     * +---------------------------------------------+
     */
    private String[][] processDocument(Document doc) {
        String[][] strArrayLabelDetails = null;
        List<String[]> listStates = new ArrayList<String[]>();

        NodeList nodelist = doc.getElementsByTagName("*");
        Node node;

        for (int i = 0; i < nodelist.getLength(); i++) {
            node = nodelist.item(i);
            System.out.println("****" + node.getNodeName() + " ");
            String strNodeName = node.getNodeName();

            if (strNodeName.equals(UMLActionState)) {
                //this starts the processiong of a state machine
                String[] arrayLabelDetail = processUMLActionState(node);
                if (arrayLabelDetail != null) {
                    listStates.add(arrayLabelDetail);
                }
            }

        }

        strArrayLabelDetails = new String[listStates.size()][];
        for (int i = 0; i < listStates.size(); i++) {
            strArrayLabelDetails[i] = listStates.get(i);
        }

        return strArrayLabelDetails;
    }

    private String[] processUMLActionState(Node nodeActionState) {
        String[] arrayLabelDetail = new String[4];

        String label = "";
        String xmiid = "";
        String feedback = "";
        String positiveFeedback = "";
        String negativeFeedback = "";

        NamedNodeMap namedNodeMap = nodeActionState.getAttributes();
        try {
            label = namedNodeMap.getNamedItem("name").getNodeValue();
            xmiid = namedNodeMap.getNamedItem("xmi.id").getNodeValue();
        } catch (Exception ex) {
        }

        if (label.equals("")) {
            return null;
        }
        
        //the followinng two lines with lots of getFirstChild().getNextSibling() are a way to get to the feedback value which is present in the 
        //tag <UML:TaggedValue.dataValue>.
        Node child1 = nodeActionState.getFirstChild().getNextSibling().getFirstChild().getNextSibling();
        Node childNodeUMLTaggedValuedataValue = child1.getFirstChild().getNextSibling();
        
        String nameChildNodeUMLTaggedValuedataValue = childNodeUMLTaggedValuedataValue.getNodeName();
        // System.out.println("^^^^^ nameChildNodeUMLTaggedValuedataValue " + nameChildNodeUMLTaggedValuedataValue);
        if (nameChildNodeUMLTaggedValuedataValue.equals(UMLTaggedValuedataValue)) {
            feedback = childNodeUMLTaggedValuedataValue.getTextContent();
        }



        arrayLabelDetail[0] = label;
        arrayLabelDetail[1] = xmiid;
        arrayLabelDetail[2] = feedback.split("]")[0].replace("[", "").replace("]", "");
        arrayLabelDetail[3] = feedback.split("]")[1].replace("[", "").replace("]", "");
        //arrayLabelDetail[2]=feedback;
        //arrayLabelDetail[3]=feedback;

        return arrayLabelDetail;
    }

    private String[] processUMLActionState_old(Node nodeActionState) {
        String[] arrayLabelDetail = new String[4];

        String label = "";
        String xmiid = "";
        String feedback = "";
        String positiveFeedback = "";
        String negativeFeedback = "";

        NamedNodeMap namedNodeMap = nodeActionState.getAttributes();
        try {
            label = namedNodeMap.getNamedItem("name").getNodeValue();
            xmiid = namedNodeMap.getNamedItem("xmi.id").getNodeValue();
        } catch (Exception ex) {
        }

        if (label.equals("")) {
            return null;
        }
        NodeList nodelist = nodeActionState.getChildNodes();

        for (int i = 0; i < nodelist.getLength(); i++) {
            Node childNode = nodelist.item(i);
            String strNodeName = childNode.getNodeName();
            if (strNodeName.equals(UMLModelElementtaggedValue)) {
                NodeList nodelist1 = childNode.getChildNodes();

                for (int j = 0; j < nodelist1.getLength(); j++) {
                    Node childNode1 = nodelist1.item(j);
                    String strChildNode1Name = childNode1.getNodeName();
                    //System.out.println("%%%%%%%%% strChildNode1Name " + strChildNode1Name);
                    if (strChildNode1Name.equals(UMLTaggedValuedataValue)) {
                        feedback = childNode1.getNodeValue();
                    }
                }

            }

        }

        arrayLabelDetail[0] = label;
        arrayLabelDetail[1] = xmiid;
        //arrayLabelDetail[2]=feedback.split("]")[0].replace("[", "");
        //arrayLabelDetail[3]=feedback.split("]")[1].replace("]", "");
        arrayLabelDetail[2] = feedback;
        arrayLabelDetail[3] = feedback;

        return arrayLabelDetail;
    }
}