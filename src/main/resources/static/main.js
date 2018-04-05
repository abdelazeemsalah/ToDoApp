var app = angular.module("TaskManagement", []);
 
// Controller Part
app.controller("TaskController", function($scope, $http) {
 
	//if you use spring boot embedded server use this http://localhost:8080/Task
 var taskManagementURL='http://localhost:8080/ToDoApp/Task'
    $scope.tasks = [];
    $scope.statusList = [];
    $scope.taskObject = {
    		taskId:0 ,
    		creationDate:new Date(),
    		status: {statusId:0,statusName:""},
        description: ""
    };
 
    // Now load the data from server
    refreshTaskData();
 

    $scope.submitTask = function() {
 
        var method = "POST";
        //var url = "";
 
 

        $http({
            method: method,
            url: taskManagementURL+"/addTask",
            data: angular.toJson($scope.taskObject),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(success, error);
        
    };
 
    $scope.createTask = function() {
        clearFormData();
    }
 

    $scope.deleteTask = function(task) {
        $http({
            method: 'DELETE',
            url:taskManagementURL+ '/task/' + task.taskId
        }).then(success, error);
    };
 
    // In case of edit
    $scope.editTask = function(task) {
    	//$scope.taskObject=	task;
    	for(var i=0;i<$scope.statusList.length;i++)
    	{
    		if(task.status.statusId==$scope.statusList[i].statusId) 
    			{
    			$scope.taskObject.status=$scope.statusList[i];
    			break;
    			}
    			 	
    	}
    	  
        $scope.taskObject.taskId = task.taskId;
        $scope.taskObject.creationDate =new Date(task.creationDate);
        $scope.taskObject.description = task.description;
    };
 

    function refreshTaskData() {
        $http({
            method: 'GET',
            url:taskManagementURL+ '/tasks'
        }).then(
            function(res) { // success
                $scope.tasks = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
        $http({
            method: 'GET',
            url:taskManagementURL+ '/statusList'
        }).then(
            function(res) { // success
                $scope.statusList = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
 
    function success(res) {
        refreshTaskData();
        clearFormData();
    }
 
    function error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function clearFormData() {
        $scope.taskObject.taskId =0;
        $scope.taskObject.status = null;
        $scope.taskObject.creationDate =new Date();
        $scope.taskObject.description = "";
    };
});