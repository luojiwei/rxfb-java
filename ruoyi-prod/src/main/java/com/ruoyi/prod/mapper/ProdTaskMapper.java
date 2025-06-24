package com.ruoyi.prod.mapper;

import java.util.List;
import com.ruoyi.prod.domain.ProdTask;

/**
 * 生产任务Mapper接口
 * 
 * @author luojiwei
 * @date 2025-06-21
 */
public interface ProdTaskMapper 
{
    /**
     * 查询生产任务
     * 
     * @param taskId 生产任务主键
     * @return 生产任务
     */
    public ProdTask selectProdTaskByTaskId(Long taskId);

    /**
     * 查询生产任务列表
     * 
     * @param prodTask 生产任务
     * @return 生产任务集合
     */
    public List<ProdTask> selectProdTaskList(ProdTask prodTask);

    /**
     * 新增生产任务
     * 
     * @param prodTask 生产任务
     * @return 结果
     */
    public int insertProdTask(ProdTask prodTask);

    /**
     * 修改生产任务
     * 
     * @param prodTask 生产任务
     * @return 结果
     */
    public int updateProdTask(ProdTask prodTask);

    /**
     * 删除生产任务
     * 
     * @param taskId 生产任务主键
     * @return 结果
     */
    public int deleteProdTaskByTaskId(Long taskId);

    /**
     * 批量删除生产任务
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProdTaskByTaskIds(Long[] taskIds);
}
