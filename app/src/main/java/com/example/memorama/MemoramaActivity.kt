package com.example.memorama

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.GridLayoutManager
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama2.*

class MemoramaActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama2)
        val rv = recyclerView1
        rv.setHasFixedSize(true)
        var grid = GridLayoutManager(this, 4)
        rv.layoutManager = grid
        val memoramaKeys:HashMap<Int,String> = HashMap<Int,String>()
        val used:HashMap<String,Int> = HashMap<String,Int>()
        used.put("batman",2)
        used.put("bobesponja",2)
        used.put("gofast",2)
        used.put("kirby",2)
        used.put("marciano",2)
        used.put("polite",2)
        used.put("rocket",2)
        used.put("cohete",2)
        used.put("space",2)
        val chips = ArrayList<Chip>()
        var i=0
        loop@ while( i  < 16) {
            val rnd = (0..7).random()

            when(rnd){
                0->{
                    val temp=used["batman"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("batman",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "batman"))
                    memoramaKeys[i] = "batman"
                }
                1->{
                    val temp=used["bobesponja"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("bobesponja",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "bobesponja"))
                    memoramaKeys[i] = "bobesponja"
                }
                2->{
                    val temp=used["gofast"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("gofast",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "gofast"))
                    memoramaKeys[i] = "gofast"
                }
                3->{
                    val temp=used["kirby"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("kirby",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "kirby"))
                    memoramaKeys[i] = "kirby"
                }
                4->{
                    val temp=used["marciano"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("marciano",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "marciano"))
                    memoramaKeys[i] = "marciano"
                }
                5->{
                    val temp=used["polite"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("polite",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "polite"))
                    memoramaKeys[i] = "polite"
                }
                6->{
                    val temp=used["rocket"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("rocket",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "rocket"))
                    memoramaKeys[i] = "rocket"
                }
                7 ->{
                    val temp=used["space"]
                    if(temp==0){
                        continue@loop
                    }
                    if (temp != null) {
                        used.replace("space",temp-1)
                    }
                    chips.add(Chip(R.mipmap.ic_launcher, i, "space"))
                    memoramaKeys[i] = "space"
                }
            }
            i++
        }

        var  adapter = MemoramaAdapter(chips, memoramaKeys)
        rv.adapter = adapter

    }
}
