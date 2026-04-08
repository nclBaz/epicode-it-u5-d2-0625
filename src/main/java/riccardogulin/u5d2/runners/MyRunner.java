package riccardogulin.u5d2.runners;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import riccardogulin.u5d2.dao.UsersDAO;

@Component
@Order(1)
public class MyRunner implements CommandLineRunner {

	private Faker faker;
	private UsersDAO usersDAO;

	public MyRunner(Faker faker, UsersDAO usersDAO) {
		this.faker = faker;
		this.usersDAO = usersDAO;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CIAO DAL RUNNER");
		System.out.println(faker.gameOfThrones().character());

		usersDAO.save();
		usersDAO.findById();
	}
}
