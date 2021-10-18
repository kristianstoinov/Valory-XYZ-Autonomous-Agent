1. Assumptions

- The current assumptions are that we have two Agents and two Queues. 
- The first queue representing both the OutBox of Agent1 and the InBox of Agent2. The vice versa applies as well.
- Considering the time limitations, exactly 3 hours of implementation and 1 hour of Git / Documentation, perhaps some validations have been missed out.

2. Architecture decisions

- ConcurrentLinkedQueue is a good candidate for the current goal, because it supports thread-safe operations on queues.
- The MessageHandlers and Behaviours were intentionally not given names in order to decrease the complexity of the current example.
- The Application runs with the Spring Boot server for ease of use.
- The current Application is written in Java, as per the example started during the coding challenge.
 I am able to replicate the same in Python, but I chose to continue this example.
- Registration of Behaviours and MessageHandlers happens through updating the respective collections of the SimpleAutonomousAgent class.
- The Architecture of the application includes Interfaces for each of the classes to use as well as Generic Abstract classes for each of them,
so that we can easily use and create new and different types of instances of each object. 
- The Interfaces include some redundant methods, which are there to showcase the potential flexibility and abstraction.


3. Run and Test

- Best way to run and test this project would be to use the IntelliJ IDE for Java Applications and also Maven as a build tool.
- You need a Java (JDK) distribution of version 8 or higher.
- You can run the Main Class and also the TestApplication class, where the tests are.

4. Potential improvements

- Could add additional logs for more clarity.
- Logging can be improved upon.
- As mentioned, some more validations.
- More tests.