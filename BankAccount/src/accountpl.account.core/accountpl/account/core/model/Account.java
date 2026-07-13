package accountpl.account.core.model;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;
import java.util.*;
import java.lang.*;

public interface Account {
	    public int getBalance();
	    public void setBalance(int balance);
	    public UUID getId_account();
	    public void setId_account(UUID id_account);
	public boolean update(int x);
	HashMap<String, Object> toHashMap();
}
