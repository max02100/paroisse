// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ChoiceActivity$$ViewBinder<T extends com.krealid.starter.ChoiceActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558555, "method 'plusButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.plusButton();
        }
      });
    view = finder.findRequiredView(source, 2131558553, "method 'useLessButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.useLessButton();
        }
      });
    view = finder.findRequiredView(source, 2131558552, "method 'mouvementsButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.mouvementsButton();
        }
      });
    view = finder.findRequiredView(source, 2131558551, "method 'horairesButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.horairesButton();
        }
      });
    view = finder.findRequiredView(source, 2131558550, "method 'newsButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.newsButton();
        }
      });
    view = finder.findRequiredView(source, 2131558549, "method 'evangileButton'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.evangileButton();
        }
      });
  }

  @Override public void unbind(T target) {
  }
}