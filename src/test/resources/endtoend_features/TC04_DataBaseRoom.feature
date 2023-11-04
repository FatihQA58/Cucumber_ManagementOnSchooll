@e2e,@database
  Feature: Room DataBase Test
    Scenario: Select Room
      Given connect to database
      Then read and validate
