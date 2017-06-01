package com.saladseller.dao;


import com.saladseller.model.Board;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public class BoardDaoImpl implements BoardDao{
    @Override
    public int selectCount() throws Exception {
        return 0;
    }

    @Override
    public int selectCount(HashMap<String, Object> map) {
        return 0;
    }

    @Override
    public List<Board> selectList(int firstRow, int endRow) throws Exception {
        return null;
    }

    @Override
    public int insert(Board boardVO) throws Exception {
        return 0;
    }

    @Override
    public Board selectOne(int boardNumber) throws Exception {
        return null;
    }

    @Override
    public void increaseReadCount(int boardNumber) throws Exception {

    }

    @Override
    public int update(Board boardVO) throws Exception {
        return 0;
    }

    @Override
    public int delete(int boardNumber) throws Exception {
        return 0;
    }
}
