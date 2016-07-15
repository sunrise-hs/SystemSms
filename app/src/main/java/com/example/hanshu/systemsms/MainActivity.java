package com.example.hanshu.systemsms;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hanshu.systemsms.smsinfo.SmsUtils;
import com.example.hanshu.systemsms.smsinfo.Smsinfor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path="content://sms";
                Uri uri=Uri.parse(path);
                ContentResolver resolver=getContentResolver();
                Cursor cursor=resolver.query(uri,new String[]{"address","date","type","body"},null,null,null);
                List<Smsinfor> list=new ArrayList<Smsinfor>();
                while(cursor.moveToNext()){

                    String address=cursor.getString(0);
                    Long data=cursor.getLong(1);
                    int type=cursor.getInt(2);
                    String body=cursor.getString(3);
                    Smsinfor sms=new Smsinfor(data,type,body,address);
                    list.add(sms);
                    System.out.println(address+"###"+data+"###"+type+"###"+body);
                }
                cursor.close();
                SmsUtils.backUpSms(list,MainActivity.this);
            }
        });
    }
}
