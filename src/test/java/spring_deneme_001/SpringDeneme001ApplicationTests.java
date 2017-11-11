package spring_deneme_001;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring_deneme_001.model.Address;
import spring_deneme_001.model.PhoneNumber;
import spring_deneme_001.model.User;
import spring_deneme_001.service.MyTest;

/**
 * @author yakup
 * 
 * bu sayfa jUnit i deneme amaçlıydı içerisinde bişey yok yani
 *  */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDeneme001ApplicationTests {
	private double value1, value2;
	@Autowired
	private MyTest myTest;

	@Before
	public void setUp() {
		value1 = 2.0;
		value2 = 3.0;
	}

	@Test(timeout = 1000)
	public void contextLoads() {

		User user = new User("yakup", "yalcin", "email");
		user.setId(1l);
		Set adresler = new HashSet<Address>() {
			{
				add(new Address("adres1"));
				add(new Address("adres2"));
				add(new Address("adres3"));
			}
		};
		user.setAddresses(adresler);
		Set phoneNumbers = new HashSet<PhoneNumber>() {
			{
				add(new PhoneNumber("numara1"));
				add(new PhoneNumber("numara2"));
				add(new PhoneNumber("numara3"));
			}
		};
		user.setPhoneNumbers(phoneNumbers);

		assertThat(4.0).isEqualTo(myTest.carp(2.0, 2.0));
		assertThat(user.getLastname()).isEqualTo("yalcin");

		assertEquals(4.0, myTest.kalan(13.0, 8.0), 1);

		assertTrue("cevap doğru", myTest.carp(2.0, 4.0) == 8.0);
		assertFalse("islem false dondu", myTest.carp(2.0, 4.0) == 4.0);
		assertNotNull(user);

		int[] sayi = { 2, 1, 5, 3, 6 };
		int[] sayi2 = { 2, 1, 5, 3, 6 };
		assertArrayEquals("diziler eşleşiyor", sayi, sayi2);

		assertEquals("tamamdır", "Hello world", myTest.getMessage());

		Set<Double> sayilar = new HashSet<Double>();
		sayilar.add(5.0);
		sayilar.add(3.0);
		assertThat(5.0).isGreaterThan(3.0);
		assertThat(5.0).isIn(sayilar);
		assertThat(5.0).isPositive();

	}

}
