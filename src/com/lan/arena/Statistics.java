package com.lan.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {
        //Player集合并指定初始大小
        List<Player> list = new ArrayList<>(Constant.PLAYER);
//        用LinkedList更慢
//        List<Player> list=new LinkedList<>();
        //添加Player
        for (int i = 0; i < Constant.PLAYER; i++) {
            list.add(new Player());
        }
        //开始模拟游戏
        int size = list.size();
        while (size > 1) {
            Random r = new Random();
            int i = r.nextInt(size);
            int j = r.nextInt(size);
            //保证i!=j
            while (i == j) j = r.nextInt(size);

//            System.out.println(i+" VS "+j);
            //第一个人win,第二个人lose
            Player player1 = list.get(i);
            Player player2 = list.get(j);
            int win = player1.getWin();
            int lose = player2.getLose();
            player1.setWin(++win);
            player2.setLose(++lose);
            //如果玩家1达到12胜
            if (win == Constant.WIN) {
                list.remove(i);
                CountUtil.setCount(player1);
                //如果玩家1退出,且j>i,j-1
                j -= j > i ? 1 : 0;
            }
            //如果玩家2达到3负
            if (lose == Constant.LOSE) {
                list.remove(j);
                CountUtil.setCount(player2);
            }
            //刷新size
            size = list.size();
        }
        //计算期望
        CountUtil.expectation();
        //打印模拟结果
        CountUtil.showCount();
    }
}

/*
  蒙特·卡罗方法（Monte Carlo method），也称统计模拟方法
  概念:是一种以概率统计理论为指导的一类非常重要的数值计算方法。
       是指使用随机数（或更常见的伪随机数）来解决很多计算问题的方法。与它对应的是确定性算法。

  基本思想:当所求解问题是某种随机事件出现的概率，或者是某个随机变量的期望值时，通过某种“实验”的方法，
           以这种事件出现的频率估计这一随机事件的概率，或者得到这个随机变量的某些数字特征，并将其作为问题的解。

  典型应用:投点求圆周率Pi
           在一个边长为a的正方形内一均匀概率随机投点，该点落在此正方形的内切圆中的概率即为内切圆与正方形的面积比值，
           即：Pi * (a / 2)^2 : a^2 = Pi / 4。
*/

