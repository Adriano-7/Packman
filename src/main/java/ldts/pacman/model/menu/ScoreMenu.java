package ldts.pacman.model.menu;

import ldts.pacman.FileManipulation.ResourceFileReader;

import java.io.IOException;
import java.util.List;

public class ScoreMenu {
    private List<String> lines;
    public ScoreMenu() throws IOException {
        lines = new ResourceFileReader().readLines("/scores.txt");
    }
    public List<String> getLines() {
        return lines;
    }
    public void addScore(String name, int score) {
        //TODO
    }
}
