package com.example.keep_the_bucket

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home_my_list.*

class HomeShareListFragment : Fragment(R.layout.fragment_home_share_list) {

//    lateinit var homeShareListAdapter: HomeShareListAdapter
//    val datas = mutableListOf<HomeShareListData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_share_list, container, false)
        val spinner : Spinner = view.findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.itemList,
            R.layout.spinner_list
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(R.layout.spinner_list)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        val spring_mission : LinearLayout = view.findViewById(R.id.spring_mission)
        val summer_mission : LinearLayout = view.findViewById(R.id.summer_mission)
        val autumn_mission : LinearLayout = view.findViewById(R.id.autumn_mission)
        val winter_mission : LinearLayout = view.findViewById(R.id.winter_mission)

        spring_mission.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext(),  R.style.MyAlertDialogStyle)
            val dialogView = layoutInflater.inflate(R.layout.spring_mission, null)

            builder.setView(dialogView).setNegativeButton("OK") { dialogInterface, i ->
                /* 취소일 때 아무 액션이 없으므로 빈칸 */
            }.show()
        }

        summer_mission.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext(),  R.style.MyAlertDialogStyle)
            val dialogView = layoutInflater.inflate(R.layout.summer_mission, null)

            builder.setView(dialogView).setNegativeButton("OK") { dialogInterface, i ->
                /* 취소일 때 아무 액션이 없으므로 빈칸 */
            }.show()
        }

        autumn_mission.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext(),  R.style.MyAlertDialogStyle)
            val dialogView = layoutInflater.inflate(R.layout.autumn_mission, null)

            builder.setView(dialogView).setNegativeButton("OK") { dialogInterface, i ->
                /* 취소일 때 아무 액션이 없으므로 빈칸 */
            }.show()
        }

        winter_mission.setOnClickListener{
            val builder = AlertDialog.Builder(requireContext(),  R.style.MyAlertDialogStyle)
            val dialogView = layoutInflater.inflate(R.layout.winter_mission, null)

            builder.setView(dialogView).setNegativeButton("OK") { dialogInterface, i ->
                /* 취소일 때 아무 액션이 없으므로 빈칸 */
            }.show()
        }

        return view
    }


}