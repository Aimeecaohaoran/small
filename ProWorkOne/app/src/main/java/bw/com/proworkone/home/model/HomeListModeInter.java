package bw.com.proworkone.home.model;

import android.util.Log;

import java.util.List;

import bw.com.proworkone.network.HttpUrlUtils;
import bw.com.proworkone.network.MyTask;

//实现接口
public class HomeListModeInter implements IHomeListModelnter{
    ModuleInterface moduleInterface;
    public HomeListModeInter(ModuleInterface moduleInterface) {
        this.moduleInterface=moduleInterface;
    }
    @Override
    public void getDate(final String url) {
        new Runnable(){
            @Override
            public void run() {
                new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        Log.i("", "result:=== "+t);
                        if(t!=null){
                            moduleInterface.LoadSuccess(t);
                        }else {
                            moduleInterface.LoadFailed();
                        }

                    }
                }).execute();
            }
        }.run();
        //获取数据
    }
    public interface ModuleInterface {
        //获取数据状态回调的接口
        void LoadSuccess(String data);

        void LoadFailed();
    }
}
