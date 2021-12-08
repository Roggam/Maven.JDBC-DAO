package daos;

import com.sun.jdi.connect.Connector;
import models.Cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAO implements DAOInterface<Cars> {


    public Cars findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);
            if (rs.next()) {
                return extractCarsFromResult(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");

            List<Cars> cars = new ArrayList<>();

            while (rs.next()) {
                Cars car = extractCarsFromResult(rs);
                cars.add(car);
            }

            return cars;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Boolean update(int id, Cars car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET make = ?, model = ?, color = ?, year = ?, vin = ? WHERE id ="+id);
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getColor());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getVin());

            int i = ps.executeUpdate();

            if(i == 1){
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean create(Cars car) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car (make, model, color, year, vin) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getColor());
            ps.setInt(4, car.getYear());
            ps.setString(5, car.getVin());
            int i = ps.executeUpdate();

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE id=" + id);

            if(i == 1) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private Cars extractCarsFromResult(ResultSet rs) throws SQLException {
        Cars cars = new Cars();

        cars.setId(rs.getInt("id"));
        cars.setYear(rs.getInt("year"));
        cars.setMake(rs.getString("make"));
        cars.setModel(rs.getString("model"));
        cars.setColor(rs.getString("color"));
        cars.setVin(rs.getString("vin"));

        return cars;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Cars cars = new Cars(2022,"Tesla","Model S","Green",  "JH4DC4360XX007991");
        //dao.create(cars);
        dao.update(6,cars);
       // System.out.println(dao.findAll());
    }


}
