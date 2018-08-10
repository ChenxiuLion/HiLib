package chen.lion.hilib.view.photo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

/**
 * 上午11:49
 * by chenxiu
 **/
public class HiSerchPhotoThread extends Thread {

    private ArrayList<String> mSerchFiles = new ArrayList<String>();

    private OnSerchFinish mOnSerchFinish;

    interface OnSerchFinish{
       void onFinish(ArrayList<String> files);
       void onNext(String path);
       Context getContext();
    }

    public HiSerchPhotoThread(OnSerchFinish onSerchFinish){
        mOnSerchFinish = onSerchFinish;
    }


    @Override
    public void run() {
        Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentResolver mContentResolver = mOnSerchFinish.getContext().getContentResolver();
        Cursor mCursor = mContentResolver.query(mImageUri, null,
                MediaStore.Images.Media.MIME_TYPE + "=? or "
                        + MediaStore.Images.Media.MIME_TYPE + "=?"
                        + " or " + MediaStore.Images.Media.MIME_TYPE
                        + "=?", new String[]{"image/jpeg",
                        "image/png", "image/jpg"},
                MediaStore.Images.Media.DATE_MODIFIED);

        while (mCursor.moveToNext()) {
            String path = mCursor.getString(mCursor
                    .getColumnIndex(MediaStore.Images.Media.DATA));
            mSerchFiles.add(path);

            if(mOnSerchFinish!=null){
                mOnSerchFinish.onNext(path);
            }
        }
        mCursor.close();

        if(mOnSerchFinish!=null){
            mOnSerchFinish.onFinish(mSerchFiles);
        }
    }
}
