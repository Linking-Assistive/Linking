package com.example.hearing_java_figma;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.hearing_java_figma.ObjectListContent.KeywordsContent;
import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.dialog.DialogAddKeyword;
import com.example.hearing_java_figma.placeholder.MessageContent;
import com.example.hearing_java_figma.placeholder.MessageContent.MessageItem;
import com.example.hearing_java_figma.databinding.FragmentMessagesBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link MessageItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MymessagesRecyclerViewAdapter extends RecyclerView.Adapter<MymessagesRecyclerViewAdapter.ViewHolder> {

    private List<MessageItem> mValues;

    public MymessagesRecyclerViewAdapter(List<MessageItem> items) {
        mValues = items;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentMessagesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        /*holder.mIdView.setText(mValues.get(position).id);*/
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /*public final TextView mIdView;*/
        public final TextView mContentView;
        public MessageItem mItem;

        public ViewHolder(FragmentMessagesBinding binding) {
            super(binding.getRoot());
            /*mIdView = binding.itemNumber;*/
            mContentView = binding.content;
        }


        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}