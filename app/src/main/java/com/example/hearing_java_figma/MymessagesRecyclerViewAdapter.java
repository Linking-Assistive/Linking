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
            binding.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    KeywordsMenu(view);
                }
            });
            binding.deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setMessage("Are you sure you want to delete it?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //put your code that needed to be executed when okay is clicked
                                    AlertDialog.Builder builderok = new AlertDialog.Builder(view.getContext());
                                    builderok.setMessage("Delete function not yet incomplete");
                                    builderok.create().show();
                                }
                            });
                    builder.setNegativeButton("Cancel",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.create().show();
                }
            });
            mContentView = binding.content;
        }

        private void KeywordsMenu(View view){

            PopupMenu popupmenu = new PopupMenu(view.getContext(), view);
            popupmenu.setGravity(Gravity.LEFT);
            if (mItem.activated) {
                popupmenu.getMenuInflater().inflate(R.menu.keywords_menu, popupmenu.getMenu());
            }
            else{
                popupmenu.getMenuInflater().inflate(R.menu.keywords_deactive_menu, popupmenu.getMenu());
            }
            popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.activate_switch:
                            mItem.activated = false;
                            break;
                        case R.id.deactivate_keyword:
                            mItem.activated = true;
                            break;
                    }
                    return true;
                }
            });
            popupmenu.show();

        }
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}