package accountpl.account.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.hibernate.RepositoryUtil;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import accountpl.account.core.model.Account;
//add other required packages

public abstract class AccountResourceComponent implements AccountResource{
	
	public AccountResourceComponent() { }
 
    public abstract List<HashMap<String,Object>> saveAccount(VMJExchange vmjExchange);
    public abstract Account createAccount(VMJExchange vmjExchange);
	public abstract Account createAccount(VMJExchange vmjExchange, UUID id);
	public abstract HashMap<String, Object> updateAccount(VMJExchange vmjExchange);
    public abstract HashMap<String, Object> getAccount(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> getAllAccount(VMJExchange vmjExchange);
    public abstract List<HashMap<String,Object>> deleteAccount(VMJExchange vmjExchange);

	public abstract boolean update(int x);
}
