package accountpl.account.dailylimit.resource;
import java.util.*;
import java.lang.*;

import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import id.ac.ui.cs.prices.winvmj.core.exceptions.*;

import accountpl.account.core.resource.AccountResourceDecorator;
import accountpl.account.core.resource.AccountResourceComponent;
import accountpl.account.core.model.Account;
import accountpl.account.core.model.AccountImpl;
import accountpl.account.core.service.AccountServiceComponent;
import accountpl.account.dailylimit.service.AccountServiceImpl;

public class AccountResourceImpl extends AccountResourceDecorator {
	private AccountServiceComponent accountdailylimitServiceImpl;

    public AccountResourceImpl (AccountResourceComponent record, AccountServiceComponent recordService) {
        super(record);
		this.accountdailylimitServiceImpl = new AccountServiceImpl(recordService);
    }

    
    @Route(url="call/dailylimit/save")
    public List<HashMap<String,Object>> saveAccount(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		Account accountdailylimit = createAccount(vmjExchange);
		return getAllAccount(vmjExchange);
	}

    public Account createAccount(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Account result = accountdailylimitServiceImpl.createAccount(requestBody);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

    public Account createAccount(VMJExchange vmjExchange, UUID id){
		if (vmjExchange.getHttpMethod().equals("POST")) {
		    Map<String, Object> requestBody = vmjExchange.getPayload(); 
			Account result = accountdailylimitServiceImpl.createAccount(requestBody, id);
			return result;
		}
		throw new NotFoundException("Route tidak ditemukan");
	}

	
    @Route(url="call/dailylimit/update")
    public HashMap<String, Object> updateAccount(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")){
			return null;
		}
		return accountdailylimitServiceImpl.updateAccount(requestBody);
	}

	
    @Route(url="call/dailylimit/detail")
    public HashMap<String, Object> getAccount(VMJExchange vmjExchange){
		return record.getAccount(vmjExchange);
	}

	
    @Route(url="call/dailylimit/list")
    public List<HashMap<String,Object>> getAllAccount(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload();
		return accountdailylimitServiceImpl.getAllAccount();
	}

    public List<HashMap<String,Object>> transformAccountListToHashMap(List<Account> AccountDailyLimitList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < AccountDailyLimitList.size(); i++) {
            resultList.add(AccountDailyLimitList.get(i).toHashMap());
        }

        return resultList;
	}

	
    @Route(url="call/dailylimit/delete")
    public List<HashMap<String,Object>> deleteAccount(VMJExchange vmjExchange){
		Map<String, Object> requestBody = vmjExchange.getPayload(); 
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		return accountdailylimitServiceImpl.deleteAccount(requestBody);
	}

	public boolean update(int x) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
}
