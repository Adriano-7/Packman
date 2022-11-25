## LDTS_04-03 - PAC-MAN

### Game Description
> In this thrilling recreation of the classic arcade game, you will be tasked with navigating a maze and eating all the Pac-dots while avoiding the infamous ghosts  Blinky, Pinky, Inky, and Clyde.
If one of the ghosts catches you, you will lose a life unless you've eaten a power pellet, in which case you can eat the ghosts for bonus points. If you lose all your three lives, it's game over.
You'll also be able to play with your friend in a 2-player mode, where one of you will live in the shoes of Pac-Man and the other will be a ghost.

This project was developed by *Adriano Machado* (*up202105352*@fe.up.pt), *Félix Martins* (*up202108837*@fe.up.pt) and *Tomás Pereira* (*up202108845*@fe.up.pt) for LDTS 2022⁄23.

### IMPLEMENTED FEATURES

> This section should contain a list of implemented features and their descriptions. In the end of the section, include two or three screenshots that illustrate the most important features.

>- **Pacman movement** - moves in direction given by input and keeps moving until reaches wall or receives input
>- **Monster movement** - moves randomly in the maze for now
>- **Pacman collects coins** - score increases when he collects one
>- **Pacman collides with monsters** - health decreased and positions of monsters and pacman reset to beginning of level
>- **Loading map from file** - map is loaded from file thus allowing different maps to be used
>   
>- ![Game Screenshot](https://user-images.githubusercontent.com/93844395/204031881-69ea1bdd-0acd-4d1a-9cec-cac0d7a03d75.png)

### PLANNED FEATURES

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.
>- **Multiplayer** - pacman player and monster player
>- **PowerUps for** pacman - makes ghosts "scared" (change behaviour) and is able to eat them for points
>- **Different** movement algorithms for different monsters
>- **Menu** to choose the level to play
>- **Menu** to see the best scores

### DESIGN
This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

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
>>**Consequences**\
>>Promotes replaceability (in this case, of Lanterna with another external library to draw things) and promotes SRP, since only the LanternaGUI is concerned with how exactly to draw things with Lanterna and not each of the Viewers (e.g. the viewers don't have to be concerned with the existence of a screen or TextGraphics) 



>>**Problem in Context**\
>>Monsters could have different ways of moving and the controller needs to know how to move them. There is the possibility of using a switch-case and determining the way they move that way. However, that disrespects the OCP and is not a good solution.
>>
>>**The Pattern**\
>>We have used the **Factory Method** pattern to return the way the monsters move to the controller.
>>**Implementation**
>>
>>**Consequences**\
>>Using this pattern, we delegate the algorithm choice for the movement to the type of monster. The controller asks for it from the monster and uses it to move said monster.


>>**Problem in Context**\
>>There are different ways of moving and a movable object might share his movement algorithm with another object. That would make for code cloning.
>>
>>**The Pattern**\
We used the **Strategy** pattern. There exist some strategies that define the way the entities can move. A given entity must only identify as moving with that algorithm and not define it.\
**Implementation**\
>>
>>**Consequences**
As such, we've removed having to clone code due to multiple entities having the same algorithm.



>>**Problem in Context**
>>In defining a class with its data, behaviour (movement) and way of drawing itself, we would be neglecting the **Single Responsibility Principle**.
>>
>>**The Pattern**   
We've used the **Model-View-Control** pattern, more specifically HMVC (MVC for each component). This defines a model with the data for the entity, a controller which manipulates that data and a Viewer to display the data.
>>
>>**Implementation**
>>
>>**Consequences**\
By using this pattern, we've delegated each responsibility to each class, now respecting the SRP.


>>**Problem in Context**\
>>A possible but bad solution would be to have multiple flags for the states in the Game and use a switch-case statement.
Any controller (controls movement of entities) could modify those flags which would make the game change behaviour
>>The controller for the player(s) should receive input from the user(s)
>>Modify behaviour of application according to state
>>
>>**The Pattern**\
We used the **State** Pattern to modify behaviour according to the state.
This pattern allows you to represent different states with different subclasses.
We can switch to a different state of the "game" by switching to another implementation (another subclass of State).
Our game (main class) has a state and any controller can modify it. The state represents what's going on in the application.
This pattern allowed to address the identified problems because
>>
>>**Implementation**
>>
>>**Consequences**\
Using this pattern makes existing states explicit and easier to comprehend.
There's no need for conditional statements in relation to application state, used polymorphism instead.
Passing input to the controllers is now done by states (using polymorphism) and it's clear what use it has in each state.



**Problem in Context**
**The Pattern**
**Implementation**
**Consequences**


- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

![img](https://www.fe.up.pt/~arestivo/page/img/examples/lpoo/state.svg)

These classes can be found in the following files:

- [Character](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/Character.java)
- [JumpAbilityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/JumpAbilityState.java)
- [DoubleJumpState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/DoubleJumpState.java)
- [HelicopterState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/HelicopterState.java)
- [IncreasedGravityState](https://web.fe.up.pt/~arestivo/page/courses/2021/lpoo/template/src/main/java/IncreasedGravityState.java)

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s ability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polymorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING
**Coverage Report**

![CoverageReport](https://user-images.githubusercontent.com/93844395/204028558-82f986fe-3a99-49b8-9121-8c68445c9861.png)

**Mutation Testing Report**
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.
- Adriano Machado:
- Félix Martins:
- Tomás Pereira:
**Example**:

- John Doe: 40%
- Jane Doe: 60%