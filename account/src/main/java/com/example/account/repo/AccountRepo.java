package com.example.account.repo;

import com.example.account.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Accounts, Long> {
    Optional<Accounts>findByCustomerId(Long customerId);
    @Query("select a from Accounts a where a.accountNumber = :accountNumber")
    Optional<Accounts> findByAccountNumber(Long accountNumber);
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);

}
