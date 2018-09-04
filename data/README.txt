######################################################################
#####################PRODUCT WEBAPP DOCUMENTATION#####################
######################################################################

Please follow the following steps

Step 1 - Setting up front-end
- Install NodeJS
- Navigate to app/proxy folder
- On the node terminal, run npm install
- Now run node server.js - this will start the server on port 5000

Step 2 - Setting up back-end
- Navigate to project folder
- Run mvn clean install
- Go to target folder and run the jar using java -jar
- This will start the SprintBoot service

Step 3- Running the application
- Open the browser and open localhost:5000 and the web application should open
- There are 4 tabs:
	- Home - This tab contains the description of the application
	- Products - This tab provides the functionality of fetching the list of products
	- Add - This tab provides the functionality of adding a new products
	- Modify - This tab provides the functionality of modifying an existing product entry. The user can choose the available products from the drop down, and then fill the form and click on Submit button.
	
#Details about the web app
- MVC based architecture
- Controller layer has been divided into 3 parts:
	- REST controller - that exposes the APIs
	- Service layer
	- DAO connection for filesystem/database
- The front-end has been developed using AngularJS, JQuery, HTML, CSS, Bootstrap. The server that hosts the application has been written in NodeJS.
- The service layer has been written in Java, SprintBoot. For test coverage, Junits and Mockito has been used.
- The back-end is filesystem currently, but can be extended to use Database.
- The service writes to a file that is places in the /tmp folder, please ensure you have a /tmp folder, else change the location of file in the properties file.
