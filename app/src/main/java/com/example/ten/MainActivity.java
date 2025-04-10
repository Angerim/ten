package com.example.ten;
import static com.example.ten.R.id.anime_preview;
import static com.example.ten.R.drawable;
import static com.example.ten.R.string;
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
        showRandomAnime();
    }
    private void showRandomAnime() {
        int[] imageResIds = {drawable.nogame, drawable.butler, drawable.moriarty, drawable.sherlock, drawable.hunters, drawable.assasion,
                drawable.killing_love, drawable.monolog, drawable.heaven, drawable.cremni, drawable.hero, drawable.friends, drawable.spy,
        };
        String[] animeNames = {getString(string.text_001), getString(string.text_002), getString(string.text_003), getString(string.text_004),
                getString(string.text_005), getString(string.text_006), getString(string.text_007), getString(string.text_008), getString(string.text_009),
                getString(string.text_010), getString(string.text_011), getString(string.text_012), getString(string.text_013),
        };
        mainText.setOnClickListener(v -> {
            int index = random.nextInt(animeNames.length);
            mainText.setText(animeNames[index]);
            animePreview.setImageResource(imageResIds[index]);
            mediaPlayer.start();
        });
    }
}