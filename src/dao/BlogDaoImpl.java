package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl implements BlogDaoInterface {
	private static final String INSERT_BLOG_SQL = "INSERT INTO BLOG(blogId,blogTitle,blogDescription,postedOn) VALUES (seq_blog.nextval,?,?,?)";
	private static final String SELECT_ALL_BLOGS = " SELECT * FROM BLOG ";
	private static final String DELETE_BLOG_BY_ID = "delete from blog where blogId=?";
	@Override
	public void insertBlog(Blog blog) throws SQLException {
		System.out.println(INSERT_BLOG_SQL);
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT_BLOG_SQL);
	
			ps.setString(1, blog.getBlogTitle());
			ps.setString(2, blog.getBlogDescription());
			ps.setDate(3, java.sql.Date.valueOf(blog.getPostedOn()));
			System.out.println(ps);
			ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Blog selectBlog(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blog> selectAllBlogs() throws IOException {
		Blog blog = null;
		List<Blog> blogList = new ArrayList<>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_BLOGS);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int blogId = rs.getInt(1);
				String blogTitle = rs.getString(2);
				String blogDescription = rs.getString(3);
				LocalDate postedOn = rs.getDate(4).toLocalDate();
				
				blog = new Blog();
				blog.setBlogId(blogId);
				blog.setBlogTitle(blogTitle);
				blog.setBlogDescription(blogDescription);
				blog.setPostedOn(postedOn);
				
				blogList.add(blog);
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		return blogList;
	}

	@Override
	public boolean deleteBlog(int id) throws SQLException {
		System.out.println(id);
		boolean rowDeleted = false;
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE_BLOG_BY_ID);
			ps.setInt(1, id);
			System.out.println(ps);
			rowDeleted = ps.executeUpdate() > 0;
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return rowDeleted;
	}

	@Override
	public boolean UpdateBlog(Blog blog) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
