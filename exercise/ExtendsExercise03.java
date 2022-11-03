package src.main.com.tian.exercise;

public class ExtendsExercise03 {
    public static void main(String[] args) {
        //编写computer类，包含CPU，内存，硬盘等属性，getDetails方法用于返回computer的详细信息
        //编写pc子类，继承computer类，添加特有属性品牌brand
        //编写notepad子类，继承computer类，添加特有属性演示color
        //编写test类，在main方法中创建pc和notepad对象，分别给对象中特有属性赋值
        //以及从computer类继承的属性赋值，并使用方法并打印输出信息
        PC pc = new PC("intel",16,500,"IBM");
        pc.printInfo();
        NotePad notePad = new NotePad("intel",16,500,"白色");
        notePad.printInfo();
    }
}
