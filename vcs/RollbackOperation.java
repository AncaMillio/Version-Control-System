// @Copyright Anca Millio
package vcs;

import java.util.ArrayList;

import utils.ErrorCodeManager;
import utils.OperationType;

public final class RollbackOperation extends VcsOperation {
    /**
     * Rollback operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public RollbackOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }
    /**
     *Frees the staging and brings the file system snapshot to the version given by the last commit.
     *
     * @return return code
     */
    @Override
    public int execute(Vcs vcs) {
        Staging.isEmpty = true;
        Staging.convertedStaging.clear();
        int lastCommit = vcs.getCurrentBranch().getCommits().size() - 1;
        vcs.setActiveSnapshot(vcs.getCurrentBranch().getCommits().get(lastCommit).getFss());
        return ErrorCodeManager.OK;
    }
}
