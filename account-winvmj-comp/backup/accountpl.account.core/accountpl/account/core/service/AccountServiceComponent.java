package accountpl.account.core.service;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import accountpl.account.core.model.Account;
//add other required packages

public abstract class AccountServiceComponent implements AccountService{
	protected RepositoryUtil<Account> Repository;

    public AccountServiceComponent(){
        this.Repository = new RepositoryUtil<Account>(accountpl.account.core.model.AccountComponent.class);
    }	

    public abstract Account createAccount(Map<String, Object> requestBody);
	public abstract Account createAccount(Map<String, Object> requestBody, UUID id);
	public abstract HashMap<String, Object> updateAccount(Map<String, Object> requestBody);
    public abstract HashMap<String, Object> getAccount(String idStr);
    public abstract List<HashMap<String,Object>> getAllAccount();
    public abstract List<HashMap<String,Object>> transformListToHashMap(List<Account> List);
    public abstract List<HashMap<String,Object>> deleteAccount(Map<String, Object> requestBody);
	public abstract HashMap<String, Object> getAccountById(UUID id);

	public abstract boolean update(int x);
}
