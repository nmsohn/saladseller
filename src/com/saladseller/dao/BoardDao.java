package com.saladseller.dao;

import java.util.HashMap;
import java.util.List;

import com.saladseller.model.Board;

/**
 * Created by 5CLASS-184 on 2017-05-31.
 */
public interface BoardDao {
    public int selectCount() throws Exception;
    public int selectCount(HashMap<String, Object> map);
    public List<Board> selectList(int firstRow, int endRow) throws Exception;
    public List<Board> selectList(int firstRow, int endRow, int cat) throws Exception;
    public boolean insert(Board b) throws Exception;
    public Board selectOne(int boardNumber) throws Exception;
    public void increaseViewCount(int boardNumber) throws Exception;
    public boolean update(Board b) throws Exception;
    public boolean delete(int boardNumber) throws Exception;
}
