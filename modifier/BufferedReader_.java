package com.tian.modifier;

public class BufferedReader_ extends Reader_{
    //做成包装流
    private Reader_ reader_;//属性是Reader_类型

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }
    //让方法更加灵活，多次读取文件
    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }
    //扩展readString,批量处理字符串数据
    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }
}
