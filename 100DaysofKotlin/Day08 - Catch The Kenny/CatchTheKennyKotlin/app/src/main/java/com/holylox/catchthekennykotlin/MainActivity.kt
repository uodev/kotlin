package com.holylox.catchthekennykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.holylox.catchthekennykotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    var score = 0
    var imageArray = ArrayList<ImageView>()

    var handler = Handler()
    var runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ImageArray
        imageArray.add(binding.kennyImageView)
        imageArray.add(binding.kennyImageView1)
        imageArray.add(binding.kennyImageView2)
        imageArray.add(binding.kennyImageView3)
        imageArray.add(binding.kennyImageView4)
        imageArray.add(binding.kennyImageView5)
        imageArray.add(binding.kennyImageView6)
        imageArray.add(binding.kennyImageView7)
        imageArray.add(binding.kennyImageView8)

        hideImages()

        object:CountDownTimer(15700,1000)
        {
            override fun onTick(p0: Long) {
                binding.timeTextView.text= "Time: ${p0/1000}"
            }

            override fun onFinish() {
                binding.timeTextView.text="Time: 0"

                handler.removeCallbacks(runnable)

                for (image in imageArray)
                {
                    image.visibility = View.INVISIBLE
                }

                //AlertDialog
                var alert=AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart The Game")
                alert.setPositiveButton("Yes") {dialog,which->
                    //Restart
                    val intent=intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") {dialog,which ->
                    Toast.makeText(this@MainActivity, "Game Over", Toast.LENGTH_SHORT).show()
                }
                alert.show()
            }

        }.start()

    }

    fun hideImages()
    {
        runnable = object:Runnable{
            override fun run() {
                for (image in imageArray)
                {
                    image.visibility = View.INVISIBLE
                }
                val random = (0..8).random()
                imageArray[random].visibility= View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)
    }

    fun increaseScore(view:View)
    {
        score++
        binding.scoreTextView.text = "Score: $score"
    }
}