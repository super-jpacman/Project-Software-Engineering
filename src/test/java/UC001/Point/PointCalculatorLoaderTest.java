package UC001.Point;

import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

class PointCalculatorLoaderTest {

    private PointCalculatorLoader loader;

    @BeforeEach
    void setUp() {
        loader = new PointCalculatorLoader();
    }

    @Test
    @DisplayName("TC01: loadDefaultCalculator")
    public void TC01() {
        PointCalculator calculator = loader.load();
        Assertions.assertTrue(calculator instanceof DefaultPointCalculator);
    }

}

