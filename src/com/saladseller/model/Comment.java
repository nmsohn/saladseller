package com.saladseller.model;

import java.sql.Date;

public class Comment {

        private int id;
        private String name;
        private String pass;
        private String content;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPass() {
            return pass;
        }
        public void setPass(String pass) {
            this.pass = pass;
        }
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
        @Override
        public String toString() {
            return "Comment [id=" + id + ", name=" + name + ", pass=" + pass + ", content=" + content + "]";
        }
}
