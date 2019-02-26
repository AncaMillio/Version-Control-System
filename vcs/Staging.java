// @Copyright Anca Millio
package vcs;
import java.util.ArrayList;
import utils.OperationType;

public final class Staging {
    static boolean isEmpty = true;
    /*Stores all the FyleSystem operations in the staging(In the form of String,
    ready for printing in the output file, if the Status Operation
     is called.)*/
    static ArrayList<String> convertedStaging = new ArrayList<String>();
    /*Staging constructor.*/
    public Staging() {
    	convertedStaging = new ArrayList<String>();
    }
    /*Gets the operations in the staging.*/
    public ArrayList<String> getConvertedStaging() {
    	return convertedStaging;
    }

    /*Converts the operations in the staging into text for the Status command.*/
    public static void convertStaging(OperationType type, ArrayList<String> operationArgs) {
    	isEmpty = false;
    		switch (type) {
    		case CHANGEDIR:
    			convertedStaging.add("	Changed directory to "
    		+ operationArgs.get(0) + "\n");
    			break;
            case MAKEDIR:
            	convertedStaging.add("	Created directory " + operationArgs.get(0) + "\n");
            	break;
            case REMOVE:
            	convertedStaging.add("	Removed " + operationArgs.get(0) + "\n");
            	break;
            case TOUCH:
            	convertedStaging.add("	Created file " + operationArgs.get(1) + "\n");
            	break;
            case WRITETOFILE:
            	convertedStaging.add("	Added \"" + operationArgs.get(1) +  "\" to file "
            + operationArgs.get(0) + "\n");
            	break;
            default:
            	break;
    		}
    }
}
