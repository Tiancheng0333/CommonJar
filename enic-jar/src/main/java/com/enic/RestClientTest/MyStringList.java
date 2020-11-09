package com.enic.RestClientTest;

/**
 *
 */
public class MyStringList implements StringList {

    private SNode head;

    private int size;

    //default constructor
    public MyStringList() {
    }

    /**
     *
     * @param s the item to add
     */
    @Override
    public void insert(String s) {

        //Whether initialization is Need
        if (head == null) {
            this.head = new SNode();
            size++;
        }
        //Traverse according to this variable
        SNode sNode = head;
        while (sNode.getNextNode() != null) {
            //isRepeat
            if (sNode.getNextNode().getData().equals(s)) {
                sNode.getNextNode().increment();
                return;
            }
            sNode = sNode.getNextNode();
        }
        //If no return indicates that the node does not have this value, the end node is set at this time
        sNode.setNext(new SNode(s));
        size++;
    }

    /**
     *
     * @param s the String (i.e. item) to delete
     */
    @Override
    public void delete(String s) {
        //Whether initialization is Need
        if (size == 0) {
            System.out.println("List is Null!");
        }
        //Traverse according to this variable
        SNode sNode = head;
        while (sNode.getNextNode() != null) {
            //isRepeat
            if (sNode.getNextNode().getData().equals(s)) {
                if (sNode.getNextNode().getCount() > 1) {
                    sNode.getNextNode().decrement();
                    return;
                }
                sNode.setNext(sNode.getNextNode().getNextNode());
                return;
            }
            sNode = sNode.getNextNode();
        }
    }

    /**
     *
     * @param s the String that we are looking for
     * @return
     */
    @Override
    public int findCount(String s) {
        //isNull
        if (size == 0) {
            System.out.println("List is Null!");
        }
        SNode sNode = head;
        while (sNode.getNextNode() != null) {
            if (sNode.getNextNode().getData().equals(s)) {
                return sNode.getNextNode().getCount();
            }
            sNode = sNode.getNextNode();
        }
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    public SNode firstNode() {
        //isNull
        if (size == 0) {
            System.out.println("List is Null!");
        }
        return head;
    }

    public SNode getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "MyStringList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
