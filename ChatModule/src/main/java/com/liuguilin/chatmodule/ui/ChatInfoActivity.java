package com.liuguilin.chatmodule.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.liuguilin.basemodule.base.BaseActivity;
import com.liuguilin.chatmodule.R;
import com.liuguilin.chatmodule.R2;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * FileName: ChatInfoActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 16:22
 * Email: lgl@szokl.com.cn
 * Profile:
 */
public class ChatInfoActivity extends BaseActivity {

    public static final String USER_KEY = "userId";

    public static void startChatInfo(Context mContext, String userId) {
        Intent intent = new Intent(mContext, ChatInfoActivity.class);
        intent.putExtra(USER_KEY, userId);
        mContext.startActivity(intent);
    }

    @BindView(R2.id.iv_photo)
    CircleImageView iv_photo;

    @Override
    protected int createView() {
        return R.layout.activity_chat_info;
    }

    @Override
    protected void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("聊天详情");
    }

    @Override
    protected void initData() {
        String userId = getIntent().getStringExtra(USER_KEY);
        if (!TextUtils.isEmpty(userId)) {
            //加载数据
            iv_photo.setImageResource(R.drawable.img_user);
        }
    }

    @Override
    protected void initListener() {

    }

    @OnClick(R2.id.iv_photo)
    void PhotoClick() {
        Toast.makeText(this, "点击头像", Toast.LENGTH_SHORT).show();
    }
}
