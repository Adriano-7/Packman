package ldts.pacman.gui;


import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import ldts.pacman.controller.game.monster.state.MonsterState;
import ldts.pacman.model.game.Position;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class LanternaGUI implements GUI {
    private final Screen screen;
    Set<Integer> pressedKeys = new HashSet<>();

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
        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
            }
        });

        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, IOException, FontFormatException {
        URL resource = getClass().getClassLoader().getResource("fonts/Square-PacFont.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        g.registerFont(font);

        Font loadFont =  font.deriveFont(Font.PLAIN, 28);
        return AWTTerminalFontConfiguration.newInstance(loadFont);
    }
    @Override
    public List<OPTION> getNextOptions() throws IOException {
        List<OPTION> actions = new LinkedList<>();
        if (pressedKeys.contains(KeyEvent.VK_Q)) actions.add(OPTION.QUIT);
        if (pressedKeys.contains(KeyEvent.VK_UP)) actions.add(OPTION.UP);
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) actions.add(OPTION.RIGHT);
        if (pressedKeys.contains(KeyEvent.VK_DOWN)) actions.add(OPTION.DOWN);
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) actions.add(OPTION.LEFT);
        if (pressedKeys.contains(KeyEvent.VK_ENTER)) actions.add(OPTION.SELECT);
        if (pressedKeys.contains(KeyEvent.VK_W)) actions.add(OPTION.UP2);
        if (pressedKeys.contains(KeyEvent.VK_D)) actions.add(OPTION.RIGHT2);
        if (pressedKeys.contains(KeyEvent.VK_S)) actions.add(OPTION.DOWN2);
        if (pressedKeys.contains(KeyEvent.VK_A)) actions.add(OPTION.LEFT2);
        clearKeys();
        return actions;
    }
    private void clearKeys() {
        pressedKeys.clear();
    }
    @Override
    public void drawPacman(Position position, Position direction) {
        if(direction.equals(new Position(0,1))) {drawCharacter(position,'b', "#FFFF00");}
        else if(direction.equals(new Position(0,-1))) {drawCharacter(position,'d', "#FFFF00");}
        else if(direction.equals(new Position(1,0))) {drawCharacter(position,'a', "#FFFF00");}
        else if(direction.equals(new Position(-1,0))) {drawCharacter(position,'c', "#FFFF00");}
        else drawCharacter(position, 'e', "#FFFF00");
    }
    @Override
    public void drawWall(Position position){
        drawCharacter(position,'k', "#2424FF");
    }
    @Override
    public void drawCoin(Position position){
        drawCharacter(position,'l', "#d4af37");
    }
    @Override
    public void drawMonster(Position position, Position direction, MonsterState state) {
        Map<Position, Integer> index= new HashMap<>();
        index.put(new Position(0, 1),0); index.put(new Position(0, -1), 1);
        index.put(new Position(1, 0), 2); index.put(new Position(-1, 0), 3);
        if (direction.equals(new Position(0, 0))) {
            char upChar = 'g';
            drawCharacter(position, upChar, state.getColor());
        }
        else drawCharacter(position, state.getDrawingChar()[index.get(direction)], state.getColor());
    }

    @Override
    public void drawPowerUp(Position position) {
        drawCharacter(position, 'j', "#ffffff");
    }
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
        drawText(new Position(0, 22), "SCORE: " + score, "#FFFFFF");
    }
    @Override
    public void drawHealth(int health) {
        while (health > 0) {
            drawCharacter(new Position(health, 21), 'a', "#FFD700");
            health--;
        }
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

