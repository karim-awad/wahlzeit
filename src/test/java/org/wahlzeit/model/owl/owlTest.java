/**
 * 
 */
package org.wahlzeit.model.owl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.wahlzeit.model.Color;
import org.wahlzeit.model.Gender;
import org.wahlzeit.model.Owl;
import org.wahlzeit.model.Species;
import org.wahlzeit.utils.exceptions.IllegalOwlException;
import org.wahlzeit.utils.exceptions.IllegalSpeciesException;

public class owlTest {

	@Test
	public void testClassInvariants() throws IllegalOwlException, IllegalSpeciesException {
		try {
		@SuppressWarnings("unused")
		Owl owl = new Owl(null, -1, null, null, null);
		fail();
		}catch(IllegalOwlException e) {};
		Species species = new Species("test", "test", false);
		Owl owl = new Owl("Sudie", 5, Gender.FEMALE, species, Color.BROWN);
		try {
			owl.setAge(-1);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
			owl.setColor(null);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
			owl.setGender(null);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
		    owl.setName(null);
			fail();
			}catch(IllegalOwlException e) {};
			
		try {
			owl.setSpecies(null);
			fail();
			}catch(IllegalOwlException e) {};
		
	}

}
