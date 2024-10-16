package com.example.pz_8;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String name;
    private String company;
    private int age;
    private String phone;

    // Конструктор класса User
    public User(String name, String company, int age, String phone) {
        this.name = name;
        this.company = company;
        this.age = age;
        this.phone = phone;
    }

    // Конструктор для создания объекта из Parcel
    protected User(Parcel in) {
        name = in.readString();
        company = in.readString();
        age = in.readInt();
        phone = in.readString();
    }

    // Реализация Creator для Parcelable
    public static final Creator<User> CREATOR = new Creator<User>() {
        // Создание нового объекта User из Parcel
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        // Создание массива объектов User
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    // Описание содержимого (не используется, поэтому 0)
    @Override
    public int describeContents() {
        return 0;
    }

    // Запись полей объекта в Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(company);
        dest.writeInt(age);
        dest.writeString(phone);
    }

    // Геттеры для доступа к приватным полям
    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}
