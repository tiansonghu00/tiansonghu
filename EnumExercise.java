package com.tian;

public class EnumExercise {
    public static void main(String[] args) {
        //声明week枚举类，包含周一到周日，用values返回所有枚举数组，并遍历
        Week weeks[] = Week.values();
        System.out.println("所有星期信息如下");
        for (Week week:weeks){
            System.out.println(week);
        }
    }
}
enum Week {
    Monday("星期一"),Tuseday("星期二"),Wednesday("星期三"),
    Thursday("星期四"),Friday("星期五"),Saturday("星期六"),Sunday("星期日");
    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}