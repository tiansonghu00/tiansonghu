package src.main.com.tian.homework.homework8;

public class Homework08 {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("jack", 20, "牙医", '男', 6000);
        Doctor doctor2 = new Doctor("jack", 20, "牙医", '男', 6000);

        System.out.println(doctor1.equals(doctor2));
    }
}
