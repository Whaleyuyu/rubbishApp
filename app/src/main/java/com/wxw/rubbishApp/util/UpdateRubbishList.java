package com.wxw.rubbishApp.util;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class UpdateRubbishList{

    public void updateRubbish(Context context) {
        // 访问服务器url
        String urlStr = HttpUtil.BASE_URL + "servlet/UpdateServlet";
        try {
            // 实例化URL对象
            URL url = new URL(urlStr);
            // 打开连接
            URLConnection conn = url.openConnection();
            // 获得输入流
            InputStream in = conn.getInputStream();
            // 实例化DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            // 实例化DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 获得Document
            Document doc = builder.parse(in);
            // 获得节点列表
            NodeList nl = doc.getElementsByTagName("rubbish");
            // 获得访问数据接口ContentResolver
            ContentResolver cr = context.getContentResolver();
            // 访问数据的Uri
            Uri uri1 = Rubbish.CONTENT_URI;
            // 删除本地SQLite数据库中垃圾分类表中的数据
            cr.delete(uri1, null, null);
            Log.i("hi","插入将执行");

            // 循环将数据保存到垃圾分类表
            for (int i = 0; i < nl.getLength(); i++) {
                // 实例化ContentValues
                ContentValues values = new ContentValues();
                // 解析XML文件获得垃圾分类表id
                int id = Integer.parseInt(doc.getElementsByTagName("id")
                        .item(i).getFirstChild().getNodeValue());
                // 名称
                String name = doc.getElementsByTagName("name").item(i)
                        .getFirstChild().getNodeValue();
                // 类型
                String type = doc.getElementsByTagName("type").item(i)
                        .getFirstChild().getNodeValue();

                // 添加到ContenValues对象
                values.put("_id", id);
                values.put("name", name);
                values.put("type", type);
                // 插入到数据库
                cr.insert(uri1, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
