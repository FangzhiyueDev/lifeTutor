package com.xiaofangfang.lib;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class demo4 {

    //   static List list = null;

    public static void main(String[] argc) {

//        list = new ArrayList<Person>();


        List list = new ArrayList();
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));
        list.add(new Person("ag", "agqg"));

        List<? extends Person> persons = new ArrayList<>();
        persons = list;
        persons.get(0);
        //persons.add(new SuperMan());


        List<? super SuperMan> superMans=new ArrayList<>();







//        try (
////                BufferedReader bufferedReader=new BufferedReader();
//
//                ){
//
//        }


    }


    static class Person {

        private String Name;
        private String age;

        public Person() {

        }

        public Person(String name, String age) {
            Name = name;
            this.age = age;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }


    static class User {

        private String userName;
        private String serAddress;

        public User(String userName, String serAddress) {
            this.userName = userName;
            this.serAddress = serAddress;
        }

        public User() {

        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getSerAddress() {
            return serAddress;
        }

        public void setSerAddress(String serAddress) {
            this.serAddress = serAddress;
        }
    }

    static class SuperMan extends Person {


    }


}
