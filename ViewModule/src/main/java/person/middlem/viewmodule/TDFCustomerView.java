//package person.middlem.viewmodule;
//
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.graphics.PixelFormat;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//
//import middlem.person.utilsmodule.SystemUtils;
//
//
///***********************************************
// * <P> 在线客服组件
// *        使用方式 ：  (在onResume方法中使用)getInstance(this)   获取该空件
// *                    直接调用show方法(默认 显示在左中部)
// *                    设置点击事件的回调.setOnClickListener()
// *                    兼容客服消息推送的小标签,getChildView()可拿到子组件(不为ViewGroup)
// *                    可通过setLocation方法设置客服的位置  左中  左下  右中 右下 默认显示右中
// *                    必须在onStop或onPause 的时候调用dismiss方法 不然造成内存泄露
// * <P> Author: gongtong
// * <P> Date: 2017-07-25 上午9:36
// * <P> Copyright  2008 二维火科技
// ***********************************************/
//public class TDFCustomerView {
//
//    public static final int LOCATION_LEFT_CENTER = 1;
//    public static final int LOCATION_RIGHT_BOTTOM = 2;
//    public static final int LOCATION_LEFT_BOTTOM = 3;
//
//    private static TDFCustomerView mTDFCustomer = null;
//
//    private Context mContext;
//    private WindowManager mWindowManager;
//    private WindowManager.LayoutParams mLayoutParams;
//    private View mViewImpl;
//    private float mLastX = 0;
//    private float mLastY = 0;
//    private int mScreenWidth = 0;
//    private int mScreenHeight = 0;
//    //点击的开始时间和up时间
//    private long startTime;
//    private long endTime;
//    private boolean isClick = false;//是否可点击效果
//    //此view是为了添加小标签
//    private View childView;
//    private boolean isDismiss=true;
//
//    public TDFCustomerView(Context context) {
//        mContext = context;
//        init();
//    }
//
//    private void init() {
//        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
//        mLayoutParams = new WindowManager.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT
//                , ViewGroup.LayoutParams.WRAP_CONTENT
//                , WindowManager.LayoutParams.TYPE_APPLICATION
//                , WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//                , PixelFormat.RGBA_8888
//        );
//        mLayoutParams.gravity = Gravity.END | Gravity.CENTER_VERTICAL;
//        mScreenWidth = mWindowManager.getDefaultDisplay().getWidth();
//        mScreenHeight = mWindowManager.getDefaultDisplay().getHeight();
//    }
//
//    /**
//     * 显示客服组件
//     */
//    public void show() {
//        if (isDismiss&&null==mViewImpl) {
//            mViewImpl = LayoutInflater.from(mContext).inflate(R.layout.custorview, null);
//            childView = mViewImpl.findViewById(R.id.custom_lin);
//        }
//        if (null==mWindowManager){
//            init();
//        }
//        isDismiss=false;
//        mViewImpl.setVisibility(View.VISIBLE);
//        mWindowManager.addView(mViewImpl, mLayoutParams);
//        mHasAdd = true;//  添加了view
//        setListener();
//    }
//
//    public void cancel() {
//        mViewImpl = null;
//        mWindowManager = null;
//    }
//
//    private boolean mHasAdd = false; //window是否有view添加
//
//    private void hide() {
//        if (!mHasAdd) {
//            return;
//        }
//        mViewImpl.setVisibility(View.GONE);
//        mWindowManager.removeViewImmediate(mViewImpl);
//        isDismiss=true;
//        mHasAdd=false;
//    }
//
//    public void dismiss() {
//        hide();
//        childView=null;
//        mViewImpl = null;
//        mContext = null;
//        mLayoutParams = null;
//        mWindowManager = null;
//    }
//    /**
//     * 在调用show方法后 调用该方法
//     *
//     * @param location
//     */
//    public void setLocation(int location) {
//        if (location == LOCATION_LEFT_BOTTOM) {
//
//            /**
//             * 左下
//             */
//            updateChildView(-SystemUtils.getScreenWidth(mContext), SystemUtils.getScreenHeight(mContext) / 2);
//        } else if (location == LOCATION_LEFT_CENTER) {
//            /**
//             * 左中
//             */
//            updateChildView(-SystemUtils.getScreenWidth(mContext), 0);
//
//        } else {
//            /**
//             * 右下
//             */
//            updateChildView(SystemUtils.getScreenWidth(mContext), SystemUtils.getScreenHeight(mContext));
//        }
//    }
//
//    //设置移动事件
//    private TDFCustomerView setListener() {
//        childView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (onClickListener != null)
//                    onClickListener.onViewClickListener(childView);
//            }
//        });
//
//        childView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        mLastX = motionEvent.getRawX();
//                        mLastY = motionEvent.getRawY();
//                        isClick = false;
//                        startTime = System.currentTimeMillis();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        isClick = true;
//                        float deltaX = motionEvent.getRawX() - mLastX;
//                        float deltaY = motionEvent.getRawY() - mLastY;
//                        updateChildView(deltaX, deltaY);
//                        mLastX = motionEvent.getRawX();
//                        mLastY = motionEvent.getRawY();
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        if (mLayoutParams.x > 0
//                                && mLayoutParams.x < mScreenWidth / 2)
//                            animateToSide(mLayoutParams.x, 0);
//                        else if (mLayoutParams.x < mScreenWidth
//                                && mLayoutParams.x >= mScreenWidth / 2)
//                            animateToSide(mLayoutParams.x, mScreenWidth);
//                        endTime = System.currentTimeMillis();
//                        //解决事件 冲突
//                        if ((endTime - startTime) > 0.1 * 1000L) {
//                            isClick = true;
//                        } else
//                            isClick = false;
//                        break;
//                }
//                return isClick;
//            }
//
//        });
//
//        return mTDFCustomer;
//    }
//
//    /**
//     * 得到view  添加客服组件
//     *
//     * @return
//     */
//    public View getChildView() {
//        return childView;
//    }
//
//    private void updateChildView(float deltaX, float deltaY) {
//        mLayoutParams.x = (int) (mLayoutParams.x - deltaX);
//        mLayoutParams.y = (int) (mLayoutParams.y + deltaY);
//        if (mLayoutParams.x < 0) // x 是从最右边开始的
//            mLayoutParams.x = 0;
//        if (mLayoutParams.y < -mScreenHeight / 2) // y 中间开始的
//            mLayoutParams.y = -mScreenHeight / 2;
//        if (mLayoutParams.x > mScreenWidth)
//            mLayoutParams.x = mScreenWidth;
//        if (mLayoutParams.y > mScreenHeight / 2)
//            mLayoutParams.y = mScreenHeight / 2;
//        mWindowManager.updateViewLayout(mViewImpl, mLayoutParams);
//    }
//
//    private void animateToSide(int startX, int targetX) {
//        ValueAnimator mAnimator = ValueAnimator.ofInt(startX, targetX);
//        //2.为目标对象的属性变化设置监听器
//        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // 3.为目标对象的属性设置计算好的属性值
//                int x = (int) animation.getAnimatedValue();
//                mLayoutParams.x = x;
//                mWindowManager.updateViewLayout(mViewImpl, mLayoutParams);
//            }
//        });
//        mAnimator.setDuration(300);
//        mAnimator.start();
//    }
//
//    private OnClickListener onClickListener;
//
//    public void setOnClickListener(OnClickListener onClickListener) {
//        this.onClickListener = onClickListener;
//    }
// public WindowManager getmWindowManager(){
//     return mWindowManager;
// }
//    /**
//     * 组件的监听事件
//     */
//    public interface OnClickListener {
//        void onViewClickListener(View view);
//    }
//}
//
//
