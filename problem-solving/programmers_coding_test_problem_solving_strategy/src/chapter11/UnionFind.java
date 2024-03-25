package chapter11;

public class UnionFind {

    private static class Node {
        private Node parent = null;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if(isConnected(o)) return;
            o.parent = this;
        }

        private Node root() {
            if(parent == null) return this;
            return parent = parent.root();
        }
    }
}
