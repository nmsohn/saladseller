package com.saladseller.service;

import com.saladseller.dao.BoardDaoImpl;
import com.saladseller.model.Board;

import java.util.List;

/**
 * Created by 5CLASS-184 on 2017-06-02.
 */
public class BoardService {
    //Singleton Pattern

    private BoardDaoImpl dao;
    private static BoardService instance;
    private BoardService(){dao = BoardDaoImpl.getInstance();}

    public static BoardService getInstance() {
        if (instance == null) {
            instance = new BoardService();
        }
        return instance;
    }

    public void addPost(Board b)  throws Exception{
        dao.insert(b);
    }
    public void deletePost(int b_id)  throws Exception{
        dao.delete(b_id);
    }
    public Board retrievePost(int b_id)  throws Exception{
        return dao.selectOne(b_id);
    }

    public List<Board> list(int firstRow,int endRow)  throws Exception{
        return dao.selectList(firstRow,endRow);
    }
    public void updatePost(Board b) throws Exception{
        dao.update(b);
    }
}
