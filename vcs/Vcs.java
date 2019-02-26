package vcs;

import java.util.ArrayList;

import filesystem.FileSystemOperation;
import filesystem.FileSystemSnapshot;
import utils.OutputWriter;
import utils.Visitor;

public final class Vcs implements Visitor {
    private final OutputWriter outputWriter;
    private FileSystemSnapshot activeSnapshot;
    private Branch currentBranch;
    static ArrayList<Branch> branches;

    public void setActiveSnapshot(FileSystemSnapshot activeSnapshot) {
    	this.activeSnapshot = activeSnapshot.cloneFileSystem();
    }
    public Branch getCurrentBranch() {
    	return currentBranch;
    }
    public void setCurrentBranch(Branch branch) {
    	this.currentBranch = branch;
    }

    public FileSystemSnapshot getActiveSnapshot() {
    	return activeSnapshot;
    }
    /**
     * Vcs constructor.
     *
     * @param outputWriter the output writer
     */
    public Vcs(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public OutputWriter getOutputWriter() {
    	return outputWriter;
    }
    /**
     * Does initialisations.
     */
    public void init() {
        this.activeSnapshot = new FileSystemSnapshot(outputWriter);

        //TODO other initialisations
        this.currentBranch = new Branch("master");
        this.currentBranch.addCommit(new Commit("First commit", activeSnapshot.cloneFileSystem()));
        branches = new ArrayList<Branch>();
        branches.add(currentBranch);
    }

    /**
     * Visits a file system operation.
     *
     * @param fileSystemOperation the file system operation
     * @return the return code
     */
    public int visit(FileSystemOperation fileSystemOperation) {
        return fileSystemOperation.execute(this.activeSnapshot);
    }

    /**
     * Visits a vcs operation.
     *
     * @param vcsOperation the vcs operation
     * @return return code
     */
    @Override
    public int visit(VcsOperation vcsOperation) {
        //TODO
    	return vcsOperation.execute(this);
    }
}
