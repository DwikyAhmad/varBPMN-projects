package accountpl.account.core.resource;
import java.util.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;
import accountpl.account.AccountFactory;
import id.ac.ui.cs.prices.winvmj.auth.annotations.Restricted;
import accountpl.account.core.model.Account;
import accountpl.account.core.service.AccountServiceImpl;
//add other required packages


public class AccountResourceImpl extends AccountResourceComponent{
	
	private AccountServiceImpl accountServiceImpl = new AccountServiceImpl();

	
    @Route(url="call/account/save")
    public List<HashMap<String,Object>> saveAccount(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Account account = createAccount(vmjExchange);
		return accountServiceImpl.getAllAccount();
	}

    public Account createAccount(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Account result = accountServiceImpl.createAccount(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}
	
    public Account createAccount(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Account result = accountServiceImpl.createAccount(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/account/update")
    public HashMap<String, Object> updateAccount(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return accountServiceImpl.updateAccount(requestBody);
		
	}

	
    @Route(url="call/account/detail")
    public HashMap<String, Object> getAccount(VMJExchange vmjExchange){
		String idStr = vmjExchange.getGETParam("id_account");
		return accountServiceImpl.getAccount(idStr);
	}

	
    @Route(url="call/account/list")
    public List<HashMap<String,Object>> getAllAccount(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		return accountServiceImpl.getAllAccount();
	}

	
    @Route(url="call/account/delete")
    public List<HashMap<String,Object>> deleteAccount(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return accountServiceImpl.deleteAccount(requestBody);
	}


	
	public boolean update(int x) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
}
