package com.example.account.service;

import com.example.account.Dto.CustomerDto;
import com.example.account.entity.Accounts;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);


}
