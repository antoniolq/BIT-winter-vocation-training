package com.example.antonio.day02_basics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antonio.day02_basics.widget.CircleImageView;
import com.example.antonio.day02_basics.xmlparser.Message;
import com.example.antonio.day02_basics.xmlparser.XmlActivity;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private XmlActivity pasrse = new XmlActivity();

    private Context mContext;

    public List<Message> mMessages;

    private OnItemClickListener mlistener;

    public  LinearAdapter(Context context,List<Message> messages,OnItemClickListener listener){
        this.mContext = context;
        mlistener = listener;
        mMessages = messages;

    }
    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.im_list_item,parent,false));
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        System.out.print(mMessages);
        holder.mTitle.setText(mMessages.get(position).getTitle());
        holder.mDes.setText(mMessages.get(position).getHashTag());
        holder.mTime.setText(mMessages.get(position).getTime());
        if (mMessages.get(position).getIcon().hashCode() == 320112901)
            holder.mIcon.setImageResource(R.drawable.session_robot);
        else if(mMessages.get(position).getIcon().hashCode() == -959845929)
            holder.mIcon.setImageResource(R.drawable.icon_micro_game_comment);
        else if(mMessages.get(position).getIcon().hashCode() == 1371940564)
            holder.mIcon.setImageResource(R.drawable.session_system_notice);
        else if(mMessages.get(position).getIcon().hashCode() == -308540453)
            holder.mIcon.setImageResource(R.drawable.session_stranger);
        else
            holder.mIcon.setImageResource(R.drawable.icon_girl);

        if(mMessages.get(position).isOfficial()) {
            int flag = 1;
            holder.mImg.setVisibility(flag);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView mIcon;
        private ImageView mImg;
        private TextView mTitle;
        private TextView mDes;
        private TextView mTime;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.iv_avatar);
            mImg = itemView.findViewById(R.id.robot_notice);
            mTitle = itemView.findViewById(R.id.tv_title);
            mDes = itemView.findViewById(R.id.tv_description);
            mTime = itemView.findViewById(R.id.tv_time);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
