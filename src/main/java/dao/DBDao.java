package dao;

import model.Event;

/**
 * Created by Maksim on 10/31/2017.
 */
public interface DBDao<O> {

    void create(O o);
    void update(O o);
    void remove(O o);
    O get(O o);
}
