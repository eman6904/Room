package com.example.roomdatabase.databaseitems

import android.content.Context
import com.example.roomdatabase.adapter.PostsAdapter
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


 class DatabaseFunctions(context: Context) {

     val postsDatabase = PostsDatabase.getDatabase(context)

    fun insertData(title: String, body: String) {
        postsDatabase.postDao().insert(Post(2, 12, title, body))
            .subscribeOn(Schedulers.computation())
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {}
                override fun onComplete() {}
                override fun onError(e: Throwable) {}
            })
    }

    fun getData(): PostsAdapter {

        lateinit var adapter: PostsAdapter
        postsDatabase.postDao().getPosts()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<Post>> {
                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {}
                override fun onSuccess(posts: List<Post>) {
                    adapter.setPosts(posts)
                    adapter.notifyDataSetChanged()
                }
            })
        return adapter
    }
}