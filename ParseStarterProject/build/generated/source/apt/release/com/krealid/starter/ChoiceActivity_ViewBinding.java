// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChoiceActivity_ViewBinding<T extends ChoiceActivity> implements Unbinder {
  protected T target;

  private View view2131558554;

  private View view2131558552;

  private View view2131558551;

  private View view2131558550;

  private View view2131558549;

  private View view2131558548;

  @UiThread
  public ChoiceActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.plusButton, "method 'plusButton'");
    view2131558554 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.plusButton();
      }
    });
    view = Utils.findRequiredView(source, R.id.uselessButton, "method 'useLessButton'");
    view2131558552 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.useLessButton();
      }
    });
    view = Utils.findRequiredView(source, R.id.mouvementsButton, "method 'mouvementsButton'");
    view2131558551 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.mouvementsButton();
      }
    });
    view = Utils.findRequiredView(source, R.id.horairesButton, "method 'horairesButton'");
    view2131558550 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.horairesButton();
      }
    });
    view = Utils.findRequiredView(source, R.id.newsButton, "method 'newsButton'");
    view2131558549 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.newsButton();
      }
    });
    view = Utils.findRequiredView(source, R.id.evangileButton, "method 'evangileButton'");
    view2131558548 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.evangileButton();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (this.target == null) throw new IllegalStateException("Bindings already cleared.");

    view2131558554.setOnClickListener(null);
    view2131558554 = null;
    view2131558552.setOnClickListener(null);
    view2131558552 = null;
    view2131558551.setOnClickListener(null);
    view2131558551 = null;
    view2131558550.setOnClickListener(null);
    view2131558550 = null;
    view2131558549.setOnClickListener(null);
    view2131558549 = null;
    view2131558548.setOnClickListener(null);
    view2131558548 = null;

    this.target = null;
  }
}
