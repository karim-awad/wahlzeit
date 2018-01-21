/**
 * 
 */
package org.wahlzeit.model.owl;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.wahlzeit.model.Owl;
import org.wahlzeit.model.OwlType;
import org.wahlzeit.utils.exceptions.IllegalOwlException;

import com.google.appengine.api.memcache.InvalidValueException;

import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;


public class OwlTypeTest {
	
	@ClassRule
	public static RuleChain ruleChain = RuleChain.
			outerRule(new LocalDatastoreServiceTestConfigProvider()).
			around(new RegisteredOfyEnvironmentProvider());

	
	@Test(expected = InvalidValueException.class)
	public void testClassInvariants() {
		OwlType type = new OwlType(null);
	}
	
	@Test
	public void testSubtypes() {
		OwlType superType = new OwlType("Supertype");
		OwlType subType = new OwlType("Subtype");
		superType.addSubType(subType);
		Owl owl = null;
		try {
			owl = subType.createInstance("peter", 5);
		} catch (IllegalOwlException e) {
			fail("IllegalOwlException thrown. This definitely shouldn't happen");
		}
		
		assertTrue(superType.hasInstance(owl));
		assertTrue(subType.getSuperType().equals(superType));
		
	}

}
