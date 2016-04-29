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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asy.animations.R;
import com.asy.animations.model.Heroe;
import com.asy.animations.ui.fragment.HeroesMainActivity;
import com.asy.animations.ui.fragment.list.adapter.HeroesAdapter;
import com.asy.animations.ui.fragment.list.listener.OnHeroeClickListener;

import java.util.List;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class HeroesListFragment extends Fragment implements HeroesListView, OnHeroeClickListener{


    private HeroesListPresenter mHeroesListPresenter;

    private RecyclerView rvHeroes;

    private HeroesAdapter heroesAdapter;


    public static HeroesListFragment newInstance() {

        return new HeroesListFragment();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_heroes_list, container, false);

        rvHeroes = (RecyclerView)view.findViewById( R.id.rv_heroes );

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        rvHeroes.setLayoutManager( new LinearLayoutManager( getActivity() ) );

        heroesAdapter = new HeroesAdapter(this);

        rvHeroes.setAdapter( heroesAdapter );

        mHeroesListPresenter = new HeroesListPresenterImpl();

        mHeroesListPresenter.setView(this);

        mHeroesListPresenter.getHeroes();

    }

    @Override
    public void setHeroes(List<Heroe> heroes) {

        heroesAdapter.setHeroeList( heroes );

        heroesAdapter.notifyDataSetChanged();

    }

    @Override
    public void onHeroeClicked(Heroe heroe, HeroesAdapter.Holder holder) {

        ((HeroesMainActivity)getActivity()).goToHeroeDetail( heroe, holder );

    }
}
