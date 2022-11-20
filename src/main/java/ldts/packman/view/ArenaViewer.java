package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.arena.Arena;
import ldts.packman.model.game.elements.Coin;
import ldts.packman.model.game.elements.Element;
import ldts.packman.model.game.elements.Monster;
import ldts.packman.model.game.elements.Wall;

import java.io.IOException;
import java.util.List;

public class ArenaViewer {
    private PacmanViewer pacmanViewer;
    private MonsterViewer monsterViewer;
    private CoinViewer coinViewer;
    private WallViewer wallViewer;
    public ArenaViewer() {
        pacmanViewer = new PacmanViewer();
        monsterViewer = new MonsterViewer();
        coinViewer = new CoinViewer();
        wallViewer = new WallViewer();
    }
    public void draw(Arena arena, GUI gui) throws IOException {
        gui.clear();

        pacmanViewer.draw(arena.getPacman(), gui);
        drawElements(arena.getCoins(), gui, coinViewer);
        drawElements(arena.getMonsters(), gui, monsterViewer);
        drawElements(arena.getWalls(), gui, wallViewer);

        gui.refresh();
    }
    private<T extends Element> void drawElements(List<T> elements, GUI gui, ElementViewer<T> viewer) {
        for (T element: elements) {
            viewer.draw(element, gui);
        }
    }
}
