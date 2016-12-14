// Generated code from Butter Knife. Do not modify!
package com.krealid.starter.adapters;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class HeaderHorairesAdapter$ViewHolder$$ViewBinder<T extends com.krealid.starter.adapters.HeaderHorairesAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558581, "field 'title'");
    target.title = finder.castView(view, 2131558581, "field 'title'");
    view = finder.findRequiredView(source, 2131558583, "field 'listHoraires'");
    target.listHoraires = finder.castView(view, 2131558583, "field 'listHoraires'");
    view = finder.findRequiredView(source, 2131558582, "field 'expandableLayout'");
    target.expandableLayout = finder.castView(view, 2131558582, "field 'expandableLayout'");
    view = finder.findRequiredView(source, 2131558580, "field 'buttonLayout'");
    target.buttonLayout = finder.castView(view, 2131558580, "field 'buttonLayout'");
  }

  @Override public void unbind(T target) {
    target.title = null;
    target.listHoraires = null;
    target.expandableLayout = null;
    target.buttonLayout = null;
  }
}
