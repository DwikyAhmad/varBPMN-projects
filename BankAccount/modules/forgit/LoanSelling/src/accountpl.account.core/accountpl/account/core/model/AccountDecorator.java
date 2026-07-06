package accountpl.account.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.OneToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
//add other required packages

@MappedSuperclass
public abstract class AccountDecorator extends AccountComponent{
    @OneToOne(cascade=CascadeType.ALL)
	protected AccountComponent record;

	public AccountDecorator () {
		super();
		this.id_account =  UUID.randomUUID();
	}

	public AccountDecorator (UUID id_account, AccountComponent record) {
		this.id_account =  id_account;
		this.record = record;
	}
	
	public AccountDecorator (AccountComponent record, String objectName) {
		this.id_account =  UUID.randomUUID();
		this.record = record;
		this.objectName=objectName;
	}


	public int getBalance() {
		return record.getBalance();
	}
	public void setBalance(int balance) {
		record.setBalance(balance);
	}
	public UUID getId_account() {
		return record.getId_account();
	}
	public void setId_account(UUID id_account) {
		record.setId_account(id_account);
	}

	public boolean update(int x) {
		return record.update(x);
	}

	public HashMap<String, Object> toHashMap() {
        return this.record.toHashMap();
    }

}
