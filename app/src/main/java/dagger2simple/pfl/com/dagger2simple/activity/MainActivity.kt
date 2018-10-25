package dagger2simple.pfl.com.dagger2simple.activity

import android.os.Bundle
import dagger.android.DaggerActivity
import dagger2simple.pfl.com.dagger2simple.R
import dagger2simple.pfl.com.dagger2simple.bean.Persion
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

class MainActivity : DaggerActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    @Inject
    lateinit var persion: Persion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print(persion.toString())

        btnRequest.setOnClickListener {

            var url = "http://www.wanandroid.com/article/list/0/json"

            var request = Request.Builder()
                    .url(url)
                    .get()
                    .build()

            var call = okHttpClient.newCall(request)

            call.enqueue(object : Callback {
                override fun onFailure(call: Call?, e: IOException?) {
                    runOnUiThread {
                        tvResult.text = e!!.message
                    }
                }

                override fun onResponse(call: Call?, response: Response?) {
                    var result = response!!.body()!!.string()
                    runOnUiThread {
                        tvResult.text = result
                    }
                }

            })

        }
    }
}
