package model;
 
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
 
import dao.Access;
import dao.database;
import dto.Course;
 
@SuppressWarnings("unused")
public class AccessManager
{
public ArrayList<Course> getCourses() throws Exception
{
ArrayList<Course> courseList = new ArrayList<Course>();
database db = new database();
Connection con = db.getConnection();
Access access = new Access();
courseList = access.getCourses(con);
return courseList;
}
}