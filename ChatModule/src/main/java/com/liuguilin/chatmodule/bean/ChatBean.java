package com.liuguilin.chatmodule.bean;

/**
 * FileName: ChatBean
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 15:41
 * Email: lgl@szokl.com.cn
 * Profile:
 */
public class ChatBean {

    //用户ID
    private String userId;
    //头像
    private int mUserPhoto;
    //文字
    private String chatText;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getUserPhoto() {
        return mUserPhoto;
    }

    public void setUserPhoto(int mUserPhoto) {
        this.mUserPhoto = mUserPhoto;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }
}
