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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.asy.animations.R;
import com.asy.animations.model.User;
import com.asy.animations.ui.activity.detail.UserDetailActivity;
import com.asy.animations.ui.activity.list.adapter.UserAdapter;
import com.asy.animations.ui.activity.list.listener.OnUserClickListener;

import java.util.List;
/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class UserListActivity extends AppCompatActivity implements UserListView, OnUserClickListener {

    private RecyclerView rvElements;

    private UserAdapter userAdapter;

    private UserListPresenter userListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_list);

        //Init RecyclerView
        rvElements = (RecyclerView) findViewById(R.id.rv_elements);

        rvElements.setLayoutManager(new LinearLayoutManager(this));

        userAdapter = new UserAdapter(this);

        rvElements.setAdapter(userAdapter);

        //Init Presenter
        userListPresenter = new UserListPresenterImpl();

        userListPresenter.setView(this);

        userListPresenter.searchUsers();

    }

    @Override
    public void setUsers(List<User> users) {

        userAdapter.setUserLists(users);

        userAdapter.notifyDataSetChanged();

    }

    @Override
    public void onUserClicked(User user, UserAdapter.Holder holder) {

        Intent intent = new Intent(this, UserDetailActivity.class);

        intent.putExtra(UserDetailActivity.EXTRA_USER, user);

        Pair<View, String> p1 = Pair.create((View) holder.getIvUserAvarar(), getString(R.string.transition_avatar));

        Pair<View, String> p2 = Pair.create((View) holder.getTvUserName(), getString(R.string.transition_name));

        Pair<View, String> p3 = Pair.create((View) holder.getTvUserSurname(), getString(R.string.transition_surname));

        Pair<View, String> p4 = Pair.create((View) holder.getTvUserActor(), getString(R.string.transition_actor));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, p1, p2, p3, p4);

        startActivity(intent, options.toBundle());

    }
}
