package com.example.demo.src.board;

import com.example.demo.config.BaseException;
import com.example.demo.src.board.model.GetPostRes;
import com.example.demo.utils.JwtService;
import com.example.demo.utils.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class BoardProvider {
    private final BoardDao boardDao;
    private final JwtService jwtService;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BoardProvider(BoardDao boardDao, JwtService jwtService) {
        this.boardDao = boardDao;
        this.jwtService = jwtService;
    }

    /*public List<GetPostRes> getPosts(Pagination pagination) throws BaseException {
        try {
            List<GetPostRes> getPostRes = boardDao.getPosts(pagination);
            return getPostRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }*/

    public List<GetPostRes> getPosts() {
            List<GetPostRes> getPostRes = boardDao.getPosts();
            return getPostRes;
    }

    public List<GetPostRes> getPostByWriter(String writer) throws BaseException {
        try {

            List<GetPostRes> getPostRes = boardDao.getPostsByWriter(writer);
            return getPostRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
