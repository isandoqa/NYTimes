package com.ishaq.nytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Article implements Parcelable {
    @SerializedName("uri")
    private String uri;

    @SerializedName("url")
    private String url;

    @SerializedName("id")
    private String id;

    @SerializedName("asset_id")
    private String assetId;

    @SerializedName("source")
    private String source;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("updated")
    private String updated;

    @SerializedName("section")
    private String section;

    @SerializedName("subsection")
    private String subsection;

    @SerializedName("nytdsection")
    private String nytdSection;

    @SerializedName("adx_keywords")
    private String adxKeywords;

    @SerializedName("column")
    private String column;


    @SerializedName("byline")
    private String byline;

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String abstractStr;

    @SerializedName("des_facet")
    private ArrayList<String> desFacet;

    @SerializedName("org_facet")
    private ArrayList<String> orgFacet;

    @SerializedName("per_facet")
    private ArrayList<String> perFacet;

    @SerializedName("geo_facet")
    private ArrayList<String> geoFacet;

    @SerializedName("media")
    private ArrayList<ArticleMedia> mediaList;

    @SerializedName("eta_id")
    private String etaId;

    public Article(){}


    protected Article(Parcel in) {
        uri = in.readString();
        url = in.readString();
        id = in.readString();
        assetId = in.readString();
        source = in.readString();
        publishedDate = in.readString();
        updated = in.readString();
        section = in.readString();
        subsection = in.readString();
        nytdSection = in.readString();
        adxKeywords = in.readString();
        column = in.readString();
        byline = in.readString();
        type = in.readString();
        title = in.readString();
        abstractStr = in.readString();
        desFacet = in.createStringArrayList();
        orgFacet = in.createStringArrayList();
        perFacet = in.createStringArrayList();
        geoFacet = in.createStringArrayList();
        mediaList = in.createTypedArrayList(ArticleMedia.CREATOR);
        etaId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uri);
        dest.writeString(url);
        dest.writeString(id);
        dest.writeString(assetId);
        dest.writeString(source);
        dest.writeString(publishedDate);
        dest.writeString(updated);
        dest.writeString(section);
        dest.writeString(subsection);
        dest.writeString(nytdSection);
        dest.writeString(adxKeywords);
        dest.writeString(column);
        dest.writeString(byline);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(abstractStr);
        dest.writeStringList(desFacet);
        dest.writeStringList(orgFacet);
        dest.writeStringList(perFacet);
        dest.writeStringList(geoFacet);
        dest.writeTypedList(mediaList);
        dest.writeString(etaId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getNytdSection() {
        return nytdSection;
    }

    public void setNytdSection(String nytdSection) {
        this.nytdSection = nytdSection;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstractStr() {
        return abstractStr;
    }

    public void setAbstractStr(String abstractStr) {
        this.abstractStr = abstractStr;
    }

    public ArrayList<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(ArrayList<String> desFacet) {
        this.desFacet = desFacet;
    }

    public ArrayList<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(ArrayList<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public ArrayList<String> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(ArrayList<String> perFacet) {
        this.perFacet = perFacet;
    }

    public ArrayList<String> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(ArrayList<String> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public ArrayList<ArticleMedia> getMediaList() {
        return mediaList;
    }

    public void setMediaList(ArrayList<ArticleMedia> mediaList) {
        this.mediaList = mediaList;
    }

    public String getEtaId() {
        return etaId;
    }

    public void setEtaId(String etaId) {
        this.etaId = etaId;
    }

    public String getImageUrlByFormat(String format){
        if(mediaList==null)return null;
        for(ArticleMedia media:mediaList){
            if(media.getType().equals(ArticleMedia.TYPE_IMAGE)&&
                    media.getMediaMetadata()!=null){
                for(MediaMetaData metaData:media.getMediaMetadata()){
                    if(metaData.getFormat().equals(format)){
                        return metaData.getUrl();
                    }
                }
            }
        }
        return null;
    }
}
