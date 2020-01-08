package com.shop.mapper;

import com.shop.pojo.TbDing;
import com.shop.pojo.TbDingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDingMapper {
    int countByExample(TbDingExample example);

    int deleteByExample(TbDingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbDing record);

    int insertSelective(TbDing record);

    List<TbDing> selectByExample(TbDingExample example);

    TbDing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbDing record, @Param("example") TbDingExample example);

    int updateByExample(@Param("record") TbDing record, @Param("example") TbDingExample example);

    int updateByPrimaryKeySelective(TbDing record);

    int updateByPrimaryKey(TbDing record);
}