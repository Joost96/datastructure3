/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataStructures;

import generatestudents.Student;

/**
 *
 * @author Joost
 */
public class LinearProbingHash<Key, Value> {

    private int N; // number of key-value pairs in the table
    private int M = 16; // size of linear-probing table 
    private Key[] keys; // the keys 
    private Value[] vals; // the values 

    public LinearProbingHash() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }
    
    public LinearProbingHash(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        Student s = new Student(key.toString(), 0);
        return (s.hash() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHash<Key, Value> t;
        t = new LinearProbingHash<Key, Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public int put(Key key, Value val) {
        if (N >= M / 2) {
            resize(2 * M); // double M (see text)
        }
        int i , j = 0;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return 0;
            }
            j++;
        }
        keys[i] = key;
        vals[i] = val;
        N++;
        return j;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
}
