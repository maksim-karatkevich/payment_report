import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import model.Category;
import model.Event;
import model.Shop;
import service.EventService;

/**
 * Created by Maksim_Karatkevich on 11/10/2017.
 */
public class ServiceTest {

	@Test
	public void saveEventTest() throws ParseException {
		EventService service = new EventService();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = simpleDateFormat.parse("20.11.2017");
		Event event = new Event(new Shop("Evroopt"), new Category("Product Shop Payment"), 1.1, date);
		service.saveEvent(event);
	}

	@Test
	public void getEventsTest() throws ParseException {
		EventService service = new EventService();
		service.getEventsByPeriod("2017-11-09", "2017-11-09");
	}
}
