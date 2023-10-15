package dao;

import java.util.ArrayList;

public interface UserDAO<Type> {
    void insert(Type type);

    void update(Type type);

    void delete(String id);

    ArrayList<Type> selectAll();

    Type selectById(String id);

    boolean CheckExistence(String id);

}
