package ldts.pacman.control.game;

import ldts.pacman.model.game.elements.Monster;

public interface MovementStrategy {
    // Maybe change monster to Element (also usable for Pacman)
    void move(Monster monster);
}
