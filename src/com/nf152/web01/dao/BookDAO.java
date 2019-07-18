package com.nf152.web01.dao;

import com.nf152.web01.bean.Book;
import com.nf152.web01.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> list() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select * from book");

            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPublisher(rs.getString(4));
                book.setPrice(rs.getDouble(5));
                book.setAmount(rs.getInt(6));
                book.setPublishAt(rs.getString(7));
                books.add(book);
            }
            return books;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("查找书籍出错");
        } finally {
            DBUtil.close(conn, st, rs);
        }
    }

    public int delete(int id) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement("delete from book where id = ?");
            st.setInt(1, id);
            return st.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("删除失败");
        } finally {
            DBUtil.close(conn, st, null);
        }
    }

    public Book save(Book book) {
        return null;
    }

    public int execute(String sql) {
        return 0;
    }
}
