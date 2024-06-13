Feature: Add and remove a book

  Background: User generates token for authorization
    Given I am an authorized user

  Scenario: The authorized user can add and remove a book
    Given a list of books is available
    When I add a book to my reading list
    Then the book is added
    When I remove a book from my reading list
    Then the book is removed
