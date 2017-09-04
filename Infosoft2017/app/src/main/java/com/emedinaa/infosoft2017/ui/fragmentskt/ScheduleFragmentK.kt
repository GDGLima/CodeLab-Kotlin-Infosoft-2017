package com.emedinaa.infosoft2017.ui.fragmentskt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emedinaa.infosoft2017.R
import kotlinx.android.synthetic.main.fragment_schedule.*

/**
 * Created by emedinaa on 2/09/17.
 */
class ScheduleFragmentK : Fragment() {

    private var mParam1: String? = null
    private var mParam2: String? = null

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): ScheduleFragmentK {
            var args: Bundle = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)

            var homeFragment: ScheduleFragmentK = newInstance()
            homeFragment.arguments = args
            return homeFragment
        }

        fun newInstance(): ScheduleFragmentK {
            return ScheduleFragmentK()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ui();
    }

    private fun goToActivities(){

    }

    private fun goToWorkshops(){

    }

    private fun ui(){
        cardViewActivities.setOnClickListener{
            goToActivities();
        }
        cardViewWorkshops.setOnClickListener{
            goToWorkshops();
        }
    }
}