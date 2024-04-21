import org.example.JsonReader;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

    public class JsonReaderTest {
        private JsonReader reader;
        private boolean result;

        @Before
        public void setUp() {
            reader = new JsonReader();
        }
        @Test
        public void testResourceFieldContainsAsterisk() {
            result = reader.checkIfResourceFieldContainsASingleAsterisk("src/test/resources/fileWithStar.json");
            assertFalse(result); // Expecting false because Resource field contains a single asterisk
        }

        @Test
        public void testResourceFieldDoesNotContainAsterisk() {
            result = reader.checkIfResourceFieldContainsASingleAsterisk("src/test/resources/noStarFile.json");
            assertTrue(result); // Expecting true because Resource field does not contain a single asterisk
        }

        @Test(expected = RuntimeException.class)
        public void testIOException() {
            reader.checkIfResourceFieldContainsASingleAsterisk("non_existing_file.json"); // Expecting IOException
        }

        @Test(expected = RuntimeException.class)
        public void testJSONException() {
            reader.checkIfResourceFieldContainsASingleAsterisk("invalidJsonFile.json"); // Expecting JSONException
        }

        @Test(expected = RuntimeException.class)
        public void testResourceFieldNotPresent() {
            reader.checkIfResourceFieldContainsASingleAsterisk("src/test/resources/noResourceFieldFile.json"); // Expecting RuntimeException
        }
    }

