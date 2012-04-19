package com.appspot.lincoln_kids.juststop;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Score {
    /* データストアが内部で管理する主キー */
    @PrimaryKey private String accountId;

    /* データストアに保存するフィールドに、Persistentアノテーションを付与 */
    @Persistent private String nickname;
    @Persistent private Date registerDate;
    @Persistent private double rankValue;

    /* コンストラクタ */
    public Score(String accountId, String nickname, Date registerDate,
            double rankValue) {
        this.accountId = accountId;
        this.nickname = nickname;
        this.registerDate = registerDate;
        this.rankValue = rankValue;
    }

    /* getterとsetter */
    public String getAccountId() { return accountId; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public String getNickname() { return nickname; }
    public double getRankValue() { return rankValue; }
    public void setRankValue(double rankeValue) { this.rankValue = rankeValue; }
    public void setRegisterDate(Date registerDate) { this.registerDate = registerDate; }
    public Date getRegisterDate() { return registerDate; }

    /* 登録データから残り距離を計算して返すヘルパーメソッド */
    public double getLeftLength() {
        Calendar calendar = Calendar.getInstance(TimeZone
                .getTimeZone("Asia/Tokyo"));
        calendar.setTime(registerDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int offset = year * 1000000 + month * 10000;
        return ((int) (rankValue - offset) / 6) / 10D;
    }
}
