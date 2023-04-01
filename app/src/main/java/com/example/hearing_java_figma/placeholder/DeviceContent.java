package com.example.hearing_java_figma.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DeviceContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<DeviceItem> ITEMS = new ArrayList<DeviceItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, DeviceItem> ITEM_MAP = new HashMap<String, DeviceItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDeviceItem(i));
        }
    }

    private static void addItem(DeviceItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DeviceItem createDeviceItem(int position) {
        return new DeviceItem(String.valueOf(position), "Devices " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class DeviceItem {
        public final String id;
        public final String content;
        public final String details;

        public DeviceItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}