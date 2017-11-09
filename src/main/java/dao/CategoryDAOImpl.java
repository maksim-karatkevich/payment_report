package dao;

import dao.handler.CategoryResultHandlerImpl;
import model.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maksim on 11/9/2017.
 */
public class CategoryDAOImpl extends AbstractDAO {
    private CategoryResultHandlerImpl categoryResultHandler = new CategoryResultHandlerImpl();

    public int persist(Category Category) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(Category.getName());
        parameters.add(Category.getName());
        String query = "INSERT INTO category (name) SELECT ? WHERE NOT EXISTS (SELECT * FROM Category WHERE name = ?)";
        return insertEntity(query, parameters);
    }

    public Category findByName(String name) {
        String query = "SELECT * FROM Category WHERE name = ?";
        return find(name, query);
    }

    public Category findById(long id) {
        String query = "SELECT * FROM Category WHERE id = ?";
        return find(id, query);
    }

    public int update(Category o) {
        return -1;
    }

    public int remove(Category o) {
        return -1;
    }

    private Category find(Object parameter, String query) {
        List<Object> parameters = new ArrayList<Object>();
        parameters.add(parameter);
        return getEntity(query, parameters, categoryResultHandler);
    }
}
