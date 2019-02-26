// @Copyright Anca Millio
package vcs;

import java.util.ArrayList;
import utils.ErrorCodeManager;
import utils.OperationType;

public final class BranchOperation extends VcsOperation {

    /**
     * Branch operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public BranchOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    /**
     * Creates a new branch with the same structure of the file system as
     * the one described by the current branch's commit.
     *
     * @return return code
     */
    @Override
    public int execute(Vcs vcs) {
    	/*Returns error if the branch name doesn't exist*/
        for (int i = 0; i < Vcs.branches.size(); i++) {
            if (Vcs.branches.get(i).getName().equals(operationArgs.get(0))) {
                return ErrorCodeManager.VCS_BAD_CMD_CODE;
            }
        }
        Branch b = new Branch(operationArgs.get(0));
        Vcs.branches.add(b);
        return ErrorCodeManager.OK;
    }
}
