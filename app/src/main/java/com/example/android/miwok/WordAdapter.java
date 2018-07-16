package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    /**
     * We can also create a ViewHolder and set it as a tag to recycled view in order to cache the view and do not call findBy*
     */
    private static class ViewHolder {
        TextView name1;
        TextView name2;
    }

    WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects) {
        super(context, 0, objects);
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
            listItemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) listItemView.getTag();
        }

        Word currentWord = getItem(position);
        viewHolder.name1.setText(currentWord.getName1());
        viewHolder.name2.setText(currentWord.getName2());

        return listItemView;
    }


}
