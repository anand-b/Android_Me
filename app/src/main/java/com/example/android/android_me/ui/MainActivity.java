/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

import static com.example.android.android_me.ui.AndroidMeActivity.EXTRA_BODY_INDEX;
import static com.example.android.android_me.ui.AndroidMeActivity.EXTRA_HEAD_INDEX;
import static com.example.android.android_me.ui.AndroidMeActivity.EXTRA_LEG_INDEX;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex = 0;
    private int bodyIndex = 0;
    private int legIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button_next);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putInt(EXTRA_HEAD_INDEX, headIndex);
                b.putInt(EXTRA_BODY_INDEX, bodyIndex);
                b.putInt(EXTRA_LEG_INDEX, legIndex);

                Intent androidMeIntent = new Intent(MainActivity.this, AndroidMeActivity.class);
                androidMeIntent.putExtras(b);
                startActivity(androidMeIntent);
            }
        });

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        int bodyPart = position / 12;
        int partIndex = position % 12;
        switch (bodyPart) {
            case 0 : headIndex = partIndex;
            case 1 : bodyIndex = partIndex;
            default: legIndex = partIndex;
        }
    }

}
