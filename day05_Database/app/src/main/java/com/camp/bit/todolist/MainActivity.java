package com.camp.bit.todolist;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.camp.bit.todolist.beans.Note;
import com.camp.bit.todolist.beans.State;
import com.camp.bit.todolist.db.TodoContract;
import com.camp.bit.todolist.db.TodoDbHelper;
import com.camp.bit.todolist.debug.DebugActivity;
import com.camp.bit.todolist.ui.NoteListAdapter;
import com.camp.bit.todolist.ui.NoteViewHolder;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD = 1002;
    public TodoDbHelper mtodobHelper;
    public SQLiteDatabase sqliteDatabase;
    private RecyclerView recyclerView;
    private NoteListAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mtodobHelper = new TodoDbHelper(MainActivity.this);
        sqliteDatabase = mtodobHelper.getWritableDatabase();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        new Intent(MainActivity.this, NoteActivity.class),
                        REQUEST_CODE_ADD);
            }
        });

        recyclerView = findViewById(R.id.list_todo);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        notesAdapter = new NoteListAdapter(new NoteOperator() {
            @Override
            public void deleteNote(Note note) {
                MainActivity.this.deleteNote(note);
            }

            @Override
            public void updateNote(Note note) {
                MainActivity.this.updateNode(note);
            }
        });
        recyclerView.setAdapter(notesAdapter);

        notesAdapter.refresh(loadNotesFromDatabase());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mtodobHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.action_debug:
                startActivity(new Intent(this, DebugActivity.class));
                return true;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD
                && resultCode == Activity.RESULT_OK) {
            notesAdapter.refresh(loadNotesFromDatabase());
        }
    }
    private List<Note> loadNotesFromDatabase() {
        // TODO 从数据库中查询数据，并转换成 JavaBeans
        if (sqliteDatabase == null){
            return Collections.emptyList();
        }
        List<Note> result = new LinkedList<>();
        Cursor cursor = null;
        try{
//            cursor = sqliteDatabase.query(TodoContract.Notes.TABLE_NAME,
//                    new String[]{TodoContract.Notes.CONTEND,
//                    TodoContract.Notes.DATE,
//                    TodoContract.Notes.STATE},null,null,
//                    null ,null,TodoContract.Notes.DATE+"DESC");
            cursor = sqliteDatabase.rawQuery("select * from todo order by date ",null);
            while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex(TodoContract.Notes._ID));
                String content = cursor.getString(cursor.getColumnIndex(TodoContract.Notes.CONTEND));
                Long dateMs = cursor.getLong(cursor.getColumnIndex(TodoContract.Notes.DATE));
                int intState = cursor.getInt(cursor.getColumnIndex(TodoContract.Notes.STATE));

                Note note = new Note(id);
                note.setContent(content);
                note.setDate(new Date(dateMs));
                note.setState(State.from(intState));

                result.add(note);
            }
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return result;
    }

    private void deleteNote(Note note) {
        sqliteDatabase.execSQL("delete from todo where _id=?",new Object[]{note.id});
        notesAdapter.refresh(loadNotesFromDatabase());
    }

    private void updateNode(Note note) {
//         更新数据
        ContentValues values = new ContentValues();
        int state = note.getState().intValue;
        values.put("state", state);
        String[] args = {String.valueOf(note.id)};
//        sqliteDatabase.update("todo", values, "_id = ?", args);
        sqliteDatabase.execSQL("update todo set state=? where _id=?",new Object[]{state,note.id});
        notesAdapter.refresh(loadNotesFromDatabase());
    }

}
