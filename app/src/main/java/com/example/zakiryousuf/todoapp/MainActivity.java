package com.example.zakiryousuf.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    MyDatabasHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.EditTextTask);
        textView=(TextView)findViewById(R.id.textviewtask);
        databaseHelper=new MyDatabasHelper(this,null,null,1);
        printdb();
    }
    public void addButtonClicked(View view)
    {
        Tasks tasks=new Tasks(editText.getText().toString());
        databaseHelper.addTasks(tasks);
        printdb();
    }
    public void removeButtonClicked(View view){
        String input=editText.getText().toString();
        databaseHelper.removeTask(input);
        printdb();
    }
    public void printdb(){
        String  dbString =databaseHelper.databaseToString();
        textView.setText(dbString);
    }
}
