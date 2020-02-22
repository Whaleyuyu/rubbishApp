package com.wxw.rubbishApp.util;


import android.net.Uri;
import android.provider.BaseColumns;

public final class Rubbish implements BaseColumns{
    // 授权常量
    public static final String AUTHORITY = "com.wxw.rubbishApp.provider.RUBBISH";
    // 访问Uri
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/rubbish");
    // 默认排序常量
    public static final String DEFAULT_SORT_ORDER = "_id DESC";
    // 表字段常量
    public static final String NAME = "name";					// 名称
    public static final String TYPE= "type";	                // 类型
}

