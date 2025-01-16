# ShoppingCartAssessment

## ShoppingCartApp 

### Summary 
The user can display cart, remove an item, add an item, and checkout the items in the cart.

#### Functionality

- Dislay main menu with 5 options. 
	- View, Add, Remove, Checkout, Exit
- Creates print out of menu and allows user to select the option

- Contains class for item, cart, catalog
- Item stores name, price
- Cart has-a Item, can have none or many
- Cart stores collection of items and the quanitities

- For functionality and segmentation, class for consoleIO (input), controling menu MenuController, CartService

- Catalog Class to store the items for inventory that the cart pulls from
- The catalog is displayed when the option to add an item is selected

- Checkout method calculates the cost of the cart items if items exist otherwise no checkout
- During checkout the cart is displayed with items

- Contains tests for each option to ensure proper execution ~ at least 3

- Future considerations
 	- Add interface for added functionality
