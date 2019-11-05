package com.liuguilin.chatmodule.fragment;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.liuguilin.basemodule.base.BaseFragment;
import com.liuguilin.chatmodule.R;
import com.liuguilin.chatmodule.R2;
import com.liuguilin.chatmodule.adapter.ChatAdapter;
import com.liuguilin.chatmodule.bean.ChatBean;
import com.liuguilin.chatmodule.ui.ChatInfoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * FileName: ChatFragment
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 15:20
 * Email: lgl@szokl.com.cn
 * Profile: 聊天
 */
public class ChatFragment extends BaseFragment implements ChatAdapter.OnItemClickListener {

    @BindView(R2.id.mChatListView)
    RecyclerView mChatListView;
    private ChatAdapter mChatAdapter;
    private List<ChatBean> mList = new ArrayList<>();

    @Override
    protected int createView() {
        return R.layout.fragment_chat;
    }

    @Override
    protected void initView() {
        mChatListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatListView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mChatAdapter = new ChatAdapter(getActivity(), mList);
        mChatAdapter.setOnItemClickListener(this);
        mChatListView.setAdapter(mChatAdapter);
    }

    @Override
    protected void initData() {

        addChatBean("你好");
        addChatBean("我是刘某人");
        addChatBean("很高兴认识你");

        mChatAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener() {

    }

    /**
     * 添加数据
     *
     * @param text
     */
    private void addChatBean(String text) {
        ChatBean chatBean = new ChatBean();
        chatBean.setUserId("1");
        chatBean.setChatText(text);
        chatBean.setUserPhoto(R.drawable.img_user);
        mList.add(chatBean);
    }

    @Override
    public void onClick(int position) {
        //模拟将用户ID传递
        ChatInfoActivity.startChatInfo(getActivity(), mList.get(position).getUserId());
    }
}
