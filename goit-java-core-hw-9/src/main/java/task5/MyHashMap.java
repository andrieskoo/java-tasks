package task5;

import java.util.HashMap;
import java.util.Objects;

public class MyHashMap<K, V> {
    Entry<K, V>[] buckets;

    private static final int DEFAULT_BUCKET_COUNT = 10;

    public MyHashMap() {
        this.buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public boolean put(K key, V value) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;
        Entry<K, V> newEntry = new Entry<>();
        newEntry.setKey(key);
        newEntry.setValue(value);

        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = newEntry;
            return true;
        }
        newEntry.setNextEntry(buckets[bucketNumber]);
        buckets[bucketNumber] = newEntry;
        return true;
    }

    public V remove(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
//        Entry<K, V> deletedEntry;
        Entry<K, V> prevEntry = null;
        if (currentEntry.getNextEntry() == null){
            buckets[bucketNumber]= null;
            return currentEntry.getValue();
        }
        while (currentEntry.getNextEntry() != null){
            if (checkEntryEquals(currentEntry, key)) {
                if (prevEntry == null){
                    buckets[bucketNumber] = currentEntry.getNextEntry();
                    return currentEntry.getValue();
                }
                else {
                prevEntry.setNextEntry(currentEntry.getNextEntry());
//                currentEntry = null;
                return currentEntry.getValue();
                }

            }
            prevEntry = currentEntry;
            currentEntry = currentEntry.getNextEntry();

        }
//        else {
//            buckets[bucketNumber] = null;
//        }

        return null;
//        while (currentEntry.getNextEntry() != null) {
//            if (checkEntryEquals(currentEntry, key)) {
//                deletedEntry = currentEntry;
//                prevEntry.setNextEntry(currentEntry.getNextEntry());
//                currentEntry = null;
//                return null;
//            }
//            prevEntry = currentEntry;
//            currentEntry = currentEntry.getNextEntry();
//        }
//        if (checkEntryEquals(currentEntry, key)){
//            buckets[bucketNumber] = null;
//            return currentEntry;
//        }
//        return null;
//        HashMap<String, Integer> m = new HashMap<>();
//                m.remove("sqs");
    }

    public void clear() {
        this.buckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public int size() {
        int size = 0;
        for (Entry<K, V> currEntry : buckets) {
            if (currEntry == null){
                continue;
            }
            while (currEntry.getNextEntry() != null){
                size++;
                currEntry = currEntry.getNextEntry();
            }
            size++;
        }
        return size;

    }

    public V get(K key) {
        int hash = key.hashCode();
        int bucketNumber = hash % buckets.length;

        Entry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.getNextEntry() != null) {
            if (checkEntryEquals(currentEntry, key)) {
                return currentEntry.getValue();
            }
            currentEntry = currentEntry.getNextEntry();
        }
        return currentEntry.getValue();

    }

    private boolean checkEntryEquals(Entry<K, V> currentEntry, K key) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(currentEntry.getKey());
        return Objects.equals(currentEntry.getKey(), key);
    }
}
