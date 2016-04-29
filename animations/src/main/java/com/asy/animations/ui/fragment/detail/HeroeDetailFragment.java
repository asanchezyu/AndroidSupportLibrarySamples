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

package com.asy.animations.ui.fragment.detail;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asy.animations.R;
import com.asy.animations.model.Heroe;
import com.asy.animations.util.CircleTransform;
import com.squareup.picasso.Picasso;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class HeroeDetailFragment extends Fragment {

    private static final String EXTRA_HEROE = "heroe";

    private Heroe heroe;

    private ImageView ivHeroeAvatar;

    private TextView tvHeroeName;

    private TextView tvHeroeActor;

    public static HeroeDetailFragment newInstance(Heroe heroe) {

        Bundle args = new Bundle();

        args.putSerializable(EXTRA_HEROE, heroe );

        HeroeDetailFragment fragment = new HeroeDetailFragment();

        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroe_detail, container, false);

        ivHeroeAvatar = (ImageView) view .findViewById(R.id.iv_heroe_detail_avatar);
        tvHeroeActor =  (TextView) view .findViewById(R.id.tv_heroe_detail_actor);
        tvHeroeName  = (TextView) view .findViewById(R.id.tv_heroe_detail_name);

        heroe = (Heroe) getArguments().getSerializable(EXTRA_HEROE);

        Picasso.with( getActivity() ).load( heroe.getAvatarUrl() )
                .transform( new CircleTransform() )
                .into(ivHeroeAvatar);

        tvHeroeActor.setText( heroe.getActor() );

        tvHeroeName.setText( heroe.getName() );

        return view;
    }

}
