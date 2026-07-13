package accountpl.account.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import accountpl.account.core.model.Account;

public abstract class AccountServiceDecorator extends AccountServiceComponent{
	protected AccountServiceComponent record;

    public AccountServiceDecorator(AccountServiceComponent record) {
        this.record = record;
    }

	public Account createAccount(Map<String, Object> requestBody){
		return record.createAccount(requestBody);
	}
	
    public Account createAccount(Map<String, Object> requestBody, UUID id){
		return record.createAccount(requestBody, id);
	}

	public HashMap<String, Object> getAccount(String idStr){
		return record.getAccount(idStr);
	}

	public List<HashMap<String,Object>> getAllAccount(){
		return record.getAllAccount();
	}

    public HashMap<String, Object> updateAccount(Map<String, Object> requestBody){
		return record.updateAccount(requestBody);
	}

    public List<HashMap<String,Object>> transformListToHashMap(List<Account> List){
		return record.transformListToHashMap(List);
	}

    public List<HashMap<String,Object>> deleteAccount(Map<String, Object> requestBody){
		return record.deleteAccount(requestBody);
	}

	public HashMap<String, Object> getAccountById(UUID id){
        return record.getAccountById(id);
    }

	public boolean update(int x) {
		return record.update(x);
	}
}
