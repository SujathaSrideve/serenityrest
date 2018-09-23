Meta:
@Demoblaze API for DeleteItem

Scenario: Delete product from Cart

When I request delete item {"id":"a5378c7c7902"}
Then I should get response status code 200 from API

And I should get this response 'Item deleted.'
