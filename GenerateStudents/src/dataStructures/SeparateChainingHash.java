package dataStructures;

import generatestudents.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joost
 */
public class SeparateChainingHash<Key, Value> {

    private int N; // number of key-value pairs
    private int M; // hash table size
    private SequentialSearchST<Key, Value>[] st; // array of ST objects

    public SeparateChainingHash() {
        this(997);
    }

    public SeparateChainingHash(int M) { // Create M linked lists.
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST();
        }
    }

    private int hash(Key key) {
        Student s = new Student(key.toString(), 0);
        return (s.hash() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public int put(Key key, Value val) {
        st[hash(key)].put(key, val);
        return st[hash(key)].size();
    }

}
