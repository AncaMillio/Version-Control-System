// @Copyright Anca Millio
package vcs;
import java.util.ArrayList;
public final class Branch {

    /* Stores the commits done on a branch.*/
    ArrayList<Commit> commits = new ArrayList<Commit>();
    private String name = new String();

    /**
     * Branch constructor.
     *
     * @param name   of the branch
     */
    public Branch(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    /* Gets all the commits of this branch.*/
    public ArrayList<Commit> getCommits() {
        return commits;
    }

    /*Adds a commit to the branch.*/
    public void addCommit(Commit commit) {
        commits.add(commit);
    }
}
