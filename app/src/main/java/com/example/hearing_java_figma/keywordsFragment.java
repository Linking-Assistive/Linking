package com.example.hearing_java_figma;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hearing_java_figma.DB.AppDatabase;
import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.Repository.KeywordRepository;
import com.example.hearing_java_figma.VM.KeywordViewModel;
import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.dialog.DialogAddKeyword;
import com.example.hearing_java_figma.placeholder.PlaceholderContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class keywordsFragment extends Fragment implements DialogAddKeyword.DialogEditListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private List<KeywordTuple> mItems;

    private KeywordViewModel keywordViewModel;

    private MykeywordsRecyclerViewAdapter adapter;

    private AlertDialog.Builder builder;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public keywordsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static keywordsFragment newInstance(int columnCount) {
        keywordsFragment fragment = new keywordsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View main_view = inflater.inflate(R.layout.fragment_keywords_list, container, false);
        View view = main_view.findViewById(R.id.list);

        // Button initial
        FloatingActionButton fab = main_view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAddKeyword newFragment = new DialogAddKeyword();
                newFragment.setListener(keywordsFragment.this);
                newFragment.show(getParentFragmentManager() ,"add_keyword");
                builder = new AlertDialog.Builder(view.getContext());
            }
        });

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            mItems = new ArrayList<>();
            adapter = new MykeywordsRecyclerViewAdapter(mItems);
            recyclerView.setAdapter(adapter);

            keywordViewModel = new ViewModelProvider(this).get(KeywordViewModel.class);
            keywordViewModel.loadKeywordInfoLiveData().observe(getViewLifecycleOwner(), new Observer<List<KeywordTuple>>() {
                @Override
                public void onChanged(List<KeywordTuple> keywordTuples) {
                    adapter.setList(keywordTuples);
                    adapter.notifyDataSetChanged();
                }
            });

        }
        return main_view;
    }

    @Override
    public void onDialogEditClick(String keyName) {
        // Toast.makeText(getContext(), keyName, Toast.LENGTH_SHORT).show();
        if (keyName != null) {
            Keyword keyword = new Keyword(keyName, true);
            keywordViewModel.insertKeyword(keyword);
        }else{
            builder.setMessage("Error");
            builder.create().show();
        }
    }
}