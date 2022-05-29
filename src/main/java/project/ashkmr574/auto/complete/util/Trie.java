package project.ashkmr574.auto.complete.util;

import java.util.*;

public final class Trie {

    private class Node {
        Map<Character, Node> successors;
        boolean endOfWord;

        public Node() {
            successors = new HashMap<>();
            endOfWord = false;
        }
    }

    private final Node rootNode;

    public Trie() {
        this.rootNode = new Node();
    }

    public void insert(String word) {
        Node currentNode = rootNode;

        for(int i= 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            Node node = currentNode.successors.get(currentChar);

            if (node == null) {
                node = new Node();
                currentNode.successors.put(currentChar, node);
            }

            currentNode = node;
        }

        currentNode.endOfWord = true;
    }

    public List<String> searchNames(String prefix) {
        List<String> names = new ArrayList<>();
        Node prefixNode = search(prefix);

        if (prefixNode != null) {
            searchAllMatchingNames(prefixNode, names, prefix);
        }

        return names;
    }

    private Node search(String word) {
        Node currentNode = rootNode;

        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            Node node = currentNode.successors.get(currentChar);

            if (node == null) {
                return null;
            }

            currentNode = node;
        }

        return currentNode;
    }

    private void searchAllMatchingNames(Node node, List<String> names, String curName) {
        if (node == null) {
            return;
        }

        if(node.endOfWord == true) {
            names.add(curName);
        }

        for (Map.Entry<Character, Node> element : node.successors.entrySet()) {
            char ch = element.getKey();
            Node curNode = element.getValue();

            searchAllMatchingNames(curNode, names, curName + ch);
        }
    }

}
