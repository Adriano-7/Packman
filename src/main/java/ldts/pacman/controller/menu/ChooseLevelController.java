package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.GameState;
import ldts.pacman.application.state.MainMenuState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.menu.ChooseLevel;
import ldts.pacman.model.menu.MainMenu;

import java.io.IOException;

public class ChooseLevelController extends Controller<ChooseLevel> {
    public ChooseLevelController(ChooseLevel model) {
        super(model);
    }
    @Override
    public void step(Game game, GUI.OPTION option, long time) throws IOException {
        switch (option) {
            case UP -> getModel().prev_Op();
            case DOWN -> getModel().next_Op();
            case QUIT -> game.setState(new MainMenuState(new MainMenu()));
            case SELECT -> {
                if (getModel().isSelectedExit()) {
                    game.setState(new MainMenuState(new MainMenu()));
                    break;
                }
                int levelNumber = getModel().getCurrentOption() + 1;
                Arena arena = new ArenaLoader(levelNumber).createArena();
                game.setState(new GameState(arena));
            }
        }
    }
}
