package com.wxw.rubbishApp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Window;

import com.wxw.rubbishApp.util.HttpUtil;
import com.wxw.rubbishApp.util.Rubbish;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WelcomeActivity extends Activity {
    private boolean isFirst = false;//是否第一次打开App

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
//        无标题显示
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);
       /* if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/
        initData();
    }

    private void initData() {
//        指定所指向类名
        SharedPreferences sp = getSharedPreferences("WelcomeActivity", 0);
        isFirst = sp.getBoolean("isFirst",true);
        updateRubbish();
        //判断是否第一次打开App,是的话跳转到引导页，否则跳转到主页
        if (isFirst) {
            handler.postDelayed(new Runnable() {
                public void run() {
                    gotoStartActivity();
                }
            }, 500);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isFirst",true);
            editor.commit();
        } else {
//            延迟0.5秒执行
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gotoMainActivity();
                }
            }, 500);
        }
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void gotoStartActivity() {
        Intent intent = new Intent(WelcomeActivity.this, StartActivity.class);
        startActivity(intent);
        finish();
    }

    private void updateRubbish() {
        // 访问服务器url
        //TODO 这里声明为final了
        final String urlStr = HttpUtil.BASE_URL + "servlet/UpdateServlet";
        // TODO Android 4.0 之后不能在主线程中请求HTTP请求
        new Thread(new Runnable(){
            @Override
            public void run() {
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
                    ContentResolver cr = getContentResolver();
                    // 访问数据的Uri
                    Uri uri1 = Rubbish.CONTENT_URI;
                    // 删除本地SQLite数据库中菜谱表中的数据
                    cr.delete(uri1, null, null);

                    // 循环将数据保存到菜谱表
                    for (int i = 0; i < nl.getLength(); i++) {
                        // 实例化ContentValues
                        ContentValues values = new ContentValues();
                        // 解析XML文件获得菜单id
                        int id = Integer.parseInt(doc.getElementsByTagName("id")
                                .item(i).getFirstChild().getNodeValue());
                        // 名称
                        String name = doc.getElementsByTagName("name").item(i)
                                .getFirstChild().getNodeValue();
                        // 价格
                        int type = Integer.parseInt(doc.getElementsByTagName("type")
                                .item(i).getFirstChild().getNodeValue());
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
        }).start();


    }
}
