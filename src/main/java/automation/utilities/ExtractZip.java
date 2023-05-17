package automation.utilities;

import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.io.File;
import java.io.IOException;

public class ExtractZip {

    public static String getContent(final String directory, final String fileName, final String subFileName) throws IOException {
        String out = null;
        final File fDirectory = new File(directory);
        final File input7z = new File(fDirectory, fileName);
        try (final SevenZFile sevenZFile = new SevenZFile(input7z)) {
            SevenZArchiveEntry entry = sevenZFile.getNextEntry();
            while (entry != null) {
                if (subFileName.equals(entry.getName())) {
                    byte[] content = new byte[(int) entry.getSize()];
                    sevenZFile.read(content, 0, content.length);
                    out = new String(content);
                }
                entry = sevenZFile.getNextEntry();
            }
        } catch (final IOException ioe) {
            final String error = "Error when reading entry " + fileName;
            throw ioe;
        }
        return out;
    }
}
