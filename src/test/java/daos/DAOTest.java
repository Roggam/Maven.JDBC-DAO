package daos;

import models.Cars;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class DAOTest {
    @Test
    public void findByIdTest() { //passed
        //given
        DAO dao = new DAO();
        String expected = "Cars{id=5, year=2014, " +
                "make='Dodge', model='Charger', " +
                "color='Purple', vin='2B3CA4CT2AH305117'}";
        //when
        String actual = dao.findById(5).toString();
        //then

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findAllTest() { //passed
        //given
        DAO dao = new DAO();
        //when
        List actual = dao.findAll();
        //then
        Assert.assertNotNull(actual);

    }

    @Test
    public void createTest() { //passed
        //given
        DAO dao = new DAO();
        Cars mustang = new Cars(2019, "Ford", "Mustang", "Red", "MH4DC7360XX115985");
        //when
        Boolean actual = dao.create(mustang);
        //then
        Assert.assertTrue(actual);

    }

    @Test
    public void updateTest() {//passed
        //given
        DAO dao = new DAO();
        Cars mustang = new Cars(2022, "Ford", "Mustang", "Green", "MH4DC7360XX115985");
        //when
        Boolean actual = dao.update(9, mustang);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void deleteTest() {//passed
        //given
        DAO dao = new DAO();
        int idToDelete = 9;
        //when
        Boolean actual = dao.delete(idToDelete);
        //then
        Assert.assertTrue(actual);

    }


}
