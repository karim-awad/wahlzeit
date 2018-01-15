/**
 * 
 */
package org.wahlzeit.model.owl;

import static org.junit.Assert.fail;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.model.Owl;
import org.wahlzeit.model.OwlManager;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.utils.exceptions.IllegalOwlException;

public class OwlTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());

	@Test
	public void testClassInvariants() throws IllegalOwlException {
		try {
		@SuppressWarnings("unused")
		Owl owl = new Owl(null, -1, null);
		fail();
		}catch(IllegalOwlException e) {};
		Owl owl = OwlManager.getInstance().createOwl("Tyto alba", "Susie", 5);
		try {
			owl.setAge(-1);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
		    owl.setName(null);
			fail();
			}catch(IllegalOwlException e) {};
			
		
	}

}
