package com.inexx.atm_project.dto;

public record AccountDto(
        Long id,
        String name,
        Double balance,
        String accountName,
        String cardType,
        Integer password
) {}
