// @Copyright Anca Millio
package vcs;

import java.util.ArrayList;

import utils.ErrorCodeManager;
import utils.OperationType;

public final class LogOperation extends VcsOperation {
    /**
     * Log operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public LogOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    /**
     * Prints all the commits done on the current branch.
     *
     * @return return code
     */
    @Override
    public int execute(Vcs vcs) {
        int firstTime = 1;
        for (Commit co : vcs.getCurrentBranch().getCommits()) {
            if (firstTime == 1) {
                vcs.getOutputWriter().write("Commit id: " + co.getId()
                + "\n" + "Message: " + co.getMessage() + "\n");
                firstTime = 0;
            } else {
                vcs.getOutputWriter().write("\n" + "Commit id: " + co.getId()
                 + "\n" + "Message: " + co.getMessage() + "\n");
            }
        }
        return ErrorCodeManager.OK;
    }
}
