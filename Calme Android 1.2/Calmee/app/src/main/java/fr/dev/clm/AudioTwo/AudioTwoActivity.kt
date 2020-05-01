package fr.dev.clm.AudioTwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import fr.dev.clm.R
import kotlinx.android.synthetic.main.activity_audio_one.*
import android.media.MediaPlayer
import android.media.AudioManager
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.mikhaellopez.circularprogressbar.CircularProgressBar

class AudioTwoActivity : AppCompatActivity() {

    private val url = "http://working-staff.com/relaxSounds/forestSound.mp3"

    private lateinit var mInterstitialAd: InterstitialAd

    lateinit var mAdView : AdView

    private val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(url)
        prepare()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        loadAds()
        mediaPlayer!!.stop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_two)

        MobileAds.initialize(this,getString(R.string.AdMobAppId))

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId= getString(R.string.AdMobAppInterstitialId)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        pauseButton.isVisible = false

        playButton.setOnClickListener {
            mediaPlayer!!.start()
            playButton.isVisible = false
            pauseButton.isVisible = true

            Toast.makeText(this, getString(R.string.tip_one), Toast.LENGTH_LONG).show()

            val circularProgressBar = findViewById<CircularProgressBar>(R.id.circularProgressBar)
            circularProgressBar.apply {
                circularProgressBar.setProgressWithAnimation(400f, mediaPlayer.duration.toLong())
                circularProgressBar.progressMax = 400f
            }
        }

        pauseButton.setOnClickListener {
            mediaPlayer!!.stop()
            mediaPlayer.prepare()
            pauseButton.isVisible = false
            playButton.isVisible = true
            loadAds()
        }

        shareButton.setOnClickListener {
            val s = ("Hello! Check this amazing relax audio file: $url")
            //Intent to share the text
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(Intent.createChooser(shareIntent,"Share via:"))
        }
    }

    private fun loadAds() {
        if(mInterstitialAd.isLoaded)
            mInterstitialAd.show()
    }
}
