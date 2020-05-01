package fr.dev.clm

import android.content.Intent
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.dev.clm.AudioOne.AudioOneActivity
import kotlinx.android.synthetic.main.collection_layout_one.*
import android.media.MediaPlayer
import android.net.Uri
import androidx.core.view.isVisible
import fr.dev.clm.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import fr.dev.clm.AudioEight.AudioEightActivity
import fr.dev.clm.AudioFive.AudioFiveActivity
import fr.dev.clm.AudioFour.AudioFourActivity
import fr.dev.clm.AudioMix.AudioMixActivity
import fr.dev.clm.AudioSeven.AudioSevenActivity
import fr.dev.clm.AudioSix.AudioSixActivity
import fr.dev.clm.AudioThree.AudioThreeActivity
import fr.dev.clm.AudioTwo.AudioTwoActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.shareButton
import kotlinx.android.synthetic.main.collection_layout_four.*
import kotlinx.android.synthetic.main.collection_layout_three.*
import kotlinx.android.synthetic.main.collection_layout_two.*


class MainActivity : AppCompatActivity() {

    val isOpen = false

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onBackPressed() {
        super.onBackPressed()
        loadAds()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this,getString(R.string.AdMobAppId))

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId= getString(R.string.AdMobAppInterstitialId)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        myMixButton.isVisible = false
        rateButton.isVisible = false
        shareButton.isVisible = false
        calmZone.isVisible = false
        rateText.isVisible = false
        shareText.isVisible = false

        val url = "http://working-staff.com/relaxSounds/menuSound.mp3"

        val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
            setAudioStreamType(AudioManager.STREAM_MUSIC)
            setDataSource(url)
            prepare()
            start()
        }

        mediaPlayer!!.start()

        categoryOneButton.setOnClickListener {
            val intent = Intent(this, AudioOneActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        catOneImage.setOnClickListener {
            val intent = Intent(this, AudioOneActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        categoryTwoButton.setOnClickListener {
            val intent = Intent(this, AudioTwoActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        catTwoImage.setOnClickListener {
            val intent = Intent(this, AudioTwoActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        categoryThreeButton.setOnClickListener {
            val intent = Intent(this, AudioThreeActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        catThreeImage.setOnClickListener {
            val intent = Intent(this, AudioThreeActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        categoryFourButton.setOnClickListener {
            val intent = Intent(this, AudioFourActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        catFourImage.setOnClickListener {
            val intent = Intent(this, AudioFourActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        thunderStormOption.setOnClickListener {
            val intent = Intent(this, AudioFiveActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        nightRainOption.setOnClickListener {
            val intent = Intent(this, AudioSixActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        nightCityOption.setOnClickListener {
            val intent = Intent(this, AudioSevenActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        cicadasOption.setOnClickListener {
            val intent = Intent(this, AudioEightActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        myMixButton.setOnClickListener {
            val intent = Intent(this, AudioMixActivity::class.java)
            startActivity(intent)
            loadAds()
            mediaPlayer.stop()
        }

        shareButton.setOnClickListener {
            val s = ("Hello! Check this amazing relaxation app: https://play.google.com/store/apps/details?id=com.iuriidolotov.calmee")
            //Intent to share the text
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, s);
            startActivity(Intent.createChooser(shareIntent,"Share via:"))
        }

        rateButton.setOnClickListener {
            val rate = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.iuriidolotov.calmee"))
            startActivity(rate)
        }

        menuButton.setOnClickListener {
            myMixButton.isVisible = true
            rateButton.isVisible = true
            shareButton.isVisible = true
            calmZone.isVisible = true
            rateText.isVisible = true
            shareText.isVisible = true

            loadAds()
        }
    }

    private fun loadAds() {
        if(mInterstitialAd.isLoaded)
            mInterstitialAd.show()
    }
}
