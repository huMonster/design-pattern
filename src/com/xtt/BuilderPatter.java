package com.xtt;


import lombok.*;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 产品角色
 * 套餐：食物 + 饮料
 */
@Data
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class Meal{

    public Meal() {
        System.out.println("初始化！！！");
    }

    private String food;
    private String drink;
}

/**
 * 抽象建造者
 * 组合套餐中需要的食物和饮料
 */
@Getter
abstract class MealBuilder{
    Meal meal = new Meal();
    public abstract void buildFood();
    public abstract void buildDrink();
}

/**
 * 具体建造者 套餐A
 */
class MealA extends MealBuilder{

    @Override
    public void buildFood() {
        meal.setFood("炸鸡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("可乐");
    }
}

/**
 * 具体的建造者：套餐B
 */
class MealB extends MealBuilder{

    @Override
    public void buildFood() {
        meal.setFood("汉堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("雪碧");
    }
}

/**
 * 指挥官： 利用建造者将各个部分的建造走一条流水线
 * 如果没有指挥官，客户端构建一个Neal对象时需要自己明白构建过程
 */
class Director{
    private MealBuilder mealBuilder;

    public Meal constructor(){
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }

    public Director(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }
}

/**
 * @Description 建造者模式（又名 生成器模式）：是一种对象构建模式
 *                 Lombok中的@Builder注解是builder patter的一个变种
 * @Author Monster
 * @Date 2021/3/4 15:03
 * @Version 1.0
 */
public class BuilderPatter {
    /**
     * 建造者模式：4类重要角色
     * Product(产品角色): 一个具体的产品对象
     * Builder(抽象建造者): 是一个抽象类，创建一个Product对象的各个部件指定的抽象接口
     * ConcreteBuilder(具体的建造者)：实现Builder类，构建和装配各个部件
     * Director(指挥者): 构建一个builder抽象接口。主要用于创建一个复杂的对象，
     *                  作用：1、隔离了客户与对象的生产过程
     *                       2、负责控制产品的生产过程
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        // 在KFC，我需要套餐A
        MealA mealA = new MealA();
        // 点餐台收到我的菜单
        Director director = new Director(mealA);
        // 将菜单交给后厨，后厨根据菜单的内容做好，并转交前台
        Meal meal = director.constructor();
        // 取餐
        System.out.println(meal.toString());

    }
}
