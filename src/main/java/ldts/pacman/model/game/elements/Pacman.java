package ldts.pacman.model.game.elements;

public class Pacman extends MovableElement {
    int health;
    int score;
    public Pacman(int x, int y) {
        super(x, y);
        this.health = 3;
        this.score = 0;
    }
    public void setScore(int score){ this.score=score;}
    public int getScore(){return this.score;}
    public void increaseScore() {this.score+=1;}
    public int getHealth() {
        return health;
    }
    public void decreaseHealth() {
        this.health--;
    }
}
