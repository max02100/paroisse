// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AboutEvangileActivity$$ViewBinder<T extends com.krealid.starter.AboutEvangileActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558533, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558533, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558538, "field 'textAbout'");
    target.textAbout = finder.castView(view, 2131558538, "field 'textAbout'");
    view = finder.findRequiredView(source, 2131558535, "method 'openWebsite'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.openWebsite();
        }
      });
  }

  @Override public void unbind(T target) {
    target.mToolbar = null;
    target.textAbout = null;
  }
}
