package com.example.androidasignment2.models.view

import android.os.Bundle
import android.util.Log
import android.view.InputQueue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidasignment2.R
import com.example.androidasignment2.models.SingsList
import com.example.androidasignment2.models.SingsModel
import com.example.androidasignment2.models.remote.SingsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SingsListFragment (var p_Term: String,
                         var p_Media : String,
                         var p_Entity : String,
                         var p_Limit: String
                         ):Fragment() {
    private lateinit var sings_List:RecyclerView
    private lateinit var adapter : SingsAdapter
    private val TAG = "SingsListFragment"
private lateinit var swipeRefreshLayout : SwipeRefreshLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.list_sing_layout_fragment,
            container,
            false
        )
        initViews(view)
        getSings(
            p_Term,
            p_Media,
            p_Entity ,
            p_Limit

        )
        return view
    }

    private fun getSings(
        ps_Term: String,
        ps_Media : String,
        ps_Entity : String,
        ps_Limit: String
    ) {
        SingsService.initRetrofit().getSings(
            ps_Term,
            ps_Media,
            ps_Entity ,
            ps_Limit
        )
            .enqueue(
                object : Callback<SingsList>{
                    override fun onResponse(call: retrofit2.Call<SingsList>,
                                            response: Response<SingsList>) {
                        Log.d(TAG, "onResponse: $response")
                        if(response.isSuccessful)
                        {
                            updateAdapter(response.body())
                        }else{
                            showError(response.message())
                        }
                        swipeRefreshLayout.isRefreshing=false
                    }

                    override fun onFailure(
                        call: Call<SingsList>,
                        t: Throwable) {
                        Log.d(TAG, "onFailure: $t")
                        showError(t.message?:"Unknown Error")
                    }

                }
            )
    }

    private fun updateAdapter(body: SingsList?) {
body?.let{
    adapter= SingsAdapter(it){
        singDetail-> activity?.openSingDetail(singDetail)
        swipeRefreshLayout.isRefreshing=false
    }
        sings_List.adapter=adapter
    swipeRefreshLayout.isRefreshing=false
    }?:showError("No Response from Server")
    }



private fun FragmentActivity.openSingDetail(singDetail : SingsModel)
{
    supportFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(android.R.id.content,
       SingsDetailFragment.newInstance(singDetail)).commit()
}
    private fun showError(message: String) {

    }
    private fun initViews(view: View) {
        sings_List=view.findViewById(R.id.rv_singslist)
        sings_List.layoutManager=GridLayoutManager(context, 1)

        swipeRefreshLayout = view.findViewById(R.id.swype_main)
        swipeRefreshLayout.setOnRefreshListener{
            getSings(
                p_Term,
                p_Media,
                p_Entity ,
                p_Limit

            )
        }
    }
}