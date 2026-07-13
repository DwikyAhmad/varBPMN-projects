package accountpl.account.dailylimit.service;

import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import accountpl.account.core.service.AccountServiceDecorator;
import accountpl.account.core.service.AccountServiceComponent;
import accountpl.account.core.model.Account;
import accountpl.account.core.model.AccountDecorator;
import accountpl.account.dailylimit.model.AccountImpl;
import accountpl.account.AccountFactory;

public class AccountServiceImpl extends AccountServiceDecorator {
    public AccountServiceImpl (AccountServiceComponent record) {
        super(record);
    }

 	public Account createAccount(Map<String, Object> requestBody){
		String dailyLimitStr = (String) requestBody.get("dailyLimit");
		int dailyLimit = Integer.parseInt(dailyLimitStr);
		String withdrawStr = (String) requestBody.get("withdraw");
		int withdraw = Integer.parseInt(withdrawStr);
		String balanceStr = (String) requestBody.get("balance");
		int balance = Integer.parseInt(balanceStr);
		Account accountdailylimit = record.createAccount(requestBody);
		Account accountdailylimitdeco = AccountFactory.createAccount("accountpl.account.dailylimit.model.AccountImpl", accountdailylimit, dailyLimit, withdraw);
		Repository.saveObject(accountdailylimitdeco);
		return accountdailylimitdeco;
	}

    public Account createAccount(Map<String, Object> requestBody, UUID id){
		Account savedAccount = Repository.getObject(id);
		String dailyLimitStr = (String) requestBody.get("dailyLimit");
		int dailyLimit = Integer.parseInt(dailyLimitStr);
		String withdrawStr = (String) requestBody.get("withdraw");
		int withdraw = Integer.parseInt(withdrawStr);
		UUID recordAccountId_account = ((AccountDecorator) savedAccount).getId_account();
		Account account = record.createAccount(requestBody, recordAccountId_account);
		Account accountdailylimit = AccountFactory.createAccount("accountpl.account.dailylimit.AccountImpl", account, dailyLimit, withdraw);
		return accountdailylimit;
	}

    public HashMap<String, Object> updateAccount(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_account");
		int balance = 0;
		UUID id = UUID.fromString(idStr);
		int dailyLimit = 0;
		int withdraw = 0;
		
		Account accountdailylimit = Repository.getObject(id);
		String balanceStr = (String) requestBody.get("balance");
		balance = Integer.parseInt(balanceStr);
		((AccountImpl) accountdailylimit).setBalance(balance);
		// dailyLimit Integer
		String dailyLimitStr = (String) requestBody.get("dailyLimit");
		dailyLimit = Integer.parseInt(dailyLimitStr);
		((AccountImpl) accountdailylimit).setDailyLimit(dailyLimit);
		// withdraw Integer
		String withdrawStr = (String) requestBody.get("withdraw");
		withdraw = Integer.parseInt(withdrawStr);
		((AccountImpl) accountdailylimit).setWithdraw(withdraw);
		
		Repository.updateObject(accountdailylimit);
		record.updateAccount(requestBody);
		accountdailylimit = Repository.getObject(id);
		
		//to do: fix association attributes
		
		return accountdailylimit.toHashMap();
	}

	public HashMap<String, Object> getAccount(String idStr){
		UUID id = UUID.fromString(idStr);		
		Account accountdailylimit = Repository.getObject(id);
		return accountdailylimit.toHashMap();
	}

	public HashMap<String, Object> getAccountById(UUID id){
		List<HashMap<String, Object>> accountList = getAllAccount();
		for (HashMap<String, Object> account : accountList){
			UUID account_id = UUID.fromString((String) account.get("id_account"));
			if (account_id.equals(id)){
				return account;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAccount(){
		List<Account> List = Repository.getAllObject("account_dailylimit");
		return transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Account> List){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < List.size(); i++) {
            resultList.add(List.get(i).toHashMap());
        }

        return resultList;
	}

    public List<HashMap<String,Object>> deleteAccount(Map<String, Object> requestBody){
		String idStr = ((String) requestBody.get("id_account"));
		UUID id = UUID.fromString(idStr);
		Repository.deleteObject(id);
		return getAllAccount();
	}

	
	public boolean update(int x) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
