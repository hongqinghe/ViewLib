package person.middlem.viewmodule.tabview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import person.middlem.viewmodule.R;

/**
 * 可选中textView  选中后切换颜色
 */
@SuppressLint("NewApi")
public class ToggleTextView extends CompoundButton {
    private CharSequence mTextOn;
    private CharSequence mTextOff;

    public ToggleTextView(Context context) {
        super(context);
        initView(context, null, android.R.attr.checkboxStyle, 0);
    }

    public ToggleTextView(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.checkboxStyle);
        /**
         *这里传入checkboxStyle，使其有checkbox属性,以便作选中效果
         */
        initView(context, attrs, android.R.attr.checkboxStyle, 0);
    }

    public ToggleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
        initView(context, attrs, defStyleAttr, 0);
    }

    public ToggleTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs, defStyleAttr, defStyleRes);
    }

    /**
     * @return void
     * @Description: 初始化
     * @author malong
     * @date Sep 11, 201510:33:50 AM
     */
    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ToggleTextView, defStyleAttr, defStyleRes);
        mTextOn = a.getText(R.styleable.ToggleTextView_android_textOn);
        mTextOff = a.getText(R.styleable.ToggleTextView_android_textOff);
        syncTextState();
        a.recycle();
    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        syncTextState();
    }

    private void syncTextState() {
        boolean checked = isChecked();
        if (checked && mTextOn != null) {
            setText(mTextOn);
        } else if (!checked && mTextOff != null) {
            setText(mTextOff);
        }
    }

    /**
     * Returns the text for when the ToggleTextView is in the checked state.
     *
     * @return The text.
     */
    public CharSequence getTextOn() {
        return mTextOn;
    }

    /**
     * Sets the text for when the ToggleTextView is in the checked state.
     *
     * @param textOn The text.
     */
    public void setTextOn(CharSequence textOn) {
        mTextOn = textOn;
        if (isChecked()) {
            setText(textOn);
        }
    }

    /**
     * Returns the text for when the ToggleTextView is not in the checked state.
     *
     * @return The text.
     */
    public CharSequence getTextOff() {
        return mTextOff;
    }

    /**
     * Sets the text for when the ToggleTextView is not in the checked state.
     *
     * @param textOff The text.
     */
    public void setTextOff(CharSequence textOff) {
        mTextOff = textOff;
        if (!isChecked()) {
            setText(textOff);
        }
    }

    @Override
    public CharSequence getAccessibilityClassName() {
        return ToggleTextView.class.getName();
    }
}


