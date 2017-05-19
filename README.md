# training-project

The Java back-end connects to an SQLite db to fetch a user; an instance of it is created using the builder pattern.

The AngularJS front-end provides routing, animations and displays the JSON data.

The project is ready to be built. After building, use `jetty:run` as a command line parameter with IntelliJ, or `mvn jetty:run` at the CL to start the jetty servlet. Finally, connect at `localhost:8080/spring`.

### Dependencies: ### 
* JDK 1.8
* Spring 4.2.4
* Maven 3
* Jetty 9
* AngularJS 1.6.4
* Bootstrap 3.3.7
* SQLite 3.18.0

### Database setup ###
* Download SQLite and:
  * save it inside the `db` folder located at the root of the project
  * or add `sqlite3` to your environmental variables
* Run the `create_db.bat` and you are ready to go!

