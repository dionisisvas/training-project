# training-project

The Java back-end provides a REST api that connects to an SQLite database and manages a user and user comments. Dependency injection is handled by spring. Design patterns were used for handling domain objects (MVC pattern, builders, transformers).

The AngularJS front-end provides routing, animations and displays the JSON data.

### Running the web application ###
The project is ready to run, with only prerequisite having a maven installation on you machine:
* Checkout training-project to a directory of your choice
* Download Maven 3 and unzip it in a desired directory, for example C:\maven
* Add the environment variable M2_HOME=C:\maven to windows environment variables
* Add %M2_HOME%\bin to your windows Path variable
* Open a command line interface and navigate to training-project home folder
* Issue the command: `mvn jetty:run`
* Open a browser and connect at `localhost:8080/spring`

### Setting up DEV Environment ###
To setup the development environment download required software and your choice of IDE. Checkout project in desired directory and import it. Maven should provide all external libraries required for building and running the application. You can run the application by providing `jetty:run` as a Maven run configuration parameter from your IDE of choice.

### Dependencies: ### 
* JDK 1.8
* Spring 4.2.4
* Maven 3
* Jetty 9
* AngularJS 1.6.4
* Bootstrap 3.3.7
* SQLite 3.18.0

### Database setup ###
The application has a pre-set database with some sample data. Scripts are provided in case you want to reset the DB or insert your own data:
* Edit sample files in 'training-project/db' folder of the project 
* Run the `create_db.bat` and you are ready to go!
