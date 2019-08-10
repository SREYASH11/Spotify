@run
Feature:Spotify
  Scenario:Play song from Recently played
    Given Application is opened
    When I choose song from Recently played playlist
    Then Song is played

   Scenario: Play dong from Search box
     Given Application is on search menu
     When I enter "UnderCover" to search song
     Then I will choose song from list
     And Song is played

    Scenario Outline: P lay song from search box using different artist name
      Given Application is on search menu
      When I enter "<Artist>" to search song
      Then I will choose song from list
      And Song is played
      Examples:
      |Artist|
      |John Lennon|
      |  KK         |
      |    Bob dylan       |




