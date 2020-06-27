package com.ishaq.nytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArticleMedia implements Parcelable {

    public static final String TYPE_IMAGE="image";

    @SerializedName("type")
    private String type;

    @SerializedName("subtype")
    private String subType;

    @SerializedName("caption")
    private String caption;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("approved_for_syndication")
    private int approveForSyndication;

    @SerializedName("media-metadata")
    private ArrayList<MediaMetaData> mediaMetadata;

    public ArticleMedia(){}


    protected ArticleMedia(Parcel in) {
        type = in.readString();
        subType = in.readString();
        caption = in.readString();
        copyright = in.readString();
        approveForSyndication = in.readInt();
        mediaMetadata = in.createTypedArrayList(MediaMetaData.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(subType);
        dest.writeString(caption);
        dest.writeString(copyright);
        dest.writeInt(approveForSyndication);
        dest.writeTypedList(mediaMetadata);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArticleMedia> CREATOR = new Creator<ArticleMedia>() {
        @Override
        public ArticleMedia createFromParcel(Parcel in) {
            return new ArticleMedia(in);
        }

        @Override
        public ArticleMedia[] newArray(int size) {
            return new ArticleMedia[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getApproveForSyndication() {
        return approveForSyndication;
    }

    public void setApproveForSyndication(int approveForSyndication) {
        this.approveForSyndication = approveForSyndication;
    }

    public ArrayList<MediaMetaData> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(ArrayList<MediaMetaData> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    @Override
    public String toString() {
        return "ArticleMedia [copyright = "+copyright+", media-metadata = "+mediaMetadata+
                ", subtype = "+subType+", caption = "+caption+", type = "+
                type+", approved_for_syndication = "+approveForSyndication+"]";
    }
}
