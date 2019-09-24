package com.example.favoriteapp.model;

import android.os.Parcel;
import android.os.Parcelable;




public class MoviesModel implements Parcelable {





    private String title;



    private String date;


    private String description;

    private String img;


    private String lang;






    public String getImg() {
        return img;
    }


    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getLang() {
        return lang;
    }



    public MoviesModel( String title, String img, String date, String description, String lang) {

        this.title = title;
        this.date = date;
        this.description = description;
        this.img = img;
        this.lang = lang;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.description);
        dest.writeString(this.img);
        dest.writeString(this.lang);


    }

    protected MoviesModel(Parcel in) {

        this.title = in.readString();
        this.date = in.readString();
        this.description = in.readString();
        this.img = in.readString();
        this.lang = in.readString();



    }


    public static final Creator<MoviesModel> CREATOR = new Creator<MoviesModel>() {
        @Override
        public MoviesModel createFromParcel(Parcel source) {
            return new MoviesModel(source);
        }

        @Override
        public MoviesModel[] newArray(int size) {
            return new MoviesModel[size];
        }
    };
}
