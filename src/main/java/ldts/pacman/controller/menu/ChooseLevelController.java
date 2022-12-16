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
import ldts.pacman.sound.observer.*;
import ldts.pacman.sound.subject.SoundSubject;

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
                case UP -> getModel().prev_Op();
                case DOWN -> getModel().next_Op();
                case QUIT -> game.setState(new MainMenuState(new MainMenu(new SoundSelection(), new SoundSubject())));
                case SELECT -> {
                    if (getModel().isSelectedExit()) {
                        game.setState(new MainMenuState(new MainMenu(new SoundSelection(), new SoundSubject())));
                        break;
                    }
                    int levelNumber = getModel().getCurrentOption() + 1;

                    ArenaLoader arenaLoader = getModel().getArenaLoader();

                    arenaLoader.setLevelNumber(levelNumber);
                    Arena arena = arenaLoader.createArena(new SoundSubject(), new SoundPacCoin(), new SoundPacDies(), new SoundStartLevel());

                    game.setState(new GameState(arena));
                }
            }
        }
    }
}