# Parking Lot System
Assignment. Parking lot system assigns designated floor for a vechicle in accordance with it's plate number.

## How it works
Parking lot has 10 floors: -2, -1, 1 ... 8. Each floor has 10 parking spaces. Parking Lot entrance is at floor #1.

There are three kind of vechicles: Electric car, Van and Regular car (Petrol/Gasolin). These cars have designated parking floors. They are identfied by their plate numbers:
1) Electric Car plate number starts with "EV" and they can park in 7 or 8 floors.
2) Van plate number starts with "VA" and they can park in -1 or -2 floors.
3) Regular car plate number starts with any characters and they can park in any floor.

For convenience, parking lot system assigns closest parking floor. If all parking floors are taken, program finishes.

Parking Lot System shall be run in Main.java.

When started, program asks to enter plate number. Scanner was used for entering and plate number should be entered directly into the console.
By entered plate number, program assigns a floor and puts vechicle in register, with plate number and floor number.
Then program asks are there any more cars or customers left. Boolean should be entered in console. 
If true, program asks if customer wants to enter or leave the parking lot. If false - program finishes.
If customer wants to enter, boolean true shall be entered and then vechicle plate number must be put. Program puts vechicle in register.
If customer wants to leave, boolean false shall be entered and then vechicle plate number must be put. Program search for plate number in register.
If plate number is found, vechicle is removed from register and floor parking space clears.

Program finishes if all parking spaces are taken or if there are no more customers.
When this happens, "Good Bye" message appears and register file is printed out with all car plate numbers and assigned floors.

### Unit Test

Test has been written for car number plates assigning to floor numbers.

