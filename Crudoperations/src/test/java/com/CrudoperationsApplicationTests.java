package com;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.model.User;
import com.repo.UserRepo;
import com.service.UserService;
@SpringBootTest
@RunWith(SpringRunner.class)
class CruddemoApplicationTests {
	@Autowired
	private UserService userService;
	@MockBean
	private UserRepo userRepo;

	@Test
	public void getData() {
		
		when(userRepo.findAll()).thenReturn(
				Stream.of(new User(101, "Anu", 23), new User(102, "Pop", 24)).collect(Collectors.toList()));
		assertEquals(2, userService.getData().size());
	}
	@Test
	public void insertData() {
		User user = new User(201, "ABC", 21);
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.insertData(user));
	}

	@Test
	public void deleteById() {
		User user = new User(1, "Anu", 10);
		userService.deleteById(user.getId());
		verify(userRepo, times(1)).deleteById(user.getId());
	}
}
