package com.inexx.atm_project.controller;

import com.inexx.atm_project.dto.AccountDto;
import com.inexx.atm_project.servieces.AccountServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/atm")
public class AccountController {

    private final AccountServices accountService;

    public AccountController(AccountServices accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> listele() {
        return ResponseEntity.ok(accountService.tumHesaplariGetir());
    }

    @PostMapping("/olustur")
    public ResponseEntity<AccountDto> olustur(@RequestBody AccountDto istek) {
        // Artık direkt DTO alıyoruz, içindeki name, password, cardType vb. otomatik geliyor
        AccountDto yeniHesap = accountService.hesapAc(istek);
        return new ResponseEntity<>(yeniHesap, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/yatir")
    public ResponseEntity<AccountDto> paraYatir(@PathVariable Long id, @RequestParam Double miktar) {
        return ResponseEntity.ok(accountService.paraYatir(id, miktar));
    }

    @PutMapping("/{id}/cek")
    public ResponseEntity<AccountDto> paraCek(@PathVariable Long id, @RequestParam Double miktar) {
        return ResponseEntity.ok(accountService.paraCek(id, miktar));
    }
}