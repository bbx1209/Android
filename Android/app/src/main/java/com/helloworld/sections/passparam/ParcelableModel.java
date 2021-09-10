package com.helloworld.Sections.passparam;

import android.app.LauncherActivity;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.helloworld.Sections.passparam.ListItem;

public class ParcelableModel implements Parcelable {
    private String name;

    private int age;

    private boolean isDriver;

    private List<ListItem> list = new ArrayList<>(); // model list  需要 初始化

    private List<String> list2;


    protected ParcelableModel(Parcel in) {
        name = in.readString();
        age = in.readInt();
        isDriver = in.readByte() != 0;
        in.readTypedList(list, ListItem.CREATOR);
        in.readList(list2, String.class.getClassLoader());
    }

    public static final Creator<ParcelableModel> CREATOR = new Creator<ParcelableModel>() {
        @Override
        public ParcelableModel createFromParcel(Parcel in) {
            return new ParcelableModel(in);
        }

        @Override
        public ParcelableModel[] newArray(int size) {
            return new ParcelableModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDriver() {
        return isDriver;
    }

    public void setDriver(boolean driver) {
        isDriver = driver;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeInt(age);
        dest.writeByte((byte)(isDriver ? 1 : 0));
        dest.writeTypedList(list);
        dest.writeStringList(list2);


    }


}
