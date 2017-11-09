package dao.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Maksim_Karatkevich on 11/9/2017.
 */
public interface ResultHandler <T>{
	T handle(ResultSet t) throws SQLException;
}
