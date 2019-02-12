package com.example.fragactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.MessageReadListener {
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_con) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().add(R.id.fragment_con, new MessageFragment(), null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void ReadListenerMessage(String message) {
        TextView textView = findViewById(R.id.set_text);
        textView.setText(message);

    }
}
