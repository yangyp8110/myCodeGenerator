package ${basepackage}.mapper.${database_name_lower};

import org.apache.ibatis.annotations.Param;
import java.util.List;
import ${basepackage}.BaseExample;

<#include "/java_copyright.include">

public interface BaseDaoMapper<T, E> {
    /**
     * 根据 key 查询
     * @param key 查询的id
     * @return
     */
    T getByPrimaryKey(E key);

    /**
     * 根据 keyList 查询
     * @param keyList 查询id的集合
     * @return
     */
    List<T> getByPrimaryKeyList(@Param("keyList") List<E> keyList);

    /**
     * 根据条件查询
     * @param example 查询条件
     * @return
     */
    T getSingleByPredicate(BaseExample example);

    /**
     * 根据条件查询所有
     * @param example 查询条件
     * @return
     */
    List<T> getAllByPredicate(BaseExample example);

    /**
     * 根据条件查询
     * @param example 查询条件
     * @return
     */
    int queryCount(BaseExample example);

    /**
     * 分页查询(配合pageHelper)
     * @param example 查询条件
     * @return
     */
    List<T> getListByPage(BaseExample example);

    /**
     * 根据key更新除了key以外的其他字段
     * @param record
     * @return
     */
    int updateByPrimaryKey(@Param("record") T record);

    /**
     * 按条件更新
     * @param record 需要更新的字段
     * @param example 需要满足的条件
     * @return
     */
    int updateByPredicate(@Param("record") T record, @Param("example")BaseExample example);

    /**
     * 新增记录
     * @param entity 需要新增的entity
     * @return
     */
    int insert(T entity);

    /**
     * 批量新增
     * @param list 批量新增的entity
     * @return
     */
    int batchInsert(@Param("list") List<T> list);
}