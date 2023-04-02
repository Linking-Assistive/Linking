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
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.VM.KeywordViewModel;
import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.databinding.FragmentKeywordsBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.example.hearing_java_figma.VO.KeywordTuple}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MykeywordsRecyclerViewAdapter extends RecyclerView.Adapter<MykeywordsRecyclerViewAdapter.ViewHolder> {

    private List<Keyword> mValues;

    private static KeywordViewModel keywordViewModel;

    public MykeywordsRecyclerViewAdapter(List<Keyword> items, KeywordViewModel viewModel) {
        mValues = items;
        keywordViewModel = viewModel;
    }

    public void setList(List<Keyword> mValues){
        this.mValues = mValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentKeywordsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        /*holder.mIdView.setText(mValues.get(position).id);*/
        holder.mContentView.setText(mValues.get(position).getName());
        holder.mSwitch.setChecked(mValues.get(position).isActivated());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        /* public final TextView mIdView;*/
        public final TextView mContentView;
        public Keyword mItem;

        public SwitchMaterial mSwitch;

        public ViewHolder(FragmentKeywordsBinding binding) {
            super(binding.getRoot());
            /*mIdView = binding.itemNumber;*/
            mSwitch = binding.activateSwitch;
            mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.i("debug3", mItem.toString() + b);
                    mItem.setActivated(b);
                    // keywordViewModel.updateKeyword(mItem);
                }
            });
            binding.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    KeywordsMenu(view, mItem);
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
                                    keywordViewModel.deleteKeyword(mItem);
                                    AlertDialog.Builder builderok = new AlertDialog.Builder(view.getContext());
                                    builderok.setMessage("Delete complete");
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
        private void KeywordsMenu(View view, Keyword keyword){

            PopupMenu popupmenu = new PopupMenu(view.getContext(), view);
            popupmenu.setGravity(Gravity.LEFT);
            popupmenu.getMenuInflater().inflate(R.menu.keywords_menu, popupmenu.getMenu());

            popupmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    Log.i("debug1", keyword.toString());
                    switch (menuItem.getItemId()){
                        case R.id.activate_keyword:
                            keyword.setActivated(true);
                            break;
                        case R.id.deactivate_keyword:
                            keyword.setActivated(false);
                            break;
                    }
                    keywordViewModel.updateKeyword(keyword);
                    Log.i("debug2", keyword.toString());
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