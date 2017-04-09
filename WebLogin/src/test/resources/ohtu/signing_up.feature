Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation successful with correct username and password
    Given new user is selected
    When correct new username "newuser" and correct password "c0rrectPassword" and correct password confirmation "c0rrectPassword" are given
    Then user is created and forwarded to wellcome

  Scenario: creation fails with too short username and valid password
    Given new user is selected
    When too short username "aa" and correct password "c0rrectPassword" and correct password confirmation "c0rrectPassword" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When correct new username "newuser" and too short password "short1" and too short password confirmation "short1" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When correct new username "newuser" and letter-only password "onlylettersinpassword" and letter-only password confirmation "onlylettersinpassword" are given
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given new user is selected
    When already taken username "jukka" and valid password "c0rrectPassword" and valid password confirmation "c0rrectPassword" are given
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When correct new username "newuser" and valid password "c0rrectPassword" and not matching password confirmation "n0taMatch" are given
    Then user is not created and error "password and password confirmation do not match" is reported

  Scenario: user can login with successfully generated account
    Given user with username "liisa" with password "salainen1" is successfully created
    And login is selected
    When correct username "liisa" and password "salainen1" are given
    Then user is logged in

  Scenario: user can not login with account that is not successfully created
    Given user with username "aa" and password "bad" is unsuccessfully created
    And login is selected
    When nonexistent username "aa" and password "bad" are given
    Then user is not logged in and error message is given
