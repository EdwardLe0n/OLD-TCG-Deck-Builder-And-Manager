package com.example.tcgdeckbuilderandmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NewCardActivity extends AppCompatActivity {

    public static final Bundle EXTRA_REPLY = new Bundle();

    private EditText mEditCardName;
    private EditText mEditCardRPSType;
    private EditText mEditCardType;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
        mEditCardName = findViewById(R.id.edit_cName);
        mEditCardRPSType = findViewById(R.id.edit_rpsType);
        mEditCardType = findViewById(R.id.edit_type);

        final Button button = findViewById(R.id.button_save);


        String name = mEditCardName.getText().toString();
        int rpsType = Integer.parseInt(mEditCardRPSType.getText().toString());


        button.setOnClickListener(view -> {

            Intent replyIntent = new Intent();

            if (this.isValid()) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {

                replyIntent.putExtras(EXTRA_REPLY);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    private boolean isValid() {

        if (TextUtils.isEmpty(mEditCardName.getText())) { return false; }

        return true;

    }

}