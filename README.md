Database Configuration:

The MongoDB configuration and connection in this project is already done in application.properties file. (I know it is not ideal to configure DB details and share to others on GIT. This was just done to simplify the setup process). If you wish to save the data in your database, you can change the configuration on application.properties file. (location /technical/src/main/resources/application.properties)
There is no need to create a new collection in your MongoDB, the code auto creates the collection on its first run.
The DB is currently deleted and empty, so any API call will begin entry with ID=1, and so on.


Steps to run this application in eclipse:

1. Open git link https://github.com/nair-niku/Bramfitt in any browser and copy the clone URL.
2. Open eclipse and open the Git Repositories window, click on "Clone a Git Repository". The copied URL will autofill this window and click on "Next/Finish" to proceed to clone the repository.
3. In the repository, go to Working Tree and right-click to open menu, select "Import Projects.."
4. Select the option "\technical" folder and import as "Maven", and select "Finish".
5. In the project, Run the file TechnicalApplication.java as a Java Application (location /technical/src/main/java/com/springboot/bramfitt/technical/TechnicalApplication.java)
6. Open a browser and go to "http://localhost:8080/" url. This will run the Application.



Design Choice:

A simple java springboot application has been made along with HTML, CSS and Thymeleaf. 
The Database used is MongoDB as NoSQL as they are scalable and flexible. Since the data fetched from API call is not of known fixed size, the decision was made to choose NoSQL db.
The code is fairly easy to understand and comments have been added wherever it felt necessary.



If I had more time to code, I would have tried to come up with a better implemention for the try-catch condition rather than writing the exception data into 0th position of the list in TFLServiceImpl.java line 45 and TFLController.java line 65.
Also I would have worked on improving the CSS styling in the HTML pages. Currently, the CSS I have written is a fairly commonly seen format.
