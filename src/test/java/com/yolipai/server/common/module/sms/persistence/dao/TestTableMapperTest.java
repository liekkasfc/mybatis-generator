package com.yolipai.server.common.module.sms.persistence.dao;

import com.yolipai.common.SpringTransactionalTestCase;
import com.yolipai.server.common.module.sms.persistence.entity.TestTable;
import com.yolipai.server.common.module.sms.persistence.entity.TestTableCriteria;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

public class TestTableMapperTest extends SpringTransactionalTestCase {
    @Autowired
    private TestTableMapper testTableMapper;

    @Test
    public void crudTest() {
        TestTable record=new TestTable();
        //vaild insertRecord Test
        assertEquals(1,testTableMapper.insert(record));
        //vaild updateRecord Test
        record.setTimer(new Date());
        testTableMapper.updateByPrimaryKeySelective(record);
        //vaild selectRecord Test
        assertEquals(record.getId(),testTableMapper.selectByPrimaryKey(record.getId()).getId());
        //vaild selectByConditon Test
        TestTableCriteria criteria = new TestTableCriteria();
        criteria.createCriteria().andIdEqualTo(record.getId());
        List<TestTable> TestTables =testTableMapper.selectByCondition(criteria);
        assertEquals(1,TestTables.size());
        //vaild countByCondition Test
        int connt=testTableMapper.countByCondition(criteria);
        assertEquals(1, connt);
        //vaild page Test
        criteria.setLimitStart(0);
        criteria.setLimitEnd(10);
        TestTables =testTableMapper.selectByCondition(criteria);
        assertEquals(1,TestTables.size());
        //vaild deleteRecord Test
        assertEquals(1,testTableMapper.deleteByPrimaryKey(record.getId()));
    }
}