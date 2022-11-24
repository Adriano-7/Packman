package ldts.pacman.control.menu;

import ldts.pacman.Game;
import ldts.pacman.control.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.game.elements.Monster;
import ldts.pacman.model.game.elements.monsters.RedMonster;
import ldts.pacman.model.game.elements.Pacman;
import ldts.pacman.model.menu.Menu;
import ldts.pacman.state.GameState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) throws IOException {
        switch (option) {
            case UP:
                getModel().prev_Op();
                break;
            case DOWN:
                getModel().next_Op();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                // Temporary
                /*
                Arena arena = new Arena(10, 10);
                arena.setPacman(new Pacman(10, 10));
                List<Monster> monsters = new ArrayList<>();
                Monster red = new RedMonster(20, 20);
                monsters.add(red);
                arena.setMonsters(monsters);
                if (getModel().isSelectedStart()) {
                    game.setState(new GameState(arena));
                }
                */
                if (getModel().isSelectedStart()) {
                    game.setState(new GameState(new ArenaLoader(1).createArena()));
                }
                break;
            case QUIT:
                System.exit(0);
                break;
        }
    }
}
