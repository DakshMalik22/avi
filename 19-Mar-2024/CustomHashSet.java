import java.util.ArrayList;
import java.util.List;

public class CustomHashSet {
    private List<Integer>[] buckets;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    public CustomHashSet() {
        buckets = new List[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new ArrayList<>();
        }
        size = 0;
    }

    public void add(int key) {
        if (!contains(key)) {
            if (loadFactor() >= LOAD_FACTOR) {
                resize();
            }
            int index = getIndex(key);
            buckets[index].add(key);
            size++;
        }
    }

    public void remove(int key) {
        int index = getIndex(key);
        System.out.println(key);
        buckets[index].remove((Integer) key);
    }

    public boolean contains(int key) {
        int index = getIndex(key);
        return buckets[index].contains(key);
    }

    private int getIndex(int key) {
        return key % buckets.length;
    }

    private double loadFactor() {
        return (double) size / buckets.length;
    }

    private void resize() {
        List<Integer>[] oldBuckets = buckets;
        buckets = new List[2 * oldBuckets.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (List<Integer> bucket : oldBuckets) {
            for (int key : bucket) {
                int index = getIndex(key);
                buckets[index].add(key);
            }
        }
    }

    public static void main(String[] args) {
        CustomHashSet set = new CustomHashSet();
        set.add(500);
        set.add(200);
        set.add(400);
        System.out.println(set.contains(200));
        System.out.println(set.contains(600));
        set.remove(200);
    }
}

