package chen.lion.hilib.view.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import chen.lion.hilib.HiApp;
import chen.lion.hilib.R;

/**
 * 下午12:09
 * by chenxiu
 **/
public class HiPhotoAdapter extends BaseAdapter {

    private ArrayList<String> mPaths;

    private Context mContext;

    public HiPhotoAdapter(ArrayList<String> mPaths, Context mContext) {
        this.mPaths = mPaths;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mPaths.size();
    }

    @Override
    public String getItem(int i) {
        return mPaths.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.item_hi_image,null);
        ImageView image = view.findViewById(R.id.item_image);
        ImageView check = view.findViewById(R.id.item_check);

        HiApp.image.load(mPaths.get(i),image);
        return view;
    }
}
