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

package com.asy.animations.model;

import java.io.Serializable;

/**
 * Class Description.
 *
 * @author asanchezy.
 * @version 1.0.
 * @since 26/4/16.
 */
public class User implements Serializable{

    private String name;

    private String surname;

    private String actor;

    private int avatarUrl;

    private User(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.actor = builder.actor;
        this.avatarUrl = builder.avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(int avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public static class Builder{
        private String name;

        private String surname;

        private String actor;

        private int avatarUrl;

        public Builder setAvatarUrl(int avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setActor(String actor) {
            this.actor = actor;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
