// Generated code from Butter Knife. Do not modify!
package com.krealid.starter.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class NewsAdapter$ViewHolder$$ViewBinder<T extends com.krealid.starter.adapters.NewsAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558575, "field 'mImageView'");
    target.mImageView = finder.castView(view, 2131558575, "field 'mImageView'");
    view = finder.findRequiredView(source, 2131558576, "field 'title'");
    target.title = finder.castView(view, 2131558576, "field 'title'");
    view = finder.findRequiredView(source, 2131558577, "field 'intro'");
    target.intro = finder.castView(view, 2131558577, "field 'intro'");
    view = finder.findRequiredView(source, 2131558578, "field 'introButton'");
    target.introButton = finder.castView(view, 2131558578, "field 'introButton'");
  }

  @Override public void unbind(T target) {
    target.mImageView = null;
    target.title = null;
    target.intro = null;
    target.introButton = null;
  }
}
