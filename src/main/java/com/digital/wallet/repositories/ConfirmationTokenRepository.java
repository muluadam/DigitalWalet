package com.digital.wallet.repositories;

import com.digital.wallet.models.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

	ConfirmationToken findByToken(String token);


}
