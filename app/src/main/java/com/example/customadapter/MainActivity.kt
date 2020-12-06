package com.example.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.customadapter.databinding.ActivityMainBinding
import com.example.customadapter.databinding.RowBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    val data1 = arrayOf("데이터1","데이터2","데이터3","데이터4","데이터5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.list1.adapter = adapter1
    }

    val adapter1 = object : BaseAdapter() {
        //항목의 개수를 반환한다.
        override fun getCount(): Int {
            return data1.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        // p1: View? 재사용 가능한 뷴
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            //재사용 가능한  view를 변수에 담는다.
            //안전한 자료형 변환 as? 연산자
            var rowView = p1 as? RowBinding

            if(rowView == null) {
                //rowView = layoutInflater.inflate(R.layout.row, null)
                rowView = RowBinding.inflate(layoutInflater)
            }

            //항목 뷰의 내부에 배치되어 있는 뷰들의 주소값을 가져온다.
            //val text1 = rowView?.findViewById<TextView>(R.id.rowTextView)
            //val btn1 = rowView?.findViewById<Button>(R.id.rowButton1)
            //val btn2 = rowView?.findViewById<Button>(R.id.rowButton2)

            //안전한 호출 ?. 연산자
            /*
            val text1 = rowView.rowTextView
            val btn1 = rowView.rowButton1
            val btn2 = rowView.rowButton2

            text1.text = data1[p0]
            btn1.tag = p0
            btn2.tag = p0

            btn1.setOnClickListener {
                binding.textView.text = "첫 번째 버튼을 눌렀습니다.${it.tag}"
            }
            btn2.setOnClickListener {
                binding.textView.text = "두 번째 버튼을 눌렀습니다.${it.tag}"
            }
            */

            rowView.run{
                rowTextView.text = data1[p0]

                rowButton1.tag = p0
                rowButton2.tag = p0

                rowButton1.setOnClickListener {
                    binding.textView.text = "첫 번째 버튼을 눌렀습니다.${it.tag}"
                }

                rowButton2.setOnClickListener {
                    binding.textView.text = "두 번째 버튼을 눌렀습니다.${it.tag}"
                }
            }

            //return rowView!!
            return rowView.root
        }
    }
}