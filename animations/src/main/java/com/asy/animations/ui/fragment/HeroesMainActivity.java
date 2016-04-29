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

package com.asy.animations.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.widget.FrameLayout;

import com.asy.animations.R;
import com.asy.animations.model.Heroe;
import com.asy.animations.ui.fragment.detail.HeroeDetailFragment;
import com.asy.animations.ui.fragment.list.HeroesListFragment;
import com.asy.animations.ui.fragment.list.adapter.HeroesAdapter;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class HeroesMainActivity extends AppCompatActivity {

    private FrameLayout mainContainer;

    private HeroesListFragment heroesListFragment;

    private HeroeDetailFragment heroeDetailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_heroes);

        mainContainer = (FrameLayout)findViewById(R.id.main_container);

        goToHeroesList();
    }

    public void goToHeroesList(){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        heroesListFragment = HeroesListFragment.newInstance();

        transaction.replace(R.id.main_container, heroesListFragment );
//        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void goToHeroeDetail(Heroe heroe, HeroesAdapter.Holder holder){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        heroeDetailFragment = HeroeDetailFragment.newInstance(heroe);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            // Inflate transitions to apply
            Transition changeTransform = TransitionInflater.from(this).inflateTransition(R.transition.change_image_transform);

            Transition explodeTransform = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);

//            // Setup exit transition on first fragment
            heroesListFragment.setSharedElementReturnTransition(changeTransform);
            heroesListFragment.setExitTransition(explodeTransform);

            // Setup enter transition on second fragment
            heroeDetailFragment.setSharedElementEnterTransition(changeTransform);
            heroeDetailFragment.setEnterTransition(explodeTransform);

            transaction.addSharedElement(holder.getIvAvatar(), getString(R.string.transition_avatar));

        }

        transaction.addToBackStack(null);

        transaction.replace(R.id.main_container, heroeDetailFragment );

        transaction.commit();
    }


}
