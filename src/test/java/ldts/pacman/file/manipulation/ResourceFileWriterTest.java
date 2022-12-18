package ldts.pacman.file.manipulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class ResourceFileWriterTest {
    private ResourceFileWriter resourceFileWriter;
    private List<String> lines;
    @BeforeEach
    public void setUp() {
        resourceFileWriter = new ResourceFileWriter();
        lines = Arrays.asList("First line", "Second", "Third", "12345 - 151 forth line");
    }
    @Test
    public void writeLinesWithWriter() {
        String filePath = "/scoresWrite.txt";
        try {
            URL resource = ResourceFileWriterTest.class.getResource(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile()));

            resourceFileWriter.writeLines(writer, lines);
        }
        catch (FileNotFoundException e) {
            fail(filePath + " not found");
        }
        catch (IOException e) {
            fail();
        }

        ResourceFileReader resourceFileReader = new ResourceFileReader();
        List<String> newLines = null;
        try {
            newLines = resourceFileReader.readLines(filePath);
        }
        catch (IOException e) { fail(); }
        assertEquals(lines, newLines);
    }
    @Test
    public void writeLinesWithString() {
        String filePath = "/scoresWrite.txt";

        resourceFileWriter = Mockito.spy(resourceFileWriter);

        try {
            resourceFileWriter.writeLines(filePath, lines);

            Mockito.verify(resourceFileWriter, times(1))
                    .writeLines(Mockito.any(BufferedWriter.class), Mockito.anyList());
        }
        catch (IOException e) {
            fail();
        }

        ResourceFileReader resourceFileReader = new ResourceFileReader();
        List<String> newLines = null;
        try {
            newLines = resourceFileReader.readLines(filePath);
        }
        catch (IOException e) { fail(); }
        assertEquals(lines, newLines);
    }
}
