// @Copyright Anca Milliopackage vcs;
package vcs;

import java.util.ArrayList;

import utils.ErrorCodeManager;
import utils.OperationType;

public final class CheckoutOperation extends VcsOperation {
	private static int three = 1 + 2;
	/**
     * Checkout operation constructor.
     *
     * @param type          type of the operation
     * @param operationArgs the arguments of the operation
     */
    public CheckoutOperation(OperationType type, ArrayList<String> operationArgs) {
        super(type, operationArgs);
    }

    /**
     * Moves the HEAD pointer on another branch.
     * OR
     * Moves the HEAD pointer on a previous commit from the current branch.
     *
     * @return return code
     */
    @Override
    public int execute(Vcs vcs) {
    	if (!Staging.isEmpty) {
    		return ErrorCodeManager.VCS_STAGED_OP_CODE;
    	}

        if (operationArgs.get(0).equals("-c")) {
        	/*Returns an error if the commit id does not exist.*/
        	for (int i = 0; i < vcs.getCurrentBranch().getCommits().size(); i++) {
        		if (vcs.getCurrentBranch().getCommits().get(i).getId()
        				== Integer.parseInt(operationArgs.get(1))) {
        			break;
        		}
        		if (i == vcs.getCurrentBranch().getCommits().size() - 1) {
        			return ErrorCodeManager.VCS_BAD_PATH_CODE;
        		}
        	}
            /*Restores the FileSystem Snapshot to the state of the given commit.
             *"(Integer.parseInt(operationArgs.get(1)) - three) / 2" represents
             *the correlation between the commit id and it's
             *position in the commits ArrayList.
            */
        	vcs.setActiveSnapshot(vcs.getCurrentBranch().getCommits()
            .get((Integer.parseInt(operationArgs.get(1)) - three) / 2)
            .getFss().cloneFileSystem());

        int index = vcs.getCurrentBranch().getCommits().size() - 1;

        while (vcs.getCurrentBranch().getCommits().size() - 1
        		> (Integer.parseInt(operationArgs.get(1)) - three) / 2) {
        	vcs.getCurrentBranch().getCommits().remove(index);
        	index--;
        }

        } else {
            /* Moves on another branch*/
        	for (int i = 0; i < Vcs.branches.size(); i++) {
        		if (Vcs.branches.get(i).getName().equals(operationArgs.get(0))) {
        			vcs.setCurrentBranch(Vcs.branches.get(i));
        			break;
        		}
                /* Returns error if the branch doesn't exist*/
        		if (i == Vcs.branches.size() - 1) {
        			return ErrorCodeManager.VCS_BAD_CMD_CODE;
        		}
        	}
        }
        return ErrorCodeManager.OK;
    }
}
