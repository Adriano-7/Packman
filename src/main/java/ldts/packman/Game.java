package ldts.packman;

import ldts.packman.gui.LanternaGUI;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;

    public Game(LanternaGUI gui) throws IOException {
        this.gui = new LanternaGUI(40,40);
    }

}
