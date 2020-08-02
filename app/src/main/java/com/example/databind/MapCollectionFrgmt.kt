package com.example.databind

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.fragment.app.Fragment
import com.example.databind.databinding.MapCollectionBinding
import kotlin.concurrent.thread

class MapCollectionFrgmt : Fragment() {

    lateinit var binding : MapCollectionBinding

    val list    = ArrayList<String>()
    val map     = HashMap<String,ObservableField<String>>()
    val data    = Data()

    init {
        data.key = "data key"
        data.key = "data value"

        map.put("key1",ObservableField("value1"))
        map.put("key2",ObservableField("value2"))
        map.put("key3",ObservableField("value3"))
        map.put("key4",ObservableField("value4"))

        list.add("value0")
        list.add("value1")
        list.add("value2")
        list.add("value3")
    }


    fun onDataThreadMainClicked(view: View){
        val random = (Math.random() * 1000).toInt()
        data.key = "新Main key$random"
        data.value = random
        binding.data = data
    }

    fun onDataThreadOtherClicked(view: View){
        thread {
            val random = (Math.random() * 1000).toInt()
            data.key = "新other key$random"
            data.value = random
            binding.data = data
        }
    }

    fun onMap1ThreadMain(v : View){
        val random = (Math.random() * 1000).toInt()
        val ob = ObservableField<String>()
        ob.set("新Main value$random")
        map.put("key1",ob)
        binding.map = map
    }
    fun onMap1ThreadOther(v : View){
        thread {
            val random = (Math.random() * 1000).toInt()
            val ob = ObservableField<String>()
            ob.set("新Main value$random")
            map.put("key1",ob)
            binding.map = map
        }
    }
    fun onList0ThreadMain(v : View){
        val random = (Math.random() * 1000).toInt()
        list[0] = "新Main value$random"
        binding.list = list
    }
    fun onList0ThreadOther(v : View){
        thread {
            val random = (Math.random() * 1000).toInt()
            list[0] = "新Main value$random"
            binding.list = list
        }
    }
    fun initBinding(){
        binding.list = list
        binding.data = data
        binding.map = map

        binding.threadMainData.setOnClickListener(this::onDataThreadMainClicked)
        binding.threadOtherData.setOnClickListener(this::onDataThreadOtherClicked)
        binding.threadMainMap1.setOnClickListener(this::onMap1ThreadMain)
        binding.threadOtherMap1.setOnClickListener(this::onMap1ThreadOther)
        binding.threadMainList0.setOnClickListener(this::onList0ThreadMain)
        binding.threadOtherList0.setOnClickListener(this::onList0ThreadOther)
        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val text: String = getString(R.string.map_title, map.size)
            val styledText: Spanned = Html.fromHtml(text, FROM_HTML_OPTION_USE_CSS_COLORS)
            binding.mapTitle.text = styledText
        }*/
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MapCollectionBinding.inflate(inflater,container,false)
        initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
    }

}