package berkaykaanedikli.com;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    Oyuncu oyuncu1;
    Oyuncu oyuncu2;
    Button btnTopcu1, btnTopcu2, btnTankci1, btnTankci2, btnReset;
    Integer isabet;
    TextView txtViewIsabet;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ArrayList<Oyuncu> oyuncular = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.zulamusic);
        player.setLooping(true);
        player.start();
        oyuncu1 = new Oyuncu("Oyuncu 1",100);
        oyuncu2 = new Oyuncu("Oyuncu 2",100);
        oyuncular.add(oyuncu1);
        oyuncular.add(oyuncu2);
        btnTankci1 = findViewById(R.id.btnTankci1);
        btnTankci2 = findViewById(R.id.btnTankci2);
        btnTopcu1 = findViewById(R.id.btnTopcu1);
        btnTopcu2 = findViewById(R.id.btnTopcu2);
        btnReset = findViewById(R.id.btnReset);
        progressBar1 = findViewById(R.id.progressBar1);
        progressBar2 = findViewById(R.id.progressBar2);
        txtViewIsabet = findViewById(R.id.textView46);

        btnTankci1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isabet = oyuncu1.tankci.atesEt(oyuncu2);
                progressBar2.setProgress(oyuncu2.getHealth());
                txtViewIsabet.setText(isabet.toString());
                oyucuKontrol();
            }
        });
        btnTopcu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isabet = oyuncu1.topcu.atesEt(oyuncu2);
                progressBar2.setProgress(oyuncu2.getHealth());
                txtViewIsabet.setText(isabet.toString());
                oyucuKontrol();
            }
        });
        btnTankci2.setOnClickListener(view -> {
            isabet = oyuncu2.tankci.atesEt(oyuncu1);
            progressBar1.setProgress(oyuncu1.getHealth());
            txtViewIsabet.setText(isabet.toString());
            oyucuKontrol();
        });
        btnTopcu2.setOnClickListener(view -> {
            isabet = oyuncu2.topcu.atesEt(oyuncu1);
            progressBar1.setProgress(oyuncu1.getHealth());
            txtViewIsabet.setText(isabet.toString());
            oyucuKontrol();
        });
        btnReset.setOnClickListener(view -> {
            oyuncu1.setHealth(100);
            oyuncu2.setHealth(100);
            progressBar1.setProgress(oyuncu1.getHealth());
            progressBar2.setProgress(oyuncu2.getHealth());
            txtViewIsabet.setText("0");
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
    private void oyucuKontrol() {
        for (Oyuncu oyuncu:oyuncular) {
            if (oyuncu.getHealth()<=0 )
                txtViewIsabet.setText("Oyun Sona Erdi.");
        }
    }
}