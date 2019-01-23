package com.camp.bit.todolist.db;

import android.provider.BaseColumns;

import com.camp.bit.todolist.beans.Note;

import java.util.Date;

/**
 * Created on 2019/1/22.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public final class TodoContract {

    // TODO 定义表结构和 SQL 语句常量

    private TodoContract() {
    }

    public static class Notes implements BaseColumns{
        public static final String TABLE_NAME = "todo";
        public static final String DATE = "date";
        public static final String STATE = "state";
        public static final String CONTEND = "content";


    }

}
