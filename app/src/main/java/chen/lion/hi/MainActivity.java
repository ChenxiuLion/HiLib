package chen.lion.hi;



import android.view.View;
import android.widget.TextView;

import chen.lion.hilib.base.HiBaseActivity;
import chen.lion.hilib.view.bind.HiView;

public class MainActivity extends HiBaseActivity {

    /**
     * 注解绑定View
     */
    @HiView(R.id.hiworld)
    public TextView mHiTextView;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mHiTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("绑定成功");
            }
        });
    }
}
