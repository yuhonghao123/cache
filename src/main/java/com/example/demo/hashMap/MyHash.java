package com.example.demo.hashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHash {
    private int size = 8;
    private int number = 0;
    private ArrayList<LinkedList> array_head = new ArrayList<LinkedList>(size);

    public MyHash() {
        for(int i=0;i<size;i++) {
            LinkedList mylist = new LinkedList();
            array_head.add(mylist);
        }
    }


    public void put(Object key,Object value) {
        number++;
        Node new_node = new Node(key,value);

        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);

        list_head.add(new_node);
    }

    public Object get(Object key) {

        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);

        for(int i=0;i<list_head.size();i++) {
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {
                if(node.getKey().equals(key)) {
//					System.out.println("node.getValue() :"+node.getValue());
                    return node.getValue();
                }
                node = node.getNext();
            }
        }

        return null;
    }

    public Object remove(Object key) {
        number--;
        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);

        for(int i=0;i<list_head.size();i++) {
            //首先拿到头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {

                //如果 键 相等
                if(node.getKey().equals(key)) {
                    Object value = node.getValue();
                    list_head.remove(node);
                    return value;
                }
                node = node.getNext();
            }
        }
        return null;

    }


    public Object replace(Object key,Object newvalue) {
        System.out.println("replace");
        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);

        for(int i=0;i<list_head.size();i++) {
            //首先拿到头节点
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {
                //如果 键 相等
                if(node.getKey().equals(key)) {
                    Object oldvalue = node.getValue();
                    node.setValue(newvalue);
                    return oldvalue;
                }
                node = node.getNext();
            }
        }
        return null;


    }

    public boolean containsKey(Object key) {

        int code = hashcode(key.toString());
        int position = locate(code);

        LinkedList list_head = (LinkedList) array_head.get(position);

        for(int i=0;i<list_head.size();i++) {
            Node head = (Node) list_head.get(i);
            Node node = head;
            while(node!=null) {

                if(node.getKey().equals(key)) {
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;

    }


    public Object containsValue(Object value) {

        for(int k=0;k<size;k++) {
            LinkedList list_head = (LinkedList) array_head.get(k);

            for(int i=0;i<list_head.size();i++) {
                Node head = (Node) list_head.get(i);
                Node node = head;
                while(node!=null) {

                    if(node.getValue().equals(value)) {
                        return true;
                    }
                    node = node.getNext();
                }
            }
        }
        return false;

    }

    public int size() {

        return number;

    }


    public void clear() {
        for(int i=0;i<size;i++) {

            LinkedList list_head = array_head.get(i);
            list_head.clear();

        }
        number = 0;
    }

    public int hashcode(String s) {
        int k = 0;
        for(int i=0;i<s.length();i++) {
            k += s.charAt(i);
        }
        return k;
    }

    public int locate(int k) {
        int m = k%size;
        return m;
    }
}
