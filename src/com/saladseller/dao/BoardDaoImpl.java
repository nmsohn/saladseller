package com.saladseller.dao;


import com.saladseller.model.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.Date;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public class BoardDaoImpl implements BoardDao{

    //Singleton Pattern
    private static BoardDaoImpl instance = new BoardDaoImpl();

    private BoardDaoImpl(){}
    public static BoardDaoImpl getInstance(){
        if(instance != null){
            instance = new BoardDaoImpl();
        }
        return instance;
    }

    //count all posts from the board
    @Override
    public int selectCount() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) from board";
        int num =0;
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                num= rs.getInt(1);
            }
        }finally {
            ConnectionCloser.close(conn,ps,rs);
        }
        return num;
    }

    @Override
    public int selectCount(HashMap<String, Object> map) {
        return 0;
    }

    //fetch posts from first row to end row
    @Override
    public List<Board> selectList(int firstRow, int endRow) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from board ORDER BY b_num DESC LIMIT ?, ?)";
        List<Board> list = new ArrayList<>();
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,firstRow-1);
            ps.setInt(2,endRow-firstRow+1);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("b_num");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Date genDate = rs.getDate("genDate");
                int viewCount = rs.getInt("viewCount");
                String spec = rs.getString("spec");
                String imgPath = rs.getString("imgPath");
                int cat = rs.getInt("c_id");
                list.add(new Board(id,title,content,genDate,viewCount,spec,imgPath,cat));
            }
        }finally {
            ConnectionCloser.close(conn,ps,rs);
        }
        return list;
    }

    //fetch posts with category specified
    @Override
    public List<Board> selectList(int firstRow, int endRow, int cat) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from board where c_id= ? ORDER BY b_num DESC LIMIT ?, ?)";
        List<Board> list = new ArrayList<>();
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cat);
            ps.setInt(2,firstRow-1);
            ps.setInt(3,endRow-firstRow+1);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("b_num");
                String title = rs.getString("title");
                String content = rs.getString("content");
                Date genDate = rs.getDate("genDate");
                int viewCount = rs.getInt("viewCount");
                String spec = rs.getString("spec");
                String imgPath = rs.getString("imgPath");
                list.add(new Board(id,title,content,genDate,viewCount,spec,imgPath,cat));
            }
        }finally {
            ConnectionCloser.close(conn,ps,rs);
        }
        return list;
    }

    //create posts
    @Override
    public boolean insert(Board b) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into Board (title, content, genDate, viewCount, spec, imgPath, cat_id) "+
            "values(?,?,?,?,?,?,?)";
        boolean ok = false;
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getContent());
            ps.setDate(3,b.getGenDate());
            ps.setInt(4,b.getViewCount());
            ps.setString(5,b.getSpec());
            ps.setString(6,b.getImgPath());
            ps.setInt(7,b.getCat());
            int i = ps.executeUpdate();
            if(i>0){
                ok = true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }
    //update posts
    @Override
    public boolean update(Board b) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update board set title=?, content=?, genDate =?,viewCount=?,spec=?,imgPath=? c_id=? where b_num=?";
        boolean ok = false;
        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,b.getTitle());
            ps.setString(2,b.getContent());
            ps.setDate(3,b.getGenDate());
            ps.setInt(4,b.getViewCount());
            ps.setString(5,b.getSpec());
            ps.setString(6,b.getImgPath());
            ps.setInt(7,b.getCat());
            ps.setInt(8,b.getB_num());
            int i = ps.executeUpdate();
            if(i>0){
                ok = true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }
    //delete posts
    @Override
    public boolean delete(int boardNumber) throws Exception {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement ps =null;
        String sql = "delete * from board where b_num=?";
        try {
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, boardNumber);
            int i = ps.executeUpdate();
            if(i>0){
                ok=true;
            }
        }finally {
            ConnectionCloser.close(conn,ps);
        }
        return ok;
    }

    //select one of posts
    @Override
    public Board selectOne(int boardNumber) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from category where b_num=?";
        Board b = new Board();

        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,boardNumber);
            rs = ps.executeQuery();
            if(rs.next()){
                b.setB_num(rs.getInt("b_num"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setGenDate(rs.getDate("genDate"));
                b.setViewCount(rs.getInt("viewCount"));
                b.setSpec(rs.getString("spec"));
                b.setImgPath(rs.getString("imgPath"));
                b.setCat(rs.getInt("c_id"));
            }
        }finally {
            ConnectionCloser.close(conn,ps,rs);
        }

        return b;
    }

    //increase view count
    @Override
    public void increaseViewCount(int boardNumber) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "update board set viewCount = viewCount+1 where b_num = ?";


        try{
            conn = ConnectionProvider.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,boardNumber);
            ps.executeUpdate();

            }finally {
            ConnectionCloser.close(conn,ps);
        }

    }

}
