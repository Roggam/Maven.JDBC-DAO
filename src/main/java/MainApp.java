import daos.DAO;
import models.Cars;

public class MainApp {
    public static void main(String[] args) {
        DAO dao = new DAO();
        Cars tesla = new Cars(2022,"Tesla","CyberTruck","Grey",  "WH4DC7360XX007988");
        Cars subaru = new Cars(2022,"Subaru","WRX","Blue",  "RH4DC7360XX117979");

        System.out.println(dao.findById(5).toString()); //works

        System.out.println(dao.findAll()); //works

      //  dao.update(6,tesla); //works

     //   dao.create(subaru); //works

      //   dao.delete(8); //works
    }


}
