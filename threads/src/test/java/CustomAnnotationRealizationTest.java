import com.dudka.courses.task2.annotation.annotationPostProcces.CustomPropertyDeserialization;
import com.dudka.courses.task2.entity.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class CustomAnnotationRealizationTest {
    Person expectedPerson;
    Person actualPerson;

    @Before
    public void initExpectedAndActualPersonsForTesting() {
        actualPerson = (Person) CustomPropertyDeserialization.loadFromProperty(new Person(), "src/test/data/testProp.properties");
        Instant joinDate = LocalDateTime.parse("19.6.2020, 13:24", DateTimeFormatter
                        .ofPattern("d.M.uuuu, HH:mm"))
                .toInstant(ZoneOffset.UTC);
        expectedPerson = new Person("GhoulSSS", 30, joinDate);

    }

    @Test
    public void deserializePersonFromPropertiesThatReturnsPersonObjectWithFilledFields() {
        Assert.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void isDeserializedPersonHasNotNullValue() {
        Assert.assertNotNull(actualPerson);
    }


}
