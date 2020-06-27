package com.ishaq.nytimes.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MediaMetaData implements Parcelable {

    public static final String FORMAT_STANDARD_THUMBNAIL="Standard Thumbnail";
    public static final String FORMAT_MEDIUM_THREE_BY_TWO_210="mediumThreeByTwo210";
    public static final String FORMAT_MEDIUM_THREE_BY_TWO_440="mediumThreeByTwo440";

    @SerializedName("format")
    private String format;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private float width;

    @SerializedName("height")
    private float height;

    public MediaMetaData(){}

    protected MediaMetaData(Parcel in) {
        format = in.readString();
        url = in.readString();
        width = in.readFloat();
        height = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(format);
        dest.writeString(url);
        dest.writeFloat(width);
        dest.writeFloat(height);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MediaMetaData> CREATOR = new Creator<MediaMetaData>() {
        @Override
        public MediaMetaData createFromParcel(Parcel in) {
            return new MediaMetaData(in);
        }

        @Override
        public MediaMetaData[] newArray(int size) {
            return new MediaMetaData[size];
        }
    };

    public String getFormat () {
        return format;
    }

    public void setFormat (String format) {
        this.format = format;
    }

    public float getWidth () {
        return width;
    }

    public void setWidth (float width) {
        this.width = width;
    }

    public String getUrl () {
        return url;
    }

    public void setUrl (String url) {
        this.url = url;
    }

    public float getHeight () {
        return height;
    }

    public void setHeight (float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "MediaMetaData [format = "+format+", width = "+width+", url = "+url+", height = "+height+"]";
    }
}