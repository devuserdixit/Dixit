package com.example.roomdatabase;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CourseRepository {

    // below line is the create a variable
    // for dao and list for all courses.
    private Dao dao;
    private LiveData<List<CourseModal>> allCourses;

    // creating a method to insert the data to our database.
    public void insert(CourseModal model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }


    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<CourseModal, Void, Void> {
        private Dao dao;

        private InsertCourseAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CourseModal... courseModals) {
            return null;
        }
    }
}
