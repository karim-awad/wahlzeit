package org.wahlzeit.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.HandlersSuit;
import org.wahlzeit.model.ModelSuit;
import org.wahlzeit.services.ServicesSuit;
import org.wahlzeit.utils.UtilsSuite;

@RunWith(Suite.class)
@SuiteClasses({HandlersSuit.class, ModelSuit.class, ServicesSuit.class, UtilsSuite.class})

public class AllTests {

}
