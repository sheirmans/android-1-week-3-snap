package com.ucsdextandroid1.snapapp.stories;

import android.content.Context;
import android.view.ViewGroup;

import com.ucsdextandroid1.snapapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 2019-04-20
 */
public class StoriesAdapter extends RecyclerView.Adapter {

    private List<StoriesListItem> items = new ArrayList<>();

    public void setItems(Context context, List<Story> stories) {
        items.clear();

        //TODO add title item, using context.getString(R.string.stories)) to get the title
        items.add(new StoriesListItem(context.getString(R.string.stories)));

        //TODO add all of the story items to the list
        for (Story story : stories) {  //loop thru story of our list
            items.add(new StoriesListItem(story));
        }

        //TODO let the adapter know that  the data has changed
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //TODO return the correct view holder for each viewType
        return StoryCardViewHolder.inflate(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //TODO bind the title or the story to the correct view holder

        if(holder instanceof StoryCardViewHolder)
            ((StoryCardViewHolder) holder).bind(items.get(position).getStory());
        else if (holder instanceof StoriesSectionTitleViewHolder)
            ((StoriesSectionTitleViewHolder) holder).bind(items.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        // TODO return the correct item count
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        //TODO return the correct view type
        //items.get  then switch
        return 0;
    }

    //TODO add a method that returns the correct span for each item type.

    //TODO add a custom interface called Callback that extends the click listener defined on the StoriesCardViewHolder

    private class StoriesListItem {

        public static final int TYPE_TITLE = 1;
        public static final int TYPE_STORY = 2;

        private String title;
        private Story story;
        private int type;

        public StoriesListItem(String title) {
            this.title = title;
            this.story = null;
            this.type = TYPE_TITLE;
        }

        public StoriesListItem(Story story) {
            this.title = null;
            this.story = story;
            this.type = TYPE_STORY;
        }

        public int getType() {
            return type;
        }

        public Story getStory() {
            return story;
        }

        public String getTitle() {
            return title;
        }
    }

}
