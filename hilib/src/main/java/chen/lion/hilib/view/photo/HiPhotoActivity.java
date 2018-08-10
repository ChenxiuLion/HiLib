package chen.lion.hilib.view.photo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

import chen.lion.hilib.R;
import chen.lion.hilib.base.HiBaseActivity;
import chen.lion.hilib.view.bind.HiView;

/**
 * 上午11:45
 * by chenxiu
 **/
public class HiPhotoActivity extends HiBaseActivity implements HiSerchPhotoThread.OnSerchFinish {

    private ArrayList<String> mFiles = new ArrayList<String>();

    private HiSerchPhotoThread mHiSerchPhotoThread;

    private HiPhotoAdapter mAdapter;

    public GridView mImageGridView;

    @Override
    protected int initLayout() {
        return R.layout.activity_hi_photo;
    }

    @Override
    protected void initData() {
        mImageGridView = findViewById(R.id.photo_grid);
        mHiSerchPhotoThread = new HiSerchPhotoThread(this);
        mHiSerchPhotoThread.run();
        mAdapter = new HiPhotoAdapter(mFiles,this);
        mImageGridView.setAdapter(mAdapter);
    }

    /**
     * 查询系统所有图片地址
     */
    private void serchPhoto() {
        mFiles.clear();

    }

    @Override
    public void onFinish(ArrayList<String> files) {

    }

    @Override
    public void onNext(String path) {
        mFiles.add(path);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mAdapter!=null) {
                    mAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public Context getContext() {
        return this;
    }
}
