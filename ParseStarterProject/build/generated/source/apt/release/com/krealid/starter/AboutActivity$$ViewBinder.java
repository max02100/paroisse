// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AboutActivity$$ViewBinder<T extends com.krealid.starter.AboutActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558538, "field 'bottomSheetLayout'");
    target.bottomSheetLayout = finder.castView(view, 2131558538, "field 'bottomSheetLayout'");
    view = finder.findRequiredView(source, 2131558539, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558539, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558541, "method 'onClickFAB'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickFAB();
        }
      });
  }

  @Override public void unbind(T target) {
    target.bottomSheetLayout = null;
    target.mToolbar = null;
  }
}
