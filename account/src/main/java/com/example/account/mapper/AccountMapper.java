package com.example.account.mapper;

import com.example.account.Dto.AccountDto;
import com.example.account.entity.Accounts;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "accountNumber", ignore = true)
    Accounts toAccounts(AccountDto accountDto);
    AccountDto toDto(Accounts accounts);
    List<AccountDto> toDto(List<Accounts> accounts);
    List<Accounts> toAccounts(List<AccountDto> accountDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccountFromDto(AccountDto accountDto, @MappingTarget Accounts account);
}
