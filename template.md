## LDTS_2L.EIC04-03 - PAC-MAN

### Game Description
> In this thrilling recreation of the classic arcade game, you will be tasked with navigating a maze and eating all the Pac-dots while avoiding the infamous ghosts  Blinky, Pinky, Inky, and Clyde.
If one of the ghosts catches you, you will lose a life unless you've eaten a power pellet, in which case you can eat the ghosts for bonus points. If you lose all your three lives, it's game over.
You'll also be able to play with your friend in a 2-player mode, where one of you will live in the shoes of Pac-Man and the other will be a ghost.

This project was developed by *Adriano Machado* (*up202105352*@fe.up.pt), *Félix Martins* (*up202108837*@fe.up.pt) and *Tomás Pereira* (*up202108845*@fe.up.pt) for LDTS 2022⁄23.

### IMPLEMENTED FEATURES
>- **Pacman movement** - moves in direction given by input and keeps moving until reaches wall or receives input
>- **Monster movement** - moves randomly in the maze for now
>- **Pacman collects coins** - score increases when he collects one
>- **Pacman collides with monsters** - health decreased and positions of monsters and pacman reset to beginning of level
>- **Loading map from file** - map is loaded from file thus allowing different maps to be used
>   

### PLANNED FEATURES

>- **Multiplayer** - pacman player and monster player
>- **PowerUps for** pacman - makes ghosts "scared" (change behaviour) and is able to eat them for points
>- **Different** movement algorithms for different monsters
>- **Menu** to choose the level to play
>- **Menu** to see the best scores
>
> Conceptual mock-ups of the planned features:
> 
> <img src="https://user-images.githubusercontent.com/93844395/204063857-afe1e54a-b2d7-45c2-a558-3914241dc886.jpg" height="664,8" width="806,4" >

### DESIGN

