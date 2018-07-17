Follow the below steps(screenshots of the execution from myside are also provided) 

Step1: Download the zip of four java and other files and  then open the terminal, then compile using the command
	javac *.java

Step2: Create the stub and skeleton for ServerOperations class using the command
	rmic ServerOperations

Step3: create RMI registry using the command 
	rmiregistry 5500            (here portnumber 5500)

-->>open another terminal window and follow below

step4: Run Server using the command 
	java ServerApplication <directorypath>
Example cmd: java ServerApplication serverdirectory   
(make sure the server started now, it will print server started and running on port 5505)

(if no such directory is present, it creates automatically. Here in the above exmple it creates a folder called "serverdirectory" in the serverApplication.java directoty)

step5: Concurrently run the ClientApplication on the other terminal window using the command 
	java ClientApplication 

 Case 1: To upload a file from client to server ( here case_number=1)
	cmd: java ClientApplication <case_number> <server directory path> <client directory path> <filename>
Example cmd: java ClientApplication 1 "G:\Thrinath Assignment\ServerFiles" "G:\Thrinath Assignment\ClientFiles" ClientFile.txt

 Case 2: To download a file from server to client(case_number=2)
	cmd: java ClientApplication <case_number>  <server path> <client path> <file name>
Example cmd: java ClientApplication 2 "G:\Thrinath Assignment\ServerFiles" "G:\Thrinath Assignment\ClientFiles" Welcome.txt

 Case 3: To list all files in server(case_number=3) 
	cmd: java ClientApplication <case_number> <serverpath>
Example cmd: java ClientApplication 3 "G:\Thrinath Assignment\ServerFiles" 

 Case 4: Delete a directory in server(case_number=4)
        cmd: java ClientApplication <case_number> <serverpath>
Example cmd: java ClientApplication 4 "G:\Thrinath Assignment\ServerFiles\dummy

 Case 5: Delete a file from the directory(case_number=5)
	cmd: java ClientApplication <case_number> <serverpath> <filename>
Example cmd: java ClientApplication 5 "G:\Thrinath Assignment\ServerFiles" Hello.txt

Resorces:
https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/hello/hello-world.html --->> this site helped to understand the java rmi and interface. 





     
   

           
        
              