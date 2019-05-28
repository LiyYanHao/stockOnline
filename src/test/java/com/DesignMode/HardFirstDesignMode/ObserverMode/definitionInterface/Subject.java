package com.DesignMode.HardFirstDesignMode.ObserverMode.definitionInterface;

/**
 * 主题
 * @author lyh on 2019/5/28
 */
public interface Subject {

    void registerObserver(Observer observer);//注册观察者

    void removeRegisterOberver(Observer observer);//移除注册的观察者

    void notifyOberver();//通知注册的观察者
}
