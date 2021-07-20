package ru.absens.spring.security.jwt;

import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import ru.absens.spring.security.jwt.models.User;
import ru.absens.spring.security.jwt.repository.UserRepository;
import ru.absens.spring.security.jwt.security.services.UserDetailsImpl;
import ru.absens.spring.security.jwt.security.services.UserDetailsServiceImpl;

import java.util.Optional;

@SpringBootTest
class UserDetailsServiceTest {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@MockBean
	UserRepository userRepository;

	@Test
	void findOneUserTest() {
		User userFromDB = new User();
		userFromDB.setId(1L);
		userFromDB.setEmail("test@y.ru");
		userFromDB.setUsername("user");
		userFromDB.setPassword("100");

		Mockito.doReturn(Optional.of(userFromDB)).when(userRepository).findByUsername("user");

		UserDetailsImpl user = userDetailsService.loadUserByUsername("user");
		Assertions.assertNotNull(user);
		Assertions.assertEquals(1L, user.getId());
		Assertions.assertEquals("user", user.getUsername());
		Assertions.assertEquals("test@y.ru", user.getEmail());
		Assertions.assertEquals("100", user.getPassword());
		Mockito.verify(userRepository, Mockito.times(1)).findByUsername(ArgumentMatchers.eq("user"));
	}

}
