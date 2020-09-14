package com.tharaka.corebank.endpoint;


import com.tharaka.corebank.model.*;
import com.tharaka.corebank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccountEndpoint {
    @Autowired
    private AccountService accountService;

    @PayloadRoot(namespace = "http://tharaka.com/corebank/model", localPart = "getAccountBalanceRequest")
    @ResponsePayload
    public GetAccountBalanceResponse getAccountBalance(@RequestPayload GetAccountBalanceRequest request) {
        GetAccountBalanceResponse response = new GetAccountBalanceResponse();
        response.setBalance(accountService.getAccountBalance(request.getAccountNo()));
        return response;
    }

    @PayloadRoot(namespace = "http://tharaka.com/corebank/model", localPart = "getTotalAccountBalanceRequest")
    @ResponsePayload
    public GetTotalAccountBalanceResponse getTotalAccountBalance(@RequestPayload GetTotalAccountBalanceRequest request) {
        GetTotalAccountBalanceResponse response = new GetTotalAccountBalanceResponse();
        response.setBalance(accountService.getTotalAccountBalance(request.getUserId()));
        return response;
    }

    @PayloadRoot(namespace = "http://tharaka.com/corebank/model", localPart = "fundTransferToOwnAccountRequest")
    @ResponsePayload
    public FundTransferToOwnAccountResponse fundTransferToOwnAccount
            (@RequestPayload FundTransferToOwnAccountRequest request) {
        FundTransferToOwnAccountResponse response = new FundTransferToOwnAccountResponse();
        response.setAccount(accountService.fundTransferToOwnAccount(request.getFromAccountNo(),
                request.getToAccountNo(), request.getAmount()));
        return null;
    }

    @PayloadRoot(namespace = "http://tharaka.com/corebank/model", localPart = "fundTransferToOtherAccountRequest")
    @ResponsePayload
    public FundTransferToOtherAccountResponse fundTransferToOtherAccount
            (@RequestPayload FundTransferToOtherAccountRequest request) {
        FundTransferToOtherAccountResponse response = new FundTransferToOtherAccountResponse();
        response.setAccount(accountService.fundTransferToOtherAccount(request.getFromAccountNo(),
                request.getToAccountNo(), request.getBankCode(), request.getAmount()));
        return response;
    }
}
