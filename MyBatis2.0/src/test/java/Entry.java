import com.dw.mybatis.v2.bean.Test;
import com.dw.mybatis.v2.config.DWConfiguration;
import com.dw.mybatis.v2.config.mappers.TestMapper;
import com.dw.mybatis.v2.executor.SimpleExecutor;
import com.dw.mybatis.v2.session.DWSqlsession;

public class Entry {
    public static void main(String[] args) {
        DWConfiguration configuration = new DWConfiguration();
        DWSqlsession sqlsession = new DWSqlsession(configuration,new SimpleExecutor(configuration));
        TestMapper testMapper = sqlsession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(4222);
        System.out.println(test.toString());
    }
}
