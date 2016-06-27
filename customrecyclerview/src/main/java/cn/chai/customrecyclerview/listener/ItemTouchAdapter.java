package cn.chai.customrecyclerview.listener;

/**
 * Created by chai_imac on 16/6/12.
 */
public interface ItemTouchAdapter {

    void onMove(int fromPosition, int toPosition);

    void onDismiss(int position);
}
