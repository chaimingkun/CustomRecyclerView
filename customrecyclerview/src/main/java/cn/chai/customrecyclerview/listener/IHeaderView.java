package cn.chai.customrecyclerview.listener;

/**
 * Created by chai_imac on 16/6/12.
 */
public interface IHeaderView {

    void pullToRefresh();

    void releaseToRefresh();

    void onRefresh();

    void onReset(float distance, float fraction);

    void onPull(float distance, float fraction);
}
