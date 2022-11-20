package ldts.packman.view;

import ldts.packman.gui.GUI;
import ldts.packman.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    public void draw(Monster monster, GUI gui){
        gui.drawText(monster.getPosition(), "M", "#CC0000");
    }
}
