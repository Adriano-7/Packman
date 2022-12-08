package ldts.pacman.fileManipulation;

import java.io.*;
import java.net.URL;
import java.util.List;

public class ResourceFileWriter {
    public void writeLines(String filePath, List<String> lines) throws IOException {
        URL resource = ResourceFileWriter.class.getResource(filePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile()));
        writeLines(writer, lines);
    }
    public void writeLines(BufferedWriter writer, List<String> lines) throws IOException {
        for (String line: lines) {
            System.out.println(line);
            writer.write(line + "\n");
        }
        writer.close();
    }
}
