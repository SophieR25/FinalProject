Functions:
This program is a simple clicker game. At the startup of the game you will be able to either input a name or allow the program to choose a randomized name for you. Upon finalizing your name and starting the game, you will be entered into a one screen game area with collision around the buildings and edges to prevent clipping and the character from exiting the screen. The character sprite is a black cat that can be moved around the screen with the WASD keys. The goal of the game is to finalize all upgrades, with 3 upgrades being available for a shop and 3 upgrades being available for a cat bed. At all times the game currency, fish, is displayed in the top left and passively increased. The rate of passive increase increases as the shop is upgraded. Furthermore, fish can be increased by manually fishing, which is done at the dock and is where the clicker aspect of the game comes into play. 

How to use the program:
When starting the game you will be brought to a starting screen called “Welcome!”. To create a custom name, type your name into the textbox and hit enter. To get a random name, press the “Randomize” button. Your final name will be displayed on the left hand side. Once you are happy with your name, you may hit the “Start Game” button to progress to the game. You will not be able to change your name after this point. You will be placed in the top left corner of the game screen, with your character being a black cat. To move up press the W key. To move left press the A key. To move right press the D key. To move down press the S key. P is the interact button, but only works when you are in range of an interactable area. To interact with the shop, stand in front of the shop window and press P. The shop level ranges from one to three and can be seen in the top right corner of the shop menu. The shop can be upgraded by pressing the “Upgrade Fish Shop” with an adequate amount of currency, known as fish. As this aspect of the game is currently not working, I have not chosen what this amount should be. Fish can be seen in the top left of the game. The number of fish you have passively increases at a rate based on your shop level. To manually increase the number of fish you have, you will have to fish. You can open up the fishing menu by standing on the edge of the dock and pressing P. To fish, press the “Fish!” button, which will grant you one fish. Similarly to the shop, the cat bed has 3 total levels and can be upgraded with an adequate amount of money. The sprite of the bed should change with the bed level, however this aspect of the game is non-functional. All sprites, namely for the cat, the cat beds, the shop, and the background (there is an additional background asset that is unused due to the size of the game being cut) can be found under resources. 

Challenges encountered while writing program:
I had two major issues creating this project, namely adding user interaction to the game and creating global variables that updated between classes. My initial plan was to have everything in one panel, with interactive user interfaces popping up in small sections of the main game panel. When attempted, the buttons would not appear. I ultimately opted to make multiple windows, eliminating this issue. The biggest issue, which I still currently have, is creating interaction between the different panels. I have successfully implemented the state variable, which controls which panel is visible, across multiple panels. However, the currency variable (that controls the number of in-game currency fish) and the inputName variable (which stores the name chosen by the player) have caused significant issues for me. inputName is currently limited to the PanelWindow class, meaning I have so far been unable to display it in the fish shop window, which is created in the FishShopUIFinal class. currency has been successfully linked to the gamePanel class, allowing it to display in the top corner of the game and passively increase, however I have been unable to link it to FishShopUIFinal and FishingUI, meaning that it is not possible to manually increase the currency (fish) or buy upgrades. One main issue stems from FishShopUI, as I have not been able to get the fish shop level or the bed level to update elsewhere, making it impossible to update the passive currency increase rate or the bed appearance based on these values. 

Development concerns:
I feel my game does not have significant development issues as the content is too simplistic to address such topics. In terms of character representation, there are only two cats. As a game with just cats and no people, human diversity does not seem to be an issue. Regrettably, I did not have time to add more cats with different appearances, either as NPCs or as selectable player sprites, which does limit the amount of cat representation in the game. However, I do not see this as particularly damaging in terms of diversity since they are just cats. The game itself is quite fair. All players would start with the same resources, generated at the same rate. The main mechanism of the game is clicking, but even players able to click at an exceptionally fast rate are not at an advantage due to the limit at which the game updates, meaning there is a cap to how quickly you can generate new fish set by how quickly the game recognizes a new click. If I were to make one change to make the game more fair, it would be to explain game controls within the game. There is nowhere that states that the move buttons are WASD, or even more ambiguous, that the interact button is P. Furthermore, that the interact button only works within designated event zones is never explained. This would make the program extremely difficult for anyone to use without outside information. 

Brief explanation of each class:

AddToCurrency- a mock class made in attempt to fix the issue with currency. This currently does not link to anything or have any used code. 

Background- contains the image used as the background and the Graphics 2d used by the gamePanel to draw it

BedAppearance- contains the images used for the bed and the Graphics 2d used to draw it. Currently only draws one bed due to inability to pull Bed Level from FishShopUIFinal

CatGameMain- builds the windows for the game panels 

CollisionChecker- pulls data about player position from the player class and creates collision with the fish shop, bed, edges of the map, and the water

Entity- a base class initially created with the intention of adding more NPCs or movable entities to the game. Creates variables about player movement and position

FindName- a mock class made in attempt to fix the issue with inputName. This currently does not link to anything or have used code

FishingShopUIFinal- creates the fish shop panel and includes functionality such as the ability to buy things 

FishingUI- creates the fishing panel and includes functionality such as the fishing clicker

FishshopAppearance- pulls the image used as the fish shop sprite and creates the Graphics2D for it that is later used in GamePanel

GamePanel- the main class that links to all other classes and contains the panel where the cat sprite is seen walking (and where the fish shop and bed sprite are displayed)

KeyInput- determines the WASD key inputs and assigns them to boolean variables

PanelWindow- the initial game panel that pops up and allows you to choose a name

Player- Moves the player based on information from KeyInput and CollisionChecker

StateLocation- pulls information from player location and key input to determine if the player can switch to a new screen

TestFishShopUI- test code made when attempting to make the game in one panel rather than multiple

UI- test code made when attempting to make the game in one panel rather than multiple

fishCounter- unfortunately made with improper capitalization, passively increases the fish currency the player has as displayed in the top left corner. The fish seen in the top left of the screen is a truncated value determined in GamePanel based on this class
