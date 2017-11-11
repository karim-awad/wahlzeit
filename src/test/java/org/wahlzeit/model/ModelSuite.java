package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.model.persistence.PersistenceSuite;

@RunWith(Suite.class)
@SuiteClasses({ PersistenceSuite.class,
				AccessRightsTest.class,
				CoordinateTest.class,
				FlagReasonTest.class,
				GenderTest.class,
				GuestTest.class,
				PhotoFilterTest.class,
				LocationTest.class,
				TagsTest.class,
				UserStatusTest.class, 
				ValueTest.class })

public class ModelSuite {

}
