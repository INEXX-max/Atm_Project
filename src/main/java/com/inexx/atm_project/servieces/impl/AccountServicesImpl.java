package com.inexx.atm_project.servieces.impl;

import com.inexx.atm_project.dto.AccountDto;
import com.inexx.atm_project.entity.Account;
import com.inexx.atm_project.repository.AccountRepository;
import com.inexx.atm_project.servieces.AccountServices;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServicesImpl implements AccountServices {

    private final AccountRepository accountRepository;

    public AccountServicesImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Entity -> DTO Çevirici
    private AccountDto convertToDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getAccountName(),
                account.getCardType(),
                account.getPassword()
        );
    }

    // DTO -> Entity Çevirici (Hesap açarken lazım)
    private Account convertToEntity(AccountDto dto) {
        Account account = new Account();
        account.setName(dto.name());
        account.setBalance(dto.balance());
        account.setAccountName(dto.accountName());
        account.setCardType(dto.cardType());
        account.setPassword(dto.password());
        return account;
    }

    @Override
    public List<AccountDto> tumHesaplariGetir() {
        return accountRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto hesapAc(AccountDto accountDto) {
        Account yeniHesap = convertToEntity(accountDto);
        Account kaydedilenHesap = accountRepository.save(yeniHesap);
        return convertToDto(kaydedilenHesap);
    }

    @Override
    public AccountDto paraCek(Long id, Double miktar) {
        Account hesap = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hesap bulunamadı! ID: " + id));

        if (hesap.getBalance() < miktar) {
            throw new RuntimeException("Yetersiz Bakiye! Mevcut: " + hesap.getBalance());
        }

        hesap.setBalance(hesap.getBalance() - miktar);
        Account guncelHesap = accountRepository.save(hesap);
        return convertToDto(guncelHesap);
    }

    @Override
    public AccountDto paraYatir(Long id, Double miktar) {
        Account hesap = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hesap bulunamadı! ID: " + id));

        hesap.setBalance(hesap.getBalance() + miktar);
        Account guncelHesap = accountRepository.save(hesap);
        return convertToDto(guncelHesap);
    }
}
