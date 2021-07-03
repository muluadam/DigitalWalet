package com.digital.wallet.validators;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String>{

	@Override
	public boolean test(String email) {
		// TODO Auto-generated method stub
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
		
	}

}
