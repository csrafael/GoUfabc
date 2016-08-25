package android.ufabc.edu.br.goufabc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Pokemon extends AppCompatActivity {

    public Context ctx;
    public int id;
    public String trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        ctx = Pokemon.this;
        String[][] listaPokemon = null;

        try {
            listaPokemon = Matrix.readFromAssets(ctx);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        trainer = intent.getStringExtra("trainer");
        Long Ide;
        Ide = intent.getLongExtra("pokemon", 999);
        id = Ide.intValue();
        TextView txtDetalhes = (TextView)findViewById(R.id.nomePokemon);
        txtDetalhes.setText(listaPokemon[id][0].toString()+" "+listaPokemon[id][1].toString());
        String url = listaPokemon[id][2];
        
        new LoadImagefromUrl( ).execute((ImageView) findViewById(R.id.imgPkmn), listaPokemon[id][2].toString());

        new LoadImagefromUrl( ).execute((ImageView) findViewById(R.id.imgType1), listaPokemon[id][3].toString());

        if (!(listaPokemon[id][4].toString().equals("null"))){
            new LoadImagefromUrl( ).execute((ImageView) findViewById(R.id.imgType2), listaPokemon[id][4].toString());
        }

        View view = this.getWindow().getDecorView();
        view.setOnTouchListener(new OnSwipeTouchListener(Pokemon.this) {
            @Override
            public void onSwipeLeft() {
                Intent intent = new Intent(Pokemon.this, Pokemon.class);
                Long ID = (long) (id + 1);
                intent.putExtra("pokemon", ID);
                intent.putExtra("trainer", trainer);
                finish();
                startActivity(intent);
            }
            public void onSwipeRight() {
                Intent intent = new Intent(Pokemon.this, Pokemon.class);
                Long ID = (long) (id - 1);
                intent.putExtra("pokemon", ID);
                intent.putExtra("trainer", trainer);
                finish();
                startActivity(intent);
            }
        });
    }

    public void clickAdd(View view){
        Intent intent = new Intent(this, AddActivity.class);
        intent.putExtra("pokemon", id);
        intent.putExtra("trainer", trainer);
        startActivity(intent);
        finish();
    }

    private class LoadImagefromUrl extends AsyncTask< Object, Void, Bitmap > {
        ImageView ivPreview;

        @Override
        protected Bitmap doInBackground( Object... params ) {
            this.ivPreview = (ImageView) params[0];
            String url = (String) params[1];
            System.out.println(url);
            return loadBitmap( url );
        }

        @Override
        protected void onPostExecute( Bitmap result ) {
            super.onPostExecute( result );
            ivPreview.setImageBitmap( result );
        }
    }

    public Bitmap loadBitmap( String url ) {
        URL newurl = null;
        Bitmap bitmap = null;
        try {
            newurl = new URL( url );
            bitmap = BitmapFactory.decodeStream( newurl.openConnection( ).getInputStream( ) );
        } catch ( MalformedURLException e ) {
            e.printStackTrace( );
        } catch ( IOException e ) {

            e.printStackTrace( );
        }
        return bitmap;
    }

    public class OnSwipeTouchListener implements View.OnTouchListener {

        private final GestureDetector gestureDetector;

        public OnSwipeTouchListener (Context ctx){
            gestureDetector = new GestureDetector(ctx, new GestureListener());
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gestureDetector.onTouchEvent(event);
        }

        private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

            private static final int SWIPE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                boolean result = false;
                try {
                    float diffY = e2.getY() - e1.getY();
                    float diffX = e2.getX() - e1.getX();
                    if (Math.abs(diffX) > Math.abs(diffY)) {
                        if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                            if (diffX > 0) {
                                onSwipeRight();
                            } else {
                                onSwipeLeft();
                            }
                        }
                        result = true;
                    }
                    else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeBottom();
                        } else {
                            onSwipeTop();
                        }
                    }
                    result = true;

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return result;
            }
        }

        public void onSwipeRight() {
        }

        public void onSwipeLeft() {
        }

        public void onSwipeTop() {
        }

        public void onSwipeBottom() {
        }
    }
}
