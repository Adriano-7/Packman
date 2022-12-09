package ldts.pacman.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import ldts.pacman.model.game.Position;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {this.screen = screen;}

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("fonts/Square-Regular.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        g.registerFont(font);

        Font loadFont =  font.deriveFont(Font.PLAIN, 25);
        return AWTTerminalFontConfiguration.newInstance(loadFont);
    }
    @Override
    public OPTION getNextOption() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return OPTION.NONE;
        KeyType keyType = keyStroke.getKeyType();
        if ((keyType == KeyType.EOF) || (keyType == KeyType.Character && keyStroke.getCharacter() == 'q')) return OPTION.QUIT;
        if (keyType == KeyType.ArrowUp) return OPTION.UP;
        if (keyType == KeyType.ArrowDown) return OPTION.DOWN;
        if (keyType == KeyType.ArrowLeft) return OPTION.LEFT;
        if (keyType == KeyType.ArrowRight) return OPTION.RIGHT;
        if (keyType == KeyType.Enter) return OPTION.SELECT;
        return OPTION.NONE;
    }

    @Override
    public void drawPacman(Position position){
        drawCharacter(position,'@', "#FFFF00");
    }
    @Override
    public void drawWall(Position position){
        drawCharacter(position,'#', "#2424FF");
    }
    @Override
    public void drawCoin(Position position){
        drawCharacter(position,'o', "#d4af37");
    }
    @Override
    public void drawMonster(Position position, String color){drawCharacter(position,'M',color);}
    @Override
    public void drawText(Position position, String text, String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void drawCharacter(Position position, char ch, String color){
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setForegroundColor(TextColor.Factory.fromString(color));
        textGraphics.putString(position.getX(), position.getY(), "" + ch);
    }
    @Override
    public void drawScore(int score) {
        drawText(new Position(0, 21), "Score: " + score, "#FFD700");
    }
    @Override
    public void drawHealth(int health) {
        drawText(new Position(0, 20), "Health: " + health, "#FFD700");
    }

    @Override
    public void clear(){
        screen.clear();
    }

    @Override
    public void refresh() throws IOException{
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}

