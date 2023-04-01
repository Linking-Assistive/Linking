package com.example.hearing_java_figma;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.databinding.FragmentKeywordsBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link com.example.hearing_java_figma.VO.KeywordTuple}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MykeywordsRecyclerViewAdapter extends RecyclerView.Adapter<MykeywordsRecyclerViewAdapter.ViewHolder> {

    private List<KeywordTuple> mValues;

    public MykeywordsRecyclerViewAdapter(List<KeywordTuple> items) {
        mValues = items;
    }

    public void setList(List<KeywordTuple> mValues){
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
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /* public final TextView mIdView;*/
        public final TextView mContentView;
        public KeywordTuple mItem;

        public ViewHolder(FragmentKeywordsBinding binding) {
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