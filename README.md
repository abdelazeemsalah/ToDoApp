//to run application in any server

1-create database "task_management" 
2-create two tables status and task the DDL and DML in the file "db_DDL_DML.sql" in the same path
3-open eclipse and import existing maven project 
4-bulid the project using the command(mvn clean install)
5-go to target path and take the generated war from it
6-deploy the war file in any application server
7-open this url "http://localhost:8080/ToDoApp/" in browsr


//to run application in spring boot embedded server


1-create database "task_management" 
2-create two tables status and task the DDL and DML in the file "db_DDL_DML.sql" in the same path
3-open eclipse and import existing maven project
4-change the value of "taskManagementURL" variable in main.js file to "http://localhost:8080/Task"
5-bulid the project
6-right click on the project and select "run as spring boot project"
7-open this url "http://localhost:8080/" in browsr
