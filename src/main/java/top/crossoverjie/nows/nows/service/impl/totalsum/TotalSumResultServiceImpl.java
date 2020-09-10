package top.crossoverjie.nows.nows.service.impl.totalsum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.crossoverjie.nows.nows.service.ResultService;

/**
 * Function:
 *
 * @author crossoverJie
 * Date: 2019-05-06 21:02
 * @since JDK 1.8
 */
@Service
@Slf4j
public class TotalSumResultServiceImpl implements ResultService {

    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<>();

    @Autowired
    private TotalWords totalWords;

    public void setCurrentTime() {
        TIME_THREAD_LOCAL.set(System.currentTimeMillis());
    }

    @Override
    public void end() {
        long total = totalWords.total();
        long end = System.currentTimeMillis();
        log.info("total sum=[{}],[{}] ms", total, end - TIME_THREAD_LOCAL.get());
    }
}
