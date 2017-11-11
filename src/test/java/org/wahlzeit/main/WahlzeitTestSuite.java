package org.wahlzeit.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.HandlersSuite;
import org.wahlzeit.model.ModelSuite;
import org.wahlzeit.services.ServicesSuite;
import org.wahlzeit.utils.UtilsSuite;

@RunWith(Suite.class)
@SuiteClasses({HandlersSuite.class,
				ModelSuite.class,
				ServicesSuite.class,
				UtilsSuite.class})

public class WahlzeitTestSuite {

}
