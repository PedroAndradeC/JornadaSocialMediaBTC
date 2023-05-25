package com.beyondthecode.database;

import com.beyondthecode.entities.Post;
import com.beyondthecode.entities.User;

import java.util.ArrayList;

public abstract class DatabaseMemo {
  public static ArrayList<User> userArrayList = new ArrayList<User>();

  public static ArrayList<Post> postArrayList = new ArrayList<Post>();
}
