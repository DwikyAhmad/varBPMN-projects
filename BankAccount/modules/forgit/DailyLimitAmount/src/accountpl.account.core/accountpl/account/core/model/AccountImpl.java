package accountpl.account.core.model;

import java.lang.*;
import java.util.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="account_impl")
@Table(name="account_impl")
public class AccountImpl extends AccountComponent {

	public AccountImpl(int balance, UUID id_account) {
		this.balance = balance;
		this.id_account = id_account;
	}

	public AccountImpl(int balance) {
		this.id_account =  UUID.randomUUID();
		this.balance = balance;
	}

	public AccountImpl() { }

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public UUID getId_account() {
		return this.id_account;
	}

	public void setId_account(UUID id_account) {
		this.id_account = id_account;
	}

	public boolean update(int x) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}
	
	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> accountMap = new HashMap<String,Object>();
		accountMap.put("balance",getBalance());
		accountMap.put("id_account",getId_account());

        return accountMap;
    }

}
