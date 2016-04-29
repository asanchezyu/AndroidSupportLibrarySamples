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
 * @author asanchezyu@gmail.com.
 * @version 1.0.
 * @since 26/4/16.
 */
public class Heroe implements Serializable{

    private String name;

    private String actor;

    private int avatarUrl;

    private Heroe(Builder builder) {
        this.name = builder.name;
        this.actor = builder.actor;
        this.avatarUrl = builder.avatarUrl;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(int avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{

        private String name;

        private String actor;

        private int avatarUrl;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setActor(String actor) {
            this.actor = actor;
            return this;
        }

        public Builder setAvatarUrl(int avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public Heroe build(){
            return new Heroe(this);
        }
    }

}
