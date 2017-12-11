/**
 * 
 */
package org.wahlzeit.model.owl;


import static org.junit.Assert.fail;
import org.junit.Test;
import org.wahlzeit.model.Species;
import org.wahlzeit.utils.exceptions.IllegalSpeciesException;


public class SpeciesTest {

	@Test
	public void testClassInvariants() throws IllegalSpeciesException {
		try {
		@SuppressWarnings("unused")
		Species species = new Species(null, null, false);
		fail();
		}catch(IllegalSpeciesException e) {};
			
		Species species = new Species("Testspecies", "testfamily", false);
		
		try {
		species.setFamily(null);
		fail();
		}catch(IllegalSpeciesException e) {};
		
		try {
		species.setName(null);		
		fail();
		}catch(IllegalSpeciesException e) {};
	}

}
