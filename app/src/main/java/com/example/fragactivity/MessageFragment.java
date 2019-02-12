package com.example.fragactivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    MessageReadListener ReadListener;
    Button button;
    EditText editText;

    public interface MessageReadListener {
        void ReadListenerMessage(String message);
    }


    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        button = view.findViewById(R.id.send);
        editText = view.findViewById(R.id.get_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = editText.getText().toString();
                ReadListener.ReadListenerMessage(message);

            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            ReadListener = (MessageReadListener) activity;
        } catch (Exception e) {
            Log.d("shamed", "e");
        }
    }
}
