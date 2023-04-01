package com.example.hearing_java_figma.ObjectListContent;


import com.example.hearing_java_figma.VO.KeywordTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordsContent {

    public static final List<KeywordTuple> ITEMS = new ArrayList<KeywordTuple>();
    public static final Map<String, KeywordTuple> ITEM_MAP = new HashMap<String, KeywordTuple>();

    static {
        // Add some sample items.
        for (int i = 1; i <= 10; i++) {
            KeywordTuple k = new KeywordTuple();
            k.setName("Keyword ");
            k.setActivated(true);
            addItem(k);
        }
    }

    public static void addItem(KeywordTuple item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getName(), item);
    }

}
