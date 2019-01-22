package com.example.demo.dto;

import com.example.demo.utils.AccountMoneyTransferStatus;

public class AccountMoneyTransferDTO {
    private AccountMoneyTransferStatus status;

    public AccountMoneyTransferStatus getStatus() {
        return status;
    }

    public void setStatus(AccountMoneyTransferStatus status) {
        this.status = status;
    }
}
