package com.xtt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * Subject：公众号->推送文章
 *
 */
interface IOfficialAccount{
    /**
     * 推送文章
     */
    void notifySubscribers();

    /**
     * 添加订阅
     *
     * @param user
     */
    void addSubscribe(User user);

    /**
     * 取消订阅
     *
     * @param user
     */
    void cancelSubscribe(User user);
}
/**
 * concreteSubject: 具体的某一个公众号
 *             实现公众号接口的三个方法
 */

class ConcreteOfficialAccount implements IOfficialAccount{

    private ArrayList<User> list;
    private String article;

    public ConcreteOfficialAccount() {
        list = new ArrayList<>();
    }

    @Override
    public void notifySubscribers() {
        // 通知所有订阅者
        for (User user : list) {
            user.update(article);
        }
    }

    @Override
    public void addSubscribe(User user) {
        list.add(user);
    }

    @Override
    public void cancelSubscribe(User user) {
        if(!list.isEmpty()){
            list.remove(user);
        }
    }

    /**
     * 推送的文章
     *
     * @param article
     */
    public void pushArticle(String article) {
        this.article = article;
        notifySubscribers();
    }
}

/**
 * Observer: 观察者接口
 * 定义了一个update()方法，当被观察者调用pushArticle(String article)方法时，观察者的update()方法会被回调。
 */
interface IUser{
    /**
     * 接收更新文章
     *
     * @param message
     */
    void update(String message);
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User implements IUser{

    private String name;

    @Override
    public void update(String message) {
        System.out.println(name + "有一个新的推送文章：" + message);
    }
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
        ConcreteOfficialAccount c = new ConcreteOfficialAccount();
        // 两个用户
        User u = new User("张三");
        User u2 = new User("李四");

        // 订阅了c公众号
        c.addSubscribe(u);
        c.addSubscribe(u2);

        // c公众号推送一篇文章
        c.pushArticle("哆啦A梦");

        // 用户u取消订阅
        c.cancelSubscribe(u);

        // c公众号再推送一篇文章
        c.pushArticle("金刚葫芦娃");

        // 打印结果为哪些用户接受到了公众号的文章
    }
}
