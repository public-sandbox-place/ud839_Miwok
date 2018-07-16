package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColor;
    /**
     * We can also create a ViewHolder and set it as a tag to recycled view in order to cache the view and do not call findBy*
     */
    private static class ViewHolder {
        TextView name1;
        TextView name2;
        ImageView img;
    }

    WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects, int color) {
        super(context, 0, objects);
        mColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        ViewHolder viewHolder;
        if (listItemView == null) {
            viewHolder = new ViewHolder();

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

            viewHolder.name1 = (TextView) listItemView.findViewById(R.id.list_item_name);
            viewHolder.name2 = (TextView) listItemView.findViewById(R.id.list_item_sub_name);
            viewHolder.img = (ImageView) listItemView.findViewById(R.id.image);
            listItemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) listItemView.getTag();
        }

        Word currentWord = getItem(position);
        viewHolder.name1.setText(currentWord.getName1());
        viewHolder.name2.setText(currentWord.getName2());

        if (currentWord.hasImage()) {
            viewHolder.img.setImageResource(currentWord.getImageId());
            viewHolder.img.setVisibility(View.VISIBLE);
        } else {
            viewHolder.img.setVisibility(View.GONE);
        }


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColor);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        return listItemView;
    }


}
