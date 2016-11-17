package com.luxoft.bankapp.model;

public abstract class AbstractAccount implements Account {
	protected float balance;



	@Override
	public void printReport() {
		System.out.println("Account balance: " + balance);
	}

	@Override
	public void deposit(float x) throws IllegalArgumentException {
		if (x >= 0) {
			balance += x;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public float getBalance() {
		return balance;
	}


	@Override
	public String toString() {
		return this.getAccountName() + " " + this.getBalance() + " ";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AbstractAccount)) return false;

		AbstractAccount that = (AbstractAccount) o;
		if(!this.getAccountName().equals(that.getAccountName())) return false;
		return Float.compare(that.balance, balance) == 0;

	}

	@Override
	public int hashCode() {
		int result = getAccountName().hashCode();
		return (balance != +0.0f ? 31* result* Float.floatToIntBits(balance) : 0);
	}

	@Override
	public int decimalValue() {
		return Math.round(this.getBalance());
	}
}
