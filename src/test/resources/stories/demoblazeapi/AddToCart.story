Meta: 
@Demoblaze API for AddToCart

Scenario: Add product to cart

When I have selected product {"id":"a5378c7c7902","cookie":"user=3fb85704-3a5c-8997-c29d-25b57c3ac125","prod_id":7,"flag":false}
Then I should get response status code 200

And I should get response {}

