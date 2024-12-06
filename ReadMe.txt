This file includes steps to run the project
1. Download the entire codebase into the local machine
2. Frontend is configured to run backend API's on port 8081. Make sure that your spring application is running on 8081 port
	--How to change port of spring application
	- Add server.port=8081 in applications.properties file. 

3. Running react frontend
 - Run npm i-- to install all the dependencies and make sure you have relevant node version (18.20.5)
 - Run "npm run dev" command to run the frontend on port 5173. 

4. Since it is running on in-memory database(H2) you wont be able to see any products in home page. Click on "Add Product" to view list. 
