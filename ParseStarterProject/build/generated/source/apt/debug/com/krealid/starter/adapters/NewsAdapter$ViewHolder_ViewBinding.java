// Generated code from Butter Knife. Do not modify!
package com.krealid.starter.adapters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bluejamesbond.text.DocumentView;
import com.krealid.starter.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class NewsAdapter$ViewHolder_ViewBinding<T extends NewsAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public NewsAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.mImageView = Utils.findRequiredViewAsType(source, R.id.news_image, "field 'mImageView'", ImageView.class);
    target.title = Utils.findRequiredViewAsType(source, R.id.titleActu, "field 'title'", TextView.class);
    target.intro = Utils.findRequiredViewAsType(source, R.id.introActu, "field 'intro'", DocumentView.class);
    target.introButton = Utils.findRequiredViewAsType(source, R.id.introButton, "field 'introButton'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mImageView = null;
    target.title = null;
    target.intro = null;
    target.introButton = null;

    this.target = null;
  }
}
