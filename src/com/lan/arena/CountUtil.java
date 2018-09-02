package com.lan.arena;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountUtil {
    //定义记录结果和结果计数的map
    private static Map<String, Integer> map = new HashMap<>();

    //玩家结束游戏时记录战绩
    public static void setCount(Player player) {
        String key = player.getWin() + "-" + player.getLose();
        Integer count = map.get(key);
        map.put(key, (count == null) ? 1 : ++count);
    }

    //竞技场结束时展示统计数据
    public static void showCount() {
        Set<String> keySet = map.keySet();
        System.out.println("战绩----计数-----概率");
        for (String key : keySet) {
            //注意这里的计算类型
            double probability = map.get(key) * 1.0 / Constant.PLAYER;
            // - :设置左对齐, .3f:设置保留3位小数(如果要保留有效数字,则不用格式输出的方法), %%:添加%
            System.out.printf("%-4s----%-5d----%.3f%%%n", key, map.get(key), 100 * probability);
            //两种格式输出等价,printf()就是调format()
//            System.out.format("%-4s----%-5d----%f%%%n",key,map.get(key),100*probability);
        }
       /* Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> enrty = iterator.next();
            double probability = enrty.getValue() * 1.0 / Constant.PLAYER;
            System.out.printf("%-4s----%-5d----%.3f%%%n", enrty.getKey(), enrty.getValue(), 100 * probability);
        }*/
    }

    //求玩家胜场数的数学期望
    public static void expectation() {
        Set<String> keySet = map.keySet();
        int sum = 0;
        for (String key : keySet) {
            //key的前两个字符表示胜场数,若个位数,去掉-
            String win = key.substring(0, 2).replace("-", "");
            sum += Integer.parseInt(win) * map.get(key);
        }
        //计数人数是Constant.PLAYER或-1人
        double expect = sum * 1.0 / Constant.PLAYER;
        System.out.println("玩家胜场数的数学期望为:" + expect);
    }


}
