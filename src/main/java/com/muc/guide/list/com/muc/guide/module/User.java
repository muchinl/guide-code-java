package com.muc.guide.list.com.muc.guide.module;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class User {

    private int id;
    private String name;
    private String gender;
    private String email;

    public static List<User> randomDupUsers() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(
                    User.builder()
                            .id(i)
                            .name("name-" + (i / 2 == 0 ? i : "dup"))
                            .gender(i / 2 == 0 ? "MALE" : "FEMALE")
                            .email(System.currentTimeMillis() + "@example.com")
                            .build()
            );
        }
        return userList;
    }
}
