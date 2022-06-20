package com.example.keep_the_bucket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    var fbAuth : FirebaseAuth? = null
    var fbFirestore : FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val bucketListFragment = BucketListFragment()
        val usersFragment = UsersFragment()
        val profileFragment = ProfileFragment()

        replaceFragment(homeFragment)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.bucket_list -> replaceFragment(bucketListFragment)
                R.id.users -> replaceFragment(usersFragment)
                R.id.setting -> replaceFragment(profileFragment)
            }
            true
        }

        fbAuth = FirebaseAuth.getInstance()
        fbFirestore = FirebaseFirestore.getInstance()

        if(true)
        {
            var userInfo = UserModel()

            userInfo.uid = fbAuth?.uid
            userInfo.userId = fbAuth?.currentUser?.email
            fbFirestore?.collection("users")?.document(fbAuth?.uid.toString())?.set(userInfo)
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        // 현 Activity 에 연결된 Fragment 관리하는 supportFragmentManager 를 통해 Fragment 전환
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}