package com.inexx.atm_project.servieces;

import com.inexx.atm_project.dto.AccountDto;

import java.util.List;

public interface AccountServices {
    List<com.inexx.atm_project.dto.AccountDto> tumHesaplariGetir();
    AccountDto hesapAc(AccountDto accountDto);
    AccountDto paraCek(Long id, Double miktar);
    AccountDto paraYatir(Long id, Double miktar);







}
