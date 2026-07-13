package accountpl.account.core.service;
import java.util.*;
import java.lang.*;
import com.google.gson.Gson;
import java.util.*;
import java.util.logging.Logger;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import accountpl.account.AccountFactory;
import accountpl.account.core.model.Account;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
//add other required packages

public class AccountServiceImpl extends AccountServiceComponent{

    public Account createAccount(Map<String, Object> requestBody){
		String balanceStr = (String) requestBody.get("balance");
		int balance = Integer.parseInt(balanceStr);
		
		//to do: fix association attributes
		
		Account account = AccountFactory.createAccount("accountpl.account.core.model.AccountImpl", balance);
		Repository.saveObject(account);
		return account;
	}

    public Account createAccount(Map<String, Object> requestBody, UUID id){
		String balanceStr = (String) requestBody.get("balance");
		int balance = Integer.parseInt(balanceStr);
		UUID id_account = id;
		
		//to do: fix association attributes
		Account account = AccountFactory.createAccount("accountpl.account.core.model.AccountImpl",balance, id_account);
		Repository.saveObject(account);
		return account;
	}

    public HashMap<String, Object> updateAccount(Map<String, Object> requestBody){
		String idStr = (String) requestBody.get("id_account");
		UUID id = UUID.fromString(idStr);
		Account account = Repository.getObject(id);
		
		String balanceStr = (String) requestBody.get("balance");
		account.setBalance(Integer.parseInt(balanceStr));
		
		
		Repository.updateObject(account);
		
		//to do: fix association attributes
		
		return account.toHashMap();
		
	}

    public HashMap<String, Object> getAccount(String idStr){
		UUID id = UUID.fromString(idStr);
		Account account = Repository.getObject(id);
		return account.toHashMap();
	}

	public HashMap<String, Object> getAccountById(UUID id){
		List<HashMap<String, Object>> accountList = getAllAccount();
		for (HashMap<String, Object> account : accountList){
			UUID record_id = UUID.fromString((String) account.get("id_account"));
			if (record_id.equals(id)){
				return account;
			}
		}
		return null;
	}

    public List<HashMap<String,Object>> getAllAccount(){
		List<Account> List = Repository.getAllObject("account_impl");
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
