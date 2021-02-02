@api 
Feature: validate create and delete api 

Background: 
	Given set base uri of api 
	
@apiScenario 
Scenario: Status Validation for get request 
	Then user validate "Get" for "success" 
	
@apiScenario
Scenario: validate details of an employee 
	Then validate details for employee id "1"
		|id             |1              |
		|employee_name  |Tiger Nixon    |
		|employee_salary|320800         |
		|employee_age   |61             |
		
@apiScenario 
Scenario: validate delete of an employee record is successfull 
	Then user validate deleted message is "Successfully! Record has been deleted" for employee id "2" 
 