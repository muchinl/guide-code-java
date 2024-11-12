package com.muc.guide.list;

import com.muc.guide.list.com.muc.guide.module.User;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ListDuplicate
 */
public class ListDuplicate {

    private List<Integer> simpleList;
    private List<User> objList;

    @Before
    public void init() {
        simpleList = Arrays.asList(9, 2, 8, 1, 5, 2, 4, 1, 8, 1);
        objList = User.randomDupUsers();
    }

    @Test
    public void testSimpleList() {
        System.out.println("simpleList: " + simpleList);
        HashSet<Integer> hashSet = new HashSet<>(simpleList);
        System.out.println("hashSet: " + hashSet);
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(simpleList);
        System.out.println("treeSet: " + treeSet);
        Set<Integer> streamSet = simpleList.stream().collect(Collectors.toSet());
        System.out.println("streamSet: " + streamSet);
        List<Integer> streamList = simpleList.stream().distinct().collect(Collectors.toList());
        System.out.println("streamList: " + streamList);
    }

    @Test
    public void testObjectList() {
        System.out.println("dupList: " + objList);
        List<User> unDupList = objList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))),
                        ArrayList::new)
        );
        System.out.println("unDupList:" + unDupList);
    }
}
