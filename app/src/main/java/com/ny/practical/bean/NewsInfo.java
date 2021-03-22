package com.ny.practical.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Create by liub on 2021/3/15
 * Describe:
 */
public class NewsInfo implements Serializable {
    private String stat;
    private List<NewsList>data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<NewsList> getData() {
        return data;
    }

    public void setData(List<NewsList> data) {
        this.data = data;
    }

    public class NewsList {
        private String title;
        private String date;
        private String author_name;//来源
        private String url;
        private String thumbnail_pic_s;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }

        public void setThumbnail_pic_s(String thumbnail_pic_s) {
            this.thumbnail_pic_s = thumbnail_pic_s;
        }
    }
}
