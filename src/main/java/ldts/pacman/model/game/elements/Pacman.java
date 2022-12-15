package ldts.pacman.model.game.elements;

public class Pacman extends MovableElement {
    private int health;
    private int score;
    public Pacman(int x, int y) {
        super(x, y);
        this.health = 3;
        this.score = 0;
    }
    public Pacman(int x, int y, int health, int score) {
        super(x, y);
        this.health = health;
        this.score = score;
    }
    public void setScore(int score){ this.score=score;}
    public void setHealth(int health){ this.health=health;}
    public int getScore(){return this.score;}
    public void increaseScore() {this.score+=1;}
    public int getHealth() {
        return health;
    }
    public void decreaseHealth() {
        this.health--;
    }
}
