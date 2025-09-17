package com.sergio.springboot4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String iso;
    private String name;
    private String nicename;
    private String iso3;
    private String numcode;
    private String phonecode;

    public void $$_hibernate_setInstanceId(int i) {
        this.id = i;
    }
}
