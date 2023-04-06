package layout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.whatsup.Fragment1
import com.example.whatsup.Fragment2
import com.example.whatsup.Fragment3


//pass constructor from main activity
class WhatsupAdapter(supportFragmentManager: FragmentManager, val tabCount: Int) :
    FragmentPagerAdapter(supportFragmentManager) {
    override fun getCount(): Int {
        return tabCount
    }

//    display fragment class on position
    override fun getItem(position: Int): Fragment {

        when (position) {
            0 -> {
                var f1 = Fragment1()
                return f1

            }
            1 -> {
                var f2 = Fragment2()
                return f2
            }

            2 -> {
                var f3 = Fragment3()
                return f3

            }
            else -> {
                var f1 = Fragment1()
                return f1

            }
        }
    }
}