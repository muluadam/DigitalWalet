package com.digital.wallet.repositories;

import com.digital.wallet.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TansactionRepository extends JpaRepository<Transaction, Long> {
	
	//List<Transaction> findByWalletSenderOrWalletReciever(long id);
	//nativeQuery = true,value =
   @Query("SELECT t FROM Transaction t WHERE (t.walletReciever=:id AND t.status='SUCCESS') OR t.walletSender=:id ")
   List<Transaction> findWalletTransactions(@Param("id") long id);
   
}
