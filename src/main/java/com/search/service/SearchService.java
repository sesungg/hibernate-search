package com.search.service;

import com.search.entity.Newsroom;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void buildSearchIndex() throws InterruptedException {
        SearchSession searchSession = Search.session(em);
        MassIndexer indexer = searchSession.massIndexer()
                .threadsToLoadObjects(7);
        indexer.startAndWait();
    }

    public List<Newsroom> searchNewsroom(String keyword) {
        SearchSession searchSession = Search.session(em);
        SearchResult<Newsroom> result = searchSession.search(Newsroom.class)
                .where(f -> f.match()
                        .field("content")
                        .matching(keyword))
                .fetchAll();

        return result.hits();
    }
}
