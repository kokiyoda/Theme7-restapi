package com.theme7.restapi;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PokemonUpdateForm {

    @Min(1)
    int id;

    @NotNull
    @Size(min = 1,max = 6)
    String name;

    @Size(max = 6)
    String nickname;


    public PokemonUpdateForm(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return id;
    }

    public void setNo(int no) {
        this.id = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
