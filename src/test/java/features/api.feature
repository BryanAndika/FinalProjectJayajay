Feature: Test Automation Rest API

  @api
  Scenario: Test get list data users
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users.json"

  @api
  Scenario: Test create user
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new user
    Then validation status code equals 200
    Then validation response body post create new users
    Then validation response json with JSONSchema "post_create_new_user.json"

  @api
  Scenario: Test delete user
    And hit api post create new user
    Then validation status code equals 200
    Then validation response body post create new users
    And hit api delete new
    Given prepare url for "DELETE_USERS"
    When hit api delete new
    Then validation status code equals 200

  @api
  Scenario: Test update user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit api post create new user
    Then validation status code equals 200
    Then validation response body post create new users
    Given prepare url for "UPDATE_NEW_USER"
    Then validation status code equals 200
    Then validation response body update user