package runa.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * @author lyl
 * @date 2017/12/15.
 */

public class Utils {

    public  static  void toast(Context context) {
        Toast.makeText(context, "123456", Toast.LENGTH_SHORT).show();
    }
}
