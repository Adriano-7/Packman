package ldts.pacman.model.menu.options;

import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.sound.SoundSelection;

import java.util.Arrays;
import java.util.List;

public class ChooseLevel extends Menu {
    private final ArenaLoader arenaLoader;
    public ChooseLevel(SoundSelection soundSelection, ArenaLoader arenaLoader) {
        super(soundSelection);
        this.arenaLoader = arenaLoader;
    }
    public ArenaLoader getArenaLoader() {
        return this.arenaLoader;
    }
    @Override
    protected List<String> createOptions() {
        return Arrays.asList("LEVEL 1", "LEVEL 2", "LEVEL 3", "EXIT");
    }
    public boolean isSelectedExit(){
        return isSelected(3);
    }
}
