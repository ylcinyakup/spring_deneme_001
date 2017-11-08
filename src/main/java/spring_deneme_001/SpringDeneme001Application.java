package spring_deneme_001;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;
import spring_deneme_001.repository.UserRepository;


@SpringBootApplication
public class SpringDeneme001Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDeneme001Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		User user1 = new User("asdqwe", "asdqwe", "asdqwe");
		Address adres1 = new Address("adres1", user1);
		Address adres2 = new Address("adres2", user1);
		Address adres3 = new Address("adres3", user1);
		PhoneNumber pn1 = new PhoneNumber("numara1", user1);
		PhoneNumber pn2 = new PhoneNumber("numara2", user1);
		PhoneNumber pn3 = new PhoneNumber("numara3", user1);

		Set adresler = new HashSet<Address>() {
			{
				add(adres1);
				add(adres2);
				add(adres3);
			}
		};
		user1.setAddresses(adresler);

		Set phoneNumbers = new HashSet<PhoneNumber>() {
			{
				add(pn1);
				add(pn2);
				add(pn3);
			}
		};
		user1.setPhoneNumbers(phoneNumbers);

		userRepository.save(new HashSet<User>() {
			{
				add(user1);
			}
		});
	}
}
