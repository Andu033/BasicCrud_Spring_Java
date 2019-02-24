package com.andu033.restapi.basiccrud.models;

import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class userTest {
	
	@Test
	public void emailIsValid_shouldReturnTrueIfTheEmailHasAValidFormat() {
		user user1 = new user("andrei","stanila","dcuan17@yahoo.com");
		Assert.assertTrue(user1.emailIsValid());
		user1.setEmail("blabla@upb.ro");
		Assert.assertTrue(user1.emailIsValid());
	}
	
	@Test
	public void emailIsValid_shouldReturnFalseIfTheEmailDoesNotHaveAValidFormat() {
		user user1 = new user("andrei","stanila","dcuan17yahoocom");
		Assert.assertFalse(user1.emailIsValid());
		user1.setEmail("@upb.ro");
		Assert.assertFalse(user1.emailIsValid());
		user1.setEmail("dcuan17.com");
		Assert.assertFalse(user1.emailIsValid());
		user1.setEmail("blabla@upb.");
		Assert.assertFalse(user1.emailIsValid());
	}
}