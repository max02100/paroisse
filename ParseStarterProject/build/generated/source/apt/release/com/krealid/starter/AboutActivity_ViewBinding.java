// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flipboard.bottomsheet.BottomSheetLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutActivity_ViewBinding<T extends AboutActivity> implements Unbinder {
  protected T target;

  private View view2131558540;

  @UiThread
  public AboutActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.bottomSheetLayout = Utils.findRequiredViewAsType(source, R.id.bottomsheet, "field 'bottomSheetLayout'", BottomSheetLayout.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.anim_toolbar, "field 'mToolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.floating_action_button, "method 'onClickFAB'");
    view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickFAB();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bottomSheetLayout = null;
    target.mToolbar = null;

    view2131558540.setOnClickListener(null);
    view2131558540 = null;

    this.target = null;
  }
}
