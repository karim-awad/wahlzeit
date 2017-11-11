package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.services.mailing.EmailServiceSuite;

@RunWith(Suite.class)
@SuiteClasses({ EmailAddressTest.class,
				LogBuilderTest.class,
				EmailServiceSuite.class})

public class ServicesSuite {

}
