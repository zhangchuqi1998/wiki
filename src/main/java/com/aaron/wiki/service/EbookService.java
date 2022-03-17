package com.aaron.wiki.service;

import com.aaron.wiki.domain.Ebook;
import com.aaron.wiki.domain.EbookExample;
import com.aaron.wiki.mapper.EbookMapper;
import com.aaron.wiki.req.EbookReq;
import com.aaron.wiki.resp.EbookResp;
import com.aaron.wiki.utils.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    private static final Logger LOG = LoggerFactory.getLogger(EbookService.class);

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%"+ req.getName() + "%");
        }
        PageHelper.startPage(1,3);
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("Total rows: {}", pageInfo.getTotal());;
        LOG.info("Total pages: {}", pageInfo.getPages());;


        return list;
    }
}
