// @Copyright Anca Millio
package vcs;

import java.util.ArrayList;

import utils.ErrorCodeManager;
import utils.OperationType;

public final class CommitOperation extends VcsOperation {
    /**
     * Commit operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public CommitOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     * Generates a new commit, by applying the changes put in the current commit's staging.
     * The new commit will have the current commit as a parent.
     *
     * @return return code
     */
    @Override
    public int execute(Vcs vcs) {
        /*Returns error if the staging is empty.*/
        if (Staging.isEmpty) {
            return ErrorCodeManager.VCS_BAD_CMD_CODE;
        }
        String message = new String();
        int poz = 1;
        while (poz < operationArgs.size()) {
            if (poz < operationArgs.size() - 1) {
                message = message + operationArgs.get(poz) + " ";
            } else {
                message = message + operationArgs.get(poz);

            }
            poz++;
        }
        Commit c = new Commit(message, vcs.getActiveSnapshot().cloneFileSystem());
        /*By adding the commit to the branch, we know that the previous commit
         *found in the ArrayList is the parent of the new commit.
         */
        vcs.getCurrentBranch().addCommit(c);
        Staging.isEmpty = true;
        Staging.convertedStaging.clear();
        return ErrorCodeManager.OK;
    }

}
