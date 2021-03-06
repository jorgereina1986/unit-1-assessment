package nyc.c4q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InitialActivity extends Activity {

  public int counter = 0;
  public SharedPreferences preferences = null;
  public final static String TAG = "C4QTAG";

  public void loadState(){
    Log.d(TAG, "loadState()");
    counter = preferences.getInt("counter", 0);
    Log.d(TAG, "loadState(): counter=="+counter);
  }

  public void saveState(){
    Log.d(TAG, "saveState()");
    Log.d(TAG, "saveState(): counter=="+counter);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("counter", counter);
    editor.commit();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      Log.d(TAG, "onCreate()");
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_initial);
    preferences = getPreferences(Context.MODE_PRIVATE);
      Button plus = (Button) findViewById(R.id.buttonPlus);
      Button minus = (Button) findViewById(R.id.buttonMinus);
      Button tile = (Button) findViewById(R.id.buttonTileActivity);
      final TextView screen = (TextView) findViewById(R.id.tvCounter);





      plus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              for(counter = 0; counter < 10 ; counter++)
                  screen.setText(counter+"");


              Log.d(TAG, "plus.onClick(), counter="+counter);
          }
      });
      minus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              for(counter = 0; counter < 10 ; counter--)
                  screen.setText(counter+"");

              Log.d(TAG, "minus.onClick(), counter="+counter);

          }
      });
      tile.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Log.d(TAG, "tile.onClick()");
              Intent mainIntent = new Intent(InitialActivity.this,
                      TileActivity.class);
              startActivity(mainIntent);
          }
      });
  }
}
