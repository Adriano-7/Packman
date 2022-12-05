package ldts.pacman.FileManipulation;

import ldts.pacman.model.game.arena.ArenaLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResourceFileReader {
    public List<String> readLines(String filePath) throws IOException {
        URL resource = ArenaLoader.class.getResource(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        return readLines(reader);
    }
    public List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null; ) lines.add(line);
        return lines;
    }
}
