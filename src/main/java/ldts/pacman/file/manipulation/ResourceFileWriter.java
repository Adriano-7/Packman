package ldts.pacman.file.manipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            writer.write(line + "\n");
        }
        writer.close();
    }
}
