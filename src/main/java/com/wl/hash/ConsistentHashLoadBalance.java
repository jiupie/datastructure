package com.wl.hash;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 南顾北衫
 */
public class ConsistentHashLoadBalance {

    private ConcurrentHashMap<String, ConsistentHashSelector> concurrentHashMap = new ConcurrentHashMap<>();

    static class Invoker {
        private String url;
        private String name;

        public Invoker(String url, String name) {
            this.url = url;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Objects.hash(url, name);
        }

        @Override
        public String toString() {
            return "Invoker{" + "url='" + url + '\'' + ", name='" + name + '\'' + '}';
        }
    }

    public Map.Entry<Integer, Invoker> select(List<Invoker> invokers, String url) {
        ConsistentHashSelector consistentHashSelector = concurrentHashMap.get(url);

        if (Objects.isNull(consistentHashSelector) || invokers.hashCode() != consistentHashSelector.invokerListHashCode) {
            consistentHashSelector = new ConsistentHashSelector(invokers, invokers.hashCode());
            concurrentHashMap.put(url, consistentHashSelector);
        }
        Map.Entry<Integer, Invoker> integerInvokerEntry = consistentHashSelector.virtualHash.ceilingEntry(url.hashCode());
        return integerInvokerEntry;
    }

    private static class ConsistentHashSelector {
        private int invokerListHashCode;
        private TreeMap<Integer, Invoker> virtualHash = new TreeMap<>();
        private List<Invoker> invokers;
        private int replicasNumber = 160;

        public ConsistentHashSelector(List<Invoker> invokers, int invokerListHashCode) {
            this.invokers = invokers;
            this.invokerListHashCode = invokerListHashCode;

            for (Invoker invoker : invokers) {
                for (int i = 0; i < replicasNumber; i++) {
                    int abs = Math.abs((invoker.url + i).hashCode());
                    int hashCode = abs ^ abs >>> 16;
                    virtualHash.put(hashCode, invoker);
                }
            }

        }

    }

    public static void main(String[] args) {
        ConsistentHashLoadBalance consistentHashLoadBalance = new ConsistentHashLoadBalance();
        List<Invoker> arrayList = new ArrayList<>();
        arrayList.add(new Invoker("192.168.2.154", "hello"));
        arrayList.add(new Invoker("192.168.2.42", "hello"));
        arrayList.add(new Invoker("192.168.2.74", "hello"));
        arrayList.add(new Invoker("192.168.2.76", "hello"));
        arrayList.add(new Invoker("192.168.6.76", "hello"));

        System.out.println(consistentHashLoadBalance.select(arrayList, "192.168.5.125"));
        System.out.println(consistentHashLoadBalance.select(arrayList, "192.168.5.154"));
        System.out.println(consistentHashLoadBalance.select(arrayList, "192.168.3.154"));
        System.out.println(consistentHashLoadBalance.select(arrayList, "192.168.45.154"));
        System.out.println(consistentHashLoadBalance.select(arrayList, "192.168.1.154"));


        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(0,"a");
        treeMap.put(2,"b");
        treeMap.put(6,"c");
        treeMap.put(9,"d");

        System.out.println(treeMap.ceilingEntry(7).getKey());

    }
}
