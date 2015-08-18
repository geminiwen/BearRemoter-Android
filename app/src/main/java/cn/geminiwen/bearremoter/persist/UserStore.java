package cn.geminiwen.bearremoter.persist;

import android.content.Context;
import android.content.SharedPreferences;

import cn.geminiwen.bearremoter.model.UserModel;

/**
 * Created by geminiwen on 15/8/18.
 */
public class UserStore {
    private static UserStore sInstance;

    private static final String PREFERENCE_NAME = "bear";
    private static final String KEY_CELL_PHONE = "cellPhone";
    private static final String KEY_NICKNAME = "nickname";
    private static final String KEY_TARGET_CELL_PHONE = "targetCellPhone";

    private Context mContext;
    private SharedPreferences mSharedPreferences;

    public static void initialize(Context context) {
        sInstance = new UserStore(context);
    }

    public synchronized static UserStore getInstance() {
        if (sInstance == null) {
            throw new RuntimeException("You must call initialize first in Application Context");
        }
        return sInstance;
    }

    private UserStore(Context context) {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 序列化
     *
     * @param user
     */
    public void serialize(UserModel user) {
        String cellPhone = user.getCellPhone();
        String nickname = user.getNickname();
        String targetCellPhone = user.getTargetCellPhone();

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(KEY_CELL_PHONE, cellPhone);
        editor.putString(KEY_NICKNAME, nickname);
        editor.putString(KEY_TARGET_CELL_PHONE, targetCellPhone);
    }

    /**
     * 反序列化
     *
     * @return
     */
    public UserModel deserialize() {
        String cellPhone = mSharedPreferences.getString(KEY_CELL_PHONE, null);
        String nickname = mSharedPreferences.getString(KEY_NICKNAME, null);
        String targetCellPhone = mSharedPreferences.getString(KEY_TARGET_CELL_PHONE, null);

        if (cellPhone == null) {
            return null;
        }
        UserModel user = new UserModel(cellPhone, nickname, targetCellPhone);
        return user;
    }

}
