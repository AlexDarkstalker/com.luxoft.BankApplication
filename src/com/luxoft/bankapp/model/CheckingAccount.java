package com.luxoft.bankapp.model;

import com.luxoft.bankapp.exceptions.OverDraftLimitExceededException;

public class CheckingAccount extends AbstractAccount {
	private float overdraft;


	public CheckingAccount(float overdraft, float balance) throws IllegalArgumentException {
		if (overdraft >= 0) {
			this.balance = balance;
			this.overdraft = overdraft;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void setOverdraft(float x) throws IllegalArgumentException {
		if (x >= 0) {
			overdraft = x;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void withdraw(float x) throws OverDraftLimitExceededException {
		if (balance + overdraft > x) {
			balance -= x;
		} else {
			throw new OverDraftLimitExceededException(getAccountName(), balance
					+ overdraft);
		}
	}

	public String getAccountName() {
		return "Checking Account";
	}

	@Override
	public String toString() {
		return super.toString() + " Overdraft:" + this.overdraft + " ";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		CheckingAccount that = (CheckingAccount) o;

		return super.equals(o)&&Float.compare(that.overdraft, overdraft) == 0;

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (overdraft != +0.0f ? Float.floatToIntBits(overdraft) : 0);
		return result;
	}
}
