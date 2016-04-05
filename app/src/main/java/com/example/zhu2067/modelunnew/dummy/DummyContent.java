package com.example.zhu2067.modelunnew.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        ArrayList <String> docs1 = new ArrayList<String>();
        ArrayList <String> docs2 = new ArrayList<String>();
        ArrayList <String> docs3 = new ArrayList<String>();
        docs1.add(0,"file1");
        docs2.add(0, "");
        docs3.add(0,"");


        addItem(new DummyItem("1", "CSMUN", docs1));
        addItem(new DummyItem("2", "SIMUN", docs2));
        addItem(new DummyItem("3", "CIMUN", docs3));
    }



    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String itemName;
        public static ArrayList<String> docList;

        public DummyItem(String id, String itemName, ArrayList <String> docList) {
            this.id = id;
            this.itemName = itemName;
            this.docList = docList;
        }

        public ArrayList <String> getList()
        {
            return docList;
        }

        @Override
        public String toString()
        {
            return itemName;
        }
    }
}
