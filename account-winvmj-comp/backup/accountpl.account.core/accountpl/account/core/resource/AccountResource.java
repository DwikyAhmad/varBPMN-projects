package accountpl.account.core.resource;
import java.util.*;

import accountpl.account.core.model.Account;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

public interface AccountResource {
    List<HashMap<String,Object>> saveAccount(VMJExchange vmjExchange);
    HashMap<String, Object> updateAccount(VMJExchange vmjExchange);
    HashMap<String, Object> getAccount(VMJExchange vmjExchange);
    List<HashMap<String,Object>> getAllAccount(VMJExchange vmjExchange);
    List<HashMap<String,Object>> deleteAccount(VMJExchange vmjExchange);
}
