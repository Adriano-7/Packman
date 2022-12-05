package ldts.pacman;

import ldts.pacman.model.game.arena.ArenaLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class ResourceFileReaderTest {
    ResourceFileReader resourceFileReader;
    @BeforeEach
    public void setUp() {
        resourceFileReader = new ResourceFileReader();
    }
    @Test
    public void readLinesWithReader() {
        String filePath = "/scores.txt";
        try {
            URL resource = ArenaLoader.class.getResource(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));

            List<String> fileLines = resourceFileReader.readLines(reader);

            assertTrue(fileLines.size() > 0);
        }
        catch (FileNotFoundException e) {
            System.out.println(filePath + " not found");
            fail();
        }
        catch (IOException e) {
            fail();
        }
    }
    @Test
    public void readLinesWithString() {
        String filePath = "/scores.txt";
        resourceFileReader = Mockito.spy(resourceFileReader);

        try {
            List<String> lines = resourceFileReader.readLines(filePath);

            Mockito.verify(resourceFileReader, times(1))
                    .readLines(Mockito.any(BufferedReader.class));
            assertTrue(lines.size() > 0);
        }
        catch (IOException e) {
            fail();
        }
    }
}
