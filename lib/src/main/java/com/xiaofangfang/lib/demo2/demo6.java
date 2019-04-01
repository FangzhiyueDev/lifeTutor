package com.xiaofangfang.lib.demo2;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

public class demo6 {

    public static void main(String[] argc) {


        Gson gson = new Gson();
        String json = "{\"name\":\"fang\", \"age\":\"22\", \"address\":\"fangrwtweg\"}";


//        Person person = gson.fromJson(json, Person.class);


    }


    abstract class Person {

        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }


    class User extends Person {

        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public User(String name, String age, String address) {
            this.setAddress(address);
            this.name = name;
            this.age = age;
        }

        public User() {

        }
    }

}
