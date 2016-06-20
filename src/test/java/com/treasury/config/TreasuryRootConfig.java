package com.treasury.config;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.treasury.repositories.PaymentRepository;
import com.treasury.repositories.ResidentRepository;
import com.treasury.repositories.UserRepository;
import com.treasury.util.DataPopulator;

@ContextConfiguration(locations = { "classpath:config/application-test-config.xml" })
public class TreasuryRootConfig extends AbstractTestNGSpringContextTests {

	@Autowired
	protected PaymentRepository paymentRepository;

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected ResidentRepository residentRepository;

	protected Mockery context = new Mockery();

	protected DataPopulator dataPopulator;

	@BeforeClass
	public void init() {
		dataPopulator = new DataPopulator();
		context.setImposteriser(ClassImposteriser.INSTANCE);
	}

	@AfterMethod
	public void cleanUp() {
		paymentRepository.deleteAll();
		userRepository.deleteAll();
		residentRepository.deleteAll();
	}

}
