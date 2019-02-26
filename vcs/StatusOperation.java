// @Copyright Anca Millio
package vcs;

import java.util.ArrayList;

import utils.ErrorCodeManager;
import utils.OperationType;

public final class StatusOperation extends VcsOperation {

    /**
     * Status operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public StatusOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    /**
     * Lists the current branche's name and the changes found in the staging.
     *
     * @return return code
     */
    @Override
    public int execute(Vcs vcs) {
        vcs.getOutputWriter().write("On branch: "
               + vcs.getCurrentBranch().getName() + "\n" + "Staged changes:"  + "\n");
        for (String it : Staging.convertedStaging) {
        vcs.getOutputWriter().write(it);
        }
        return ErrorCodeManager.OK;
    }
}
