package accountpl.account.core.service;
import java.util.*;

import accountpl.account.core.model.Account;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface AccountService {
	Account createAccount(Map<String, Object> requestBody);
	HashMap<String, Object> getAccount(String idStr);
    HashMap<String, Object> updateAccount(Map<String, Object> requestBody);
    List<HashMap<String,Object>> getAllAccount();
    List<HashMap<String,Object>> deleteAccount(Map<String, Object> requestBody);
	List<HashMap<String, Object>> transformListToHashMap(List<Account> List);
}
