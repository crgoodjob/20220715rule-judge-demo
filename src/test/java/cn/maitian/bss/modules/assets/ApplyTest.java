// package cn.maitian.bss.modules.assets;
//
// import cn.maitian.bss.modules.AssetsApplication;
// import cn.maitian.bss.modules.assets.config.AssetsConfig;
// import cn.maitian.bss.modules.assets.model.ZcAccount;
// import cn.maitian.bss.modules.assets.service.SysShopIService;
// import cn.maitian.bss.modules.assets.service.ZcAccountIService;
// import cn.maitian.bss.modules.assets.service.ZcAssetApplyIService;
// import cn.maitian.bss.modules.assets.vo.SysShopManagerVo;
// import cn.maitian.bss.modules.assets.vo.SysShopVo;
// import cn.maitian.bss.modules.assets.vo.ZcAccountVo;
// import cn.maitian.bss.modules.common.web.PageResult;
// import cn.maitian.bss.modules.zk.service.IdGeneratorService;
// import lombok.extern.slf4j.Slf4j;
// import org.camunda.bpm.engine.HistoryService;
// import org.camunda.bpm.engine.TaskService;
// import org.camunda.bpm.engine.history.HistoricTaskInstance;
// import org.camunda.bpm.engine.history.HistoricTaskInstanceQuery;
// import org.camunda.bpm.engine.task.Task;
// import org.junit.jupiter.api.Test;
// import org.omg.CORBA.PUBLIC_MEMBER;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.util.Assert;
//
// import java.util.ArrayList;
// import java.util.List;
//
// /**
//  * @ClassName ApplyTest
//  * @Description 审批测试
//  * @Author zyk
//  * @Create 2022/4/11
//  * @Version 1.0
//  **/
// @Slf4j
// @SpringBootTest(classes = AssetsApplication.class)
// public class ApplyTest {
//     @Autowired
//     private ZcAssetApplyIService zcAssetApplyIService;
//
//     @Autowired
//     private AssetsConfig assetsConfig;
//
//     @Autowired
//     private ZcAccountIService zcAccountIService;
//
//     @Autowired
//     private SysShopIService shopIService;
//     @Autowired
//     private TaskService taskService;
//     @Autowired
//     private IdGeneratorService idGeneratorService;
//     @Autowired
//     protected HistoryService historyService;
//
//     @Test
//     public void shopTest(){
//         PageResult<List<SysShopManagerVo>> dd = shopIService.getShopManagerByUserName("朱", 1, 10);
//         Assert.notNull(dd);
//     }
//
//     @Test
//     public void zcAccountTest(){
//         PageResult<List<ZcAccountVo>> zcByShopName = zcAccountIService.getZcByShopName("西山美墅馆二店A组", "空调类", "调", 1, 10);
//         Assert.notNull(zcByShopName.getData());
//     }
//
//     @Test
//     public void  codeIsFlow(){
//         boolean fy00234 = zcAssetApplyIService.checkGoodCodeIsFlow("fy00234", 2);
//         Assert.isTrue(fy00234);
//     }
//
//     @Test
//     public void zcNumberTest() throws Exception {
//         String s = zcAssetApplyIService.zcNumber(2);
//         System.out.println("s = " + s);
//
// //        Long id = idGeneratorService.getIncrementIdByKey("ZCLY20220422");
// //        System.out.println("id = " + id);
//
//     }
//
//     /**
//      * 待办任务列表
//      */
//     @Test
//     public void candidateTask(){
// //        List<Task> tasks = taskService.createTaskQuery()
// //                .active()
// //                .or()
// //                .taskId("5c41db36-0eb2-11ec-9a4d-34f39ab07ea4")
// //                .taskAssignee("43516")
// //                .taskCandidateGroup("MyRole")
// //                .endOr()
// //                .listPage(1, 10);
// //        tasks.size();
//
//         List<String> keys=new ArrayList<>();
//         keys.add(assetsConfig.getProcessScrapKey());
//         keys.add(assetsConfig.getProcessTransforKey());
//         List<Task> candidateTask = zcAssetApplyIService.getCandidateTask(keys,null, "4366");
//         Assert.isTrue(candidateTask.size()>0);
//     }
//
//     /**
//      * 已办任务列表
//      */
//     @Test
//     public void historyTask(){
//         HistoricTaskInstanceQuery query = historyService.createHistoricTaskInstanceQuery();
//         query.finished();
//         query.processDefinitionKey(assetsConfig.getProcessTransforKey());
//
//         //同一个条件不能够or 查询。如果必须要指定多个查询流程Key，需要自定义SQL查询。
//         /**
//          * select * from (
//          * select a.*, ROWNUM rnum from (
//          * select distinct RES.*
//          * from ACT_HI_TASKINST RES
//          * left join ACT_RE_PROCDEF D on RES.PROC_DEF_ID_ = D.ID_
//          * WHERE ( 1 = 1 and D.KEY_ = 'Process_Zc_Asset_Transfor'
//          * and RES.END_TIME_ is not null )
//          * and ( 1 = 1 and RES.ID_ in
//          * (select TASK_ID_ from ACT_HI_IDENTITYLINK HIL WHERE HIL.TYPE_ = 'candidate' and HIL.USER_ID_ = '2991'  )
//          * or RES.ASSIGNEE_ = '2991')
//          * order by RES.END_TIME_ desc
//          * )
//          * a where ROWNUM < 11
//          * ) where rnum >= 1
//          * ;
//          */
// //        query.or().processDefinitionKey(assetsConfig.getProcessScrapKey())
// //                .processDefinitionKey(assetsConfig.getProcessTransforKey())
// //                .processDefinitionKey(assetsConfig.getProcessApplyKey())
// //                .processDefinitionKey(assetsConfig.getProcessTransforWareKey()).endOr();
// //        query.taskAssignee("2991");
//
//         query.or().taskAssignee("2991").taskHadCandidateUser("2991").endOr();
//
//         query.orderByHistoricTaskInstanceEndTime().desc();
//         query.unlimitedList();
//         List<HistoricTaskInstance> historicTaskInstances = query.listPage(0, 10);
//
//         System.out.println(historicTaskInstances.size());
//     }
//
//     @Test
//     public void shopAllNameTest(){
//         String shopAllNameById = shopIService.getShopAllNameById("e9d36277208211e5822a42f2e92acd29");
//         System.out.println("shopAllNameById = " + shopAllNameById);
//     }
// }
