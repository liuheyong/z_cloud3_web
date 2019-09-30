package com.cloud3.web.elasticsearchrepository;

import com.cloud3.commons.dto.GoodsInfo;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author: LiuHeYong
 * @create: 2019-06-20
 * @description:
 **/
@Component
public class GoodsRepository implements ElasticsearchRepository<GoodsInfo,Long> {
    @Override
    public <S extends GoodsInfo> S index(S s) {
        return null;
    }

    @Override
    public Iterable<GoodsInfo> search(QueryBuilder queryBuilder) {
        return null;
    }

    @Override
    public Page<GoodsInfo> search(QueryBuilder queryBuilder, Pageable pageable) {
        return null;
    }

    @Override
    public Page<GoodsInfo> search(SearchQuery searchQuery) {
        return null;
    }

    @Override
    public Page<GoodsInfo> searchSimilar(GoodsInfo goodsInfo, String[] strings, Pageable pageable) {
        return null;
    }

    @Override
    public void refresh() {

    }

    @Override
    public Class<GoodsInfo> getEntityClass() {
        return null;
    }

    @Override
    public Iterable<GoodsInfo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<GoodsInfo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends GoodsInfo> S save(S s) {
        return null;
    }

    @Override
    public <S extends GoodsInfo> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<GoodsInfo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<GoodsInfo> findAll() {
        return null;
    }

    @Override
    public Iterable<GoodsInfo> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(GoodsInfo goodsInfo) {

    }

    @Override
    public void deleteAll(Iterable<? extends GoodsInfo> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
