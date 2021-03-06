package com.digital.wallet.services;

import com.digital.wallet.models.Card;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class BanckService {
	private static List<BankCard> CARDS = Arrays.asList(new BankCard(123456789, 123, LocalDate.of(2020, 7, 1), 1000),
			new BankCard(987654321, 321, LocalDate.of(2022, 12, 1), -50),
			new BankCard(1234560987, 132, LocalDate.of(2025, 3, 1), 100),
			new BankCard(125678798, 132, LocalDate.of(2023, 3, 1), 2000),
			new BankCard(1231456789, 123, LocalDate.of(2020, 7, 1), 20),
			new BankCard(987165421, 321, LocalDate.of(2022, 12, 1), 30),
			new BankCard(1234150987, 132, LocalDate.of(2025, 3, 1), 6000),
			new BankCard(125617798, 132, LocalDate.of(2023, 3, 1), -100));

	public BankCard findAndCheckValidity(Card card) {
		for (BankCard c : CARDS) {
			if (c.getCardNumber() == card.getCardNumber())
				if (c.getCardCSV() == card.getCardCSV())
					if (c.getExpiryDate().isEqual(card.getExpiryDate()) && c.getExpiryDate().isAfter(LocalDate.now()))

						return c;
		}
		return null;
	}

	public int validAndEnoughMoney(double amount, Card card) {
		BankCard bCard = findAndCheckValidity(card);
		int ENOUGH_MONEY = 0;
		if (bCard != null) {
			if (amount <= bCard.getBalance()) {
				ENOUGH_MONEY = 1;
				bCard.setBalance(bCard.getBalance() - amount);
			}
			else
			ENOUGH_MONEY = -1;

		}
		return ENOUGH_MONEY;
	}

}

class BankCard extends Card {

	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public BankCard(long cardNumber, int cardCSV, LocalDate expiryDate, double balance) {
		super(cardNumber, cardCSV, expiryDate);
		this.balance = balance;
	}
}
