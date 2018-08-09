package chen.lion.hi;



import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import chen.lion.hilib.HiApp;
import chen.lion.hilib.base.HiBaseActivity;
import chen.lion.hilib.http.HiCallback;
import chen.lion.hilib.view.bind.HiView;

public class MainActivity extends HiBaseActivity {

    /**
     * 注解绑定View
     */
    @HiView(R.id.http_test)
    public TextView mHiTextView;

    @HiView(R.id.content)
    public TextView mContentTv;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

        mHiTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HiApp.http.get("https://api.github.com/", new HiCallback.ToString() {
                    @Override
                    public void onFailure(int code, String errorMessage) {

                    }

                    @Override
                    public void onResponse(String response) {

                    }
                });


            }
        });
    }
}
