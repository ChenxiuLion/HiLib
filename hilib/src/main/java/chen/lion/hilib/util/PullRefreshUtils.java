package chen.lion.hilib.util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;

import com.cosfund.library.R;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * 作者 by Chenxiu on 2015/12/29 0029.
 * 描述：
 * 刷新UI工具类
 */
public class PullRefreshUtils {

    private Context mContext;

    private PtrFrameLayout mPtrFrameLayout;

    private MaterialHeader mMaterialHeader;

    private ListView mListView;

    private GridView mGridView;

    private RecyclerView mRecyclerView;

    private onRefreshCallBack mListener;

    private int currentMount;

    public PullRefreshUtils(Context context, PtrFrameLayout ptrFrameLayout){
        this.mContext = context;
        this.mPtrFrameLayout = ptrFrameLayout;
        initView();
    }

    /**
     * 刷新ListView
     *
     * @param ptrFrameLayout
     * @param listView
     */
    public PullRefreshUtils(Context context, PtrFrameLayout ptrFrameLayout, ListView listView) {
        this.mContext = context;
        this.mPtrFrameLayout = ptrFrameLayout;
        this.mListView = listView;
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                            if (!GeneralUtils.isNull(mListener)) {
                                mListener.onLoadMore();
                            }
                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    /**
     * 刷新GridView
     *
     * @param ptrFrameLayout
     * @param gridView
     */
    public PullRefreshUtils(Context context, PtrFrameLayout ptrFrameLayout, GridView gridView) {
        this.mContext = context;
        this.mPtrFrameLayout = ptrFrameLayout;
        this.mGridView = gridView;
        mGridView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        if (view.getLastVisiblePosition() == (view.getCount() - 1)) {
                            if (!GeneralUtils.isNull(mListener)) {
                                mListener.onLoadMore();
                            }
                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    /**
     * 刷新RecyclerView
     *
     * @param ptrFrameLayout
     * @param recyclerView
     */
    public PullRefreshUtils(Context context, PtrFrameLayout ptrFrameLayout, RecyclerView recyclerView) {
        this.mContext = context;
        this.mPtrFrameLayout = ptrFrameLayout;
        this.mRecyclerView = recyclerView;
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                }
                if (currentMount + 1 == mRecyclerView.getAdapter().getItemCount()) {
                    if (mListener != null) {
                        mListener.onLoadMore();
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentMount = ((LinearLayoutManager) mRecyclerView.getLayoutManager()).findLastVisibleItemPosition();
            }
        });
    }

    /**
     * 设置监听
     * @param listener
     */
    public void setOnRefreshCallBack(onRefreshCallBack listener) {
        this.mListener = listener;
    }

    /**
     * 初始化PrtFrameLayout
     */
    public void initView() {
        mPtrFrameLayout.setResistance(1f);// 设置阻尼效果
        mPtrFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);// 移动头部的刷新比例
        mPtrFrameLayout.setPullToRefresh(false);// 释放刷新
        mPtrFrameLayout.setKeepHeaderWhenRefresh(true);
        mMaterialHeader = new MaterialHeader(mContext);
        mMaterialHeader.setPtrFrameLayout(mPtrFrameLayout);
        int[] colors = mContext.getResources().getIntArray(R.array.material_colors);
        mMaterialHeader.setColorSchemeColors(colors);
        mMaterialHeader.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        mMaterialHeader.setPadding(0, 10, 0, 10);
        mPtrFrameLayout.setHeaderView(mMaterialHeader);
        mPtrFrameLayout.addPtrUIHandler(mMaterialHeader);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(mPtrFrameLayout, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                if (!GeneralUtils.isNull(mListener)) {
                    mListener.onPullRefresh();
                }
                mPtrFrameLayout.refreshComplete();
            }
        });
        // 设置自动刷新
        mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.autoRefresh();
            }
        }, 200);
    }

    /**
     * 接口回调
     */
    public interface onRefreshCallBack {
        /**
         * 下拉回调
         */
        void onPullRefresh();

        /**
         * 上拉回调
         */
        void onLoadMore();
    }
}
