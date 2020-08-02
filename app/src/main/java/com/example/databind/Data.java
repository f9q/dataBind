package com.example.databind;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;


/*
//1.修改不自动更新ui版本
public class Data {

    public int      icon;
    public String   key;
    public int      value;

    @Override
    public String toString() {
        return "key = " + key + " value = " + value;
    }
}
*/

/*//2.修改数据动更新ui版本
public class Data {

    public ObservableInt            icon    = new ObservableInt();
    public ObservableField<String>  key     = new ObservableField();
    public ObservableInt            value   = new ObservableInt();

    @Override
    public String toString() {
        return "key = " + key + " value = " + value;
    }
}*/


//3.修改数据动更新ui版本
public class Data extends BaseObservable {

    public int      icon    ;
    public String   key     ;
    public int      value   ;
    public String   test     = "";
    public String   name     = "未命名";

    @Bindable public String getKey() { return key;}
    @Bindable public int getValue() { return value; }
    @Bindable public int getIcon() {
        return icon;
    }
    @Bindable public String getTest(){
        return test;
    }
    @Bindable public String getName(){
        return name;
    }

    public void setKey(String key) {
        this.key = key;
        notifyPropertyChanged(BR.key);
    }

    public void setValue(int value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }
    public void setIcon(int icon) {
        this.icon = icon;
        notifyPropertyChanged(BR.icon);
    }
    public void setTest(String ss){
        this.test = ss;
        notifyPropertyChanged(BR.test);
    }
    public void setName(String ss){
        this.name = ss;
        Log.e("Data","setName , new name = " + ss);
        notifyPropertyChanged(BR.name);
    }
    @Override
    public String toString() {
        return "key = " + key + " value = " + value;
    }
}

