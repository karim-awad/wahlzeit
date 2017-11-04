package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.model.persistence.PersistenceSuit;

@RunWith(Suite.class)
@SuiteClasses({ PersistenceSuit.class, AccessRightsTest.class, FlagReasonTest.class, GenderTest.class, GuestTest.class, PhotoFilterTest.class,
		TagsTest.class, UserStatusTest.class, ValueTest.class })

public class ModelSuit {

}
