package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class LruJdk<K, V> extends LinkedHashMap<K, V> {
    private int initialCapacity;

    public LruJdk(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.initialCapacity = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > this.initialCapacity;
    }

    public static void main(String[] args) {

        LruJdk<Integer, String> lruJdk = new LruJdk(3, 0.75f, true);
        lruJdk.put(1, "1");
        lruJdk.put(2, "2");
        lruJdk.put(3, "3");
        System.out.println(lruJdk.keySet());

        System.out.println(lruJdk.get(1));
        System.out.println(lruJdk.keySet());


        lruJdk.put(4, "4");
        lruJdk.put(1, "1");

        System.out.println(lruJdk.keySet());

    }

}
