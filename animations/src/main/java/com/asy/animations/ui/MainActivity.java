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

package com.asy.animations.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.asy.animations.R;
import com.asy.animations.ui.activity.list.UserListActivity;

/**
 * Class Description.
 *
 * @author asanchezy.
 * @version 1.0.
 * @since 26/4/16.
 */
public class MainActivity extends AppCompatActivity {

    private Button btActivityAnimations;

    private Button btFragmentAnimations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_home);

        btActivityAnimations = (Button) findViewById(R.id.bt_activity_animations);

        btFragmentAnimations= (Button) findViewById(R.id.bt_fragment_animations);

        initListeners();

    }

    private void initListeners(){

        btActivityAnimations.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent i = new Intent( MainActivity.this, UserListActivity.class);

                startActivity(i);

            }

        });

        btFragmentAnimations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
