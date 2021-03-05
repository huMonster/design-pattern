package com.xtt;

/**
 * 抽象观察者
 *
 */
interface Observer{
    public void update(String message);
}

/**
 * 具体观察者
 */
class User implements Observer{

    private String name;
    private String message;

    @Override
    public void update(String message) {

    }
}
/**
 * 抽象主题
 * 声明了添加、删除、通知观察者的方法
 */
interface Subject{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
/**
 * @Description 观察者模式：在对象之间定义一对多的依赖，当一个对象状态改变，会通知其他对象收到通知并自动更新
 *                实际运用：springboot启动原理中 应用启动监听器模块（SpringApplicationRunListeners）
 * @Author Monster
 * @Date 2021/3/5 17:45
 * @Version 1.0
 */
public class ObserverPattern {

    /**
     * 观察者模式：4类重要角色
     *  subject（主题）：也叫抽象被观察者，抽象主题角色把所有对观察者对象的引用保存在一个聚集（比如ArrayList对象）里，
     *                  每个主题都可以有任何数量的观察者。抽象主题提供一个接口，可以增加和删除观察者对象
     *  concreteSubject(具体主题)：也叫具体被观察者，将有关状态存入具体观察者对象。
     *                              在具体主题的内部状态改变时，给所有登记过的观察者发出通知。
     *  Observer（抽象观察者）: 为所有具体观察者定义一个接口，在得到主题的通知时更新自己，这个接口叫更新接口。
     *  concreteObserver（具体观察者）: 实现Observer所要求得更新接口，以便使本身的状态与主题的状态相协调
     *
     *  举例：微信公众号服务，不定时发布一些消息，关注公众号就可以收到推送消息，取消关注就收不到推送消息
     * @param args
     */
    public static void main(String[] args) {

    }
}
