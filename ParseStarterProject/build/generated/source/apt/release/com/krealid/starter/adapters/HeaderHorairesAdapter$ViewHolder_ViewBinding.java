// Generated code from Butter Knife. Do not modify!
package com.krealid.starter.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.krealid.starter.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HeaderHorairesAdapter$ViewHolder_ViewBinding<T extends HeaderHorairesAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public HeaderHorairesAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.title = Utils.findRequiredViewAsType(source, R.id.headerHoraires, "field 'title'", TextView.class);
    target.listHoraires = Utils.findRequiredViewAsType(source, R.id.horairesList, "field 'listHoraires'", TextView.class);
    target.expandableLayout = Utils.findRequiredViewAsType(source, R.id.expandableLayout, "field 'expandableLayout'", ExpandableRelativeLayout.class);
    target.buttonLayout = Utils.findRequiredViewAsType(source, R.id.button, "field 'buttonLayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.title = null;
    target.listHoraires = null;
    target.expandableLayout = null;
    target.buttonLayout = null;

    this.target = null;
  }
}
