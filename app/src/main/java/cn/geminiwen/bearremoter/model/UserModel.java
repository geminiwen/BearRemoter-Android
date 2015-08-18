package cn.geminiwen.bearremoter.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by geminiwen on 15/8/18.
 */
public class UserModel extends BaseModel implements Parcelable {
    private String cellPhone;
    private String nickname;
    private String targetCellPhone;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTargetCellPhone() {
        return targetCellPhone;
    }

    public void setTargetCellPhone(String targetCellPhone) {
        this.targetCellPhone = targetCellPhone;
    }

    public UserModel(String cellPhone, String nickname, String targetCellPhone) {
        this.cellPhone = cellPhone;
        this.nickname = nickname;
        this.targetCellPhone = targetCellPhone;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.cellPhone);
        dest.writeString(this.nickname);
        dest.writeString(this.targetCellPhone);
    }

    protected UserModel(Parcel in) {
        this.cellPhone = in.readString();
        this.nickname = in.readString();
        this.targetCellPhone = in.readString();
    }

    public static final Parcelable.Creator<UserModel> CREATOR = new Parcelable.Creator<UserModel>() {
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
