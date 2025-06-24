package com.ruoyi.prod.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.prod.mapper.ProdTaskMapper;
import com.ruoyi.prod.domain.ProdTask;
import com.ruoyi.prod.service.IProdTaskService;

/**
 * 生产任务Service业务层处理
 * 
 * @author luojiwei
 * @date 2025-06-21
 */
@Service
public class ProdTaskServiceImpl implements IProdTaskService 
{
    @Autowired
    private ProdTaskMapper prodTaskMapper;

    /**
     * 查询生产任务
     * 
     * @param taskId 生产任务主键
     * @return 生产任务
     */
    @Override
    public ProdTask selectProdTaskByTaskId(Long taskId)
    {
        return prodTaskMapper.selectProdTaskByTaskId(taskId);
    }

    /**
     * 查询生产任务列表
     * 
     * @param prodTask 生产任务
     * @return 生产任务
     */
    @Override
    public List<ProdTask> selectProdTaskList(ProdTask prodTask)
    {
        return prodTaskMapper.selectProdTaskList(prodTask);
    }

    /**
     * 新增生产任务
     * 
     * @param prodTask 生产任务
     * @return 结果
     */
    @Override
    public int insertProdTask(ProdTask prodTask)
    {
        prodTask.setCreateBy(SecurityUtils.getUsername());
        prodTask.setCreateTime(DateUtils.getNowDate());
        return prodTaskMapper.insertProdTask(prodTask);
    }

    /**
     * 修改生产任务
     * 
     * @param prodTask 生产任务
     * @return 结果
     */
    @Override
    public int updateProdTask(ProdTask prodTask)
    {
        prodTask.setUpdateBy(SecurityUtils.getUsername());
        prodTask.setUpdateTime(DateUtils.getNowDate());
        return prodTaskMapper.updateProdTask(prodTask);
    }

    /**
     * 批量删除生产任务
     * 
     * @param taskIds 需要删除的生产任务主键
     * @return 结果
     */
    @Override
    public int deleteProdTaskByTaskIds(Long[] taskIds)
    {
        return prodTaskMapper.deleteProdTaskByTaskIds(taskIds);
    }

    /**
     * 删除生产任务信息
     * 
     * @param taskId 生产任务主键
     * @return 结果
     */
    @Override
    public int deleteProdTaskByTaskId(Long taskId)
    {
        return prodTaskMapper.deleteProdTaskByTaskId(taskId);
    }
}
