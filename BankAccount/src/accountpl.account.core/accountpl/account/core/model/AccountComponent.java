package accountpl.account.core.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="account_comp")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AccountComponent implements Account{
	@Id
	protected UUID id_account; 
	protected int balance;
	protected String objectName = AccountComponent.class.getName();

	public AccountComponent() {

	} 

	public AccountComponent(
        int balance, UUID id_account
    ) {
        this.balance = balance;
        this.id_account = id_account;
    }

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
 
	public abstract boolean update(int x);

	@Override
    public String toString() {
        return "{" +
            " balance='" + getBalance() + "'" +
            " id_account='" + getId_account() + "'" +
            "}";
    }
	
}
