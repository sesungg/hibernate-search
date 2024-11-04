package com.search.service;

import com.search.entity.Newsroom;
import com.search.repository.NewsroomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SearchServiceTest {

    @Autowired
    private NewsroomRepository newsroomRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SearchService searchService;

    @BeforeEach
    void create() throws InterruptedException {
        Newsroom newsroom = new Newsroom();
                newsroom.setTitle("5월 14일 (월) 뉴스룸 다시보기 2부");
//        newsroom.setTitle("testttt");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634630");
                newsroom.setContent("뉴스룸의 앵커브리핑을 시작하겠습니다.소리가 없는 것은 차라리 다행이었습니다.38년 만에 소개된 미공개 영상.흑백의 화면만이 남아있을 뿐.음향이 담겨있지 않은 그 영상 속에는 모진 그날을 견뎌낸 5월, 광주의");
//        newsroom.setContent("test");
        newsroomRepository.save(newsroom);

        newsroom = new Newsroom();
                newsroom.setTitle("[팩트체크] 풍계리 핵실험장 폭파하면 방사능 유출?");
//        newsroom.setTitle("fastffff");
        newsroom.setLink("http://news.jtbc.joins.com/article/article.aspx?news_id=NB11634587");
                newsroom.setContent("[조선중앙TV (지난 12일) : 핵시험장 폐기를 투명성 있게 보여주기 위하여 국내 언론기관들은 물론 국제기자단의 현지 취재활동을 허용할 용의가 있다. 중국, 러시아, 미국, 영국, 남조선에서 오는 기자들로 한정시");
//        newsroom.setContent("fastfastfastfast");
        newsroomRepository.save(newsroom);
    }

    @Test
    void searchNewsroomTest() throws InterruptedException {

        searchService.buildSearchIndex();

        String keyword = "음향";

        List<Newsroom> newsrooms = searchService.searchNewsroom(keyword);

        System.out.println("newsrooms = " + newsrooms.size());
        for (Newsroom news : newsrooms) {
            System.out.println("news = " + news);
        }
    }

}