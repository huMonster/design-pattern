package com.xtt;

/**
 * 会说话
 */
interface Speak{
    /**
     * 说中文
     */
    void chinese();
}
class SpeakChinese implements Speak {

    @Override
    public void chinese() {
        System.out.println("说中文！");
    }
}
/**
 * 跳舞
 */
interface Dance{
    /**
     * 霹雳舞
     */
    void breaking();
}

abstract class Duck{
    Speak speak;
    Dance dance;

    void gagaga(){
        System.out.println("我是鸭子，嘎嘎嘎嘎！");
    }

    void swim(){
        System.out.println("我也会游泳~");
    }

    abstract void display();
}

class GreenDuck extends Duck{


    @Override
    void display() {
        System.out.println("我是绿色的");
    }
}
class YellowDuck extends Duck{

    public YellowDuck() {
        speak = new SpeakChinese();
    }


    @Override
    void display() {
        System.out.println("我是黄色的");
    }
}

/**
 * @Description StrategyPatter
 * @Author Monster
 * @Date 2021/4/27 22:25
 * @Version 1.0
 */
public class StrategyPatter {

    public static void main(String[] args) {
        GreenDuck greenDuck = new GreenDuck();
        greenDuck.gagaga();
        greenDuck.display();

        YellowDuck yellowDuck = new YellowDuck();
        yellowDuck.gagaga();
        yellowDuck.display();
    }
}
