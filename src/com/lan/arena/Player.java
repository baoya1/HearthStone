package com.lan.arena;

public class Player {
    private String playername;//玩家姓名
    private int win;//胜场数
    private int lose;//败场数

    //为win和lose设定初始值
    {
        win = 0;
        lose = 0;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playername='" + playername + '\'' +
                ", win=" + win +
                ", lose=" + lose +
                '}';
    }


}
