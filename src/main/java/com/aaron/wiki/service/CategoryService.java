package com.aaron.wiki.service;

import com.aaron.wiki.domain.Category;
import com.aaron.wiki.domain.CategoryExample;
import com.aaron.wiki.mapper.CategoryMapper;
import com.aaron.wiki.req.CategoryQueryReq;
import com.aaron.wiki.req.CategorySaveReq;
import com.aaron.wiki.resp.CategoryQueryResp;
import com.aaron.wiki.resp.PageResp;
import com.aaron.wiki.utils.CopyUtil;
import com.aaron.wiki.utils.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private SnowFlake snowFlake;

    public PageResp<CategoryQueryResp> list(CategoryQueryReq req) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        PageHelper.startPage(req.getPage(), req.getSize());
        List<Category> categoryList = categoryMapper.selectByExample(categoryExample);

        PageInfo<Category> pageInfo = new PageInfo<>(categoryList);
        LOG.info("总行数：{}", pageInfo.getTotal());
        LOG.info("总页数：{}", pageInfo.getPages());

        // List<CategoryResp> respList = new ArrayList<>();
        // for (Category category : categoryList) {
        //     // CategoryResp categoryResp = new CategoryResp();
        //     // BeanUtils.copyProperties(category, categoryResp);
        //     // 对象复制
        //     CategoryResp categoryResp = CopyUtil.copy(category, CategoryResp.class);
        //
        //     respList.add(categoryResp);
        // }

        // 列表复制
        List<CategoryQueryResp> list = CopyUtil.copyList(categoryList, CategoryQueryResp.class);

        PageResp<CategoryQueryResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
    }

    /**
     * 保存
     */
    public void save(CategorySaveReq req) {
        Category category = CopyUtil.copy(req, Category.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            category.setId(snowFlake.nextId());
            categoryMapper.insert(category);
        } else {
            categoryMapper.updateByPrimaryKey(category);
        }
    }

    public void delete(long id) {
        categoryMapper.deleteByPrimaryKey(id);
    }
}
