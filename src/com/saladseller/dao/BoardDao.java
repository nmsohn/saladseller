package com.saladseller.dao;

import java.util.HashMap;
import java.util.List;

import com.saladseller.model.Board;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public interface BoardDao {
    public int selectCount() throws Exception;
    public int selectCount(HashMap<String,Object> map);
    public List<Board> selectList(int firstRow, int endRow) throws Exception;
    public int insert(Board boardVO) throws Exception;
    public Board selectOne(int boardNumber) throws Exception;
    public void increaseReadCount(int boardNumber) throws Exception;
    public int update(Board boardVO) throws Exception;
    public int delete(int boardNumber) throws Exception;
}
