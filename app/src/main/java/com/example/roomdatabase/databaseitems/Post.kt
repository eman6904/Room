package com.example.roomdatabase.databaseitems

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")//to convert this class to table each row in table is object of it
data class Post(
 @PrimaryKey(autoGenerate = true)//to determine primary key and make it increment automatically
 val id: Byte,
 val userId: Byte,
 val title: String,
 //@Ignore            ==>to ignore using of this item in table
 val body: String,
)