package parking;

import java.util.Collections;
import java.util.Scanner;

public class ParkingLot extends RegisterSystem {

    private Scanner scanPlate = new Scanner(System.in);
    private Scanner scanAnswer = new Scanner(System.in);
    private boolean isAny = true;


    void parkingLotEntrance() {
        System.out.println("Welcome to Parking ParkingLot");
        System.out.println("Our scanner doesn't work today, please enter your car number by hand");
        System.out.println("Electric Vehicles car numbers starts with EV****, Vans start with VA*** and all other cars starts with any characters");

        while(isAny) {
            System.out.println("Please enter plate number:");
            String plateNumber = scanPlate.nextLine();
            plateNumber = plateNumber.toUpperCase();
            int floorNumber = carNumberPlateDetection(plateNumber);
            if (floorNumber == 0) {
                System.out.println("We are sorry, there is no free parking space at the moment. Please wait till someone leaves");
                break;
            }
            plateNameRegister.put(plateNumber, floorNumber);
            System.out.println("Please go to " + floorNumber + " parking floor");
            System.out.println("Are there any cars left? (enter boolean: true/false)");
            isAny = scanAnswer.nextBoolean();
            if (!isAny) {
                System.out.println("Good Bye");
                break;
            }
            isAny = leaveOrEnterParking();
            if (!isAny) {
                System.out.println("Good Bye");
                break;
            }
        }

        System.out.println("Cars left in parking lot:");
        System.out.println(Collections.singletonList(plateNameRegister));

    }

    private boolean leaveOrEnterParking() {

        System.out.println("Welcome. Do you want to leave or enter parking lot? (true for enter / false for leave)");
        boolean leave = scanAnswer.nextBoolean();
        if (!leave) {
            System.out.println("Please enter car number plate you want to leave with:");
            String enteredPlateNumber = scanPlate.nextLine();
            enteredPlateNumber = enteredPlateNumber.toUpperCase();
            if (plateNameRegister.containsKey(enteredPlateNumber)){
                int floor = plateNameRegister.get(enteredPlateNumber);
                System.out.println("Plate number detected. You are now leaving " + floor + " floor");
                leftCarsInFloor(floor);
                plateNameRegister.remove(enteredPlateNumber, floor);
                System.out.println("Are there any cars left? (enter boolean: true/false)");
                isAny = scanAnswer.nextBoolean();
                return isAny;
            } else {
                System.out.println("No such number plate detected. Try again");
                leaveOrEnterParking();
            }
        }
        return leave;
    }

    public int carNumberPlateDetection(String plate) {
        if (plate.substring(0,2).equals("EV")) {
            System.out.println("Electric car detected");
            return electricCarParkingLot();
        } else if (plate.substring(0,2).equals("VA")) {
            System.out.println("Van detected");
            return vanParkingLot();
        } else {
            System.out.println("Petrol/Diesel car detected");
            return regularCarParkingLot();
        }

    }


    private int electricCarParkingLot() {

        if(numberOfCarsFloor7 < 10) {
            numberOfCarsFloor7++;
            return 7;
        } else if (numberOfCarsFloor8 < 10) {
            numberOfCarsFloor8++;
            return 8;
        } else {
            return 0;
        }
    }

    private int vanParkingLot() {
        if(numberOfCarsFloorMin1 < 10) {
            numberOfCarsFloorMin1++;
            return -1;
        } else if (numberOfCarsFloorMin2 < 10) {
            numberOfCarsFloorMin2++;
            return -2;
        } else {
            return 0;
        }
    }

    private int regularCarParkingLot () {
        if(numberOfCarsFloor1 < 10) {
            numberOfCarsFloor1++;
            return 1;
        } else if (numberOfCarsFloor2 < 10) {
            numberOfCarsFloor2++;
            return 2;
        }  else if(numberOfCarsFloor3 < 10) {
            numberOfCarsFloor3++;
            return 3;
        } else if (numberOfCarsFloor4 < 10) {
            numberOfCarsFloor4++;
            return 4;
        }  else if(numberOfCarsFloor5 < 10) {
            numberOfCarsFloor5++;
            return 5;
        } else if (numberOfCarsFloor6 < 10) {
            numberOfCarsFloor6++;
            return 6;
        } else if(numberOfCarsFloorMin1 < 10) {
            numberOfCarsFloorMin1++;
            return -1;
        } else if (numberOfCarsFloorMin2 < 10) {
            numberOfCarsFloorMin2++;
            return -2;
        } else {
            return electricCarParkingLot();
        }
    }

    private void leftCarsInFloor(int floorNumber) {
        switch (floorNumber) {
            case -1:
                numberOfCarsFloorMin1--;
            case -2:
                numberOfCarsFloorMin2--;
            case 1:
                numberOfCarsFloor1--;
            case 2:
                numberOfCarsFloor2--;
            case 3:
                numberOfCarsFloor3--;
            case 4:
                numberOfCarsFloor4--;
            case 5:
                numberOfCarsFloor5--;
            case 6:
                numberOfCarsFloor6--;
            case 7:
                numberOfCarsFloor7--;
            case 8:
                numberOfCarsFloor8--;
        }
    }

}
