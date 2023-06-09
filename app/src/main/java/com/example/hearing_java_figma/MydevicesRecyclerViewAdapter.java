package com.example.hearing_java_figma;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hearing_java_figma.placeholder.DeviceContent.DeviceItem;
import com.example.hearing_java_figma.databinding.FragmentDevicesBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DeviceItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MydevicesRecyclerViewAdapter extends RecyclerView.Adapter<MydevicesRecyclerViewAdapter.ViewHolder> {

    private final List<DeviceItem> mValues;

    public MydevicesRecyclerViewAdapter(List<DeviceItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentDevicesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

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
        public DeviceItem mItem;

        public ViewHolder(FragmentDevicesBinding binding) {
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