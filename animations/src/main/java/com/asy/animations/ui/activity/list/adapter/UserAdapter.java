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

package com.asy.animations.ui.activity.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asy.animations.R;
import com.asy.animations.model.User;
import com.asy.animations.ui.activity.list.listener.OnUserClickListener;
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
public final class UserAdapter extends RecyclerView.Adapter<UserAdapter.Holder>{

    private List<User> mUserLists;

    private OnUserClickListener mListener;

    public UserAdapter(OnUserClickListener listener) {
        mUserLists = new ArrayList<>();
        mListener = listener;
    }

    public void setUserLists(List<User> userLists) {
        this.mUserLists = userLists;
    }

    @Override
    public int getItemCount() {
        return mUserLists.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.list_item_user,null);

        Holder holder = new Holder( view );

        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.bind( mUserLists.get(position), mListener );
    }

    public static class Holder extends RecyclerView.ViewHolder{

        private TextView tvUserName;
        private TextView tvUserSurname;
        private TextView tvUserActor;
        private ImageView ivUserAvarar;

        public Holder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById( R.id.tv_user_name);
            tvUserSurname = (TextView) itemView.findViewById( R.id.tv_user_surname);
            tvUserActor = (TextView) itemView.findViewById( R.id.tv_user_actor);
            ivUserAvarar = (ImageView) itemView.findViewById( R.id.iv_user_avatar);
        }

        public void bind(final User user, final OnUserClickListener listener){
            tvUserName.setText(user.getName());
            tvUserSurname.setText(user.getSurname());
            tvUserActor.setText(user.getActor());
            Picasso.with( itemView.getContext() ).load(user.getAvatarUrl()).transform(new CircleTransform()).into(ivUserAvarar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onUserClicked( user, Holder.this );

                }
            });
        }

        public ImageView getIvUserAvarar() {
            return ivUserAvarar;
        }

        public TextView getTvUserActor() {
            return tvUserActor;
        }

        public TextView getTvUserName() {
            return tvUserName;
        }

        public TextView getTvUserSurname() {
            return tvUserSurname;
        }
    }
}
