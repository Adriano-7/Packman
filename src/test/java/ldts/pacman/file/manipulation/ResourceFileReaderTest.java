package ldts.pacman.file.manipulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

public class ResourceFileReaderTest {
    private ResourceFileReader resourceFileReader;
    @BeforeEach
    public void setUp() {
        resourceFileReader = new ResourceFileReader();
    }
    @Test
    public void readLinesWithReader() {
        String filePath = "/scoresRead.txt";
        List<String> expectedLines = Arrays.asList("|===USERNAME=======SCORE====|",
                "  1. 123456789  - 123456789", "  2. 019231515  - 5000", "  3. 151985153  - 2500",
                "  4. hello      - 1200", "  5. h          - 789", "  6. aa         - 600",
                "  7. bb         - 300", "  8. ccccccccc  - 9", "  9. ddddddddd  - 5",
                "  10. eheeheaaa - 1", "|===========================|");

        try {
            URL resource = ResourceFileReaderTest.class.getResource(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));

            List<String> fileLines = resourceFileReader.readLines(reader);

            assertEquals(expectedLines, fileLines);
        }
        catch (FileNotFoundException e) {
            fail(filePath + " not found");
        }
        catch (IOException e) {
            fail();
        }
    }
    @Test
        public void readLinesWithString() {
        String filePath = "/scoresRead.txt";
        List<String> expectedLines = Arrays.asList("|===USERNAME=======SCORE====|", "  1. 123456789  - 123456789", "  2. 019231515  - 5000", "  3. 151985153  - 2500", "  4. hello      - 1200", "  5. h          - 789", "  6. aa         - 600", "  7. bb         - 300", "  8. ccccccccc  - 9", "  9. ddddddddd  - 5", "  10. eheeheaaa - 1", "|===========================|");
        resourceFileReader = Mockito.spy(resourceFileReader);

        try {
            List<String> fileLines = resourceFileReader.readLines(filePath);

            Mockito.verify(resourceFileReader, times(1))
                    .readLines(Mockito.any(BufferedReader.class));

            assertEquals(expectedLines, fileLines);
        }
        catch (IOException e) {
            fail();
        }
    }
}
