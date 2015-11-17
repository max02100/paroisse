/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.krealid.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.parse.ParseAnalytics;
import com.krealid.starter.R;


public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.launch_screen);

      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent mainIntent = new Intent(MainActivity.this, ChoiceActivity.class);
              MainActivity.this.startActivity(mainIntent);
              MainActivity.this.finish();
          }
      }, 3000);

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }
}
