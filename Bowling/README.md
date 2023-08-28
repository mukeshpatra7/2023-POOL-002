Bowling Game
=================

A Springboot Application developed in TDD Approach to calculate the score.


### Scoring for bowling game

		
* Each game, or “line” of bowling, includes ten turns, or “frames” for the bowler.
* In each frame, the bowler gets up to two tries to knock down all the pins.
* If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
* If in two tries he knocks them all down, this is called a “spare” and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
* If on his first try in the frame he knocks down all the pins, this is called a “strike”. His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
* If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
* The game score is the total of all frame scores.
	
### Prerequisite

* Java 8 
* Java IDE(IntelliJ, Eclipse)


### Git Cloning

		git clone https://github.com/mukeshpatra7/2023-POOL-002.git
		cd Bowling

	
### Build 
	
* After importing the project into IDE we can now use Maven to create an executabe JAR file with embedded web server
* Right mouse button on the "Bowling" project name select Run As-> Maven install
* "/bowling/target/Bowling-0.0.1-SNAPSHOT.jar" will be created in the target directory

## Run

 Running with IDE
* Right click on "Bowling" project and select Run As->Spring Boot App
* The web service can now be interacted with.
           
 Running stand alone JAR
   * Open terminal/command prompt
   * Navigate to "/bowling/target/" where Bowling-0.0.1-SNAPSHOT.jar is located
   * Type "java -jar Bowling-0.0.1-SNAPSHOT.jar"
   * The web service will start and can now be interacted with. This JAR file can be used anywhere and is not directory specific.

### Interact

* Open a web browser with a REST client ( Google Chrome with the Advanced Rest Client plugin located here "https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo?hl=en-US" )
   * Type "localhost:8080/bowling/roll" into the URL box
   * Select "POST" as the method type
   * Type in your pay load with bowlingGame input e.g. { "bowlingRoll": "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"}
   * Select "application/json" as content type
   * Click Send
   * Assuming your input is valid the response will be {"frames":[0,10,0,2,3,4,4,8,2,3],"score":36}

## Input Format

* When scoring  'X' indicates a strike, '\' indicates a spare & '-' indicates a miss
	
 Sample Input :
 
			{
    			"bowlingRoll": "X 5/ 1- 11 12 31 22 44 11 12"
			}	


## Swagger URL

	 http://localhost:8080/swagger-ui
	 
## JUnit Coverage

Run : Test Case
		
			mvn test

* Coverage Report will be generated at path \target\site\jacoco folder

