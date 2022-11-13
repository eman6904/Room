package com.example.roomdatabase.databaseitems

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.databaseitems.Post
import io.reactivex.Completable
import io.reactivex.Single

@Dao
public interface PostDao {
    @Insert
    fun insert(post: Post):Completable
    @Query("select * from posts_table")//to return all posts in table==(note)-->each row in table is post
    fun getPosts():Single<List<Post>>
}