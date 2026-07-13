package accountpl.account.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import accountpl.account.core.model.Account;

public abstract class AccountResourceDecorator extends AccountResourceComponent{
	protected AccountResourceComponent record;

    public AccountResourceDecorator(AccountResourceComponent record) {
        this.record = record;
    }

    public List<HashMap<String,Object>> saveAccount(VMJExchange vmjExchange){
		return record.saveAccount(vmjExchange);
	}

    public Account createAccount(VMJExchange vmjExchange){
		return record.createAccount(vmjExchange);
	}
	
	public Account createAccount(VMJExchange vmjExchange, UUID id){
		return record.createAccount(vmjExchange, id);
	}

    public HashMap<String, Object> updateAccount(VMJExchange vmjExchange){
		return record.updateAccount(vmjExchange);
	}

    public HashMap<String, Object> getAccount(VMJExchange vmjExchange){
		return record.getAccount(vmjExchange);
	}

    public List<HashMap<String,Object>> getAllAccount(VMJExchange vmjExchange){
		return record.getAllAccount(vmjExchange);
	}

    public List<HashMap<String,Object>> deleteAccount(VMJExchange vmjExchange){
		return record.deleteAccount(vmjExchange);
	}

	public boolean update(int x) {
		return record.update(x);
	}
}
