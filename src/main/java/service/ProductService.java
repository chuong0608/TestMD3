package service;

import java.sql.SQLException;
import java.util.List;

public interface ProductService<Product> {

    public List<Product> findAll() throws SQLException;
    public List<Product> findByPrice(int key1,int key2) throws SQLException;
    public List<Product>findByName(String key);


}
