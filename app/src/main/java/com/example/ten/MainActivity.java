package com.example.ten;

import static com.example.ten.R.id.anime_preview;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView mainText;
    Random random;
    MediaPlayer mediaPlayer;
    ImageView animePreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.sound_click);
        mainText = findViewById(R.id.mainText);
        animePreview = findViewById(anime_preview);
        random = new Random();

        int[] imageResIds = {
                R.drawable.nogame,
                R.drawable.butler,
                R.drawable.moriarty,
                R.drawable.sherlock,
                R.drawable.hunters,
                R.drawable.assasion,
                R.drawable.killing_love,
                R.drawable.monolog,
                R.drawable.heaven,
                R.drawable.cremni,
                R.drawable.hero,
                R.drawable.friends,
                R.drawable.spy,
        };

        String[] animeNames = {
                getString(R.string.text_001), getString(R.string.text_002),
                getString(R.string.text_003), getString(R.string.text_004),
                getString(R.string.text_005), getString(R.string.text_006),
                getString(R.string.text_007), getString(R.string.text_008),
                getString(R.string.text_009), getString(R.string.text_010),
                getString(R.string.text_011), getString(R.string.text_012),
                getString(R.string.text_013),
        };

        mainText.setOnClickListener(v -> {
            int index = random.nextInt(animeNames.length);
            mainText.setText(animeNames[index]);
            animePreview.setImageResource(imageResIds[index]);
            mediaPlayer.start();
        });

    }
}