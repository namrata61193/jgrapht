package org.jgrapht.alg;

import static org.junit.Assert.assertThat;


import cucumber.api.junit.Cucumber;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features="src/test/resources/org/jgrapht/alg"
        )
public class CucumberTest {
}


