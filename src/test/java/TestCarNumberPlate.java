import org.junit.Test;
import parking.ParkingLot;

import static org.junit.Assert.assertEquals;

public class TestCarNumberPlate {

    private ParkingLot lot = new ParkingLot();

    @Test
    public void successCases() {


        for (int i = 1; i < 22; i++) {
            if (i <=10) {
                assertEquals(-1, lot.carNumberPlateDetection("VAN753"));
            } else if (i <21 ) {
                assertEquals(-2, lot.carNumberPlateDetection("VAN789"));
            } else {
                assertEquals(0, lot.carNumberPlateDetection("VAN156"));
            }
        }

        for (int i = 1; i < 22; i++) {
            if (i <=10) {
                assertEquals(7, lot.carNumberPlateDetection("EV123"));
            } else if (i <21 ) {
                assertEquals(8, lot.carNumberPlateDetection("EV789"));
            } else {
                assertEquals(0, lot.carNumberPlateDetection("EV456"));
            }
        }

        for (int i = 1; i < 62; i++) {
            if (i <=10) {
                assertEquals(1, lot.carNumberPlateDetection("ABC"));
            } else if (i <21 ) {
                assertEquals(2, lot.carNumberPlateDetection("ABC"));
            } else if (i < 31){
                assertEquals(3, lot.carNumberPlateDetection("ABC"));
            } else if (i < 41) {
                assertEquals(4, lot.carNumberPlateDetection("ABC"));
            } else if (i < 51) {
                assertEquals(5, lot.carNumberPlateDetection("ABC"));
            } else if (i < 61) {
                assertEquals(6, lot.carNumberPlateDetection("ABC"));
            } else {
                assertEquals(0, lot.carNumberPlateDetection("ABC"));
            }
        }
    }
}
