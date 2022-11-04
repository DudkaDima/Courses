import com.dudka.courses.hashTags.FavoriteHashTags;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FavoriteHashTagsTest {
    List<String> hashTagsList;
    Map<String, Integer> expectedMapWithTags;

    @Before
    public void initListOfTags() {
        hashTagsList = new ArrayList<>();
        
        hashTagsList.add("#Life#Life");
        hashTagsList.add("#Life");
        hashTagsList.add("#Coffee");
        hashTagsList.add("#Coffee");
        hashTagsList.add("#Fish");
        hashTagsList.add("#Life");
        hashTagsList.add("#Life");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#RulesForward#RulesForward");
        hashTagsList.add("#RulesForward");
        hashTagsList.add("#Clouse");
        hashTagsList.add("#Clouse");
        hashTagsList.add("#Clouse");
        hashTagsList.add("#Clouse");
        hashTagsList.add("#Clouse");
    }
    
    @Before
    public void generateExpectedValues() {
        expectedMapWithTags = new LinkedHashMap<>();
        expectedMapWithTags.put("#RulesForward", 8);
        expectedMapWithTags.put("#Clouse", 5);
        expectedMapWithTags.put("#Life", 4);
        expectedMapWithTags.put("#Coffee", 2);
        expectedMapWithTags.put("#Fish", 1);

    }

    @Test
    public void mostPopularHashTagsInUseTest() {

        Assert.assertEquals(expectedMapWithTags, FavoriteHashTags.findMostPopularHashtag(hashTagsList));
    }
}
