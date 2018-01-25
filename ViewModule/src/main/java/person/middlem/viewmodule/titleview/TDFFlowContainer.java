/************************* 版权声明 **********************************
 * 版权所有：Copyright (c) 2008, 2013 张向华
 *
 * 工程名称：	rest
 * 创建者：	Administrator 创建日期： 2013-7-25
 * 创建记录：	创建类结构。
 *
 * ************************* 变更记录 ********************************
 * 修改者： 
 * 修改日期：
 * 修改记录：
 *
 * 
 * ......************************* To Do List*****************************
 * 
 *
 * Suberversion 信息
 * ID:			$Id$
 * 源代码URL：	$HeadURL$
 * 最后修改者：	$LastChangedBy$
 * 最后修改日期：	$LastChangedDate$
 * 最新版本：		$LastChangedRevision$
 **/

package person.middlem.viewmodule.titleview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


/***********************************************
 * <P> 自动换行的容器  可以动态的添加view  根据view可以自动换行的容器  可设置margin
 * <P>         可通过this.addView(view) 添加
 * <P> Author: gongtong
 * <P> Date: 2017-06-02 下午6:08
 * <P> Copyright  2008 二维火科技
 ***********************************************/
public class TDFFlowContainer extends ViewGroup {

	private final static String TAG = "HVBox";
	   
    private int VIEW_MARGIN = 2;
   
    private int clientWidth=0;
    public TDFFlowContainer(Context context) {
   
        super(context); 
   
    } 
    
    public TDFFlowContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
   
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { 
    	clientWidth = MeasureSpec.getSize(widthMeasureSpec);
        int row = 0;
        int lengthX = 0;
        int lengthY = 0;
        for (int index = 0; index < getChildCount(); index++) { 
            View child = getChildAt(index);
            if(child.getVisibility()== View.GONE){
            	continue;
            }
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            int width = child.getMeasuredWidth(); 
            int height = child.getMeasuredHeight(); 
     	   
            lengthX += width + VIEW_MARGIN; 
            lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height ; 
            if ((lengthX+VIEW_MARGIN) > clientWidth) { 
                lengthX = width + VIEW_MARGIN ; 
                row++; 
                lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height; 
            } 
        } 
        lengthY=lengthY+VIEW_MARGIN;
		// 设置容器所需的宽度和高度
		setMeasuredDimension(clientWidth, lengthY);
    } 
   
    @Override
    protected void onLayout(boolean arg0, int left, int top, int right, int bottom) { 
        int count = getChildCount(); 
        int row = 0;
        top=VIEW_MARGIN;
        int lengthX = left;
        int lengthY = 0;
        for (int i = 0; i < count; i++) { 
            View child = this.getChildAt(i);
            if(child.getVisibility()== View.GONE){
            	continue;
            }
            int width = child.getMeasuredWidth(); 
            int height = child.getMeasuredHeight(); 
   
            lengthX += width + VIEW_MARGIN; 
            lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height 
                    + top; 
            if ((lengthX+VIEW_MARGIN) > right) { 
                lengthX = width + VIEW_MARGIN + left; 
                row++; 
                lengthY = row * (height + VIEW_MARGIN) + VIEW_MARGIN + height 
                        + top; 
            } 
            child.layout(lengthX - width, lengthY - height, lengthX, lengthY); 
        } 
    }

    public void setViewMargin(int margin){
        this.VIEW_MARGIN = margin;
    }
}
