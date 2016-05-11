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

package com.asy.vectordrawables;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 11/5/16.
 */
public class HomeActivity extends AppCompatActivity {

    private Button btComparision;

    private Button btAnimated;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        initViews();

        initListeners();

    }

    private void initListeners() {

        btComparision.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ComparisionActivity.class);
                startActivity(i);
            }
        });

        btAnimated.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, AnimatedActivity.class);
                startActivity(i);
            }
        });

    }

    private void initViews() {
        btAnimated = (Button)findViewById(R.id.bt_animated_vector);

        btComparision = (Button) findViewById(R.id.bt_comparision_png_svg);
    }
}
