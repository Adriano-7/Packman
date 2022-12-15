package ldts.pacman.controller.game;

import ldts.pacman.Game;
import ldts.pacman.application.state.GameState;
import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.arena.Arena;
import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.model.menu.SaveScore;
import ldts.pacman.application.state.SaveScoreState;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ArenaController extends GameController {
    private List<GameController> controllers;
    public ArenaController(Arena arena) {
        super(arena);
        controllers = new ArrayList<>();
        controllers.add(new PacmanController(arena));
        controllers.add(new MonsterController(arena));
    }
    protected void addController(GameController controller) {
        controllers.add(controller);
    }
    @Override
    public void step(Game game, List<GUI.OPTION> options, long time) throws IOException {
        if (options.contains(GUI.OPTION.QUIT) || getModel().getPacman().getHealth() == 0) {
            int score = getModel().getPacman().getScore();
            game.setState(new SaveScoreState(new SaveScore(score)));
        }
        if(getModel().getCoins().isEmpty()) {
            Arena arena = new ArenaLoader(getModel().getLevel()).createArena(getModel().getPacman().getHealth(), getModel().getPacman().getScore());
            game.setState(new GameState(arena));
        }
        else {
            for (GameController controller : controllers) {
                controller.step(game, options, time);
            }
        }
    }

}
