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

package com.asy.animations.ui.activity.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.asy.animations.R;
import com.asy.animations.model.User;
import com.asy.animations.util.CircleTransform;
import com.squareup.picasso.Picasso;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class UserDetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "user";
    private TextView tvUserName;

    private TextView tvUserSurname;

    private TextView tvUserActor;

    private ImageView ivAvatar;

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_user_detail );

        //Receive data
        User user = (User) getIntent().getExtras().getSerializable(EXTRA_USER);

        //Find views.
        initViews();

        //Custommizing view.
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle( user.getName() + " " + user.getSurname() );

        setSupportActionBar(toolbar);

        Picasso.with( this ).load( user.getAvatarUrl() )
                .transform( new CircleTransform() )
                .into(ivAvatar);

        tvUserName.setText(user.getName());

        tvUserSurname.setText(user.getSurname());

        tvUserActor.setText(user.getActor());

    }


    private void initViews(){
        tvUserName = (TextView) findViewById(R.id.tv_user_detail_name);

        tvUserSurname = (TextView) findViewById(R.id.tv_user_detail_surname);

        tvUserActor = (TextView) findViewById(R.id.tv_user_detail_actor);

        ivAvatar = (ImageView) findViewById(R.id.iv_user_detail_avatar);

    }
}
