package ldts.pacman.view;

import ldts.pacman.gui.GUI;
import ldts.pacman.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    public void draw(Monster monster, GUI gui){
        gui.drawText(monster.getPosition(), "M", "#CC0000");
    }
}
