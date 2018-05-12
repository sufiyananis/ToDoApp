package com.example.zakiryousuf.todoapp;

/**
 * Created by Zakir Yousuf on 31/03/2018.
 */

public class Tasks {

    private int _id;
    private String _taskname;

    public Tasks(String s) {
        this._taskname=s;
    }

    public Tasks()
    {

    }
  //  public void Tasks(String taskname)
   // {
   //     this._taskname=taskname;
  //  }
    public int get_id()
    {
        return _id;
    }
    public String get_taskname()
    {
        return _taskname;
    }
    public void set_id(int _id)
    {
        this._id = _id;
    }
    public void set_taskname(String _taskname) {
        this._taskname = _taskname;
    }

}
