package com.example.account.mapper;

import com.example.account.Dto.AccountDto;
import com.example.account.Dto.CustomerDto;
import com.example.account.entity.Accounts;
import com.example.account.entity.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",uses = {AccountMapper.class})
public interface CustomerMapper {
    @Mapping(target = "customerId", ignore = true)
    Customer toCustomer(CustomerDto customerDto);
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDto(List<Customer> customers);
    List<Customer> toCustomers(List<CustomerDto> customersDto);



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(CustomerDto customerDto, @MappingTarget Customer customer);



}
