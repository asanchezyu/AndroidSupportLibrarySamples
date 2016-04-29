/*
 * Copyright (c) 2016. Alejandro Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.asy.animations.ui.activity.list;

import com.asy.animations.R;
import com.asy.animations.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class UserListPresenterImpl implements UserListPresenter {

    private UserListView mUserListView;

    public UserListPresenterImpl() {

    }

    @Override
    public void setView(UserListView userListView) {
        this.mUserListView = userListView;
    }

    @Override
    public void searchUsers() {

        List<User> users = new ArrayList<>();

        users.add(
                new User.Builder()
                        .setName("Cersei")
                        .setSurname("Lannister")
                        .setAvatarUrl(R.drawable.avatar_cersei)
                        .setActor("Lena Headey")
                        .build()
        );

        users.add(
                new User.Builder()
                        .setName("Daenerys")
                        .setSurname("Targaryen")
                        .setAvatarUrl(R.drawable.avatar_daenerys)
                        .setActor("Emilia Clarke")
                        .build()
        );

        users.add(
                new User.Builder()
                        .setName("Jon")
                        .setSurname("Snow")
                        .setAvatarUrl(R.drawable.avatar_jon)
                        .setActor("Kit Harington")
                        .build()
        );

        users.add(
                new User.Builder()
                        .setName("Sansa")
                        .setSurname("Stark")
                        .setAvatarUrl(R.drawable.avatar_sansa)
                        .setActor("Sophie Turner")
                        .build()
        );

        users.add(
                new User.Builder()
                        .setName("Tyrion")
                        .setSurname("Lannister")
                        .setAvatarUrl(R.drawable.avatar_tyrion)
                        .setActor("Peter Dinklage")
                        .build()
        );

        mUserListView.setUsers(users);
    }
}
