@web
Feature: Product Price Validation
  As a user I want to verify the price of item on different pages

Background:
Given user navigates to search page

@uiScenario
Scenario: Validate item price of first element at Add To Cart Page and Checkout Pages remains same
 When use searches for "qa testing for beginners"
 Then verify item price at search and add to cart matches
 And  verify item price at search and checkout out page matches
 