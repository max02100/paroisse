// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ActuActivity$$ViewBinder<T extends com.krealid.starter.ActuActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558532, "field 'bottomSheetLayout'");
    target.bottomSheetLayout = finder.castView(view, 2131558532, "field 'bottomSheetLayout'");
    view = finder.findRequiredView(source, 2131558540, "field 'articleTitle'");
    target.articleTitle = finder.castView(view, 2131558540, "field 'articleTitle'");
    view = finder.findRequiredView(source, 2131558541, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131558541, "field 'recyclerView'");
    view = finder.findRequiredView(source, 2131558539, "field 'coordinatorLayout'");
    target.coordinatorLayout = finder.castView(view, 2131558539, "field 'coordinatorLayout'");
    view = finder.findRequiredView(source, 2131558536, "field 'appBarLayout'");
    target.appBarLayout = finder.castView(view, 2131558536, "field 'appBarLayout'");
    view = finder.findRequiredView(source, 2131558533, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558533, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558535, "method 'share'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.share();
        }
      });
  }

  @Override public void unbind(T target) {
    target.bottomSheetLayout = null;
    target.articleTitle = null;
    target.recyclerView = null;
    target.coordinatorLayout = null;
    target.appBarLayout = null;
    target.mToolbar = null;
  }
}