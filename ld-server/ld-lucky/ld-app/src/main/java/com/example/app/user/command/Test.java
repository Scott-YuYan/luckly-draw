package com.example.app.user.command;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test0");
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        list.remove("test1");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (i == 2) {
                list.remove(i);
            }
        }
        System.out.println(list);

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().equals("test2")) {
                it.remove();
            }
        }
        System.out.println(list);

        for (String s : list) {
            if ("test5".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }


}
