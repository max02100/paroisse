// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flipboard.bottomsheet.BottomSheetLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActuActivity_ViewBinding<T extends ActuActivity> implements Unbinder {
  protected T target;

  private View view2131558540;

  @UiThread
  public ActuActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.bottomSheetLayout = Utils.findRequiredViewAsType(source, R.id.bottomsheet, "field 'bottomSheetLayout'", BottomSheetLayout.class);
    target.articleTitle = Utils.findRequiredViewAsType(source, R.id.article_title, "field 'articleTitle'", TextView.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.scrollableview, "field 'recyclerView'", RecyclerView.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinator, "field 'coordinatorLayout'", CoordinatorLayout.class);
    target.appBarLayout = Utils.findRequiredViewAsType(source, R.id.appbar, "field 'appBarLayout'", AppBarLayout.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.anim_toolbar, "field 'mToolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.floating_action_button, "method 'share'");
    view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.share();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.bottomSheetLayout = null;
    target.articleTitle = null;
    target.recyclerView = null;
    target.coordinatorLayout = null;
    target.appBarLayout = null;
    target.mToolbar = null;

    view2131558540.setOnClickListener(null);
    view2131558540 = null;

    this.target = null;
  }
}
