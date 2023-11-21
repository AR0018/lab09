package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_PATH = System.getProperty("user.home") +
        System.getProperty("file.separator") + "output.txt";

    private File currentFile;

    public Controller() {
        this.currentFile = new File(DEFAULT_PATH);
    }

    /**
     * Sets the parameter as the current File
     * @param file
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    /**
     * Returns the current File
     * @return the current File
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * Returns the absolute path of the current File
     * @return a String containing the absolute path of the File
     */
    public String getFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Gets a String as input and writes its content on the current File
     * @param content
     * @throws IOException
     */
    public void writeOnFile(String content) throws IOException {
        try(BufferedWriter os = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(this.currentFile.getAbsolutePath()), StandardCharsets.UTF_8))) {
            os.write(content);
        } catch(final IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
