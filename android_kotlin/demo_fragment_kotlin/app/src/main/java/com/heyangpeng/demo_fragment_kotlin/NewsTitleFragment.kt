package com.heyangpeng.demo_fragment_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_news_title_paid.*

class NewsTitleFragment : Fragment() {
    private var isPaid = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_title_paid, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isPaid = activity?.findViewById<View>(R.id.newsContentLayout) != null
        val layoutManager = LinearLayoutManager(activity)
        recyclerviewTitle.layoutManager = layoutManager
        val adapter = NewsTitlesAdapter(getNews())
        recyclerviewTitle.adapter = adapter
    }

    private fun getNews(): MutableList<News> {
        val news = ArrayList<News>()
        for (i in 1..50) {
//            val new = News("This is new title($i)", getRandomStringName("This is new content($i)"))
            val new = News("This is new title($i)", "This is new content($i)".repeat((5..20).random()))
            news.add(new)
        }
        return news
    }

    inner class NewsTitlesAdapter(private val news: MutableList<News>) :
        RecyclerView.Adapter<NewsTitlesAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val holder = ViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_title_recyclerview_item, parent, false)
            )
            holder.itemView.setOnClickListener {
                val new = news[holder.bindingAdapterPosition]

                if (isPaid) {
                    val fragment = newsContentFragment as NewsContentPaidFragment
                    fragment.refresh(new.title, new.content)
                } else {
                    NewsContentActivity.actionStart(
                        parent.context,
                        new.title,
                        new.content
                    )
                }
            }
            return holder
        }

        override fun getItemCount(): Int = news.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.newsTitle.text = news[position].title
        }
    }

    private fun getRandomLengthName(s: String): String {
        val n = (5..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(s)
        }
        return builder.toString()
    }

    private fun getRandomStringName(s: String): String = s * (5..20).random()
}