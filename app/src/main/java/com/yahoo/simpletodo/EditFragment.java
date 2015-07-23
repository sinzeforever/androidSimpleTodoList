package com.yahoo.simpletodo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sinze on 7/23/15.
 */
public class EditFragment extends DialogFragment {
    TextView editText;
    MainActivity main;
    static EditFragment newInstance(int id, String text, MainActivity main) {
        EditFragment fragment = new EditFragment();
        fragment.main = main;
        Bundle args = new Bundle();
        args.putInt("id", id);
        args.putString("text", text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.edit_fragment, container, false);
        editText = (TextView) v.findViewById(R.id.editText);
        editText.setText(getArguments().getString("text"));
        Button confirmButton = (Button) v.findViewById(R.id.confirm_button);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmEdit();
            }
        });
        Button cancelButton = (Button) v.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelEdit();
            }
        });
        
        return v;
    }

    public void confirmEdit() {
        int index = getArguments().getInt("id");
        DataManager.dataManager.items.set(index, editText.getText().toString());
        DataManager.dataManager.daoWriteItems();
        Util.hideKeyBoard(this.main);
        this.dismiss();
    }

    public void cancelEdit () {
        this.dismiss();
    }
}
