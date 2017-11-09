package dao;

/**
 * Created by Maksim_Karatkevich on 11/9/2017.
 */
public interface ShopDAO <T> {
	int persist(T t);
	T findByName(String name);
	T findById(long id);
	int update(T t);
	int remove(T t);
}
