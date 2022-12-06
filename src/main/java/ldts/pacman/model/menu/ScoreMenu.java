package ldts.pacman.model.menu;

import ldts.pacman.FileManipulation.ResourceFileReader;
import ldts.pacman.FileManipulation.ResourceFileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreMenu {
    private final String filePath;
    private List<String> lines;
    public ScoreMenu(String filePath) throws IOException {
        this.filePath = filePath;
        this.lines = new ResourceFileReader().readLines(filePath);
    }
    public List<String> getLines() {
        return lines;
    }
    public void addScore(String name, int scoreToAdd) throws IOException {
        if (lines.size() < 2) throw new IOException("File was empty");
        if (lines.size() > 12) throw new IOException("File had too many lines");
        String header = lines.get(0);
        String footer = lines.get(lines.size() - 1);

        List<String> newLines = new ArrayList<>();
        newLines.add(header);

        boolean newLineAdded = false;
        int i = 1;
        for ( ; i < lines.size() - 1; i++) {
            if(getScore(lines.get(i)) < scoreToAdd && !newLineAdded) {
                int numberOfSpaces = i >= 10 ? 9-name.length() : 10-name.length();
                newLines.add("  " + i + ". " + name +
                        " ".repeat(numberOfSpaces) + " - " + scoreToAdd);
                newLineAdded = true;
            }
            if (newLineAdded) {
                newLines.add(lines.get(i).replaceFirst(Integer.toString(i),
                        Integer.toString(i + 1)));
            }
            else newLines.add(lines.get(i));
        }
        if (!newLineAdded) {
            int numberOfSpaces = i >= 10 ? 10-name.length() : 11-name.length();
            lines.add("  " + i + ". " + name +
                    " ".repeat(numberOfSpaces) + " - " + scoreToAdd);
        }
        if (newLines.size() > 11) newLines.remove(newLines.size() - 1);

        newLines.add(footer);
        lines = newLines;
    }
    private int getScore(String line) {
        return Integer.parseInt(line.substring(line.lastIndexOf('-') + 2));
    }
}
