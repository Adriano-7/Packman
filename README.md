## LDTS_2L.EIC04-03 - PAC-MAN

### Game Description
> In this thrilling recreation of the classic arcade game, you will be tasked with navigating a maze and eating all the Pac-dots while avoiding the infamous ghosts  Blinky, Pinky, Inky, and Clyde.
If one of the ghosts catches you, you will lose a life unless you've eaten a power pellet, in which case you can eat the ghosts for bonus points. If you lose all your three lives, it's game over.
You'll also be able to play with your friend in a 2-player mode, where one of you will live in the shoes of Pac-Man and the other will be a ghost.

This project is under development by *Adriano Machado* (*up202105352*@fe.up.pt), *Félix Martins* (*up202108837*@fe.up.pt) and *Tomás Pereira* (*up202108845*@fe.up.pt) for LDTS course of 2022⁄23.

### IMPLEMENTED FEATURES
>- **Pacman movement** - moves in direction given by input and keeps moving until reaches wall or receives input
>- **Monster movement** - moves randomly in the maze for now
>- **Pacman collects coins** - score increases when he collects one
>- **Pacman collides with monsters** - health decreased and positions of monsters and pacman reset to beginning of level
>- **Loading map from file** - map is loaded from file thus allowing different maps to be used
>
> ![Game](https://user-images.githubusercontent.com/93844395/204083448-e0a45342-ce44-46d8-b204-686bc19dc1c8.png)

### PLANNED FEATURES

>- **Multiplayer** - pacman player and monster player
>- **PowerUps for** pacman - makes ghosts "scared" (change behaviour) and is able to eat them for points
>- **Different** movement algorithms for different monsters
>- **Menu** to choose the level to play
>- **Menu** to see the best scores
