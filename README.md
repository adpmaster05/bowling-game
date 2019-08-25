# bowling-game
Implementation of Ten-Pin-Bowling

#### How to run the project from commandline:
To run this code you can do it in two ways. It is required to have maven 3+ installed.
#### 1) Downloading the project as zip
  1. Download the code
  2. unzip the file
  3. open commandline and go to bowling-game folder
  4. run following maven command: mvn package exec:java
  
#### 2) Cloning this repository (require git installation)
  1. Open commandline
  2. Clone this repository with the following command: git clone https://github.com/adpmaster05/bowling-game.git
  3. type cd bowling-game
  4. run following maven command: mvn package exec:java

Once it's running it will print out -> Insert a file path: 

Then you can use one of the following included files to test:

* valid-two-players-game.txt
* perfect-game.txt
* zero-score-game.txt
* fouls-score-game.txt
* invalid-format.txt
* incomplete-game.txt
