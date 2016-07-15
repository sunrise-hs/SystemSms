package com.example.hanshu.systemsms.smsinfo;

import android.content.Context;
import android.os.Environment;
import android.util.Xml;
import android.widget.Toast;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by HanShu on 2016/7/15.
 */
public class SmsUtils {
    public static void  backUpSms(List<Smsinfor> list, Context context){
        try {
            XmlSerializer serializer = Xml.newSerializer();
            File file = new File(Environment.getExternalStorageDirectory(), "sms.xml");
            System.out.println(file+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            FileOutputStream os = new FileOutputStream(file);
            serializer.setOutput(os, "utf-8");
            serializer.startDocument("utf-8",true);
            serializer.startTag(null,"smss");
            for(Smsinfor infor : list){
                serializer.startTag(null,"sms");
                serializer.attribute(null,"id",infor.getId()+"");
                serializer.startTag(null,"body");
                serializer.text(infor.getBody());
                serializer.endTag(null,"body");

                serializer.startTag(null,"address");
                serializer.text(infor.getAddress());
                serializer.endTag(null,"address");

                serializer.startTag(null,"type");
                serializer.text(infor.getType()+"");
                serializer.endTag(null,"type");

                serializer.startTag(null,"date");
                serializer.text(infor.getData()+"");
                serializer.endTag(null,"date");
                serializer.endTag(null,"sms");

            }
            serializer.endTag(null,"smss");
            serializer.endDocument();
            os.close();
            Toast.makeText(context,"备份成功",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context,"备份失败",Toast.LENGTH_SHORT).show();
        }
    }

}
