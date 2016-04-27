package com.example.zhu2067.modelunnew;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhu2067
 */
public class Conference implements Parcelable {
    // Conference attributes
    String  name = "None";
    String  address = "None";


    // Constructor for Conference
    Conference(String name) {
        this.name = name;
    }
    // Text representation of the class
    public String toString () {
        return name;
    }

    // Parcelable implementation
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
    }
    public static final Parcelable.Creator<Conference> CREATOR
            = new Parcelable.Creator<Conference>() {
        public Conference createFromParcel(Parcel in) {
            return new Conference(in);
        }
        public Conference[] newArray(int size) {
            return new Conference[size];
        }
    };
    private Conference(Parcel in) {
        name = in.readString();
    }

}


