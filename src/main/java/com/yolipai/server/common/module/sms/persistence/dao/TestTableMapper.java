package com.yolipai.server.common.module.sms.persistence.dao;

import com.yolipai.server.common.module.sms.persistence.entity.TestTable;
import com.yolipai.server.common.module.sms.persistence.entity.TestTableCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestTableMapper {
    int countByCondition(TestTableCriteria condition);

    int deleteByCondition(TestTableCriteria condition);

    int deleteByPrimaryKey(String id);

    int insert(TestTable record);

    int insertSelective(TestTable record);

    List<TestTable> selectByCondition(TestTableCriteria condition);

    TestTable selectByPrimaryKey(String id);

    int updateByConditionSelective(@Param("record") TestTable record, @Param("condition") TestTableCriteria condition);

    int updateByCondition(@Param("record") TestTable record, @Param("condition") TestTableCriteria condition);

    int updateByPrimaryKeySelective(TestTable record);

    int updateByPrimaryKey(TestTable record);
}