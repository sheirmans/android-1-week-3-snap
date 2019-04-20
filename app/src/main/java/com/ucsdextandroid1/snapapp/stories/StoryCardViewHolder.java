package com.ucsdextandroid1.snapapp.stories;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ucsdextandroid1.snapapp.R;
import com.ucsdextandroid1.snapapp.chat.ChatItemViewHolder;
import com.ucsdextandroid1.snapapp.util.ColorUtil;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by rjaylward on 2019-04-20
 */
public class StoryCardViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView titleView;
    private TextView subtitleView;

    private Story currentStory;
    private StoryCardClickListener listener;

    //TODO add a static method called inflate() that inflates the layout view_story_card
    public static StoryCardViewHolder inflate(ViewGroup parent) {
        return new StoryCardViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_chat_item, parent, false));
    }

    public StoryCardViewHolder(@NonNull View itemView) {
        super(itemView);
        //TODO find all of the views
        imageView = itemView.findViewById(R.id.vsc_image_view);
        titleView = itemView.findViewById(R.id.vsc_title);
        subtitleView = itemView.findViewById(R.id.vci_subtitle);

        //TODO add a click listener to the itemView that calls the custom click listener

    }

    public void bind(Story story) {
        //TODO set the currentStory
        currentStory = story;

        //TODO load the imageUrl into the imageView using Picasso
        Picasso.get()
                .load(story.getImageUrl())
                .placeholder(new ColorDrawable(ColorUtil.getRandomColor()))
                .into(imageView);

        //TODO set the title and the subtitle
        titleView.setText(story.getTitle());
        subtitleView.setText(story.getSubtitle());
   }

    //TODO add a method to set a StoryCardClickListener to this class

    public interface StoryCardClickListener {
        // TODO add a method to be called when the user clicks the card view
    }

}
