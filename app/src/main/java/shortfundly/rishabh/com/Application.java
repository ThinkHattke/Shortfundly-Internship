package shortfundly.rishabh.com;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Application extends AppCompatActivity {

    private ImageView dp;

    private ImageView cover;

    private TextView namefield;

    private TextView collegefield;

    private TextView agefield;

    private TextView professionfield;

    private TextView expertisefield;

    private TextView appliedfield;

    private String name;

    private String age;

    private String profession;

    private String college;

    private String expertise;

    private String applied;

    private String coverphoto = "http://i.imgur.com/96Vu6cP.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application);

        // Declaring All Datatypes

        dp = (ImageView) findViewById(R.id.picture);

        cover = (ImageView) findViewById(R.id.cover);

        namefield = (TextView) findViewById(R.id.namefield);

        collegefield = (TextView) findViewById(R.id.collegefield);

        agefield = (TextView) findViewById(R.id.agefield);

        professionfield = (TextView) findViewById(R.id.professionfield);

        expertisefield = (TextView) findViewById(R.id.expertisefield);

        appliedfield = (TextView) findViewById(R.id.appliedfield);


        // Getting Data From Bundle

        Bundle extras = getIntent().getExtras();

        name = extras.getString("name");

        age = extras.getString("age");

        profession = extras.getString("profession");

        college = extras.getString("college");

        expertise = extras.getString("expertise");

        applied = extras.getString("applied");


        // Setting Values

        namefield.setText(name);

        collegefield.setText(college);

        agefield.setText(age);

        professionfield.setText(profession);

        expertisefield.setText(expertise);

        appliedfield.setText(applied);

        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");

        Picasso.with(this).load(coverphoto).into(cover);

        dp.setImageBitmap(getRoundedCornerBitmap(bmp, 10));

        internetCheck();

    }


    public boolean isOnline() {

        final ConnectivityManager connectivityManager = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }


    private void internetCheck() {

        if (isOnline()) {}

        else {

            Toast.makeText(Application.this, "You Need Internet Connection To Download Images", Toast.LENGTH_LONG).show();

        }

    }


    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;

        final Paint paint = new Paint();

        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        final RectF rectF = new RectF(rect);

        final float roundPx = pixels;

        paint.setAntiAlias(true);

        canvas.drawARGB(0, 0, 0, 0);

        paint.setColor(color);

        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;

    }


}
