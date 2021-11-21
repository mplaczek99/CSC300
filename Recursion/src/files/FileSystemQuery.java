package files;

import java.io.File;
import java.util.Objects;

/**
 * @author Michael Placzek
 */
public class FileSystemQuery {
    /**
     * Count the number of subdirectories in a specific folder
     *
     * @param startDirectory a legal, existing folder
     * @return the count of subdirectories
     */
    public int numberOfSubdirectories(File startDirectory) {
        int count = 0;

        for (File f : Objects.requireNonNull(startDirectory.listFiles())) {
            if (f.isDirectory()) {
                count++;
                count += numberOfSubdirectories(f);
            }
        }
        return count;
    }

    /**
     * Count the number of files in a specific folder
     *
     * @param startDirectory a legal, existing folder
     * @return the count of files
     */
    public int numberOfFiles(File startDirectory) {
        int count = 0;

        for (File f : Objects.requireNonNull(startDirectory.listFiles())) {
            if (f.isDirectory()) {
                count += numberOfFiles(f);
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * Count the number of hidden files in a specific folder
     *
     * @param startDirectory a legal, existing folder
     * @return the count of hidden files
     */
    public int numberOfHiddenFiles(File startDirectory) {
        int count = 0;

        for (File f : Objects.requireNonNull(startDirectory.listFiles())) {
            if (f.isDirectory()) {
                count += numberOfHiddenFiles(f);
            } else if (f.isHidden() && f.isFile()) {
                count++;
            }
        }
        return count;
    }

    public long sizeOfContents(File directory) {
        long size = 0;

        for (File f : Objects.requireNonNull(directory.listFiles())) {
            if (f.isDirectory()) {
                size += sizeOfContents(f);
            } else {
                size += f.length();
            }
        }
        return size;
    }
}