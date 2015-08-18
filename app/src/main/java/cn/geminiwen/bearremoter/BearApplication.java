package cn.geminiwen.bearremoter;

import android.app.Application;

import cn.geminiwen.bearremoter.persist.UserStore;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by geminiwen on 15/8/18.
 */
public class BearApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UserStore.initialize(this);
        JPushInterface.init(this);
    }
}
