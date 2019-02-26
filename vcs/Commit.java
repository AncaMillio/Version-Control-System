// @Copyright Anca Millio
package vcs;
import filesystem.FileSystemSnapshot;
import utils.IDGenerator;
public final class Commit {
    private FileSystemSnapshot fss;
    private String message;
    private int id;

    /**
     * Commit constructor. Generates id of commit.
     *
     * @param message   of the commit
     * @param fss   contained in the commit
     */
    public Commit(String message, FileSystemSnapshot fss) {
        this.message = message;
        this.fss = fss;
        this.id = IDGenerator.generateCommitID();
    }

    public FileSystemSnapshot getFss() {
        return fss;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }
}
