package com.liuguilin.chatmodule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liuguilin.chatmodule.R;
import com.liuguilin.chatmodule.R2;
import com.liuguilin.chatmodule.bean.ChatBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * FileName: ChatAdapter
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 16:06
 * Email: lgl@szokl.com.cn
 * Profile: 聊天适配器
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context mContext;
    private List<ChatBean> mList;
    private LayoutInflater inflater;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public ChatAdapter(Context mContext, List<ChatBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.layout_chat_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ChatBean chatBean = mList.get(position);
        holder.iv_photo.setImageResource(chatBean.getUserPhoto());
        holder.tv_text.setText(chatBean.getChatText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.iv_photo)
        CircleImageView iv_photo;
        @BindView(R2.id.tv_text)
        TextView tv_text;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

}
