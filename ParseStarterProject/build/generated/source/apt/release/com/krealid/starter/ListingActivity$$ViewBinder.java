// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ListingActivity$$ViewBinder<T extends com.krealid.starter.ListingActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558616, "field 'mToolbar'");
    target.mToolbar = finder.castView(view, 2131558616, "field 'mToolbar'");
    view = finder.findRequiredView(source, 2131558615, "field 'recyclerView'");
    target.recyclerView = finder.castView(view, 2131558615, "field 'recyclerView'");
  }

  @Override public void unbind(T target) {
    target.mToolbar = null;
    target.recyclerView = null;
  }
}
