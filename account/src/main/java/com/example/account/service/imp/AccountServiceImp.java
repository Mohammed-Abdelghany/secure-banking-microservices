package com.example.account.service.imp;

import com.example.account.Dto.AccountDto;
import com.example.account.Dto.CustomerDto;
import com.example.account.constants.AccountConstants;
import com.example.account.entity.Accounts;
import com.example.account.entity.Customer;
import com.example.account.exception.CustomerAlreadyExistsException;
import com.example.account.exception.ResourceNotFoundException;
import com.example.account.mapper.AccountMapper;
import com.example.account.mapper.CustomerMapper;
import com.example.account.repo.AccountRepo;
import com.example.account.repo.CustomerRepo;
import com.example.account.service.IAccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImp implements IAccountService {
    private AccountRepo accountRepo;
    private CustomerRepo customerRepo;
    private AccountMapper accountMapper;
    private final CustomerMapper customerMapper;

    @Override
    @Transactional
    public void createAccount(CustomerDto customerDto) {


        Customer customer = customerMapper.toCustomer(customerDto);
        Optional<Customer> existingCustomer = customerRepo.findByMobileNumber(customer.getMobileNumber());
        if (existingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer with mobile number " + customer.getMobileNumber() + " already exists.");
        }

      Customer customerSaved= customerRepo.save(customer);
        this.createNewAccount(customerSaved);
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepo.findByMobileNumber(mobileNumber)
                .orElseThrow(() ->new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));

        Accounts account=accountRepo.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", String.valueOf(customer.getCustomerId())));

        CustomerDto customerDto=customerMapper.toDto(customer);
        customerDto.setAccountsDto(accountMapper.toDto(account));
        return customerDto;
    }


    @Override
    @Transactional
    public boolean updateAccount(CustomerDto customerDto) {
        if (customerDto.getAccountsDto() != null) {
            Long AccountNumber = customerDto.getAccountsDto().getAccountNumber();
            Logger logger = LoggerFactory.getLogger(this.getClass());
            logger.info("Updating account number " + AccountNumber);
            Accounts account = accountRepo.findByAccountNumber(customerDto.getAccountsDto().getAccountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber", "ID"));

            accountMapper.updateAccountFromDto(customerDto.getAccountsDto(), account);
            accountRepo.save(account);
        }

        // 2. تحديث العميل
        Customer customer = customerRepo.findByMobileNumber(customerDto.getMobileNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile", customerDto.getMobileNumber()));

        customerMapper.updateCustomerFromDto(customerDto, customer);
        customerRepo.save(customer);

        return true;
    }

    @Override
    @Transactional
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepo.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile", mobileNumber));

        accountRepo.deleteByCustomerId(customer.getCustomerId());
        customerRepo.delete(customer);
        return true;
    }

    private Accounts createNewAccount(Customer customer) {
        long randomAccNumber= 1000000000L + new Random().nextInt(900000000);
        return    accountRepo.save( Accounts.builder()
                .accountNumber(randomAccNumber)
                .accountType(AccountConstants.SAVINGS)
                .branchAddress(AccountConstants.ADDRESS)
                .customerId(customer.getCustomerId())
                .build());
    }

}
