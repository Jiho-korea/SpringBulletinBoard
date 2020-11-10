package springBulletinBoard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springBulletinBoard.vo.BoardRequest;
import springBulletinBoard.vo.Post;

public class PostDAO {
	private JdbcTemplate jdbcTemplate;

	public PostDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public boolean nextPage(int pageNumber) {
		List<Post> results = jdbcTemplate.query(
				"SELECT POST_NO, TITLE, SID, POSTINGDATE, CONTENT, AVAILABLE FROM post WHERE AVAILABLE = 1 ORDER BY POST_NO DESC LIMIT 10 OFFSET ?",
				new RowMapper<Post>() {
					@Override
					public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
						Post post = new Post();
						post.setPostNo(rs.getInt("POST_NO"));
						post.setTitle(rs.getString("TITLE"));
						post.setSid(rs.getInt("SID"));
						post.setPostingdate(rs.getString("POSTINGDATE"));
						post.setContent(rs.getString("CONTENT"));
						post.setAvailable(rs.getInt("AVAILABLE"));
						return post;
					}
				}, pageNumber);

		return results.isEmpty() ? false : true;
	}

	public List<Post> listPost(BoardRequest boardRequest) { // date_format(POSTINGDATE,'%Y-%m-%d') as
		List<Post> results = jdbcTemplate.query(
				"SELECT POST_NO, TITLE, SID, POSTINGDATE, CONTENT, AVAILABLE FROM post WHERE AVAILABLE = 1 ORDER BY POST_NO DESC LIMIT 10 OFFSET ?",
				new RowMapper<Post>() {
					@Override
					public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
						Post post = new Post();
						post.setPostNo(rs.getInt("POST_NO"));
						post.setTitle(rs.getString("TITLE"));
						post.setSid(rs.getInt("SID"));
						post.setPostingdate(rs.getString("POSTINGDATE"));
						post.setContent(rs.getString("CONTENT"));
						post.setAvailable(rs.getInt("AVAILABLE"));
						return post;
					}
				}, boardRequest.getPageNumber());

		return results;
	}
//
////댓글까지 포함된 게시글 정보 받아온다.
//	public Post selectPostInfo(Post pPost) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		Post post = null;
//		try {
//			post = sqlSession.selectOne("org.mybatis.persistence.PostMapper.infoPost", pPost);
//			return post;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return post;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	public Post selectPost(Post pPost) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		Post post = null;
//		try {
//			post = sqlSession.selectOne("org.mybatis.persistence.PostMapper.selectPost", pPost);
//			return post;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return post;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	public int deletePost(Post pPost) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		int success = 0;
//		try {
//			success = sqlSession.delete("org.mybatis.persistence.PostMapper.deletePost", pPost);
//			sqlSession.commit();
//			return success;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return success;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	// title , content, post_no
//	public int updatePost(Post pPost) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		int success = 0;
//		try {
//			success = sqlSession.update("org.mybatis.persistence.PostMapper.updatePost", pPost);
//			sqlSession.commit();
//			return success;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return success;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	public int getPostNo() {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		int postNo = 0;
//		try {
//			postNo = sqlSession.selectOne("org.mybatis.persistence.PostMapper.selectMaxPostNo");
//			return postNo;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return postNo;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	// postNo , title, sid , content
//	public int insertPost(Post pPost) {
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		int success = 0;
//		try {
//			success = sqlSession.insert("org.mybatis.persistence.PostMapper.insertPost", pPost);
//			sqlSession.commit();
//			return success;
//		} catch (Exception e) {
//			e.printStackTrace();
//			sqlSession.rollback();
//			return success;
//		} finally {
//			sqlSession.close();
//		}
//	}

}
