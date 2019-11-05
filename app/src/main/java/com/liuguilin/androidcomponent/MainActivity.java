package com.liuguilin.androidcomponent;

import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.liuguilin.basemodule.base.BaseActivity;
import com.liuguilin.basemodule.helper.ARouterHelper;
import com.liuguilin.chatmodule.fragment.ChatFragment;
import com.liuguilin.contactmodule.fragment.ContactFragment;
import com.liuguilin.findmodule.fragment.FindFragment;
import com.liuguilin.memodule.fragment.MeFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Android组件化架构实践
 * https://github.com/alibaba/ARouter
 * https://github.com/JakeWharton/butterknife
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_wechat)
    ImageView ivWechat;
    @BindView(R.id.tv_wechat)
    TextView tvWechat;
    @BindView(R.id.ll_wechat)
    LinearLayout llWechat;

    @BindView(R.id.iv_contact)
    ImageView ivContact;
    @BindView(R.id.tv_contact)
    TextView tvContact;
    @BindView(R.id.ll_contact)
    LinearLayout llContact;

    @BindView(R.id.iv_find)
    ImageView ivFind;
    @BindView(R.id.tv_find)
    TextView tvFind;
    @BindView(R.id.ll_find)
    LinearLayout llFind;

    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.ll_me)
    LinearLayout llMe;

    //聊天
    private ChatFragment mChatFragment;
    private FragmentTransaction mChatTransaction;

    //联系人
    private ContactFragment mContactFragment;
    private FragmentTransaction mContactTransaction;

    //发现
    private FindFragment mFindFragment;
    private FragmentTransaction mFindTransaction;

    //我
    private MeFragment mMeFragment;
    private FragmentTransaction mMeTransaction;

    @Override
    protected int createView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initFragment();
        switchMainTab(0);
    }

    @Override
    protected void initData() {
        tvWechat.setText("微信");
        tvContact.setText("联系人");
        tvFind.setText("发现");
        tvMe.setText("我");
    }

    @Override
    protected void initListener() {

    }

    @OnClick({R.id.ll_wechat,
            R.id.ll_contact,
            R.id.ll_find,
            R.id.ll_me})
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.ll_wechat:
                switchMainTab(0);
                break;
            case R.id.ll_contact:
                switchMainTab(1);
                break;
            case R.id.ll_find:
                switchMainTab(2);
                break;
            case R.id.ll_me:
                switchMainTab(3);
                break;
        }
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {

        if (mChatFragment == null) {
            mChatFragment = new ChatFragment();
            mChatTransaction = getSupportFragmentManager().beginTransaction();
            mChatTransaction.add(R.id.mContentLayout, mChatFragment);
            mChatTransaction.commit();
        }

        if (mContactFragment == null) {
            mContactFragment = new ContactFragment();
            mChatTransaction = getSupportFragmentManager().beginTransaction();
            mChatTransaction.add(R.id.mContentLayout, mContactFragment);
            mChatTransaction.commit();
        }

        if (mFindFragment == null) {
            mFindFragment = new FindFragment();
            mFindTransaction = getSupportFragmentManager().beginTransaction();
            mFindTransaction.add(R.id.mContentLayout, mFindFragment);
            mFindTransaction.commit();
        }

        if (mMeFragment == null) {
            mMeFragment = new MeFragment();
            mMeTransaction = getSupportFragmentManager().beginTransaction();
            mMeTransaction.add(R.id.mContentLayout, mMeFragment);
            mMeTransaction.commit();
        }
    }

    /**
     * 显示Fragment
     *
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            hideAllFragment(transaction);
            transaction.show(fragment);
            transaction.commit();
        }
    }

    /**
     * 隐藏所有的Fragment
     *
     * @param transaction
     */
    private void hideAllFragment(FragmentTransaction transaction) {
        if (mChatFragment != null) {
            transaction.hide(mChatFragment);
        }
        if (mContactFragment != null) {
            transaction.hide(mContactFragment);
        }
        if (mFindFragment != null) {
            transaction.hide(mFindFragment);
        }
        if (mMeFragment != null) {
            transaction.hide(mMeFragment);
        }
    }

    /**
     * 切换Tab
     *
     * @param index
     */
    private void switchMainTab(int index) {
        switch (index) {
            case 0:
                showFragment(mChatFragment);

                ivWechat.setImageResource(R.drawable.img_wechat_p);
                ivContact.setImageResource(R.drawable.img_contact);
                ivFind.setImageResource(R.drawable.img_find);
                ivMe.setImageResource(R.drawable.img_me);

                tvWechat.setTextColor(getResources().getColor(R.color.colorMain));
                tvContact.setTextColor(Color.BLACK);
                tvFind.setTextColor(Color.BLACK);
                tvMe.setTextColor(Color.BLACK);

                setTitleBarName("微信");

                break;
            case 1:
                showFragment(mContactFragment);

                ivWechat.setImageResource(R.drawable.img_wechat);
                ivContact.setImageResource(R.drawable.img_contact_p);
                ivFind.setImageResource(R.drawable.img_find);
                ivMe.setImageResource(R.drawable.img_me);

                tvWechat.setTextColor(Color.BLACK);
                tvContact.setTextColor(getResources().getColor(R.color.colorMain));
                tvFind.setTextColor(Color.BLACK);
                tvMe.setTextColor(Color.BLACK);

                setTitleBarName("联系人");

                break;
            case 2:
                showFragment(mFindFragment);

                ivWechat.setImageResource(R.drawable.img_wechat);
                ivContact.setImageResource(R.drawable.img_contact);
                ivFind.setImageResource(R.drawable.img_find_p);
                ivMe.setImageResource(R.drawable.img_me);

                tvWechat.setTextColor(Color.BLACK);
                tvContact.setTextColor(Color.BLACK);
                tvFind.setTextColor(getResources().getColor(R.color.colorMain));
                tvMe.setTextColor(Color.BLACK);

                setTitleBarName("发现");

                break;
            case 3:
                showFragment(mMeFragment);

                ivWechat.setImageResource(R.drawable.img_wechat);
                ivContact.setImageResource(R.drawable.img_contact);
                ivFind.setImageResource(R.drawable.img_find);
                ivMe.setImageResource(R.drawable.img_me_p);

                tvWechat.setTextColor(Color.BLACK);
                tvContact.setTextColor(Color.BLACK);
                tvFind.setTextColor(Color.BLACK);
                tvMe.setTextColor(getResources().getColor(R.color.colorMain));

                setTitleBarName("我");

                break;
        }
    }

    /**
     * 设置标题名称
     *
     * @param name
     */
    private void setTitleBarName(String name) {
        getSupportActionBar().setTitle(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_chat:
                ARouterHelper.getInstance().build(ARouterHelper.PATH_CHAT_RUN);
                break;
            case R.id.menu_contact:
                ARouterHelper.getInstance().build(ARouterHelper.PATH_CONTACT_RUN);
                break;
            case R.id.menu_find:
                ARouterHelper.getInstance().build(ARouterHelper.PATH_FIND_RUN);
                break;
            case R.id.menu_me:
                ARouterHelper.getInstance().build(ARouterHelper.PATH_ME_RUN);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
