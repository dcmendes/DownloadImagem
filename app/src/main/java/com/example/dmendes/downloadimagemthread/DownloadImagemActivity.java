package com.example.dmendes.downloadimagemthread;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;

public class DownloadImagemActivity extends AppCompatActivity {

    //private static final String url = "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fphotos%2F37600000%2FSeason-4-ep-02-Korra-Alone-avatar-the-legend-of-korra-37679080-1912-1072.png&f=1";
   // private static  final String url = "/home/dmendes/Imagens/the-legend-of-korra-poster.jpg";
    //private static final String url = "https://www.gamingdragons.com/images/game_img/screenshots/the-legend-of-korra/788g3d%20(3).jpg";
    //private static final String url = "https://static.gamespot.com/uploads/screen_kubrick/1365/13658182/2698655-legend-of-korra-review_1920_20141019.jpg";
    private static final String url = "https://proxy.duckduckgo.com/iu/?u=http%3A%2F%2Fimages6.fanpop.com%2Fimage%2Fphotos%2F37600000%2FSeason-4-ep-02-Korra-Alone-avatar-the-legend-of-korra-37679079-1912-1072.png&f=1";

    //ó carrega pelo protocolo https
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_imagem);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        progressBar.setVisibility(View.VISIBLE);
        downloadImagem(url);
    }

    public void downloadImagem(final String urlImg){
        new Thread(){
            @Override
            public void run() {
                try{
                    final Bitmap imagem = Download.downloadBitmap(urlImg);
                    atualizaImagem(imagem);
                } catch (IOException e){
                    Log.e("Erro no download", e.getMessage(), e);
                }
            }
        }.start();

    }

    public void atualizaImagem(final Bitmap imagem){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.INVISIBLE);
                ImageView imageView = (ImageView) findViewById(R.id.img);
                imageView.setImageBitmap(imagem);
            }
        });




    }

}
