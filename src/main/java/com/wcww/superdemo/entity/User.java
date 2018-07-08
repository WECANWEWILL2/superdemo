package com.wcww.superdemo.entity;

import lombok.Data;

@Data
public class User {
    private int uid;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String birth;
    private String homeAddress;
    private int telephone;
    private String recommender;
    private int industryClub;
    private int specialCommittee;
    private int extraInfo;

    public User() {

    }
    public User(
             String username,
             String password,
             String name,
             String sex,
             String birth,
             String homeAddress,
             int telephone,
             String recommender,
             int industryClub,
             int specialCommittee){
        this.username=username;
        this.password=password;
        this.name=name;
        this.sex=sex;
        this.birth=birth ;
        this.homeAddress=homeAddress;
        this.telephone=telephone;
        this.recommender=recommender;
        this.industryClub=industryClub;
        this.specialCommittee=specialCommittee;

    }

}