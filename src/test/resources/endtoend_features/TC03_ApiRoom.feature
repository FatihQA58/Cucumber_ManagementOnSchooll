@e2e,@api
Feature: Get room
  Scenario: Get room and Validate

    Given send get request to url by id
    When validate response body