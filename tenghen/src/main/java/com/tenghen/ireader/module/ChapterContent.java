package com.tenghen.ireader.module;

import java.io.Serializable;

public class ChapterContent implements Serializable {
    private User_status user_status;
    private Msg msg;
    private Text text;
    public void setUser_status(User_status user_status) {
        this.user_status = user_status;
    }
    public User_status getUser_status() {
        return user_status;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }
    public Msg getMsg() {
        return msg;
    }

    public void setText(Text text) {
        this.text = text;
    }
    public Text getText() {
        return text;
    }

    public static class  Text implements Serializable{
        private String chapter_id;
        private String book_id;
        private String ext_content;
        private String content;
        public void setChapter_id(String chapter_id) {
            this.chapter_id = chapter_id;
        }
        public String getChapter_id() {
            return chapter_id;
        }

        public void setBook_id(String book_id) {
            this.book_id = book_id;
        }
        public String getBook_id() {
            return book_id;
        }

        public void setExt_content(String ext_content) {
            this.ext_content = ext_content;
        }
        public String getExt_content() {
            return ext_content;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

    }

   public static   class Msg  implements Serializable{
        private int costCode;
        private String warning;
        public void setCostCode(int costCode) {
            this.costCode = costCode;
        }
        public int getCostCode() {
            return costCode;
        }

        public void setWarning(String warning) {
            this.warning = warning;
        }
        public String getWarning() {
            return warning;
        }
    }

   public static class User_status implements  Serializable{
        private int is_auto_subscribe;
        private int is_collect;
        public void setIs_auto_subscribe(int is_auto_subscribe) {
            this.is_auto_subscribe = is_auto_subscribe;
        }
        public int getIs_auto_subscribe() {
            return is_auto_subscribe;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }
        public int getIs_collect() {
            return is_collect;
        }
    }
}