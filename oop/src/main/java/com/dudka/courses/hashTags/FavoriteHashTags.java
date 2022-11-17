package com.dudka.courses.hashTags;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FavoriteHashTags {
    public static LinkedHashMap<String, Integer> findMostPopularHashtag(List<String> tags) {
        Map<String, Integer> tagsAndCount = new HashMap<>();
        if(tags == null) {
            throw new NullPointerException("List of tags is null");
        } else if (tags.isEmpty()) {
            throw new IllegalArgumentException("List of tags is empty");
        } else {
            for(int i = 0; i < tags.size(); i++) {
                int count = 0;
                tags.set(i, Stream.of(tags.get(i).split("#"))
                        .distinct()
                        .collect(Collectors
                                .joining("#")));

                for(int j = 0; j < tags.size(); j++) {
                    if(tags.get(i).contains(tags.get(j))) {
                        count++;
                    }
                    tagsAndCount.put(tags.get(i), count);
                }
            }
            return tagsAndCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5)
                    .collect(Collectors
                            .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        }
    }
}
