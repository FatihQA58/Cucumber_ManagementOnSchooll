@e2e,@api
Feature: Get room
  Scenario: Get room and Validate

    Given send get request to url
    When validate body