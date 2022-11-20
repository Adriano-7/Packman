package ldts.packman.control;

import ldts.packman.model.game.elements.Monster;

public class MonsterController {
    private Monster monster;
    public MonsterController(Monster monster) {
        this.monster = monster;
    }
    public void move() { // maybe strategy pattern here
    }
    public void changeDirectionRandom() {
        //
    }
}
