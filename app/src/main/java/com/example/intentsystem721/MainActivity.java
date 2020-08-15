package com.example.intentsystem721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mTextGeo;
    private Button mBtnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextGeo=findViewById(R.id.textGeo);
        mBtnSearch=findViewById(R.id.btnSearch);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String textGeo = mTextGeo.getText().toString();
                char[] strToArray = textGeo.toCharArray();
                Boolean dig=true;
                for(int i = 0; i < strToArray.length; i++) {
                    if(Character.isLetter(strToArray[i])){
                        Uri uri=Uri.parse("geo:?q="+textGeo);
                        intent.setData(uri);
                        dig=false;
                        break;
                    }else {
                        dig=true;
                    }
                }
                if(dig){
                    Uri uri=Uri.parse("geo:"+textGeo);
                    intent.setData(uri);
                }
                startActivity(intent);

//                Intent openLink = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
//                // Проверяeм, может ли система обработать наш Intent
//                if(openLink.resolveActivity(getPackageManager())!=null){
//                    startActivity(openLink);
//                }else{
//                    Log.d("Intent","Browser not found");}
            }
        });
    }
}