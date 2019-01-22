package com.example.demo.dto.request;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountMoneyTransferRequest {
    private Long accountId;
    private Long walletId;
    private Long customerId;
    private BigDecimal amountToTransfer;
    private String paymentToken;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getAmountToTransfer() {
        return amountToTransfer;
    }

    public void setAmountToTransfer(BigDecimal amountToTransfer) {
        this.amountToTransfer = amountToTransfer;
    }

    public String getPaymentToken() {
        return paymentToken;
    }

    public void setPaymentToken(String paymentToken) {
        this.paymentToken = paymentToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountMoneyTransferRequest)) {
            return false;
        }
        AccountMoneyTransferRequest that = (AccountMoneyTransferRequest) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(walletId, that.walletId) && Objects.equals(customerId, that.customerId) &&
                Objects.equals(amountToTransfer, that.amountToTransfer) && Objects.equals(paymentToken, that.paymentToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, walletId, customerId, amountToTransfer, paymentToken);
    }

    @Override
    public String toString() {
        return "AccountMoneyTransferRequest{" + "accountId=" + accountId + ", walletId=" + walletId + ", customerId=" + customerId +
                ", amountToTransfer=" + amountToTransfer + ", paymentToken='" + paymentToken + '\'' + '}';
    }
}
