/**
 * 
 */
package org.wahlzeit.model.owl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.wahlzeit.model.Gender;
import org.wahlzeit.model.Owl;
import org.wahlzeit.utils.exceptions.IllegalOwlException;

public class owlTest {

	@Test
	public void testClassInvariants() throws IllegalOwlException {
		try {
		@SuppressWarnings("unused")
		Owl owl = new Owl(null, -1, null);
		fail();
		}catch(IllegalOwlException e) {};
		Owl owl = new Owl("Susie", 5, "Tyto alba");
		try {
			owl.setAge(-1);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
		    owl.setName(null);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
			owl.setSpeciesName(null);
			fail();
			}catch(IllegalOwlException e) {};
		
	}

}
