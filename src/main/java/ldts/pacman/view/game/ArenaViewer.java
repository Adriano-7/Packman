package ldts.pacman.view.game;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.Position;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.elements.Element;
import ldts.pacman.view.Viewer;

import java.util.List;

public class ArenaViewer extends Viewer<Arena> {
    private PacmanViewer pacmanViewer;
    private MonsterViewer monsterViewer;
    private CoinViewer coinViewer;
    private WallViewer wallViewer;
    private PowerUpViewer powerUpViewer;
    public ArenaViewer(Arena arena) {
        super(arena);
        pacmanViewer = new PacmanViewer();
        monsterViewer = new MonsterViewer();
        coinViewer = new CoinViewer();
        wallViewer = new WallViewer();
        powerUpViewer = new PowerUpViewer();
    }
    @Override
    public void drawElements(GUI gui) {
        drawElements(getModel().getCoins(), gui, coinViewer);
        drawElements(getModel().getPowerUps(), gui, powerUpViewer);
        drawElements(getModel().getMonsters(), gui, monsterViewer);
        drawElements(getModel().getWalls(), gui, wallViewer);
        pacmanViewer.draw(getModel().getPacman(), gui);
    }
    private<T extends Element> void drawElements(List<T> elements, GUI gui, ElementViewer<T> viewer) {
        for (T element: elements) {
            viewer.draw(element, gui);
        }
    }
}
