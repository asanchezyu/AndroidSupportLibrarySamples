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

package com.asy.applaunchcheckersample;

import android.support.v4.app.AppLaunchChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * AppLaunchChecker example.
 *
 * @author asanchezyu@gmail.com
 * @since 15/04/2016
 * @version 1.0.
 */
public class AppLaunchCheckerActivity extends AppCompatActivity {

    private TextView tvAppState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_app_launch_checker);

        tvAppState = (TextView) findViewById( R.id.tv_app_state );

        if( AppLaunchChecker.hasStartedFromLauncher(this) ){

            tvAppState.setText(R.string.app_started_from_launcher);

        }else{

            tvAppState.setText(R.string.app_not_started_from_launcher);

        }

        AppLaunchChecker.onActivityCreate( this );

    }
}
