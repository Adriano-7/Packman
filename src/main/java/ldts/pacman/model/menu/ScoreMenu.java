package ldts.pacman.model.menu;

import ldts.pacman.ResourceFileReader;

import java.io.IOException;
import java.util.List;

public class ScoreMenu {
    private List<String> lines;
    public ScoreMenu() {
        try {
            lines = new ResourceFileReader().readLines("/scores.txt");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not find such file");
            System.out.println("Will probably lead to NullPointerException's");
        }
    }
    public List<String> getLines() {
        return lines;
    }
    public void addScore(String name, int score) {
        //TODO
    }
}
