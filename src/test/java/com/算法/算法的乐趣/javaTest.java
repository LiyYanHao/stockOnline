//package com.算法.算法的乐趣;
//
///**
// * @author lyh on 2018/12/26
// */
//public class javaTest {
//    int SYNC_LOG_CNT=1000;
//    int SYNC_LOG_MEMOVER_CNT=50;
//    int logCnt;
//    int
//    typedef struct
//    {
//        INT32U logCnt;
//        EPON_SYNC_LOG_DATA syncLogs[SYNC_LOG_CNT];
//    }EPON_SYNC_LOG;
//    EPON_SYNC_LOG s_EponSyncLog;
//    void Epon_Sync_Log_Add(EPON_SYNC_LOG_DATA*pLogData)
//    {
//        INT32U i = 0;
//        INT32U syncLogCnt = 0;
//        syncLogCnt = s_EponSyncLog.logCnt;
//        if(syncLogCnt>=SYNC_LOG_CNT)
//        {
//            /*缓冲区已满，向前移动 950 条记录，为新纪录腾出 50 条记录的空间*/
//            memmove(s_EponSyncLog.syncLogs,
//                    s_EponSyncLog.syncLogs + SYNC_LOG_MEMOVER_CNT,
//                    (SYNC_LOG_CNT-SYNC_LOG_MEMOVER_CNT) * sizeof(EPON_SYNC_LOG_DATA));
//            /*清空新腾出来的空间*/
//            memset(s_EponSyncLog.syncLogs + (SYNC_LOG_CNT - SYNC_LOG_MEMOVER_CNT),
//                    0, SYNC_LOG_MEMOVER_CNT * sizeof(EPON_SYNC_LOG_DATA));
//            /*写入当前一条日志*/
//            memmove(s_EponSyncLog.syncLogs + (SYNC_LOG_CNT - SYNC_LOG_MEMOVER_CNT),
//                    pLogData, sizeof(EPON_SYNC_LOG_DATA));
//            s_EponSyncLog.logCnt = SYNC_LOG_CNT - SYNC_LOG_MEMOVER_CNT + 1;
//            return;
//        }
//        /*如果缓冲区有空间，则直接写入当前一条记录*/
//        memmove(s_EponSyncLog.syncLogs + syncLogCnt,
//                pLogData, sizeof(EPON_SYNC_LOG_DATA));
//        s_EponSyncLog.logCnt++;
//    }
//
//}
