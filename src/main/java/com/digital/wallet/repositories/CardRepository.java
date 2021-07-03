package com.digital.wallet.repositories;

import com.digital.wallet.models.Card;
import com.digital.wallet.models.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CardRepository extends CrudRepository<Card,Long> {

	Card findByCardNumber(long cardNumber);


	//List<Card> findAllByCardHolder(Customer customer);
	Card findByCardHolder(Customer customer);

}
