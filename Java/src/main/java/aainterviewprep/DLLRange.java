package aainterviewprep;

import java.util.function.Predicate;

public class DLLRange {

    public static Node filter( Node head, Predicate<Node> isGood ) {
        // basic check
        if (null == head) {
            throw new IllegalArgumentException(
                    "Bad arguments for filterWithRange call! Head is null."
            );
        }

        Node resultHead = null;
        Node currentResultNode = null;
        Node current = head;


        // traverse and filter
        do {
            if (isGood.test(current)) {
                Node newNode = new Node(current.getValue());

                if (null == resultHead) {
                    resultHead = newNode;
                    currentResultNode = resultHead;
                } else {
                    currentResultNode.setNext(newNode);
                    newNode.setPrev(currentResultNode);
                    currentResultNode = newNode;
                }
            }
        } while ((current = current.getNext()) != null);

        return resultHead;
    }

    static class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node( int val ) {
            this.val = val;
        }

        public Node( int val, Node inPrev, Node inNext ) {
            this.val = val;
            this.prev = inPrev;
            this.next = inNext;
        }

        public int getValue() {
            return this.val;
        }

        public void setValue( int value ) {
            this.val = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev( Node inPrev ) {
            this.prev = inPrev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext( Node inNext ) {
            this.next = inNext;
        }

        public String toString() {
            Node current = this;
            StringBuilder output = new StringBuilder();


            do {
                output.append(" ").append(current.getValue());
            } while ((current = current.getNext()) != null);

            return output.toString();
        }
    }
}
