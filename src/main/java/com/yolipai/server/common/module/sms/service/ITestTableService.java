package com.yolipai.server.common.module.sms.service;

import com.yolipai.server.common.module.sms.persistence.entity.TestTable;
import com.yolipai.server.common.utils.Pager;
import java.util.List;
import java.util.Map;

public interface ITestTableService {
    TestTable addTestTable(TestTable record);

    boolean deleteTestTable(String id);

    TestTable modifyTestTable(TestTable record);

    TestTable getTestTable(String id);

    List<TestTable> getTestTables(Map<String, Object> params);

    Pager<TestTable> getPagerTestTable(Map<String, Object> params);
}