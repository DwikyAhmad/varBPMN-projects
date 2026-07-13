package accountpl.account.dailylimit.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import accountpl.account.core.model.AccountDecorator;
import accountpl.account.core.model.Account;
import accountpl.account.core.model.AccountComponent;

@Entity(name="account_dailylimit")
@Table(name="account_dailylimit")
public class AccountImpl extends AccountDecorator {

	protected int dailyLimit;
	protected int withdraw;
	public AccountImpl() {
        super();
		this.id_account = UUID.randomUUID();
        this.objectName = AccountImpl.class.getName();
    }

	public AccountImpl(AccountComponent record, int dailyLimit, int withdraw) {
		super(record, AccountImpl.class.getName());
		this.dailyLimit = dailyLimit;
		this.withdraw = withdraw;
		this.objectName = AccountImpl.class.getName();
	}

	public int getDailyLimit() {
		return this.dailyLimit;
	}

	public void setDailyLimit(int dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
	public int getWithdraw() {
		return this.withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public boolean update(int x) {
		// TODO: implement this method
		throw new UnsupportedOperationException();
	}

	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("id_account", id_account);
		map.put("dailyLimit", getDailyLimit());
		map.put("withdraw", getWithdraw());

        return map;
    }

}
