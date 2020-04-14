package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Blog;

public interface BlogDaoInterface {
	void insertBlog(Blog blog) throws SQLException;
	Blog selectBlog(int blogId);
	List<Blog> selectAllBlogs() throws IOException;
	boolean deleteBlog(int id) throws SQLException;
	boolean UpdateBlog(Blog blog) throws SQLException, Exception;
	

}
