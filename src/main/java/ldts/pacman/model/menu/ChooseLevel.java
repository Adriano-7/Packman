package ldts.pacman.model.menu;

import ldts.pacman.model.game.arena.ArenaLoader;
import ldts.pacman.sound.observer.SoundSelection;
import ldts.pacman.sound.subject.SoundSubject;

import java.util.Arrays;
import java.util.List;

public class ChooseLevel extends Menu {
    private final ArenaLoader arenaLoader;
    public ChooseLevel(SoundSelection soundSelection, SoundSubject soundSubject, ArenaLoader arenaLoader) {
        super(soundSelection, soundSubject);
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
