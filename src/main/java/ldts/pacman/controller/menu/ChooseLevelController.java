package ldts.pacman.controller.menu;

import ldts.pacman.Game;
import ldts.pacman.application.state.GameState;
import ldts.pacman.application.state.menu.MainMenuState;
import ldts.pacman.controller.Controller;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.menu.options.ChooseLevel;
import ldts.pacman.model.menu.options.MainMenu;
import ldts.pacman.sound.SoundPacCoin;
import ldts.pacman.sound.SoundPacDies;
import ldts.pacman.sound.SoundSelection;
import ldts.pacman.sound.SoundStartLevel;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public class ChooseLevelController extends Controller<ChooseLevel> {
    public ChooseLevelController(ChooseLevel model) {
        super(model);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for (GUI.OPTION option: options) {
            switch (option) {
                case UP:
                    getModel().prev_Op();
                    break;
                case DOWN:
                    getModel().next_Op();
                    break;
                case QUIT:
                    game.setState(new MainMenuState(new MainMenu(new SoundSelection())));
                    break;
                case SELECT:
                    if (getModel().isSelectedExit()) {
                        game.setState(new MainMenuState(new MainMenu(new SoundSelection())));
                        break;
                    }
                    int levelNumber = getModel().getCurrentOption() + 1;
                    ArenaLoader arenaLoader = getModel().getArenaLoader();

                    arenaLoader.setLevelNumber(levelNumber);
                    Arena arena = arenaLoader.createArena(new SoundPacCoin(), new SoundPacDies(), new SoundStartLevel());
                    game.setState(new GameState(arena));
                    break;
                default:
                    break;
            }
        }
    }
}
