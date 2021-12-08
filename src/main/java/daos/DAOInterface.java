package daos;

import java.util.List;

public interface DAOInterface <AnyType>{

    public AnyType findById(int id);
    public List findAll();
    public Boolean update(int id, AnyType dto);
    public Boolean create( AnyType dto);
    public Boolean delete(int id);

}
