package ldts.pacman.sound;
import ldts.pacman.controller.game.monster.state.ChaseState;
import ldts.pacman.controller.game.monster.state.ScaredState;
import ldts.pacman.model.game.elements.monsters.RedMonster;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class SoundMonster extends SoundObserver<RedMonster>{
    public SoundMonster(RedMonster model) {super(model);}
    @Override
    public void onSoundEvent() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(getModel().getState() instanceof ScaredState)
            playSound("src/main/resources/sounds/monster_scared.wav");
        if(getModel().getState() instanceof ChaseState)
            playSound("src/main/resources/sounds/monster_chase.wav");
    }
}
