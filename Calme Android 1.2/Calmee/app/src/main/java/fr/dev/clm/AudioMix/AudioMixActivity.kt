package fr.dev.clm.AudioMix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import fr.dev.clm.R
import android.media.MediaPlayer
import android.media.AudioManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import fr.dev.clm.MainActivity
import kotlinx.android.synthetic.main.activity_audio_mix.*

class AudioMixActivity : AppCompatActivity() {

    private val urlOne = "http://working-staff.com/relaxSounds/seaSound.mp3"
    private val urlTwo = "http://working-staff.com/relaxSounds/forestSound.mp3"
    private val urlThree = "http://working-staff.com/relaxSounds/birdsSound.mp3"
    private val urlFour = "http://working-staff.com/relaxSounds/thunderSound.mp3"
    private val urlFive = "http://working-staff.com/relaxSounds/nightRainSound.mp3"
    private val urlSix = "http://working-staff.com/relaxSounds/citySound.mp3"
    private val urlSeven = "http://working-staff.com/relaxSounds/cikadiSound.mp3"
    private val urlEight = "http://working-staff.com/relaxSounds/fireSound.mp3"
    private val urlNine = "http://working-staff.com/relaxSounds/menuSound.mp3"

    private lateinit var mInterstitialAd: InterstitialAd

    lateinit var mAdView : AdView

    override fun onBackPressed() {
        super.onBackPressed()
        loadAds()
    }

    private val mediaPlayerOne: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlOne)

        prepareAsync()
    }

    private val mediaPlayerTwo: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlTwo)

        prepareAsync()
    }

    private val mediaPlayerThree: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlThree)

        prepareAsync()
    }

    private val mediaPlayerFour: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlFour)

        prepareAsync()
    }

    private val mediaPlayerFive: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlFive)

        prepareAsync()
    }

    private val mediaPlayerSix: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlSix)

        prepareAsync()
    }

    private val mediaPlayerSeven: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlSeven)

        prepareAsync()
    }

    private val mediaPlayerEight: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlEight)

        prepareAsync()
    }

    private val mediaPlayerNine: MediaPlayer? = MediaPlayer().apply {
        setAudioStreamType(AudioManager.STREAM_MUSIC)
        setDataSource(urlNine)

        prepareAsync()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio_mix)

        MobileAds.initialize(this,getString(R.string.AdMobAppId))

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId= getString(R.string.AdMobAppInterstitialId)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        stopButton.isVisible = false

        buttonOne.setOnClickListener {
            mediaPlayerOne!!.start()
            stopButton.isVisible = true
        }

        buttonTwo.setOnClickListener {
            mediaPlayerTwo!!.start()
            stopButton.isVisible = true
        }

        buttonThree.setOnClickListener {
            mediaPlayerThree!!.start()
            stopButton.isVisible = true
        }

        buttonFour.setOnClickListener {
            mediaPlayerFour!!.start()
            stopButton.isVisible = true
        }

        buttonFive.setOnClickListener {
            mediaPlayerFive!!.start()
            stopButton.isVisible = true
        }

        buttonSix.setOnClickListener {
            mediaPlayerSix!!.start()
            stopButton.isVisible = true
        }

        buttonSeven.setOnClickListener {
            mediaPlayerSeven!!.start()
            stopButton.isVisible = true
        }

        buttonEight.setOnClickListener {
            mediaPlayerEight!!.start()
            stopButton.isVisible = true
        }

        buttonNine.setOnClickListener {
            mediaPlayerNine!!.start()
            stopButton.isVisible = true
        }

        stopButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            mediaPlayerOne!!.stop()
            //mediaPlayerOne.prepareAsync()

            mediaPlayerTwo!!.stop()
            //mediaPlayerTwo.prepareAsync()

            mediaPlayerThree!!.stop()
            //mediaPlayerThree.prepareAsync()

            mediaPlayerFour!!.stop()
            //mediaPlayerFour.prepareAsync()

            mediaPlayerFive!!.stop()
            //mediaPlayerFive.prepareAsync()

            mediaPlayerSeven!!.stop()
            //ediaPlayerSeven.prepareAsync()

            mediaPlayerEight!!.stop()
            //mediaPlayerEight.prepareAsync()

            mediaPlayerNine!!.stop()
            //mediaPlayerNine.prepareAsync()

            mediaPlayerSix!!.stop()
            //mediaPlayerSix.prepareAsync()

            loadAds()

            stopButton.isVisible = false
        }
    }

    private fun loadAds() {
        if(mInterstitialAd.isLoaded)
            mInterstitialAd.show()
    }
}
