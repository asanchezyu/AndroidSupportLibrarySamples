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

package com.asy.animations.ui.fragment.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asy.animations.R;
import com.asy.animations.model.Heroe;
import com.asy.animations.ui.fragment.list.HeroesListFragment;
import com.asy.animations.ui.fragment.list.listener.OnHeroeClickListener;
import com.asy.animations.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Description.
 *
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.Holder>{

    private List<Heroe> mHeroeList;

    private OnHeroeClickListener listener;

    public HeroesAdapter() {

        mHeroeList = new ArrayList<>();

    }

    public HeroesAdapter(OnHeroeClickListener onHeroeClickListener) {

        listener = onHeroeClickListener;

    }

    public void setHeroeList(List<Heroe> heroeList) {
        this.mHeroeList = heroeList;
    }

    @Override
    public int getItemCount() {
        return mHeroeList.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.list_item_actor, null);
        Holder holder = new Holder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind( mHeroeList.get( position ),listener );
    }

    public static class Holder extends RecyclerView.ViewHolder{

        private TextView tvName;

        private TextView tvActor;

        private ImageView ivAvatar;


        public Holder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_heroe_name);
            tvActor = (TextView)itemView.findViewById(R.id.tv_heroe_actor);
            ivAvatar = (ImageView) itemView.findViewById(R.id.iv_heroe_avatar);

        }

        public void bind(final Heroe heroe, final OnHeroeClickListener listener){
            tvName.setText( heroe.getName());
            tvActor.setText( heroe.getActor() );
            Picasso.with( itemView.getContext() ).load(heroe.getAvatarUrl()).transform(new CircleTransform()).into(ivAvatar);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onHeroeClicked( heroe, Holder.this );
                }
            });
        }

        public ImageView getIvAvatar() {
            return ivAvatar;
        }

        public TextView getTvActor() {
            return tvActor;
        }

        public TextView getTvName() {
            return tvName;
        }
    }

}
