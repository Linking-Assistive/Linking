package com.example.hearing_java_figma.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.hearing_java_figma.MainActivity;
import com.example.hearing_java_figma.R;
import com.example.hearing_java_figma.VM.KeywordViewModel;
import com.example.hearing_java_figma.VO.KeywordTuple;
import com.example.hearing_java_figma.keywordsFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DialogAddKeyword} factory method to
 * create an instance of this fragment.
 */

public class DialogAddKeyword extends DialogFragment {
    private DialogEditListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog

        View view = inflater.inflate(R.layout.dialog_add_keyword, null);
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText text = (EditText)view.findViewById(R.id.new_keyword);
                        if (listener != null) {
                            listener.onDialogEditClick(text.getText().toString());
                            DialogAddKeyword.this.getDialog().dismiss();
                        }
                    }
                })
                .setNegativeButton(R.string.Cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogAddKeyword.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public interface DialogEditListener {
        void onDialogEditClick(String keyName);
    }

    public void setListener(DialogEditListener listener) {
        this.listener = listener;
    }
}