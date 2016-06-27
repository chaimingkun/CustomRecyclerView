package cn.chai.coorditest;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by chai_imac on 16/6/22.
 */
//@CoordinatorLayout.DefaultBehavior(CustomAppBarLayout.CustomeAppBarLayoutBehavior.class)
public class CustomAppBarLayout extends LinearLayout implements NestedScrollingParent, NestedScrollingChild {
    public CustomAppBarLayout(Context context) {
        super(context);
    }

    public CustomAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomAppBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i("CustomAppBarLayout","onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("CustomAppBarLayout","onTouchEvent");
        return super.onTouchEvent(event);
    }

    public class CustomeAppBarLayoutBehavior extends CoordinatorLayout.Behavior<CustomAppBarLayout>{

        public CustomeAppBarLayoutBehavior(){
            super();
        }

        public CustomeAppBarLayoutBehavior(Context context, AttributeSet attrs) {
            super(context,attrs);
        }

        @Override
        public boolean onMeasureChild(CoordinatorLayout parent, CustomAppBarLayout child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
            return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
        }

        @Override
        public boolean onLayoutChild(CoordinatorLayout parent, CustomAppBarLayout child, int layoutDirection) {
            parent.onLayoutChild(child,layoutDirection);
//            return super.onLayoutChild(parent, child, layoutDirection);
            return false;
        }

        @Override
        public boolean onTouchEvent(CoordinatorLayout parent, CustomAppBarLayout child, MotionEvent ev) {
            Log.i("CustomeBehavior","onTouch");
            return super.onTouchEvent(parent, child, ev);
        }

        @Override
        public boolean onDependentViewChanged(CoordinatorLayout parent, CustomAppBarLayout child, View dependency) {
            Log.i("CustomeBehavior","onDependentViewChanged");
            return super.onDependentViewChanged(parent, child, dependency);
        }

        @Override
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, CustomAppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
            Log.i("CustomeBehavior","onNestedScrollAccepted");
            super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        }

        @Override
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, CustomAppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
            Log.i("CustomeBehavior","onStartNestedScroll");
            return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
        }

        @Override
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, CustomAppBarLayout child, View target, int dx, int dy, int[] consumed) {
            Log.i("CustomeBehavior","onNestedPreScroll");
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        }

        @Override
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, CustomAppBarLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
            Log.i("CustomeBehavior","onNestedScroll");
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        }
    }
}
