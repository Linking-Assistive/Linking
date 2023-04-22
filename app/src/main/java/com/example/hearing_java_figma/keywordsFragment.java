package com.example.hearing_java_figma;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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

import com.example.hearing_java_figma.PO.Keyword;
import com.example.hearing_java_figma.ObjectListContent.KeywordsContent;
import com.example.hearing_java_figma.VM.KeywordViewModel;
import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.dialog.DialogAddKeyword;
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

    private List<Keyword> mItems;

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

            keywordViewModel = new ViewModelProvider(this).get(KeywordViewModel.class);
            List<Keyword> keywords = new ArrayList<>();
            adapter = new MykeywordsRecyclerViewAdapter(keywords, keywordViewModel);
            recyclerView.setAdapter(adapter);

            keywordViewModel.getAllLiveData().observe(getViewLifecycleOwner(), new Observer<List<Keyword>>() {
                @Override
                public void onChanged(List<Keyword> keyword) {
                    adapter.setList(keyword);
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
            builder.setMessage("Please input");
            builder.create().show();
        }
    }
}