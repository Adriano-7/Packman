package ldts.pacman.model.menu;

import ldts.pacman.file.manipulation.ResourceFileReader;
import ldts.pacman.file.manipulation.ResourceFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreMenu {
    private final String filePath;
    private List<String> lines;
    public ScoreMenu() throws IOException {
        this("/scores.txt");
    }
    public ScoreMenu(String filePath) throws IOException {
        this.filePath = filePath;
        this.lines = new ResourceFileReader().readLines(filePath);
    }
    public List<String> getLines() {
        return lines;
    }
    public void addScore(String name, int scoreToAdd) throws IOException {
        if (lines.isEmpty()) throw new IOException("File was empty");
        if (lines.size() > 10) throw new IOException("File had too many lines");

        lines = getNewLines(name, scoreToAdd);
        new ResourceFileWriter().writeLines(filePath, lines);
    }
    private List<String> getNewLines(String name, int scoreToAdd){
        List<String> newLines = new ArrayList<>();

        boolean newLineAdded = false;
        System.out.println(lines);
        int i = 0;
        for ( ; i < lines.size(); i++) {
            int place = i + 1;
            if(getScore(lines.get(i)) < scoreToAdd && !newLineAdded) {

                newLines.add("  " + place + ". " + name + " - " + scoreToAdd);
                newLineAdded = true;
                System.out.println("Added" + newLines.get(i));
            }
            if (newLineAdded) {
                newLines.add(lines.get(i).replaceFirst(Integer.toString(place),
                        Integer.toString(place + 1)));
            }
            else newLines.add(lines.get(i));
        }
        if (!newLineAdded) {
            newLines.add("  " + (i + 1) + ". " + name + " - " + scoreToAdd);
        }
        System.out.println(newLines);
        if (newLines.size() > 10) newLines.remove(newLines.size() - 1);

        return newLines;
    }
    private int getScore(String line) {
        int start = line.indexOf("-") + 2;
        return Integer.parseInt(line.substring(start));
    }
}
