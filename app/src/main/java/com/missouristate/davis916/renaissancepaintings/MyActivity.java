/*
 * Laura Davis CIS 262-902
 * 16 February 2018
 * This app allows users to scroll through a
 * handful of famous Renaissance paintings
 * and see descriptions with a Toast.
 */
package com.missouristate.davis916.renaissancepaintings;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    //Gallery of paintings
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Reference the scrollable layout structure in main_screen.xml
        mLinearLayout = (LinearLayout) findViewById(R.id.linearList);

        //Fill the scrollable layout structure with paintings
        fillPaintingGallery();
    }//end onCreate

    private void fillPaintingGallery(){
        /*
         * Populate the LinearLayour gallery
         * with paintings and descriptions
        */
        ImageButton buttonItem;

        for(int i = 0; i < RenaissanceDatabase.description.length; i++){
            //Store the individual paintings as buttons
            buttonItem = new ImageButton(this);

            Painting painting = new Painting(RenaissanceDatabase.description[i],
                    RenaissanceDatabase.id[i]);

            //Use the content description property to store painting data
            buttonItem.setContentDescription(painting.getDescription());

            //Load the painting using its unique id
            //Drawable getDrawable(painting.getId());
            buttonItem.setImageDrawable(getResources().getDrawable(painting.getId()));

            //Set onClickListener for the image button
            buttonItem.setOnClickListener(displayPaintingInformation);

            //Add the image button to the scrollable linear list
            mLinearLayout.addView(buttonItem);
        }
    }//end fillPaintingGallery

    private View.OnClickListener displayPaintingInformation = new View.OnClickListener() {

                public void onClick(View btn){
                    //Collect the info stored about the painting
                    String paintingDescription = (String) btn.getContentDescription();

                    //Make a method call to display the info
                    displayToast(paintingDescription);
                }//end onClick
            };//end displayPaintingInformation

            private void displayToast(String paintingDescription){
                //Show the info about the painting with a toast with short display life
                Toast.makeText(this, paintingDescription, Toast.LENGTH_SHORT).show();
        }//end of displayToast

        @Override
        public boolean onCreateOptionsMenu(Menu menu){
                //Inflate the menu
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }//end createOptionsMenu

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
            //Handle action bar item clicks here. The action bar will
            //automatically handle clicks on the Home/Up button,
            //as long as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            if (id == R.id.action_settings){
                return true;
            }
            return super.onOptionsItemSelected(item);
        }//end onOptionsItemSelected

}//end MyActivity
