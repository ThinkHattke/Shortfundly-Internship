package shortfundly.rishabh.com;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class List extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout app1;

    private LinearLayout app2;

    private LinearLayout app3;

    private LinearLayout app4;

    private LinearLayout app5;

    private ImageView dp1;

    private ImageView dp2;

    private ImageView dp3;

    private ImageView dp4;

    private ImageView dp5;

    private TextView name1;

    private TextView name2;

    private TextView name3;

    private TextView name4;

    private TextView name5;

    private TextView age1;

    private TextView age2;

    private TextView age3;

    private TextView age4;

    private TextView age5;

    private TextView profession1;

    private TextView profession2;

    private TextView profession3;

    private TextView profession4;

    private TextView profession5;

    private TextView college1;

    private TextView college2;

    private TextView college3;

    private TextView college4;

    private TextView college5;

    private String url1 = "http://i.imgur.com/a0rTDJY.jpg";

    private String url2 = "http://i.imgur.com/qQdHPKI.jpg";

    private String url3 = "http://i.imgur.com/HIma8eC.jpg";

    private String url4 = "http://i.imgur.com/phX52UF.jpg";

    private String url5 = "http://i.imgur.com/v3CkKiog.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // Declaring LinearLayouts

        app1 = (LinearLayout) findViewById(R.id.app1);

        app2 = (LinearLayout) findViewById(R.id.app2);

        app3 = (LinearLayout) findViewById(R.id.app3);

        app4 = (LinearLayout) findViewById(R.id.app4);

        app5 = (LinearLayout) findViewById(R.id.app5);


        // Setting OnClick Listeners

        app1.setOnClickListener(this);

        app2.setOnClickListener(this);

        app3.setOnClickListener(this);

        app4.setOnClickListener(this);

        app5.setOnClickListener(this);


        // Declaring Images

        dp1 = (ImageView) findViewById(R.id.dp1);

        dp2 = (ImageView) findViewById(R.id.dp2);

        dp3 = (ImageView) findViewById(R.id.dp3);

        dp4 = (ImageView) findViewById(R.id.dp4);

        dp5 = (ImageView) findViewById(R.id.dp5);


        // Declaring Names

        name1 = (TextView) findViewById(R.id.name1);

        name2 = (TextView) findViewById(R.id.name2);

        name3 = (TextView) findViewById(R.id.name3);

        name4 = (TextView) findViewById(R.id.name4);

        name5 = (TextView) findViewById(R.id.name5);


        // Declaring Ages

        age1 = (TextView) findViewById(R.id.age1);

        age2 = (TextView) findViewById(R.id.age2);

        age3 = (TextView) findViewById(R.id.age3);

        age4 = (TextView) findViewById(R.id.age4);

        age5 = (TextView) findViewById(R.id.age5);


        // Declaring Professions

        profession1 = (TextView) findViewById(R.id.profession1);

        profession2 = (TextView) findViewById(R.id.profession2);

        profession3 = (TextView) findViewById(R.id.profession3);

        profession4 = (TextView) findViewById(R.id.profession4);

        profession5 = (TextView) findViewById(R.id.profession5);


        // Declaring Colleges

        college1 = (TextView) findViewById(R.id.college1);

        college2 = (TextView) findViewById(R.id.college2);

        college3 = (TextView) findViewById(R.id.college3);

        college4 = (TextView) findViewById(R.id.college4);

        college5 = (TextView) findViewById(R.id.college5);

        loadImages();

    }


    private void loadImages() {

        Picasso.with(this).load(url1).into(dp1);

        Picasso.with(this).load(url2).into(dp2);

        Picasso.with(this).load(url3).into(dp3);

        Picasso.with(this).load(url4).into(dp4);

        Picasso.with(this).load(url5).into(dp5);

        internetCheck();

    }


    public boolean isOnline() {

        final ConnectivityManager connectivityManager = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();

    }


    private void internetCheck() {

        if (isOnline()) {}

        else {

            Toast.makeText(List.this, "You Need Internet Connection To Download Images", Toast.LENGTH_LONG).show();

        }

    }


    private void sendData(ImageView dp, TextView name, TextView age, TextView profession, TextView college, String expertise, String applied) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, dp, getString(R.string.picturetransition));

        dp.buildDrawingCache();

        Bitmap image = dp.getDrawingCache();

        Bundle extras = new Bundle();

        extras.putParcelable("imagebitmap", image);

        extras.putString("name", name.getText().toString());

        extras.putString("age", age.getText().toString());

        extras.putString("profession", profession.getText().toString());

        extras.putString("college", college.getText().toString());

        extras.putString("expertise", expertise);

        extras.putString("applied", applied);

        Intent intent = new Intent(List.this, Application.class);

        intent.putExtras(extras);

        startActivity(intent, options.toBundle());

    }


    @Override
    public void onClick(View view) {

        if (view == app1) {

            sendData(dp1, name1, age1, profession1, college1, "JAVA & PHP", "Android Development");

        }

        if (view == app2) {

            sendData(dp2, name2, age2, profession2, college2, "Adobe Illustrator", "Graphic Designer");

        }

        if (view == app3) {

            sendData(dp3, name3, age3, profession3, college3, "Image Processing", "Machine Learning");

        }

        if (view == app4) {

            sendData(dp4, name4, age4, profession4, college4, "XML & Mockups", "UI/UX Designer");

        }

        if (view == app5) {

            sendData(dp5, name5, age5, profession5, college5, "Node.js", "Realtime Backend");

        }

    }


}
