package org.caesar.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.caesar.mapper.SearchHistoryMapper;
import org.caesar.model.MsHistoryStruct;
import org.caesar.model.entity.SearchHistory;
import org.caesar.model.po.SearchHistoryPO;
import org.caesar.repository.SearchHistoryRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SearchHistoryRepositoryImpl extends ServiceImpl<SearchHistoryMapper, SearchHistoryPO> implements SearchHistoryRepository {

    @Resource
    private MsHistoryStruct historyStruct;

    @Override
    public List<SearchHistory> getSearchHistory(long userId, int size) {

        QueryWrapper<SearchHistoryPO> queryWrapper = new QueryWrapper<>();

        queryWrapper.select(SearchHistoryPO.CamelFields.content, SearchHistoryPO.CamelFields.dataSource)
                .eq(SearchHistoryPO.CamelFields.userId, userId)
                .orderByDesc(SearchHistoryPO.CamelFields.searchTime);

        return loadSearchHistory(baseMapper.selectList(queryWrapper));
    }

    private List<SearchHistory> loadSearchHistory(List<SearchHistoryPO> searchHistoryPOList) {
        return searchHistoryPOList.stream().map(historyStruct::POtoDO).collect(Collectors.toList());
    }
}
