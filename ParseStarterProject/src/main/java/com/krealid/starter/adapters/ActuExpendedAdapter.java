package com.krealid.starter.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.krealid.starter.R;

import butterknife.ButterKnife;

/**
 * Created by Maxime on 26/08/2015.
 */
public class ActuExpendedAdapter  extends RecyclerView.Adapter<ActuExpendedAdapter.ViewHolder> {

    private String text;
    private Context context;
    private View view;

    public ActuExpendedAdapter(String text, Context context){
        this.text = text;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.actu_text, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String iframeLink;
        if(this.text.contains("<iframe")){
            String iframeStart = "<iframe src=\"";
            String iframeEnd   = "\" width=";

            int indexToStartIframe = this.text.indexOf(iframeStart);
            int indexToEndIframe = (this.text.substring(indexToStartIframe)).indexOf(iframeEnd);

            String iframeHeight = "height=\"";
            int indexToStartHeightIframe= this.text.indexOf(iframeHeight);

            String iframeHeightValue = this.text.substring(indexToStartHeightIframe + iframeHeight.length(),
                    this.text.indexOf('"', indexToStartHeightIframe + iframeHeight.length()));

            iframeLink = this.text.substring(indexToStartIframe + iframeStart.length(),
                    indexToStartIframe + indexToEndIframe);
            String articleText = this.text.substring(0, indexToStartIframe);
            holder.text.loadData("<font style=\"text-align:justify;text-justify:inter-word;\">" +
                    articleText + "</font>", "text/html; charset=UTF-8", null);

            final RelativeLayout layout = new RelativeLayout(this.context);
            RelativeLayout.LayoutParams lprams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            layout.setLayoutParams(lprams);

            WebView web1 = new WebView(this.context);
            web1.setWebChromeClient(new WebChromeClient());
            web1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            web1.getSettings().setJavaScriptEnabled(true);
            web1.getSettings().setPluginState(WebSettings.PluginState.ON);
            web1.loadUrl(iframeLink);
            web1.setId(R.id.myWebView);
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    Integer.parseInt(iframeHeightValue),
                    this.context.getResources().getDisplayMetrics());
            final RelativeLayout.LayoutParams webViewParams = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, height);
            layout.addView(web1, webViewParams);
            holder.articleContainer.addView(layout);
        } else {
            holder.text.loadData("<font style=\"text-align:justify;text-justify:inter-word;\">" +
                    this.text + "</font>", "text/html; charset=UTF-8", null);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public void stopVideo(){
        ViewHolder holder = new ViewHolder(view);
        WebView mWebView = (WebView) holder.articleContainer.findViewById(R.id.myWebView);
        if(mWebView != null)
            mWebView.loadUrl("about:blank");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public WebView text;
        public LinearLayout articleContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            text = ButterKnife.findById(itemView, R.id.articleContent);
            articleContainer = ButterKnife.findById(itemView, R.id.article_container);
        }
    }
}
