package com.heyangpeng.menu_demo

import android.content.ClipData
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    private var isRefresh: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item_fragment -> {
                isRefresh = true
                activity?.invalidateOptionsMenu()
                Toast.makeText(context, "REFRESH_FRAGMENT", Toast.LENGTH_SHORT).show()
            }
            R.id.remove_item_fragment -> Toast.makeText(
                context,
                "REMOVE_FRAGMENT",
                Toast.LENGTH_SHORT
            ).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.add_item_fragment)
        if (isRefresh) item.title = "REFRESHED_FRAGMENT"
    }
}