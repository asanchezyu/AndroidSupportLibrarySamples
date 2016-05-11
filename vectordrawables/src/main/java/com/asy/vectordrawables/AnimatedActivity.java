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

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 11/5/16.
 */
public class AnimatedActivity extends AppCompatActivity {

    private Button btAnimate;

    private ImageView ivAnimated;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animated);

        ivAnimated = (ImageView) findViewById(R.id.iv_animated_vector);

        btAnimate = (Button) findViewById(R.id.bt_animate);

        btAnimate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                animate();
            }
        });

    }

    private void animate() {

        Drawable drawable = ivAnimated.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }

    }
}
