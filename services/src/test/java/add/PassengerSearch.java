package add;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ivanslushko.training.datamodel.Passenger;
import com.ivanslushko.training.services.PassengerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")

public class PassengerSearch {

	@Inject
	private PassengerService passengerService;

	@Test
	public void byFullName() {

		List<Passenger> passenger = passengerService.findByFullName("Anton Goncharuk");
		if (passenger.size() == 0) {
			System.out.println("This full name not found!");
		} else {
			System.out.println("By Full Name:");
			for (int i = 0; i < passenger.size(); i++) {
				System.out.println("    " + passenger.get(i));
			}
		}
	}

	@Test
	public void byBirthday() {

		List<Passenger> passenger = passengerService.findByBirthday(Date.valueOf("1985-12-11"));
		if (passenger.size() == 0) {
			System.out.println("This Birthday not found!");
		} else {
			System.out.println("By Birthday:");
			for (int i = 0; i < passenger.size(); i++) {
				System.out.println("    " + passenger.get(i));
			}
		}
	}

	@Test
	public void byPassport() {

		List<Passenger> passenger = passengerService.findByPassport("KH5632267");
		if (passenger.size() == 0) {
			System.out.println("This Passport not found!");
		} else {
			System.out.println("By Passport:");
			for (int i = 0; i < passenger.size(); i++) {
				System.out.println("    " + passenger.get(i));
				
				
				System.out.println("    " + passenger.get(i).getId());
				
				
				
			}
		}
	}
}
