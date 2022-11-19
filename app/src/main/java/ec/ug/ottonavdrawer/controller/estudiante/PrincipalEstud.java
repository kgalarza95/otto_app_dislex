package ec.ug.ottonavdrawer.controller.estudiante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

import ec.ug.ottonavdrawer.R;

public class PrincipalEstud extends AppCompatActivity implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {

    private static final int MY_DATA_CHECK_CODE = 1;
    EditText txtTextoVoz;
    Button btnHablar;

    SoundPool soundPool;
    int sonidoBoton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_estud);

        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);

        //sonido
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);
        sonidoBoton = soundPool.load(this, R.raw.click, 1);

        mediaPlayer = MediaPlayer.create(this, R.raw.fondo_music);
        mediaPlayer.start();

        txtTextoVoz = findViewById(R.id.txt_hablar);
        btnHablar = findViewById(R.id.btn_hablar);

        btnHablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sonidoBoton, 1,1,1,0,0);
                Toast.makeText(PrincipalEstud.this, "Hablar", Toast.LENGTH_SHORT).show();
                String myText1 = "Hola este es mi texto uno";
                String myText2 = "palabras para ninios de no se que edad, hola soy yo de nuevo.";
                mTts.speak(myText1, TextToSpeech.QUEUE_FLUSH, null);
                mTts.speak(myText2, TextToSpeech.QUEUE_ADD, null);


                //config y texto alarma
                HashMap<String, String> myHashAlarm = new HashMap();
                myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_STREAM,
                        String.valueOf(AudioManager.STREAM_ALARM));
                mTts.speak(myText1, TextToSpeech.QUEUE_FLUSH, myHashAlarm);
                mTts.speak(myText2, TextToSpeech.QUEUE_ADD, myHashAlarm);

               /* //sincronizar
                mTts.setOnUtteranceCompletedListener(this);
                myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_STREAM,
                        String.valueOf(AudioManager.STREAM_ALARM));
                mTts.speak(myText1, TextToSpeech.QUEUE_FLUSH, myHashAlarm);
                myHashAlarm.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID,
                        "end of wakeup message ID");
                // myHashAlarm now contains two optional parameters
                mTts.speak(myText2, TextToSpeech.QUEUE_ADD, myHashAlarm);*/
            }
        });


    }


    private TextToSpeech mTts;

    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                mTts = new TextToSpeech(this, this);
            } else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(
                        TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }
    }

    @Override
    public void onInit(int i) {
        mTts.setLanguage(new Locale(Locale.getDefault().getLanguage()));//texto del dispositivo por default
        //mTts.setLanguage(Locale.US);
        /*mTts.isLanguageAvailable(Locale.UK))
        mTts.isLanguageAvailable(Locale.FRANCE))
        mTts.isLanguageAvailable(new Locale("spa", "ESP")));*/
    }

    @Override
    public void onUtteranceCompleted(String uttId) {
        if (uttId == "end of wakeup message ID") {
            // playAnnoyingMusic();
        }
    }

    @Override
    public void onBackPressed(){
        //En caso de querer permitir volver atrás usa esta llamada:
        //super.onBackPressed();
    }

}

//fuente del texto: https://android-developers.googleblog.com/2009/09/introduction-to-text-to-speech-in.html


