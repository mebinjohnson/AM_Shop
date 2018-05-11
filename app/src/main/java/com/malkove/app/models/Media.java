package com.malkove.app.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Media implements Serializable {

    private final static long serialVersionUID = -7493478798661436015L;
    public int id;
    public String date;
    public String dateGmt;
    public Guid guid;
    public String modified;
    public String modifiedGmt;
    public String slug;
    public String status;
    public String type;
    public String link;
    public Title title;
    public String template;
    public int post;
    @SerializedName("source_url")
    public String sourceUrl;
    public Links links;

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