>>**Problem in Context**\
>>Using Lanterna directly as a way of drawing in all of our Viewer Classes would make for a direct violation of the DIP
>>In fact, a lot of our classes would depend on Lanterna. Changing that external library would be difficult (or just updating it): changes would have to be made across several classes.
>> 
>>**The Pattern**\
>>We used the **Adapter** pattern. Using a GUI interface with the methods used by our classes allows less frequent changes in general classes and avoids direct dependency across them.
>>In the case that we would change the external library, all that would be needed is to implement the GUI interface in a new class and pass that derived class to our classes.
>>
>>**Implementation**
>> 
>> <img src="https://user-images.githubusercontent.com/93844395/204065998-a82f33bd-253e-4c7f-8e70-a52c010587c6.jpg" height="336,63" width="531,09" >
>>
>> These classes can be found in the following links:
>> - [GUI](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/gui/GUI.java)
>> - [LanternaGUI](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/gui/LanternaGUI.java)
>>
>> The client in the picture is a denotation for all the classes that use the GUI
>> 
>>**Consequences**\
>>Promotes replaceability (in this case, of Lanterna with another external library to draw things) and promotes SRP, since only the LanternaGUI is concerned with how exactly to draw things with Lanterna and not each of the Viewers (e.g. the viewers don't have to be concerned with the existence of a screen or TextGraphics) 



>>**Problem in Context**\
>>Monsters could have different ways of moving and the controller needs to know how to move them.
> There is the possibility of using a switch-case and determining the way they move that way, depending on flags in monster. 
> However, that disrespects the OCP and is not a good solution.
>>
>>**The Pattern**\
>>We have used the **Factory Method** pattern to return the way the monsters move to the controller (and also the color of the monster).
> The abstract Class Monster knows it has to return a way to move (an abstract MovementStrategy).
> It does not know, however, which concrete implementation to return. Therefore, by using this pattern, we delegate the choice of the MovementStrategy to the subclasses of Monster.
> Only those will (know to) specify the concrete specification (e.g. RandomMovement)
>>
>>**Implementation**
>> 
>> <img src="https://user-images.githubusercontent.com/93844395/204080284-b589bb6e-7bc4-4db3-a905-9f265da6bf1c.jpg" height="338,58" width="556,38" > 
>> 
>> These classes can be found in the following links:
>> - [Monster](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/model/game/elements/Monster.java)
>> - [BlueMonster](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/model/game/elements/monsters/BlueMonster.java)
>> - [RedMonster](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/model/game/elements/monsters/RedMonster.java)
>> - [OrangeMonster](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/model/game/elements/monsters/OrangeMonster.java)
>> - [PurpleMonster](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/model/game/elements/monsters/PurpleMonster.java)
>> - [MovementStrategy](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/MovementStrategy.java)
>> - [RandomMovement](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/RandomMovement.java)
>>
>>**Consequences**\
>>Using this pattern, we delegate the algorithm choice for the movement to the type of monster.
> The controller asks for it from the monster and uses it to move said monster.


>>**Problem in Context**\
>>There are different ways of moving and a movable object might share his movement algorithm with another object.
> That would make for code cloning.
>>
>>**The Pattern**\
>>We used the **Strategy** pattern. There exist some strategies that define the way the entities can move. A given entity must only identify as moving with that algorithm and not define it.\
>>
>>**Implementation**\
>>
>> <img src="https://user-images.githubusercontent.com/93844395/204080444-1fe67958-bcd0-4e7e-a1bc-45e9f087192b.jpg" height="307" width="508,2" > 
>> 
>> These classes can be found in the following links:
>> - [MonsterController](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/MonsterController.java)
>> - [MovementStrategy](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/MovementStrategy.java)
>> - [RandomMovement](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/RandomMovement.java)
>> - [PlayerMovement](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/PlayerMovement.java)
>>
>>**Consequences**
>>As such, we've removed having to clone code due to multiple entities having the same algorithm.


>>**Problem in Context**\
>>In defining a class with its data, behaviour (movement) and way of drawing itself, we would be neglecting the **Single Responsibility Principle**.
>>
>>**The Pattern**   
We've used the **Model-View-Control** pattern, more specifically HMVC (MVC for each component). This defines a model with the data for the entity, a controller which manipulates that data and a Viewer to display the data.
>>
>>**Implementation**
> 
> 
>![MVC](https://user-images.githubusercontent.com/93844395/204065838-d7cb2566-f179-4da2-b522-af6faff55a1f.jpg)
> 
>> An example of the application of this pattern can be found in the following links:
>> - [PacmanController](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/control/game/PacmanController.java)
>> - [PacmanViewer](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/view/game/PacmanViewer.java)
>> - [PacmanModel](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/model/game/elements/Pacman.java)
>>
>>**Consequences**\
By using this pattern, we've delegated each responsibility to each class, now respecting the SRP.


>>**Problem in Context**\
>>A possible but bad solution would be to have multiple flags for the states in the Game and use a switch-case statement.
Any controller (controls movement of entities) could modify those flags which would make the game/application change behaviour
>>The controller for the player(s) should receive input from the user(s)
>>
>>**The Pattern**\
We used the **State** Pattern to modify behaviour according to the state.
This pattern allows you to represent different states with different subclasses.
We can switch to a different state of the "game" by switching to another implementation (another subclass of State).
Our game (main class) has a state and any controller can modify it. The state represents what's going on in the application.
In the classes below, there's also present the usage of a FactoryMethod, allowing the subclasses of State to denote their controller and viewer of choice.
This pattern allows us to avoid the scattered conditional logic by using polymorphism.
>>
>>**Implementation**
>> 
>><img src="https://user-images.githubusercontent.com/93844395/204080620-b3bb1148-4f18-43b0-9ef5-fb8fb8881615.jpg" height="328,4" width="505,8" >
>>
>>  These classes can be found in the following links:
>> - [Game](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/Game.java)
>> - [State](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/state/State.java)
>> - [GameState](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/state/GameState.java)
>> - [MenuState](https://github.com/FEUP-LDTS-2022/project-l04gr03/blob/main/src/main/java/ldts/pacman/state/MenuState.java)
>> 
>>**Consequences**\
Using this pattern makes existing states explicit and easier to comprehend.
There's no need for conditional statements in relation to application state, used polymorphism instead.
Passing input to the controllers is now done by states (using polymorphism) and it's clear what use it has in each state.


#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

#### Parallel Inheritance Hierarchies
When creating a new Monster subclass, there would be a tendency to create a new MovementStrategy to generate a new way to move that monster.
This could be fixed by allocating the movement logic to the monster subclass.
However, this is not a good solution from our project's point of view, since there may be many monsters with the same movement logic.

#### Switch Statements
There are switches used in direction and options.
Possible refactor would be to add a Direction and/or Option Parent Class and add specific Direction/Option subclasses.
For example, in the case of Direction, it would be easy to implement a method getNextPosition() for each Direction.
As such defining the direction would allow us to only call that method and not have to deal with conditional logic.
The conditional logic (switches) would be substituted by polymorphism (Refactor called Replace Type Code with Subclasses))
However, this would result in a class explosion (too many classes), especially in the long run.

#### Speculative Generality
Several options in Menu are not implemented and are unused ("MULTIPLAYER", "SCORES", "OPTIONS").
A possibly refactor would be to remove these options and only adding them when the features for these options are implemented (or are in the work)

#### Repeated field across subclasses
Each monster class has a certain colour with which it will be colored.
However, the attribute for color is present in each of the monsters and not even in the general (abstract) monster.
A simple refactor would be to move that attribute to the Monster class and to make the constructor initiate that element with the return value of getColor.
Another possible solution would be to delete that attribute and implement the getColor logic directly with the raw return value for each subclass of monster.

#### Refused Bequest
Class Controller has abstract function step with parameters Game, GUI.OPTION, time.
There exist many controllers that extend this class, but not all of them use all of those parameters in their implementation of step.
For example, MenuController's step doesn't use time and MonsterController's step does not need the option.
A solution for this would be splitting the "interfaces" of said Controllers. This does not deem necessary in this simple case, where only one attribute is not used.


### TESTING
**Coverage Report**

<img src="https://user-images.githubusercontent.com/93844395/204059751-7b661b7e-4353-4d14-a1db-d0f69be09885.png" height="340,2" width="997,5" >

-[Mutation testing report](https://adriano-7.github.io/)

### SELF-EVALUATION

- Adriano Machado:
- Félix Martins:
- Tomás Pereira:
