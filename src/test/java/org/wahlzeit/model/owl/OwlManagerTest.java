/**
 * 
 */
package org.wahlzeit.model.owl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.model.Owl;
import org.wahlzeit.model.OwlManager;
import org.wahlzeit.model.OwlType;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;
import org.wahlzeit.utils.exceptions.IllegalOwlException;

public class OwlManagerTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());

	@Test
	public void testGetType() {
		OwlType type = new OwlType("test");
		Owl owl = null;
		try {
			owl = OwlManager.getInstance().createOwl("test", "Testus", 8);
		} catch (IllegalOwlException e) {
			fail("Owl creation error");
		}
		OwlType typeNew = OwlManager.getInstance().getOwlType("test");
		assertTrue(type.equals(typeNew));
	}

}
