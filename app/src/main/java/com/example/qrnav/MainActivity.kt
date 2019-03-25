package com.example.qrnav

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Add a different request code for every activity you are starting from here
    private  val  SECOND_ACTIVITY_REQUEST_CODE = 0;

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Start the SecondActivity for result
       var intent =  Intent(this@MainActivity, ScanActivity::class.java)
       startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)

       // button to scan QRcode again
        buttonScanAgain.setOnClickListener(object : View.OnClickListener{
        override fun onClick(v: View?) {
        var intent =  Intent(this@MainActivity, ScanActivity::class.java)
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)

    }
})


   }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                // get String data from Intent
              setImages(data!!.getStringExtra("keyName"))

              }
        }
    }

    fun setImages( location: String)
    {
        if(location=="location_1")
        {
            imageButton1.setOnClickListener(object : View.OnClickListener{

                override fun onClick(v: View?) {
                    // to run video for location 2
                    //var intent2 =Intent(this@MainActivity,ScanActivity::class.java)
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aDFEb_W2t1Y"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.google.android.youtube");
                    startActivity(intent)
                }
            })

            imageButton2.setOnClickListener(object : View.OnClickListener{

                override fun onClick(v: View?) {
                    // to run video for location 3
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/9TLs2Dz95ZA"));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setPackage("com.google.android.youtube");
                    startActivity(intent)
                }
            })
        }

    }




}

