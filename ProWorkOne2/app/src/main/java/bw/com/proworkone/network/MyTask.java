package bw.com.proworkone.network;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

public class MyTask<T> extends AsyncTask<T,T,String> {
    String mPath;
    Context mContext;
    String mRam;
    private TaskListeners taskListener ;
    View mView;
    //获取接口
    public MyTask setTaskListener(TaskListeners taskListener ){
        this.taskListener = taskListener ;
        return this ;
    }
    public MyTask(String mPath, String mRam) {
        this.mPath=mPath;
        this.mRam=mRam;
    }
    @Override
    protected String doInBackground(T... ts) {
        return HttpUrlUtils.getHttpCon(mPath,mRam);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null) {
            //实现接口内面方法
            taskListener.result(s);
        }
    }
    //定义接口
    public interface TaskListeners{
        void result(String t);
    }


}
