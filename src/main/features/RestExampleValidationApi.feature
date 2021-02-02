@api
Feature: validate create and delete api

Background:
Given set base uri of api

@validateApi
Scenario: Status Validation for get 
 Then user validate "Get" for "success"
 
 @validateApi
Scenario: validate details of an employee
 Then user validate for employee id "1" name is "Tiger Nixon"
 
  @validateApi
Scenario: validate delete of an employee
 Then user validate deleted message is "Successfully! Record has been deleted" for employee id "2"
 