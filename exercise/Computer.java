package src.main.com.tian.exercise;

public class Computer {
    //编写computer类，包含CPU，内存，硬盘等属性，getDetails方法用于返回computer的详细信息
    private String cpu;
    private int memory;//内存
    private int disk;//硬盘

    public Computer() {

    }

    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }
    public String getDetails() {
        return "cpu=" + cpu + "memory=" + memory + "disk=" + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}
