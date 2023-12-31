package com.roy.shardingDemo.algorithm;

import com.google.common.base.Preconditions;
import org.apache.shardingsphere.infra.instance.InstanceContext;
import org.apache.shardingsphere.infra.instance.InstanceContextAware;
import org.apache.shardingsphere.sharding.algorithm.keygen.TimeService;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;

import java.util.Calendar;
import java.util.Properties;

/**
 * 改进雪花算法，让他能够 %4 均匀分布。
 * @auth roykingw
 */
public final class MySnowFlakeAlgorithm implements KeyGenerateAlgorithm, InstanceContextAware {

    public static final long EPOCH;

    private static final String MAX_VIBRATION_OFFSET_KEY = "max-vibration-offset";

    private static final String MAX_TOLERATE_TIME_DIFFERENCE_MILLISECONDS_KEY = "max-tolerate-time-difference-milliseconds";

    private static final long SEQUENCE_BITS = 12L;

    private static final long WORKER_ID_BITS = 10L;

    private static final long SEQUENCE_MASK = (1 << SEQUENCE_BITS) - 1;

    private static final long WORKER_ID_LEFT_SHIFT_BITS = SEQUENCE_BITS;

    private static final long TIMESTAMP_LEFT_SHIFT_BITS = WORKER_ID_LEFT_SHIFT_BITS + WORKER_ID_BITS;

    private static final int DEFAULT_VIBRATION_VALUE = 1;

    private static final int MAX_TOLERATE_TIME_DIFFERENCE_MILLISECONDS = 10;

    private static final long DEFAULT_WORKER_ID = 0;

    private static TimeService timeService = new TimeService();

    public static void setTimeService(TimeService timeService) {
        MySnowFlakeAlgorithm.timeService = timeService;
    }

    private Properties props;

    @Override
    public Properties getProps() {
        return props;
    }

    private int maxVibrationOffset;

    private int maxTolerateTimeDifferenceMilliseconds;

    private volatile int sequenceOffset = -1;

    private volatile long sequence;

    private volatile long lastMilliseconds;

    private volatile InstanceContext instanceContext;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.NOVEMBER, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        EPOCH = calendar.getTimeInMillis();
    }

    @Override
    public void init(final Properties props) {
        this.props = props;
        maxVibrationOffset = getMaxVibrationOffset(props);
        maxTolerateTimeDifferenceMilliseconds = getMaxTolerateTimeDifferenceMilliseconds(props);
    }

    @Override
    public void setInstanceContext(final InstanceContext instanceContext) {
        this.instanceContext = instanceContext;
        if (null != instanceContext) {
            instanceContext.generateWorkerId(props);
        }
    }

    private int getMaxVibrationOffset(final Properties props) {
        int result = Integer.parseInt(props.getOrDefault(MAX_VIBRATION_OFFSET_KEY, DEFAULT_VIBRATION_VALUE).toString());
        Preconditions.checkArgument(result >= 0 && result <= SEQUENCE_MASK, "Illegal max vibration offset.");
        return result;
    }

    private int getMaxTolerateTimeDifferenceMilliseconds(final Properties props) {
        return Integer.parseInt(props.getOrDefault(MAX_TOLERATE_TIME_DIFFERENCE_MILLISECONDS_KEY, MAX_TOLERATE_TIME_DIFFERENCE_MILLISECONDS).toString());
    }

    @Override
    public synchronized Long generateKey() {
        long currentMilliseconds = timeService.getCurrentMillis();
        if (waitTolerateTimeDifferenceIfNeed(currentMilliseconds)) {
            currentMilliseconds = timeService.getCurrentMillis();
        }
        if (lastMilliseconds == currentMilliseconds) {
//            if (0L == (sequence = (sequence + 1) & SEQUENCE_MASK)) {
                currentMilliseconds = waitUntilNextTime(currentMilliseconds);
//            }
        } else {
            vibrateSequenceOffset();
//            sequence = sequenceOffset;
            sequence = sequence >= SEQUENCE_MASK ? 0:sequence+1;
        }
        lastMilliseconds = currentMilliseconds;
        return ((currentMilliseconds - EPOCH) << TIMESTAMP_LEFT_SHIFT_BITS) | (getWorkerId() << WORKER_ID_LEFT_SHIFT_BITS) | sequence;
    }

    private boolean waitTolerateTimeDifferenceIfNeed(final long currentMilliseconds) {
        if (lastMilliseconds <= currentMilliseconds) {
            return false;
        }
        long timeDifferenceMilliseconds = lastMilliseconds - currentMilliseconds;
        Preconditions.checkState(timeDifferenceMilliseconds < maxTolerateTimeDifferenceMilliseconds,
                "Clock is moving backwards, last time is %d milliseconds, current time is %d milliseconds", lastMilliseconds, currentMilliseconds);
        try {
            Thread.sleep(timeDifferenceMilliseconds);
        } catch (InterruptedException e) {
        }
        return true;
    }

    private long waitUntilNextTime(final long lastTime) {
        long result = timeService.getCurrentMillis();
        while (result <= lastTime) {
            result = timeService.getCurrentMillis();
        }
        return result;
    }

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    private void vibrateSequenceOffset() {
        sequenceOffset = sequenceOffset >= maxVibrationOffset ? 0 : sequenceOffset + 1;
    }

    private long getWorkerId() {
        return null == instanceContext ? DEFAULT_WORKER_ID : instanceContext.getWorkerId();
    }

    @Override
    public String getType() {
        return "MYSNOWFLAKE";
    }

    @Override
    public boolean isDefault() {
        return true;
    }
}
