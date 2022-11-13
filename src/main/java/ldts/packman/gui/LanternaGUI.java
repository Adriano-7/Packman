package ldts.packman.gui;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import ldts.packman.model.game.Position;

import javax.swing.*;
import java.io.IOException;

public class LanternaGUI implements GUI {
    private Screen screen;

    public LanternaGUI(Screen screen) {this.screen = screen;}

    public LanternaGUI(int width, int height) throws IOException{
        //AWTTerminalFontConfiguration fontConfig = load
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height) {
        return null;
    }

    private Screen createScreen(Terminal terminal) {
        return null;
    }

    @Override
    public OPTION getNextOption() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return OPTION.NONE;

        return OPTION.NONE;
    }

    @Override
    public void drawText(Position position, String text, String color){}

    @Override
    public void clear(){}

    @Override
    public void refresh(){}

    @Override
    public void close(){}
}

