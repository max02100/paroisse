// Generated code from Butter Knife. Do not modify!
package com.krealid.starter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.bluejamesbond.text.DocumentView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AboutEvangileActivity_ViewBinding<T extends AboutEvangileActivity> implements Unbinder {
  protected T target;

  private View view2131558540;

  @UiThread
  public AboutEvangileActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.anim_toolbar, "field 'mToolbar'", Toolbar.class);
    target.textAbout = Utils.findRequiredViewAsType(source, R.id.text_evangile_about, "field 'textAbout'", DocumentView.class);
    view = Utils.findRequiredView(source, R.id.floating_action_button, "method 'openWebsite'");
    view2131558540 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openWebsite();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mToolbar = null;
    target.textAbout = null;

    view2131558540.setOnClickListener(null);
    view2131558540 = null;

    this.target = null;
  }
}
