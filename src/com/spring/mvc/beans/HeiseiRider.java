package com.spring.mvc.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 使用 Spring 配置 xml 文件的方式来创建 JavaBean 类对象
 */
public class HeiseiRider {
    String mainRider;
    String maleOwner;
    String femaleOwner;
    int count;
    String time;
    String[] sideRiders;
    List<String> enemies;
    Map<String, Integer> enemyNums;
    Properties infos;

    public HeiseiRider() {
        System.out.println("HeiseiRider 类创建成功");
    }

    public HeiseiRider(String mainRider, int count, String time) {
        this.mainRider = mainRider;
        this.count = count;
        this.time = time;
    }

    public String getMainRider() {
        return mainRider;
    }

    public void setMainRider(String mainRider) {
        this.mainRider = mainRider;
    }

    public String getMaleOwner() {
        return maleOwner;
    }

    public void setMaleOwner(String maleOwner) {
        this.maleOwner = maleOwner;
    }

    public String getFemaleOwner() {
        return femaleOwner;
    }

    public void setFemaleOwner(String femaleOwner) {
        this.femaleOwner = femaleOwner;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getSideRiders() {
        return sideRiders;
    }

    public void setSideRiders(String[] sideRiders) {
        this.sideRiders = sideRiders;
    }

    public List<String> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<String> enemies) {
        this.enemies = enemies;
    }

    public Map<String, Integer> getEnemyNums() {
        return enemyNums;
    }

    public void setEnemyNums(Map<String, Integer> enemyNums) {
        this.enemyNums = enemyNums;
    }

    public Properties getInfos() {
        return infos;
    }

    /**
     * 生命周期方法 初始化：在实例化 bean 时，立即调用该方法
     * 在配置文件中，使用 init-method 属性指定该方法
     * 也可以通过实现接口来完成初始化：org.springframework.beans.factory.InitializingBean
     *                    覆写方法：void afterPropertiesSet() throws Exception;
     */
    public void init(){

    }

    public void setInfos(Properties infos) {
        this.infos = infos;
    }

    public void love(){
        System.out.println(maleOwner + " likes " + femaleOwner);
    }

    public void play(){
        System.out.println(time + ", Kamen Rider " + mainRider + " plays. There are " + count + " riders");
    }

    /**
     * 生命周期方法 移除：从容器中移除 bean 之后，会调用该方法
     * 在配置文件中，使用 destroy-method 属性指定该方法
     * 也可以通过实现接口来完成销毁：org.springframework.beans.factory.DisposableBean
     *                  覆写方法：void destroy() throws Exception;
     */
    public void destroy(){

    }

}
