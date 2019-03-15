package com.example.memorama


import android.view.LayoutInflater
import android.view.View
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import android.os.Handler
import android.widget.TextView
import com.example.games.R
import kotlinx.android.synthetic.main.renglon.view.*

class MemoramaAdapter(val chips: ArrayList<Chip>, val keys: HashMap<Int,String>):


    RecyclerView.Adapter<MemoramaAdapter.ChipViewHolder>(){

    private lateinit var mHandler: Handler
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ChipViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.renglon, p0, false)
        mHandler = Handler()
        return ChipViewHolder(view)

    }


    var pushedButtons: MutableList<Int> = mutableListOf<Int>()
    var score=0
    override fun getItemCount(): Int {
        return  chips.size
    }

    override fun onBindViewHolder(p0: ChipViewHolder, p1: Int) {
        p0.imageView.setImageResource(chips[p1].idImage)
        p0.imageView.id=(chips[p1].pos)
    }

    var select1: ImageView? = null
    var select2: ImageView? = null

    fun playIntent(item: ImageView){

        if(select1==null){
            select1=item
        }else if(select2==null){
            select2=item
        }


    }

    fun checkPair(item:View) {
        if(select1!=null &&select2 != null){
            if(keys[select1!!.id] == keys[select2!!.id]){
                score++
                println(score)
                pushedButtons.add(select2!!.id)
                pushedButtons.add(select1!!.id)
                select1 = null
                select2 = null
                if(score==8){
                    Toast.makeText(item.context,
                        "GANASTE", Toast.LENGTH_LONG).show()
                }
            }else {
                Handler().postDelayed({
                    select1!!.setImageResource(R.mipmap.ic_launcher)
                    select2!!.setImageResource(R.mipmap.ic_launcher)
                    select1 = null
                    select2 = null
                },500)
            }

        }

    }

    inner class ChipViewHolder(item : View) : RecyclerView.ViewHolder(item){
        val imageView = item.findViewById<ImageView>(R.id.chip)

        init {
            item.setOnClickListener {
                if(imageView.id !in pushedButtons) {
                    when (keys[imageView.id]) {
                        "batman" -> {
                            imageView.setImageResource(R.drawable.batman)
                            playIntent(imageView)
                        }
                        "bobesponja" -> {
                            imageView.setImageResource(R.drawable.bobsponja)
                            playIntent(imageView)
                        }
                        "gofast" -> {
                            imageView.setImageResource(R.drawable.gofast)
                            playIntent(imageView)
                        }
                        "kirby" -> {
                            imageView.setImageResource(R.drawable.kirby)
                            playIntent(imageView)
                        }
                        "marciano" -> {
                            imageView.setImageResource(R.drawable.marciano)
                            playIntent(imageView)
                        }
                        "polite" -> {
                            imageView.setImageResource(R.drawable.polite)
                            playIntent(imageView)
                        }
                        "rocket" -> {
                            imageView.setImageResource(R.drawable.rocket)
                            playIntent(imageView)
                        }
                        "space" -> {
                            imageView.setImageResource(R.drawable.space)
                            playIntent(imageView)
                        }
                    }
                }
                checkPair(item)
            }
        }
    }

}
