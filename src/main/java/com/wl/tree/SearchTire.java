package com.wl.tree;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.*;

/**
 * @author 南顾北衫
 * @date 2022/8/24
 */
public class SearchTire {
    public static void main(String[] args) {
//        FileReader fileReader = new FileReader("");
        TireTree tireTree = new TireTree();
        tireTree.put("sdsaf");
        tireTree.put("sdsx");
        tireTree.put("safdsc");
        tireTree.put("sxfdsc");
        tireTree.put("xxfdsc");
        tireTree.put("xxf3dsc");
        tireTree.put("xxf1dsc");
        tireTree.put("xxfq2dsc");
        tireTree.put("xxfds3sdafc");
        tireTree.put("xxfdsadfsc");
        tireTree.put("xxfzcdsc");
        tireTree.put("xxfwe2rwqdsc");
        tireTree.put("xxfd4sdasc");
        tireTree.put("sda321f");
        tireTree.put("xx143fczdzxcvzsc");
        tireTree.put("xxfdsc");
        tireTree.put("xxxzcvfdsc");
        tireTree.put("xxfd zxvsc");
        tireTree.put("我xxfd sc");

        System.out.println(tireTree.search("我"));
    }

    static class TireTree {
        Node root;

        public void put(String s) {
            if (root == null) {
                this.root = new Node();
            }

            Node n = root;
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                Node node = n.getChildern().get(c);
                if (node == null) {
                    Node newNode = new Node();
                    newNode.setValue(c);
                    n.getChildern().put(c, newNode);
                    n = newNode;
                } else {
                    n = node;
                }
            }
            n.setEnd(true);
        }

        public List<String> search(String prefix) {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> list = new ArrayList<>();
            Node n = root;
            int length = prefix.length();
            for (int i = 0; i < length; i++) {
                char c = prefix.charAt(i);
                Node node = n.getChildern().get(c);
                stringBuilder.append(c);

                if (node.isEnd) {
                    list.add(stringBuilder.toString());
                }
                n = node;
            }
            Map<Character, Node> childern = n.getChildern();
            if(childern.size()!=0){
                search(childern, stringBuilder, list);
            }

            return list;
        }

        private void search(Map<Character, Node> childern, StringBuilder stringBuilder, ArrayList<String> list) {
            Set<Map.Entry<Character, Node>> entries = childern.entrySet();
            for (Map.Entry<Character, Node> entry : entries) {
                Character c = entry.getKey();
                stringBuilder.append(c);
                Node value = entry.getValue();
                if (value.isEnd) {
                    list.add(stringBuilder.toString());
                }
                Map<Character, Node> childern1 = value.getChildern();
                if (childern1 == null) {
                    continue;
                }
                search(childern1, stringBuilder, list);
            }
        }
    }


    static class Node {


        char value;

        boolean isEnd = false;

        Map<Character, Node> childern = new HashMap<>(128);

        public char getValue() {
            return value;
        }

        public Map<Character, Node> getChildern() {
            return childern;
        }

        public void setChildern(Map<Character, Node> childern) {
            this.childern = childern;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}


