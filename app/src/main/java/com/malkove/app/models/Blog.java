package com.malkove.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Blog implements Serializable {

    private final static long serialVersionUID = 7198873560117048396L;
    private int id;
    private String date;
    private String dateGmt;
    private Guid guid;
    private Guid excerpt;
    private String modified;
    private String modifiedGmt;
    private String slug;
    private String status;
    private int featured_media;
    private String type;
    private String link;
    private Title title;
    private Content content;
    private String format;
    private List<Object> meta = null;
    private List<Integer> categories = null;
    private List<Object> tags = null;
    private Links links;

    @Data
    public class Guid implements Serializable {

        private final static long serialVersionUID = -7088234210944427716L;
        private String rendered;

    }

    @Data

    public class Links implements Serializable {

        private final static long serialVersionUID = -744334807353805685L;
        private List<Self> self = null;
        private List<Collection> collection = null;
        private List<Author> author = null;
        private List<Cury> curies = null;
        @SerializedName("wp:featuredmedia")
        private List<Self> featuredmedia = null;

    }

    @Data
    public class Self implements Serializable {

        private final static long serialVersionUID = 302954342394918853L;
        private String href;
        private String embeddable;

    }

    @Data
    public class Title implements Serializable {

        private final static long serialVersionUID = -7120000386119891703L;
        private String rendered;

    }

    @Data
    public class Author implements Serializable {

        private final static long serialVersionUID = -9058493898021790279L;
        private boolean embeddable;
        private String href;

    }

    @Data
    public class Collection implements Serializable {

        private final static long serialVersionUID = 1429734334515594466L;
        private String href;

    }

    @Data

    public class Content implements Serializable {

        private final static long serialVersionUID = -1037407410604048787L;
        private String rendered;
        private boolean _protected;

    }

    @Data
    public class Cury implements Serializable {

        private final static long serialVersionUID = -7245418084995682005L;
        private String name;
        private String href;
        private boolean templated;

    }

    @Data
    public class Excerpt implements Serializable {

        private final static long serialVersionUID = -6744736244090355530L;
        private String rendered;
        private boolean _protected;

    }
}