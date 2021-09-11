package com.helloworld.Sections.passparam;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItem implements Parcelable {

    private String title;
    private int count;
    private  boolean isFemail;


    protected ListItem(Parcel in) {
        title = in.readString();
        count = in.readInt();
        isFemail = in.readByte() != 0;
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(count);
        dest.writeByte((byte) (isFemail ? 1 : 0));
    }
}
