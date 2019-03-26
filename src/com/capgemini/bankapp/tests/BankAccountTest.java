package com.capgemini.bankapp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.bankapp.model.BankAccount;

public class BankAccountTest {

	private BankAccount account;

	@Before
	public void setUp() {
		account = new BankAccount(101, "jhon", "SAVING", 35000);
	}

	@Test
	public void testBankAccountObjectisCreatedwithDefaultConstructor() {
		BankAccount account = new BankAccount();
		assertNotNull(account);
	}

	@Test
	public void testBankAccountObjectisCreatedwithParametrizedConstructor() {
		BankAccount account = new BankAccount(101, "jhon", "SAVING", 45000);
		assertNotNull(account);
		assertEquals(101, account.getAccountId());
		assertEquals("jhon", account.getAccountHolderName());
		assertEquals("SAVING", account.getAccountType());
		assertEquals(45000.0, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testBankAccountCurrentBalance() {
		assertEquals(35000, account.getAccountBalance(), 0.01);
	}
	
	@Test
	public void testWithdrawWithSufficientFund() {
		account.withdraw(5000);
		assertEquals(30000, account.getAccountBalance(), 0.01);
	}
	
	@Test
	public void testWithdrawWithInsufficientFund() {
		account.withdraw(45000);
		assertEquals(35000, account.getAccountBalance(), 0.01);
	}
   
	@Test
	public void testDeposit() {
		account.deposit(5000);
		assertEquals(40000, account.getAccountBalance(), 0.01);
	}
}
