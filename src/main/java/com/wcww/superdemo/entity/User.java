package com.wcww.superdemo.entity;

import lombok.Data;

@Data
public class User {
    private int uid;
    private String username;
    private String password;
    private String name;
    private String sex;
    private int birth;
    private String homeAddress;
    private int telephone;
    private String recommender;
    private int industryClub;
    private int specialCommittee;
    private int extraInfo;

    public User() {

    }
    public User(int uid,
             String username,
             String password,
             String name,
             String sex,
             int birth,
             String homeAddress,
             int telephone,
             String recommender,
             int industryClub,
             int specialCommittee,
             int extraInfo){
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
        this.extraInfo=extraInfo;

    }

}