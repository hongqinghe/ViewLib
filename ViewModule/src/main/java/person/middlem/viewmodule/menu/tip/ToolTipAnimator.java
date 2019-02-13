package person.middlem.viewmodule.menu.tip;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

/***********************************************
 *
 * <P> desc:   
 * <P> Author: gongTong
 * <P> Date: 2019-01-17 16:27
 ***********************************************/
 
 
public interface ToolTipAnimator {
    /**
     * Object animator for the tooltip view to pop-up.
     * @param view The tooltip view.
     * @param duration Duration for the animator.
     * @return ObjectAnimator
     */
    ObjectAnimator popup(final View view, final long duration);

    /**
     * Object animator for the tooltip view to pop-out/hide.
     * @param view The tooltip view.
     * @param duration Duration for the animator.
     * @param animatorListenerAdapter The animator listener adapter to listen for animation event.
     * @return ObjectAnimator
     */
    ObjectAnimator popout(final View view, final long duration, final AnimatorListenerAdapter animatorListenerAdapter);
}
