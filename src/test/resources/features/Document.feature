Feature: Verify document details


  @version1
  Scenario Outline: Send a valid Request to get document details
    Given Send a request to the URL documents uuid to get document details with "<uuid>"
    Then the response will return status 200 and document details
    Examples:
      |uuid                      |
      |00bd48f1-5cd3-471c-9cb8   |
      |471c-9cb8-c27882ea68cbe   |
      |af8db4a5-af9b-47bd-a906   |

  Scenario Outline: Send a valid Request to get document details test
    Given patch request with "<uuid>"
    Then the response will return status 200 and value is update
    Examples:
      |uuid                      |
      |00bd48f1-5cd3-471c-9cb8   |