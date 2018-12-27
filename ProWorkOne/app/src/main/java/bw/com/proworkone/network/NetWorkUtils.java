package bw.com.proworkone.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public  class NetWorkUtils {

    // 获取网络状态
    public static boolean getNet(Context context) {
        //初始化网络状态管理者
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //网络类型
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfo.isConnected();
    }
}
