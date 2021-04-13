package HashTable;

import LinkList.LinkList;

// This class takes Integer as key and String as value
public class HashTableUsingLinkedList implements IHashTable<Integer, String>{
    private LinkList<Entry>[] entries = new LinkList[5];

    @Override
    public void put(Integer key, String value) {
        var index = Hash(key);

        if(entries[index] == null)
            entries[index] = new LinkList<Entry>();

        // Check if the key input already exists
        for (var n : entries[index]) {
            if(n.value.key == key) {
                n.value.value = value;
                return;
            }
        }

        var entry = new Entry(key, value);
        entries[index].add(entry);
    }

    @Override
    public String get(Integer key) {
        if(key == null)
            return null;

        var index = Hash(key);

        if(entries[index] == null)
            return null;

        // Check if the key input already exists
        for (var n : entries[index])
            if(n.value.key == key)
                return n.value.value;

        return null;
    }

    @Override
    public String remove(Integer key) {
        if(key == null)
            return null;

        var index = Hash(key);

        if(entries[index] == null)
            return null;

        // Find the item, Delete and return the value of the item
        for (var n : entries[index])
            if(n.value.key == key) {
                entries[index].remove(n.value);
                return n.value.value;
            }

        return null;
    }

    private int Hash(int key){
        if(key < 0)
            throw new IllegalArgumentException("Key cannot be negative");

        return key % entries.length;
    }

    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

}
