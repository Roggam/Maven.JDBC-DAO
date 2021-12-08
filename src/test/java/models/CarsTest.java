package models;

import org.junit.Assert;
import org.junit.Test;

public class CarsTest {
    @Test
    public void constructorTest() {
        //given
        int year = 2022;
        String make = "Subaru";
        String model = "WRX";
        String color = "Blue";
        String vin = "RH4DC7360XX117979";


        Cars subaru = new Cars(year, make, model, color, vin);
        //when
       int actualYear = subaru.getYear();
       String actualMake = subaru.getMake();
       String actualModel = subaru.getModel();
       String actualColor = subaru.getColor();
       String actualVin = subaru.getVin();

        //then
        Assert.assertEquals(year, actualYear);
        Assert.assertEquals(make, actualMake);
        Assert.assertEquals(model, actualModel);
        Assert.assertEquals(color, actualColor);
        Assert.assertEquals(vin, actualVin);


    }


}
