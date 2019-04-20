package com.ucsdextandroid1.snapapp.chat;

import android.content.res.ColorStateList;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ucsdextandroid1.snapapp.R;

/**
 * Created by rjaylward on 2019-04-20
 */
public class ChatItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView titleView;
    private TextView subtitleView;
    private TextView emojiView;

    private Chat currentChat;

    private ChatClickListener chatClickListener;

    public static ChatItemViewHolder inflate(ViewGroup parent) {
        return new ChatItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_chat_item, parent, false));
    }

    private ChatItemViewHolder(@NonNull View itemView) {
        super(itemView);
        
        imageView = itemView.findViewById(R.id.vci_image);
        titleView = itemView.findViewById(R.id.vci_title);
        subtitleView = itemView.findViewById(R.id.vci_subtitle);
        emojiView = itemView.findViewById(R.id.vci_emoji);

        //TODO add click listener  -- when click on the view
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ChatItemViewHolder", v.getClass().getSimpleName());
                Log.d("ChatItemViewHolder", "Click detected");
                Log.d("ChatItemViewHolder",currentChat.getFromName());

                chatClickListener.onChatItemClick(currentChat);
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chatClickListener.onChatItemLongClick(currentChat);
                return false;
            }
        });
    }

    public void bind(Chat chat) {
        currentChat = chat;

        if(getAdapterPosition() == 0)
            itemView.setBackgroundResource(R.drawable.card_background);
        else
            itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), android.R.color.white));

        titleView.setText(chat.getFromName());
        imageView.setImageTintList(ColorStateList.valueOf(chat.getColor()));
        emojiView.setText(chat.getEmoji());
        
        switch(chat.getState()) {
            case SENT:
                subtitleView.setText(itemView.getContext().getString(R.string.sent));
                break;
            case RECEIVED:
                subtitleView.setText(itemView.getContext().getString(R.string.received));
                break;
            case OPENED:
                subtitleView.setText(itemView.getContext().getString(R.string.opened));
                break;
        }
    }

    public void setOnChatClickCallback(ChatClickListener listener) {
        chatClickListener = listener;
    }

    public interface ChatClickListener {
        void onChatItemClick(Chat chat);

        void onChatItemLongClick(Chat chat);
    }

}
