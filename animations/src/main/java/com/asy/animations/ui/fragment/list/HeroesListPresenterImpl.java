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

package com.asy.animations.ui.fragment.list;

import com.asy.animations.R;
import com.asy.animations.model.Heroe;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class HeroesListPresenterImpl implements HeroesListPresenter {

    private HeroesListView mHeroesListView;

    public HeroesListPresenterImpl() {
    }


    @Override
    public void setView(HeroesListView heroesListView) {
        mHeroesListView = heroesListView;
    }

    @Override
    public void getHeroes() {

        List<Heroe> heroeList = new ArrayList<>();

        heroeList.add(
                new Heroe.Builder()
                        .setName("Thor")
                        .setActor("Chris Hemsworth")
                        .setAvatarUrl(R.drawable.avatar_thor)
                        .build()
        );

        heroeList.add(
                new Heroe.Builder()
                        .setName("Superman")
                        .setActor("Henry Cavill")
                        .setAvatarUrl(R.drawable.avatar_superman)
                        .build()
        );

        heroeList.add(
                new Heroe.Builder()
                        .setName("Batman")
                        .setActor("Christian Bale")
                        .setAvatarUrl(R.drawable.avatar_batman)
                        .build()
        );

        heroeList.add(
                new Heroe.Builder()
                        .setName("Ironman")
                        .setActor("Robert Downey Jr.")
                        .setAvatarUrl(R.drawable.avatar_ironman)
                        .build()
        );

        heroeList.add(
                new Heroe.Builder()
                        .setName("Capitán América")
                        .setActor("Chris Evans")
                        .setAvatarUrl(R.drawable.avatar_captain_america)
                        .build()
        );


        mHeroesListView.setHeroes(heroeList);

    }

}
